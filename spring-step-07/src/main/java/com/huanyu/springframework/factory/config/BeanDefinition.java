package com.huanyu.springframework.factory.config;

import com.huanyu.springframework.PropertyValues;

/**
 * ClassName: BeanDefinition
 * Package: com.huanyu.springframework
 * Description: BeanDefinition 描述了一个 bean 实例，它具有属性值、构造函数参数值以及具体实现提供的更多信息。
 * BeanDefinition，用于定义 Bean 实例化信息，现在的实现是以一个 Object 存放对象。
 * @Author: 寰宇
 * @Create: 2024/4/11 15:25
 * @Version: 1.0
 */
public class BeanDefinition {
    private Class beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
