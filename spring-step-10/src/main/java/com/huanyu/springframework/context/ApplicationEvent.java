package com.huanyu.springframework.context;

import java.util.EventObject;

/**
 * ClassName: ApplicationEvent
 * Package: java.com.huanyu.springframework.context
 * Description: 应用程序中的事件
 * 定义事件的抽象类，所有的事件包括关闭、刷新，以及用户自己实现的事件，都需要继承这个类。
 * @Author: 寰宇
 * @Create: 2024/4/17 20:18
 * @Version: 1.0
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
