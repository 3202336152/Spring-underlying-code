package com.huanyu.springframework.event;

import com.huanyu.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * ClassName: CustomEventListener
 * Package: com.huanyu.springframework.event
 * Description: 监听 CustomEvent 事件的监听器
 *
 * @Author: 寰宇
 * @Create: 2024/4/17 21:07
 * @Version: 1.0
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}
