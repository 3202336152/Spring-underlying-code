package com.huanyu.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * ClassName: UrlResource
 * Package: com.huanyu.springframework.core.io
 * Description: 通过 HTTP 的方式读取云服务的文件
 *
 * @Author: 寰宇
 * @Create: 2024/4/13 15:40
 * @Version: 1.0
 */
public class UrlResource implements Resource{
    private final URL url;

    public UrlResource(URL url) {
        Assert.notNull(url,"URL must not be null");
        this.url = url;
    }
    @Override
    public InputStream getInputStream() throws IOException {
        // 打开与 URL 的连接
        URLConnection con = this.url.openConnection();
        try {
            // 从连接中获取输入流
            return con.getInputStream();
        }
        catch (IOException ex){
            // 如果连接是 HttpURLConnection 的实例，则断开连接。
            if (con instanceof HttpURLConnection){
                ((HttpURLConnection) con).disconnect();
            }
            throw ex;
        }
    }
}
