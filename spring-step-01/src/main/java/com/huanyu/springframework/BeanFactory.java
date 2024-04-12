package com.huanyu.springframework;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: BeanFactory
 * Package: com.huanyu.springframework
 * Description:BeanFactory，代表了 Bean 对象的工厂，可以存放 Bean 定义到 Map 中以及获取。
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 15:27
 * @Version: 1.0
 */
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
