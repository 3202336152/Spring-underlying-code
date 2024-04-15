package com.huanyu.springframework.factory.config;

import cn.hutool.core.bean.BeanException;
import com.huanyu.springframework.factory.ConfigurableListableBeanFactory;

/**
 * ClassName: BeanFactoryPostProcessor
 * Package: com.huanyu.springframework.factory.config
 * Description: 在bean实例化之前修改bean的定义
 * 允许在 Bean 对象注册后但未实例化之前，对 Bean 的定义信息 BeanDefinition 执行修改操作。
 * @Author: 寰宇
 * @Create: 2024/4/14 14:55
 * @Version: 1.0
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在应用上下文的内部bean工厂进行其标准初始化后修改它。
     * 此时，所有bean定义都已加载，但尚未实例化任何bean。
     * 这允许用户即使对于急切初始化的beans也可以覆盖或添加属性。
     *
     * @param beanFactory 应用上下文使用的bean工厂
     * @throws BeanException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException;
}
