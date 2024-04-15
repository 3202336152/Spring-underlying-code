package com.huanyu.springframework.factory.support;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.PropertyValue;
import com.huanyu.springframework.PropertyValues;
import com.huanyu.springframework.factory.DisposableBean;
import com.huanyu.springframework.factory.InitializingBean;
import com.huanyu.springframework.factory.config.AutowireCapableBeanFactory;
import com.huanyu.springframework.factory.config.BeanDefinition;
import com.huanyu.springframework.factory.config.BeanPostProcessor;
import com.huanyu.springframework.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * ClassName: AbstractAutowireCapableBeanFactory
 * Package: com.huanyu.springframework.support
 * Description: 实例化Bean类
 * 实现了 Bean 的实例化操作 newInstance,在处理完 Bean 对象的实例化后，直接调用 addSingleton 方法存放到单例对象的缓存中去。
 * @Author: 寰宇
 * @Create: 2024/4/11 16:10
 * @Version: 1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    // 定义实例化策略属性类的对象 使用Cglib 的实现类
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    // 此类的中心方法：创建 bean 实例、填充 bean 实例、应用后处理器等。
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 给 Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
            // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 注册实现了 DisposableBean 接口的 Bean 对象
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);

        addSingleton(beanName, bean);
        return bean;
    }

    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof DisposableBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
        }
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 1. 执行 BeanPostProcessor Before 处理
        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        // 执行 Bean 对象的初始化方法
        try {
            invokeInitMethods(beanName, wrappedBean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Invocation of init method of bean[" + beanName + "] failed", e);
        }

        // 2. 执行 BeanPostProcessor After 处理
        wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) throws Exception {
        // 1. 实现接口 InitializingBean
        if (bean instanceof InitializingBean) { // instanceof 是 Java 中的一个运算符，用于检查一个对象是否是某个类的实例或其子类的实例。
            ((InitializingBean) bean).afterPropertiesSet();
        }

        // 2. 配置信息 init-method {判断是为了避免二次执行销毁}
        String initMethodName = beanDefinition.getInitMethodName();
        if (StrUtil.isNotEmpty(initMethodName)) {
            Method initMethod = beanDefinition.getBeanClass().getMethod(initMethodName);
            if (null == initMethod) {
                throw new BeansException("Could not find an init method named '" + initMethodName + "' on bean with name '" + beanName + "'");
            }
            initMethod.invoke(bean);
        }
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        // 遍历所有的 BeanPostProcessor
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            // 调用每个 BeanPostProcessor 的 postProcessBeforeInitialization 方法
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (current == null) {
                // 如果返回值为 null，则直接返回之前处理的结果
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        // 遍历所有的 BeanPostProcessor
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            // 调用每个 BeanPostProcessor 的 postProcessAfterInitialization 方法
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (current == null) {
                // 如果返回值为 null，则直接返回之前处理的结果
                return result;
            }
            result = current;
        }
        return result;
    }

    // 使用适当的实例化策略为指定的 bean 创建一个新实例：工厂方法、构造函数自动装配或简单实例化。
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 获取目标类的所有声明构造函数
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        // 遍历构造函数列表，查找与给定参数匹配的构造函数
        for (Constructor ctor : declaredConstructors) {
            if(args != null && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        // 使用实例化策略（InstantiationStrategy）来实例化对象
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    /**
     * Bean 属性填充
     * 应用给定的属性值，解析对此 Bean 工厂中其他 Bean 的任何运行时引用。 必须使用深复制，因此不会永久修改此属性。
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        // 获取 BeanDefinition 中的属性值
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        // 遍历属性列表
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
            // 获取属性名和值
            String name = propertyValue.getName();
            Object value = propertyValue.getValue();
            // 当遇到 Bean 属性为 Bean 对象时，需要递归处理。
            if (value instanceof BeanReference) {
                // 如果属性值是 BeanReference 类型，表示存在依赖关系（类A中有类B的对象）
                BeanReference beanReference = (BeanReference) value;
                // 获取依赖的 Bean 实例
                value = getBean(beanReference.getBeanName());
            }

            // 使用反射设置属性值到目标对象 bean 是目标对象，name 是属性名，value 是属性值。
            // bean中有userDao对象 值为null 需要通过反射获取属性值给bean
            // 通过这样的反射操作，可以动态地将属性值设置到目标对象的属性上，无需直接访问目标对象的属性。
            // setFieldValue 方法利用反射，获取目标对象的类信息，并通过反射操作将属性值设置到目标对象的属性上。
            BeanUtil.setFieldValue(bean, name, value);
        }

    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
