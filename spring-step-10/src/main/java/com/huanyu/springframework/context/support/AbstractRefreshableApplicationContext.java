package com.huanyu.springframework.context.support;

import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.ConfigurableListableBeanFactory;
import com.huanyu.springframework.factory.support.DefaultListableBeanFactory;

/**
 * ClassName: AbstractRefreshableApplicationContext
 * Package: com.huanyu.springframework.context.support
 * Description: 用于可刷新的应用程序上下文
 *
 * @Author: 寰宇
 * @Create: 2024/4/14 15:31
 * @Version: 1.0
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    // 刷新Bean工厂
    @Override
    protected void refreshBeanFactory() throws BeansException {
        // 创建一个新的Bean工厂
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        // 加载Bean定义到Bean工厂
        loadBeanDefinitions(beanFactory);
        // 将新的Bean工厂设置为当前上下文的Bean工厂
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    // 抽象方法，由具体子类实现，用于加载Bean定义到Bean工厂
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    // 创建一个新的 DefaultListableBeanFactory 实例。
    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return (ConfigurableListableBeanFactory) beanFactory;
    }
}
