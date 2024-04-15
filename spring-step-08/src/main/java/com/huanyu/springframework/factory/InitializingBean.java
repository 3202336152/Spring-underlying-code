package com.huanyu.springframework.factory;

/**
 * ClassName: InitializingBean
 * Package: com.huanyu.springframework.factory
 * Description: 初始化操作接口
 *
 * @Author: 寰宇
 * @Create: 2024/4/15 15:01
 * @Version: 1.0
 */
public interface InitializingBean {
    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
