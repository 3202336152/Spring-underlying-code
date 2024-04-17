package com.huanyu.springframework.context.support;


import com.huanyu.springframework.factory.support.DefaultListableBeanFactory;
import com.huanyu.springframework.factory.xml.XmlBeanDefinitionReader;

/**
 * ClassName: AbstractXmlApplicationContext
 * Package: com.huanyu.springframework.context.support
 * Description: 处理了关于 XML 文件配置信息的操作
 *
 * @Author: 寰宇
 * @Create: 2024/4/14 15:38
 * @Version: 1.0
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        // 创建一个 XmlBeanDefinitionReader 对象，并传入 BeanFactory 和当前上下文
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        // 获取配置文件的路径数组
        String[] configLocations = getConfigLocations();
        // 如果配置文件路径数组不为null
        if (configLocations != null) {
            // 使用 XmlBeanDefinitionReader 加载配置文件中的 Bean 定义
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    // 抽象方法，由具体子类实现，用于获取配置文件的路径数组
    protected abstract String[] getConfigLocations();
}
