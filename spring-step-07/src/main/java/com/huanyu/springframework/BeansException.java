package com.huanyu.springframework;

/**
 * ClassName: BeansException
 * Package: com.huanyu.springframework
 * Description:定义 Bean 异常
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 16:01
 * @Version: 1.0
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
