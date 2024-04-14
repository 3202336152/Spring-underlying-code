package com.huanyu.springframework.factory.config;

import com.huanyu.springframework.BeansException;

/**
 * ClassName: BeanPostProcessor
 * Package: com.huanyu.springframework.factory.config
 * Description: 在 Bean 的初始化前后，进行自定义处理，可影响所有Bean。
 *
 * @Author: 寰宇
 * @Create: 2024/4/14 15:12
 * @Version: 1.0
 */
public interface BeanPostProcessor {
    /**
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在 Bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
