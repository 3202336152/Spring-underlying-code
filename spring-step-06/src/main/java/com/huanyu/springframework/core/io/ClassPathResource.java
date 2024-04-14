package com.huanyu.springframework.core.io;

import cn.hutool.core.lang.Assert;
import com.huanyu.springframework.utils.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: ClassPathResource
 * Package: com.huanyu.springframework.core.io
 * Description: 通过 ClassLoader 读取 ClassPath 下的文件信息.
 *
 * @Author: 寰宇
 * @Create: 2024/4/13 15:30
 * @Version: 1.0
 */
public class ClassPathResource implements Resource{

    private final String path;
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        // 使用类加载器获取指定路径的资源作为输入流
        InputStream is = classLoader.getResourceAsStream(path);
        // 如果输入流为 null，则表示资源不存在，抛出 FileNotFoundException 异常
        if(is == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        // 返回获取到的输入流
        return is;
    }
}
