package com.huanyu.springframework.context.event;

/**
 * ClassName: ContextClosedEvent
 * Package: java.com.huanyu.springframework.context.event
 * Description: 关闭动作
 *
 * @Author: 寰宇
 * @Create: 2024/4/17 20:23
 * @Version: 1.0
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
