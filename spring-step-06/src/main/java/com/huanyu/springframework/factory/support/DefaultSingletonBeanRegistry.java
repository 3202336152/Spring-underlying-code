package com.huanyu.springframework.factory.support;

import com.huanyu.springframework.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DefaultSingletonBeanRegistry
 * Package: com.huanyu.springframework.config
 * Description: 共享 bean 实例的通用注册表，实现 SingletonBeanRegistry。 允
 * 许注册单例实例，该实例应为注册表的所有调用者共享，并通过 bean 名称获取。
 * 在 DefaultSingletonBeanRegistry 中主要实现 getSingleton 方法，同时实现了一个受保护的 addSingleton 方法，这个方法可以被继承此类的其他类调用。
 * 包括：AbstractBeanFactory 以及继承的 DefaultListableBeanFactory 调用。
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 15:51
 * @Version: 1.0
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    // 单例对象的缓存：bean 名称到 bean 实例。
    private Map<String, Object> singletonObjects = new HashMap<>();
    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    // 将给定的单例对象添加到单例注册表中。
    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
