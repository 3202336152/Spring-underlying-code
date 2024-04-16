package com.huanyu.springframework.factory;

import com.huanyu.springframework.BeansException;

/**
 * ClassName: BeanFactoryAware
 * Package: com.huanyu.springframework.factory
 * Description: 提供Bean获取所属的BeanFactory
 * 允许一个 Bean 获取 Spring 容器的引用（BeanFactory），以便可以在运行时访问容器的功能和其他 Bean。
 * @Author: 寰宇
 * @Create: 2024/4/15 16:07
 * @Version: 1.0
 */
public interface BeanFactoryAware {
    /**
     * 向 bean 实例提供其拥有的工厂的回调。
     * 在正常 bean 属性填充之后但在初始化回调之前（如
     * InitializingBean#afterPropertiesSet() 或自定义的初始化方法）调用。
     * @param beanFactory 拥有的 BeanFactory（永远不会是 null）。
     * bean 可以立即调用工厂上的方法。
     * @throws BeansException 初始化错误的情况下
     * @see BeansException
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
