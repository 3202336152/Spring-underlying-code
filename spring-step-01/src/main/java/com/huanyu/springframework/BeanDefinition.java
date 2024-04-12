package com.huanyu.springframework;

/**
 * ClassName: BeanDefinition
 * Package: com.huanyu.springframework
 * Description: BeanDefinition，用于定义 Bean 实例化信息，现在的实现是以一个 Object 存放对象。
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 15:25
 * @Version: 1.0
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
