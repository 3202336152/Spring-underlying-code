package com.huanyu.springframework.factory.support;

import cn.hutool.core.util.StrUtil;
import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.DisposableBean;
import com.huanyu.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * ClassName: DisposableBeanAdapter
 * Package: com.huanyu.springframework.factory.support
 * Description: 定义销毁方法适配器(接口和配置)
 * 为什么会有适配器：销毁方法有两种或者多种，需要统一的接口进行销毁。
 * @Author: 寰宇
 * @Create: 2024/4/15 15:13
 * @Version: 1.0
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 2. 配置信息 destroy-method {判断是为了避免二次执行销毁}
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
