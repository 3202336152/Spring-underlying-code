package com.huanyu.springframework.factory.support;


import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.ConfigurableListableBeanFactory;
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
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    // 注册bean
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    // 获取指定名称的Bean定义
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            // 抛出异常，表示未找到指定名称的Bean定义
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }


    // 检查是否包含指定名称的bean
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                result.put(beanName, (T) getBean(beanName));
            }
        });
        return result;
    }

    // 获取所有已注册的Bean定义名称
    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}
