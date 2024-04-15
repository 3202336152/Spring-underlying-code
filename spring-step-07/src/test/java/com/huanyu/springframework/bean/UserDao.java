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

    public void initDataMethod(){
        System.out.println("执行：init-method");
        hashMap.put("10001", "寰宇");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public void destroyDataMethod(){
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
