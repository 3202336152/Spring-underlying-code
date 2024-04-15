package com.huanyu.springframework.factory.config;

import com.huanyu.springframework.factory.HierarchicalBeanFactory;

/**
 * ClassName: ConfigurableBeanFactory
 * Package: com.huanyu.springframework.factory.config
 * Description: 大多数 bean 工厂要实现的配置接口。
 * 除了 BeanFactory 接口中的 bean 工厂客户端方法之外，还提供配置 bean 工厂的工具。
 *
 * @Author: 寰宇
 * @Create: 2024/4/13 16:24
 * @Version: 1.0
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry{
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
