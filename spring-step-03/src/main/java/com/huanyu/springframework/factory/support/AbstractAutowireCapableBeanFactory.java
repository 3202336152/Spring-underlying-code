package com.huanyu.springframework.factory.support;


import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * ClassName: AbstractAutowireCapableBeanFactory
 * Package: com.huanyu.springframework.support
 * Description:实例化Bean类
 * 实现了 Bean 的实例化操作 newInstance,在处理完 Bean 对象的实例化后，直接调用 addSingleton 方法存放到单例对象的缓存中去。
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 16:10
 * @Version: 1.0
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    // 定义实例化策略属性类的对象 使用Cglib 的实现类
    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    // 此类的中心方法：创建 bean 实例、填充 bean 实例、应用后处理器等。
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
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

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
