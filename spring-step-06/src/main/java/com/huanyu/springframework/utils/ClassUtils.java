package com.huanyu.springframework.utils;

/**
 * ClassName: ClassUtils
 * Package: com.huanyu.springframework.utils
 * Description: 获取默认的类加载器
 *
 * @Author: 寰宇
 * @Create: 2024/4/13 15:35
 * @Version: 1.0
 */
public class ClassUtils {
    // 获取默认的类加载器
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            // 尝试获取当前线程的上下文类加载器
            cl = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable ex) {
            // 无法访问线程上下文类加载器 - 回退到系统类加载器...
        }
        if (cl == null) {
            // 如果上下文类加载器为 null，则使用当前类的类加载器作为默认类加载器
            cl = ClassUtils.class.getClassLoader();
        }
        return cl;
    }
}
