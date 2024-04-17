package com.huanyu.springframework.event;

import com.huanyu.springframework.context.ApplicationListener;
import com.huanyu.springframework.context.event.ContextClosedEvent;

/**
 * ClassName: ContextClosedEventListener
 * Package: com.huanyu.springframework.event
 * Description:
 *
 * @Author: 寰宇
 * @Create: 2024/4/17 21:10
 * @Version: 1.0
 */
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
