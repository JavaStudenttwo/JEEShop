package com.itheima.dao;

import com.itheima.domain.User;

import java.sql.SQLException;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:用户数据操作
 * indetail: 实现类:
 *              com.itheima.dao.impl.UserDaoImpl
 *
 */
public interface UserDao {

    User findByUsername(String username) throws SQLException;

    int InsterUser(User user) throws SQLException;

    User findByCode(String code) throws SQLException;

    void update(User existUser) throws SQLException;
}
