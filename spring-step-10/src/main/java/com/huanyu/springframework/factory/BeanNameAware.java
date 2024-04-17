package com.huanyu.springframework.factory;

/**
 * ClassName: BeanNameAware
 * Package: com.huanyu.springframework.factory
 * Description: 让Bean获取自身在容器中的名字
 * 当一个 Bean 实现了此接口，可以感知其在 Spring 容器中的名称。
 * @Author: 寰宇
 * @Create: 2024/4/15 16:10
 * @Version: 1.0
 */
public interface BeanNameAware extends Aware {
    /**
     * 设置在创建此 bean 的 bean 工厂中的 bean 的名称。
     * 此方法在填充常规 bean 属性之后被调用，但在如 InitializingBean#afterPropertiesSet() 这样的
     * 初始化回调或自定义初始化方法之前被调用。
     * @param name 工厂中的 bean 的名称。注意，这个名称是工厂中使用的实际 bean 名称，
     * 这可能与最初指定的名称不同：尤其对于内部 bean 名称，实际的 bean 名称可能已通过添加 "#..." 后缀变得唯一。
     * 如果需要，可以使用 BeanFactoryUtils#originalBeanName(String) 方法来提取没有后缀的原始 bean 名称。
     */
    void setBeanName(String name);
}
