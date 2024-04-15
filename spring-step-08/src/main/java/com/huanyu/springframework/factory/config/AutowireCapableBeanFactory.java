package com.huanyu.springframework.factory.config;

import com.huanyu.springframework.BeansException;

/**
 * ClassName: AutowireCapableBeanFactory
 * Package: com.huanyu.springframework.factory.config
 * Description: BeanFactory 接口的扩展由能够自动装配的 bean 工厂实现，前提是它们希望为现有 bean 实例公开此功能。
 *
 * @Author: 寰宇
 * @Create: 2024/4/13 16:23
 * @Version: 1.0
 */
public interface AutowireCapableBeanFactory {
    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
