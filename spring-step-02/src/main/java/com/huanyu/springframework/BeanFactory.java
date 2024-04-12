package com.huanyu.springframework;

/**
 * ClassName: BeanFactory
 * Package: com.huanyu.springframework
 * Description: 管理和获取bean容器的根接口
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 16:00
 * @Version: 1.0
 */
public interface BeanFactory {
    // 返回指定 bean 的实例，该实例可以是共享的，也可以是独立的。
    Object getBean(String name) throws BeansException;
}
