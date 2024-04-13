package com.huanyu.springframework.factory.support;


import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.BeanFactory;
import com.huanyu.springframework.factory.config.BeanDefinition;

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
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
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

}
