package com.huanyu.springframework;

import cn.hutool.core.io.IoUtil;
import com.huanyu.springframework.bean.UserDao;
import com.huanyu.springframework.bean.UserService;
import com.huanyu.springframework.common.MyBeanFactoryPostProcessor;
import com.huanyu.springframework.common.MyBeanPostProcessor;
import com.huanyu.springframework.context.support.ClassPathXmlApplicationContext;
import com.huanyu.springframework.core.io.DefaultResourceLoader;
import com.huanyu.springframework.core.io.Resource;
import com.huanyu.springframework.factory.config.BeanDefinition;
import com.huanyu.springframework.factory.config.BeanReference;
import com.huanyu.springframework.factory.support.DefaultListableBeanFactory;
import com.huanyu.springframework.factory.xml.XmlBeanDefinitionReader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor(){
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }



}
