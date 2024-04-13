package com.huanyu.springframework.factory.support;

import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * ClassName: InstantiationStrategy
 * Package: com.huanyu.springframework.factory.support
 * Description: 负责创建与根 bean 定义相对应的实例的接口。
 * 定义实例化策略接口
 * @Author: 寰宇
 * @Create: 2024/4/12 11:14
 * @Version: 1.0
 */
public interface InstantiationStrategy {
    // 实例化接口 instantiate 方法中添加必要的入参信息
    // 返回此工厂中具有给定名称的 bean 实例
    Object instantiate(BeanDefinition beanDefinition, String name, Constructor ctor, Object[] args) throws BeansException;
}
