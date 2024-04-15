package com.huanyu.springframework.bean;

import com.huanyu.springframework.factory.DisposableBean;
import com.huanyu.springframework.factory.InitializingBean;

/**
 * ClassName: UserService
 * Package: com.huanyu.springframework.bean
 * Description:
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 15:31
 * @Version: 1.0
 */
public class UserService implements InitializingBean, DisposableBean {
    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }
}
