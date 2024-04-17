package com.huanyu.springframework.context.event;

import com.huanyu.springframework.context.ApplicationContext;
import com.huanyu.springframework.context.ApplicationEvent;

/**
 * ClassName: ApplicationContextEvent
 * Package: java.com.huanyu.springframework.context.event
 * Description: 表示应用程序上下文相关的事件
 *
 * @Author: 寰宇
 * @Create: 2024/4/17 20:21
 * @Version: 1.0
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * 获取引发事件的 <code>ApplicationContext</code>。
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
