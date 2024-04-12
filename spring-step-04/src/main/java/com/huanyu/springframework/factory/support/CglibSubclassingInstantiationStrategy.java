package com.huanyu.springframework.factory.support;

import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * ClassName: CglibSubclassingInstantiationStrategy
 * Package: com.huanyu.springframework.factory.support
 * Description: Cglib实例化 BeanFactories 中使用的默认对象实例化策略。
 *
 * @Author: 寰宇
 * @Create: 2024/4/12 13:03
 * @Version: 1.0
 */

/*
Enhancer 是 CGLIB 库中的一个类，它用于创建动态代理类。CGLIB（Code Generation Library）是一个基于字节码操作的代码生成库，它通过修改字节码来生成被代理类的子类，从而实现动态代理。
Enhancer 类提供了许多方法和选项，用于配置和创建代理类。在给定的代码中，Enhancer 被用于创建一个代理类来实例化对象。
以下是一些 Enhancer 类的常用方法：
    setSuperclass(Class superClass): 设置被代理类的父类。
    setInterfaces(Class[] interfaces): 设置被代理类实现的接口。
    setCallback(Callback callback): 设置回调函数，用于处理代理类的方法调用。
    create(): 创建代理类的实例，使用无参构造函数。
    create(Class[] argumentTypes, Object[] arguments): 创建代理类的实例，使用指定的构造函数和参数。
*/
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{
    // 创建动态生成的子类的新实例，实现所需的查找。
    // 为提供的 bean 创建 bean 类的增强子类
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String name, Constructor ctor, Object[] args) throws BeansException {
        // 创建Enhancer对象 Enhancer 是 CGLIB 库中的一个类，它用于创建动态代理类。
        Enhancer enhancer = new Enhancer();
        // 设置被代理类的父类
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        // 设置回调函数，这里使用了一个匿名内部类，重写了 NoOp 类的 hashCode() 方法
        // 回调函数的作用是定义代理类在方法调用时的行为。代理类中的方法调用会被委托给回调函数来处理，而不是直接调用被代理类的方法。
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        // 如果构造函数为 null，则使用无参构造函数创建对象
        if (ctor == null) {
            return enhancer.create();
        }
        // 使用指定的构造函数和参数创建对象
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
