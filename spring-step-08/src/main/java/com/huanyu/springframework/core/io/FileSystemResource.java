package com.huanyu.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: FileSystemResource
 * Package: com.huanyu.springframework.core.io
 * Description: 通过指定文件路径的方式读取文件信息
 *
 * @Author: 寰宇
 * @Create: 2024/4/13 15:37
 * @Version: 1.0
 */
public class FileSystemResource implements Resource{
    private final File file;
    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public String getPath() {
        return path;
    }
}
