package com.huanyu.springframework.support;

import com.huanyu.springframework.config.BeanDefinition;

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
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
