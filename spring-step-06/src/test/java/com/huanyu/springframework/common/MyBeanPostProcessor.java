package com.huanyu.springframework.common;

import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.bean.UserService;
import com.huanyu.springframework.factory.config.BeanPostProcessor;

/**
 * ClassName: MyBeanPostProcessor
 * Package: com.huanyu.springframework.common
 * Description:
 *
 * @Author: 寰宇
 * @Create: 2024/4/14 21:10
 * @Version: 1.0
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
