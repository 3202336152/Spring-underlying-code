package com.huanyu.springframework.event;

import com.huanyu.springframework.context.event.ApplicationContextEvent;

/**
 * ClassName: CustomEvent
 * Package: com.huanyu.springframework.event
 * Description: 自定义事件，在事件类的构造函数中可以添加自己的想要的入参信息。
 * 这个事件类最终会被完成的拿到监听里，所以你添加的属性都会被获得到。
 *
 * @Author: 寰宇
 * @Create: 2024/4/17 21:06
 * @Version: 1.0
 */
public class CustomEvent extends ApplicationContextEvent {
    private Long id;
    private String message;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustomEvent(Object source, Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
