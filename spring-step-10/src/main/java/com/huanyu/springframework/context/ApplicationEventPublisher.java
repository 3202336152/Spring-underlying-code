package com.huanyu.springframework.context;

/**
 * ClassName: ApplicationEventPublisher
 * Package: com.huanyu.springframework.context
 * Description: 整个一个事件的发布接口，所有的事件都需要从这个接口发布出去。
 *
 * @Author: 寰宇
 * @Create: 2024/4/17 20:40
 * @Version: 1.0
 */
public interface ApplicationEventPublisher {
    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     * @param event the event to publish
     */
    void publishEvent(ApplicationEvent event);
}
