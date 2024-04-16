package com.huanyu.springframework.context;

import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.Aware;

/**
 * ClassName: ApplicationContextAware
 * Package: com.huanyu.springframework.context
 * Description: 允许 Bean 获取应用程序上下文
 * 允许我们访问当前的应用上下文 (ApplicationContext)。
 * 通常在某些 Spring bean 需要访问应用上下文本身或其内部其他 bean 时会有用。
 * @Author: 寰宇
 * @Create: 2024/4/15 16:12
 * @Version: 1.0
 */
public interface ApplicationContextAware extends Aware {

    /**
     * 设置此对象运行的 ApplicationContext。
     * 此调用通常用于初始化对象。
     * 此方法在普通bean属性被填充之后调用，但在诸如 org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     * 这样的初始化回调或自定义初始化方法之前调用。
     * 在 ResourceLoaderAware#setResourceLoader，
     * ApplicationEventPublisherAware#setApplicationEventPublisher 和
     * MessageSourceAware 之后调用（如果适用）。
     *
     * @param applicationContext 要由此对象使用的 ApplicationContext 对象
     * @throws BeansException 如果上下文初始化出错
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
