package com.itheima.service.impl;


import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.UserService;

import java.sql.SQLException;

/**
 * Created by 13718 on 2017/8/27.
 */
public class UserServiceImpl implements UserService {

    @Override
    public User findByUsername(String username) throws SQLException {

        UserDao userDao = new UserDaoImpl();
        User user = userDao.findByUsername(username);
        return user;
    }

    @Override
    public int regist(User user) throws SQLException {

        UserDao userDao = new UserDaoImpl();
        int i = userDao.InsterUser(user);
        return i;
    }

    @Override
    public Boolean activeUser(String code) throws SQLException {

        UserDao userDao = new UserDaoImpl();
        User existUser = userDao.findByCode(code);

        if (existUser != null){
            existUser.setState(1);
            existUser.setCode(null);
            userDao.update(existUser);
            return true;
        }else{
            return false;
        }
    }
}
