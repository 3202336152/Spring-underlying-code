package com.huanyu.springframework.factory.support;


import com.huanyu.springframework.factory.config.BeanDefinition;

/**
 * ClassName: BeanDefinitionRegistry
 * Package: com.huanyu.springframework.support
 * Description:向注册表中注册 BeanDefinition
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 16:26
 * @Version: 1.0
 */
public interface BeanDefinitionRegistry {
    //向注册表中注册 BeanDefinition
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
