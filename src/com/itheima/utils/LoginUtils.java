package com.itheima.utils;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import java.sql.SQLException;

/**
 * Created by 13718 on 2017/8/31.
 */
public class LoginUtils {

    public static User login(String username,String password){
        UserService userService = new UserServiceImpl();
        User user = null;
        try {
            user = userService.findByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (password.equals(user.getPassword()) && user.getState()==1){
            return user;
        }else{
            return null;
        }


    }
}
