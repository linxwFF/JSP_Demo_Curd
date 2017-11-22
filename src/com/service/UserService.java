package com.service;

import com.dao.UserDao;
import com.pojo.User;

/**
 * Created by LINxwFF on 2017/11/21.
 */
public class UserService {
    private UserDao userDao = new UserDao();

    //登录
    public User Login(String name,String password)
    {
        return userDao.login(name,password);
    }

    //检验是否是已经注册过的用户
    public boolean validateAlreadyRegister(String name)
    {
        return userDao.validateAlreadyRegister(name);
    }

    //注册
    public boolean Register(User user)
    {
        return userDao.insert(user);
    }
}
