package com.huanyu.springframework.factory;

/**
 * ClassName: FactoryBean
 * Package: com.huanyu.springframework.factory
 * Description: 创建和管理对象实例的工厂
 *
 * @Author: 寰宇
 * @Create: 2024/4/16 15:45
 * @Version: 1.0
 */
public interface FactoryBean<T> {

    // 获取由该工厂创建的对象实例
    T getObject() throws Exception;

    // 获取由该工厂创建的对象的类型
    Class<?> getObjectType();

    // 判断由该工厂创建的对象是否为单例
    boolean isSingleton();
}
