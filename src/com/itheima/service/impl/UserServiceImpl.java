package com.itheima.service.impl;


import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.UserService;

import java.sql.SQLException;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:用户业务处理
 * indetail:
 *
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User findByUsername(String username) throws SQLException {
        User user = userDao.findByUsername(username);
        return user;
    }

    @Override
    public int regist(User user) throws SQLException {

        int i = userDao.InsterUser(user);
        return i;
    }

    @Override
    public Boolean activeUser(String code) throws SQLException {

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

    @Override
    public User login(String username, String password) throws SQLException {

        User user = findByUsername(username);

//        if (password.equals(user.getPassword()) && user.getState()==1){
        if (password.equals(user.getPassword())){
            return user;
        }else{
            return null;
        }
    }

}
