package com.huanyu.springframework.context.event;

import com.huanyu.springframework.context.ApplicationEvent;
import com.huanyu.springframework.context.ApplicationListener;
import com.huanyu.springframework.factory.BeanFactory;

/**
 * ClassName: SimpleApplicationEventMulticaster
 * Package: com.huanyu.springframework.context.event
 * Description: 应用程序事件广播器
 *
 * @Author: 寰宇
 * @Create: 2024/4/17 20:50
 * @Version: 1.0
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
