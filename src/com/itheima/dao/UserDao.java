package com.itheima.dao;

import com.itheima.domain.User;

import java.sql.SQLException;

/**
 * Created by 13718 on 2017/8/27.
 */
public interface UserDao {
    User findByUsername(String username) throws SQLException;

    User InsterUser(User user) throws SQLException;
}
