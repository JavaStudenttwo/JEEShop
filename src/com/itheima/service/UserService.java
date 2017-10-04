package com.itheima.service;

import com.itheima.domain.User;

import java.sql.SQLException;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:用户业务处理
 * indetail:
 *
 */
public interface UserService {

    User findByUsername(String username) throws SQLException;

    int regist(User user) throws SQLException;

    Boolean activeUser(String code) throws SQLException;

    User login(String username, String password) throws SQLException;
}
