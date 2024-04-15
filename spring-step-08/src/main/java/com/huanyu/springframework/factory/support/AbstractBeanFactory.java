package com.huanyu.springframework.factory.support;


import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.config.BeanDefinition;
import com.huanyu.springframework.factory.config.BeanPostProcessor;
import com.huanyu.springframework.factory.config.ConfigurableBeanFactory;
import com.huanyu.springframework.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: AbstractBeanFactory
 * Package: com.huanyu.springframework.support
 * Description:
 * AbstractBeanFactory 首先继承了 DefaultSingletonBeanRegistry，也就具备了使用单例注册类方法。
 * 实现 BeanFactory 接口。
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 15:57
 * @Version: 1.0
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {

    // 在 createBean 中应用 BeanPostProcessors
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    // 获取bean
    protected <T> T doGetBean(final String name, final Object[] args) {
        // 从单例中获取bean
        Object bean = getSingleton(name);
        if (bean != null)
            return (T) bean;
        // 单例中没有bean 从AbstractAutowireCapableBeanFactory实现获取
        BeanDefinition beanDefinition = getBeanDefinition(name);
        // 获取后进行创建
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor){
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    // 返回将应用于使用此工厂创建的 bean 的 BeanPostProcessors 列表。
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    // 获取bean的类加载器
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    // 返回保存的 Bean 类加载器对象
    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}
