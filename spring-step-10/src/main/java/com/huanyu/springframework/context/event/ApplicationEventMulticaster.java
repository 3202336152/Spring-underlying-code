package com.huanyu.springframework.context.event;

import com.huanyu.springframework.context.ApplicationEvent;
import com.huanyu.springframework.context.ApplicationListener;

/**
 * ClassName: ApplicationEventMulticaster
 * Package: java.com.huanyu.springframework.context.event
 * Description: 事件广播器
 * 定义了添加监听和删除监听的方法以及一个广播事件的方法 multicastEvent 最终推送时间消息也会经过这个接口方法来处理谁该接收事件。
 * @Author: 寰宇
 * @Create: 2024/4/17 20:27
 * @Version: 1.0
 */
public interface ApplicationEventMulticaster {
    /**
     * 添加一个侦听器以接收所有事件的通知。
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 从通知列表中删除监听器。
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 将给定的应用程序事件多播到适当的侦听器。
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);
}
