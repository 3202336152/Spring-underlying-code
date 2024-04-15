package com.huanyu.springframework.common;

import cn.hutool.core.bean.BeanException;
import com.huanyu.springframework.PropertyValue;
import com.huanyu.springframework.PropertyValues;
import com.huanyu.springframework.factory.ConfigurableListableBeanFactory;
import com.huanyu.springframework.factory.config.BeanDefinition;
import com.huanyu.springframework.factory.config.BeanFactoryPostProcessor;

/**
 * ClassName: MyBeanFactoryPostProcessor
 * Package: com.huanyu.springframework.common
 * Description: Bean实例化之前，修改bean的定义信息。
 *
 * @Author: 寰宇
 * @Create: 2024/4/14 21:10
 * @Version: 1.0
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeanException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
