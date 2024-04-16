package com.huanyu.springframework.factory;

/**
 * ClassName: DisposableBean
 * Package: com.huanyu.springframework.factory
 * Description: 销毁操作接口
 *
 * @Author: 寰宇
 * @Create: 2024/4/15 15:01
 * @Version: 1.0
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
