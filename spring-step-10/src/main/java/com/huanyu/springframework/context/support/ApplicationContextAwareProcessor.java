package com.huanyu.springframework.context.support;


import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.context.ApplicationContext;
import com.huanyu.springframework.context.ApplicationContextAware;
import com.huanyu.springframework.factory.config.BeanPostProcessor;

/**
 * ClassName: ApplicationContextAwareProcessor
 * Package: com.huanyu.springframework.context.support
 * Description: 实现 BeanPostProcessor 接口的类
 * 用于在初始化 Bean 前后对 Bean 进行处理，特别是对实现了 ApplicationContextAware 接口的 Bean 进行处理。
 * 在初始化前，将 ApplicationContext 注入到实现了 ApplicationContextAware 接口的 Bean 中。
 * @Author: 寰宇
 * @Create: 2024/4/15 16:14
 * @Version: 1.0
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    /**
     * 构造方法，接收一个 ApplicationContext 对象作为参数，用于注入到 ApplicationContextAware 接口的 Bean 中。
     */
    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 在 Bean 初始化前进行处理。
     * 如果 Bean 实现了 ApplicationContextAware 接口，就将 ApplicationContext 注入到该 Bean 中。
     * @param bean     当前正在初始化的 Bean 对象
     * @param beanName Bean 的名称
     * @return 处理后的 Bean 对象
     * @throws BeansException 如果处理过程中发生异常
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    /**
     * 在 Bean 初始化后进行处理。
     * @param bean     当前已初始化的 Bean 对象
     * @param beanName Bean 的名称
     * @return 处理后的 Bean 对象
     * @throws BeansException 如果处理过程中发生异常
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
