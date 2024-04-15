package com.huanyu.springframework.factory;

import com.huanyu.springframework.BeansException;

/**
 * ClassName: BeanFactory
 * Package: com.huanyu.springframework.factory
 * Description: 管理和获取bean容器的根接口
 *
 * @Author: 寰宇
 * @Create: 2024/4/12 11:13
 * @Version: 1.0
 */
public interface BeanFactory {
    Object getBean(String name) throws BeansException;

    // 重载一个含有入参信息 args 的 getBean 方法，这样就可以方便的传递入参给构造函数实例化了。
    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

}
