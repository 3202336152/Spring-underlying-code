package com.huanyu.springframework.factory.config;

/**
 * ClassName: BeanReference
 * Package: com.huanyu.springframework.factory.config
 * Description: Bean的引用
 * 以抽象方式公开对 Bean 名称的引用的接口。 该接口并不一定意味着对实际 bean 实例的引用； 它只是表达对 bean 名称的逻辑引用。
 * @Author: 寰宇
 * @Create: 2024/4/12 15:24
 * @Version: 1.0
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
