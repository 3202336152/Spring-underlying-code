package com.huanyu.springframework.context;

import com.huanyu.springframework.BeansException;

/**
 * ClassName: ConfigurableApplicationContext
 * Package: com.huanyu.springframework.context
 * Description: 应用上下文配置
 *
 * @Author: 寰宇
 * @Create: 2024/4/14 15:15
 * @Version: 1.0
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    // 关闭钩子
    void registerShutdownHook();

    // 执行销毁
    void close();
}
