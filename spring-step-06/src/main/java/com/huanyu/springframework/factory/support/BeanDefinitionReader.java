package com.huanyu.springframework.factory.support;

import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.core.io.Resource;
import com.huanyu.springframework.core.io.ResourceLoader;


/**
 * ClassName: BeanDefinitionReader
 * Package: com.huanyu.springframework.factory.support
 * Description: 读取和加载 Bean 定义的方法。
 * 为容器提供一种机制，通过读取配置文件或其他资源，将 Bean 的定义信息加载到容器中。
 * @Author: 寰宇
 * @Create: 2024/4/13 15:50
 * @Version: 1.0
 */
public interface BeanDefinitionReader {

    /**
     * 获取用于注册Bean定义的BeanDefinitionRegistry实例。
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取用于加载资源的ResourceLoader实例。
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载单个资源中的Bean定义。
     *
     * @param resource 要加载的资源
     * @throws BeansException 如果在加载Bean定义时出现问题
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;



    /**
     * 加载多个资源中的Bean定义。
     *
     * @param resources 要加载的资源数组
     * @throws BeansException 如果在加载Bean定义时出现问题
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * 根据资源路径加载Bean定义。
     *
     * @param location 资源路径
     * @throws BeansException 如果在加载Bean定义时出现问题
     */
    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

}
