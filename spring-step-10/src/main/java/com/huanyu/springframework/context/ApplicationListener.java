package com.huanyu.springframework.context;

import java.util.EventListener;

/**
 * ClassName: ApplicationListener
 * Package: java.com.huanyu.springframework.context
 * Description: 由应用程序事件侦听器实现的接口。
 * 基于观察者设计模式的标准 <code>java.util.EventListener</code> 接口。
 *
 * @Author: 寰宇
 * @Create: 2024/4/17 20:28
 * @Version: 1.0
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
