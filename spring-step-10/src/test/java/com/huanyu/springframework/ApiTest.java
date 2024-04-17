package com.huanyu.springframework;

import com.huanyu.springframework.context.support.ClassPathXmlApplicationContext;
import com.huanyu.springframework.event.CustomEvent;
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
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }



}
