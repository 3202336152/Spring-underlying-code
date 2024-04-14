package com.huanyu.springframework.factory;

import com.huanyu.springframework.BeansException;

import java.util.Map;

/**
 * ClassName: ListableBeanFactory
 * Package: com.huanyu.springframework.factory
 * Description: 能够以列表形式获取 bean 定义的容器
 *
 * @Author: 寰宇
 * @Create: 2024/4/14 15:05
 * @Version: 1.0
 */
public interface ListableBeanFactory extends BeanFactory{
    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
