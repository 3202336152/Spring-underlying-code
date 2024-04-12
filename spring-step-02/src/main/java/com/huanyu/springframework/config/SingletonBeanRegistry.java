package com.huanyu.springframework.config;

/**
 * ClassName: SingletonBeanRegistry
 * Package: com.huanyu.springframework.config
 * Description:定义一个获取单例对象的接口。
 * 定义共享 bean 实例注册表的接口。 可以由 BeanFactory 实现来实现，以便以统一的方式公开其单例管理工具。
 * @Author: 寰宇
 * @Create: 2024/4/11 15:53
 * @Version: 1.0
 */
public interface SingletonBeanRegistry {
    // 返回以给定名称注册的（原始）单例对象。
    Object getSingleton(String beanName);
}
