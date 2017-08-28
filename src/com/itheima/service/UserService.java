package com.itheima.service;

import com.itheima.domain.User;

import java.sql.SQLException;

/**
 * Created by 13718 on 2017/8/27.
 */
public interface UserService {

    User findByUsername(String username) throws SQLException;
}
