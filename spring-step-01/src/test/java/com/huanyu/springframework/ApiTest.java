package com.huanyu.springframework;

import com.huanyu.springframework.bean.UserService;
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
        // 初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();
        // 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userservice", beanDefinition);
        // 获取bean
        UserService userService = (UserService) beanFactory.getBean("userservice");
        userService.queryUserInfo();
    }
}
