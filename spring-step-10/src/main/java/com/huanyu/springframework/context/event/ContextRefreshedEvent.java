package com.huanyu.springframework.context.event;

/**
 * ClassName: ContextRefreshedEvent
 * Package: java.com.huanyu.springframework.context.event
 * Description: 监听刷新动作
 *
 * @Author: 寰宇
 * @Create: 2024/4/17 20:24
 * @Version: 1.0
 */
public class ContextRefreshedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
