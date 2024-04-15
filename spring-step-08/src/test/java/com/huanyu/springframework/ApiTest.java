package com.huanyu.springframework;

import com.huanyu.springframework.bean.UserService;
import com.huanyu.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * ClassName: ApiTest
 * Package: com.huanyu.springframework
 * Description: 通过读取xml文件
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 15:31
 * @Version: 1.0
 */

public class ApiTest {
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
        System.out.println("ApplicationContextAware：" + userService.getApplicationContext());
        System.out.println("BeanFactoryAware：" + userService.getBeanFactory());
    }


}
