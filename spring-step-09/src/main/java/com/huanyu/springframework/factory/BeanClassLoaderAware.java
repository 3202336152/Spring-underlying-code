package com.huanyu.springframework.factory;

/**
 * ClassName: BeanClassLoaderAware
 * Package: com.huanyu.springframework.factory
 * Description: 允许Bean获取其类加载器
 * 当一个 bean 实现了这个接口时，Spring 容器在 bean 初始化的时候会设置它的类加载器。
 * @Author: 寰宇
 * @Create: 2024/4/15 16:09
 * @Version: 1.0
 */
public interface BeanClassLoaderAware extends Aware{
    /**
     * 提供 bean 的 ClassLoader 类加载器 的回调方法。
     * 在填充普通的 bean 属性之后但在初始化回调（如 InitializingBean InitializingBean 的
     * InitializingBean#afterPropertiesSet() 方法或自定义初始化方法）之前调用此方法。
     *
     * @param classLoader 拥有的类加载器
     */
    void setBeanClassLoader(ClassLoader classLoader);
}
