package com.huanyu.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * ClassName: DefaultResourceLoader
 * Package: com.huanyu.springframework.core.io
 * Description: 将三种不同类型的资源处理方式进行包装，分为：判断是否为ClassPath、URL以及文件。
 *
 * @Author: 寰宇
 * @Create: 2024/4/13 15:45
 * @Version: 1.0
 */
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");

        if(location.startsWith(CLASSPATH_URL_PREFIX)) {
            // 如果资源路径以 "classpath:" 开头，则创建 ClassPathResource 对象
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                // 尝试将资源路径作为 URL 解析
                URL url = new URL(location);
                // 创建 UrlResource 对象
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                // 如果解析 URL 失败，则创建 FileSystemResource 对象
                return new FileSystemResource(location);
            }
        }
    }
}
