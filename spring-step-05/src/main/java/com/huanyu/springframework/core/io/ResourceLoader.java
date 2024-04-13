package com.huanyu.springframework.core.io;

/**
 * ClassName: ResourceLoader
 * Package: com.huanyu.springframework.core.io
 * Description: 按照资源加载的不同方式，资源加载器可以把这些方式集中到统一的类服务下进行处理，外部用户只需要传递资源地址即可。
 *
 * @Author: 寰宇
 * @Create: 2024/4/13 15:43
 * @Version: 1.0
 */
public interface ResourceLoader {
    // 用于从类路径加载的伪 URL 前缀："classpath:"
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
