package com.huanyu.springframework.bean;

import com.huanyu.springframework.BeansException;
import com.huanyu.springframework.context.ApplicationContext;
import com.huanyu.springframework.context.ApplicationContextAware;
import com.huanyu.springframework.factory.BeanClassLoaderAware;
import com.huanyu.springframework.factory.BeanFactory;
import com.huanyu.springframework.factory.BeanFactoryAware;
import com.huanyu.springframework.factory.BeanNameAware;

/**
 * ClassName: UserService
 * Package: com.huanyu.springframework.bean
 * Description:
 *
 * @Author: 寰宇
 * @Create: 2024/4/11 15:31
 * @Version: 1.0
 */
public class UserService {

    private String uId;
    private String company;
    private String location;
    private IUserDao userDao;

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

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
