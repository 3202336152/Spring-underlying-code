package com.huanyu.springframework.support;

import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.config.BeanDefinition;

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
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException{
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException  | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
