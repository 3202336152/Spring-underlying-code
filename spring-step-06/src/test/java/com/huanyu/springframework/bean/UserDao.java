package com.huanyu.springframework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: UserDao
 * Package: com.huanyu.springframework.bean
 * Description:
 *
 * @Author: 寰宇
 * @Create: 2024/4/12 15:27
 * @Version: 1.0
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "寰宇");
        hashMap.put("10002", "兜兜转转");
        hashMap.put("10003", "三毛");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
