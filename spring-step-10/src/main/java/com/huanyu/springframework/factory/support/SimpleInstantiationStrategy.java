package com.huanyu.springframework.factory.support;

import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ClassName: SimpleInstantiationStrategy
 * Package: com.huanyu.springframework.factory.support
 * Description: JDK实例化。 在 BeanFactory 中使用的简单对象实例化策略。
 *
 * @Author: 寰宇
 * @Create: 2024/4/12 11:16
 * @Version: 1.0
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    // 实例化对象
    public Object instantiate(BeanDefinition beanDefinition, String name, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if(ctor != null) {
                // 使用指定的构造函数实例化对象
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                // 使用默认的无参构造函数实例化对象
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
