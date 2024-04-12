package com.huanyu.springframework;

import com.huanyu.springframework.bean.UserService;
import com.huanyu.springframework.config.BeanDefinition;
import com.huanyu.springframework.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * ClassName: ApiTest
 * Package: com.huanyu.springframework
 * Description:
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 15:31
 * @Version: 1.0
 */

public class ApiTest {
    @Test
    public void test_BeanFactory(){
        // 1. 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3. 第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 4. 第二次获取bean从Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();
    }
}
