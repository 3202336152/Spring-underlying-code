package com.huanyu.springframework.factory.support;


import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DefaultListableBeanFactory
 * Package: com.huanyu.springframework.support
 * Description:管理和组织应用程序中的 Bean 实例
 * Spring 的 ConfigurableListableBeanFactory 和 BeanDefinitionRegistry 接口的默认实现：基于 bean 定义元数据的成熟 bean 工厂，可通过后处理器进行扩展。
 * DefaultListableBeanFactory 继承了 AbstractAutowireCapableBeanFactory 类，也就具备了接口 BeanFactory 和 AbstractBeanFactory 等一连串的功能实现。
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 16:17
 * @Version: 1.0
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition == null)
            throw new BeansException("No bean named '" + beanName + "' is defined");
        return beanDefinition;
    }

    // 注册bean
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

}
