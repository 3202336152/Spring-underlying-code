package com.huanyu.springframework.event;

import com.huanyu.springframework.context.ApplicationListener;
import com.huanyu.springframework.context.event.ContextRefreshedEvent;

/**
 * ClassName: ContextRefreshedEventListener
 * Package: com.huanyu.springframework.event
 * Description:
 *
 * @Author: 寰宇
 * @Create: 2024/4/17 21:09
 * @Version: 1.0
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
