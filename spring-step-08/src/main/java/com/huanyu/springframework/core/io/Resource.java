package com.huanyu.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: Resource
 * Package: com.huanyu.springframework.core.io
 * Description: 处理资源加载流
 *
 * @Author: 寰宇
 * @Create: 2024/4/13 15:29
 * @Version: 1.0
 */
public interface Resource {
    // 定义 Resource 接口，提供获取 InputStream 流的方法，再分别实现三种不同的流文件操作：classPath、FileSystem、URL。
    InputStream getInputStream() throws IOException;
}
