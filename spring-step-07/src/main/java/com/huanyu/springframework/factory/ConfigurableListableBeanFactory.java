package com.huanyu.springframework.factory;

import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.config.AutowireCapableBeanFactory;
import com.huanyu.springframework.factory.config.BeanDefinition;
import com.huanyu.springframework.factory.config.ConfigurableBeanFactory;

/**
 * ClassName: ConfigurableListableBeanFactory
 * Package: com.huanyu.springframework.factory
 * Description: 扩展了ListableBeanFactory和ConfigurableBeanFactory，提供了更多用于配置和管理bean的方法。
 * 通过该接口，可以注册单例对象、自定义作用域、冻结配置、获取BeanDefinition信息、设置父BeanFactory等。
 *
 * @Author: 寰宇
 * @Create: 2024/4/14 14:58
 * @Version: 1.0
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    // 获取指定bean名称的BeanDefinition对象
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 确保实例化所有非懒加载单例，还考虑到org.springframework.beans.factory.FactoryBean。
     * 通常在工厂设置结束时调用，如果需要的话。
     * @throws BeansException 如果无法创建其中一个单例bean。
     * 注意：这可能已经使工厂具有一些已初始化的bean！在这种情况下，调用destroySingletons()进行完全清理。
     */
    void preInstantiateSingletons() throws BeansException;
}
