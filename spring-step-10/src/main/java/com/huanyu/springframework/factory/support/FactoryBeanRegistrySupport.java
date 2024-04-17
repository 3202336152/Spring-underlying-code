package com.huanyu.springframework.factory.support;

import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: FactoryBeanRegistrySupport
 * Package: com.huanyu.springframework.factory.support
 * Description: 支持 FactoryBean 对象的创建和缓存。
 * 它提供了方法来获取缓存中的对象实例以及通过 FactoryBean 获取对象实例的逻辑。
 *
 * @Author: 寰宇
 * @Create: 2024/4/16 15:48
 * @Version: 1.0
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    // FactoryBeans创建的单例对象的缓存：FactoryBean名称-->对象
    // 存放单例类型的对象，避免重复创建。
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<String, Object>();

    /**
     * 从工厂缓存中获取已创建的 FactoryBean 对象实例
     */
    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return (object != NULL_OBJECT ? object : null);
    }

    /**
     * 从 FactoryBean 获取对象实例
     */
    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factory, beanName);
                this.factoryBeanObjectCache.put(beanName, (object != null ? object : NULL_OBJECT));
            }
            return (object != NULL_OBJECT ? object : null);
        } else {
            return doGetObjectFromFactoryBean(factory, beanName);
        }
    }

    /**
     * 通过 FactoryBean 获取对象实例
     */
    private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName){
        try {
            return factory.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }
}
