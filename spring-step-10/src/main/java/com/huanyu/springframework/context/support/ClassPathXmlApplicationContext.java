package com.huanyu.springframework.context.support;

import com.huanyu.springframework.BeansException;

/**
 * ClassName: ClassPathXmlApplicationContext
 * Package: com.huanyu.springframework.context.support
 * Description: 具体对外给用户提供的应用上下文方法
 *
 * @Author: 寰宇
 * @Create: 2024/4/14 15:43
 * @Version: 1.0
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
    private String[] configLocations;

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     *
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    /**
     * 从 XML 中加载 BeanDefinition，并刷新上下文
     * @param configLocations
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }

}
