package com.huanyu.springframework.factory.support;


import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.config.BeanDefinition;

/**
 * ClassName: BeanDefinitionRegistry
 * Package: com.huanyu.springframework.support
 * Description:向注册表中注册 BeanDefinition
 * 用于管理和注册Bean定义。它允许我们注册、移除、检索Bean定义以及执行其他与Bean定义相关的操作。
 * @Author: 寰宇
 * @Create: 2024/4/11 16:26
 * @Version: 1.0
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 使用Bean名称查询BeanDefinition
     *
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
