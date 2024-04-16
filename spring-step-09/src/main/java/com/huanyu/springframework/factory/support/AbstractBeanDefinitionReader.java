package com.huanyu.springframework.factory.support;


import com.huanyu.springframework.core.io.DefaultResourceLoader;
import com.huanyu.springframework.core.io.ResourceLoader;

/**
 * ClassName: AbstractBeanDefinitionReader
 * Package: com.huanyu.springframework.factory.support
 * Description: 抽象的Bean定义读取器，实现了BeanDefinitionReader接口。
 * 抽象类继承接口时，可以选择是否实现接口的方法
 * @Author: 寰宇
 * @Create: 2024/4/13 15:52
 * @Version: 1.0
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
    private final BeanDefinitionRegistry registry; // Bean定义注册器

    private ResourceLoader resourceLoader; // 资源加载器

    /**
     * 使用给定的Bean定义注册器和默认的资源加载器创建一个AbstractBeanDefinitionReader实例。
     * @param registry Bean定义注册器
     */
    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    /**
     * 使用给定的Bean定义注册器和资源加载器创建一个AbstractBeanDefinitionReader实例。
     *
     * @param registry       Bean定义注册器
     * @param resourceLoader 资源加载器
     */
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
