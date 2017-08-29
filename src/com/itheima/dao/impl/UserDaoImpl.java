package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by 13718 on 2017/8/27.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public User findByUsername(String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username = ? ";
        User existUser = queryRunner.query(sql,new BeanHandler<User>(User.class),username);
        return existUser;
    }

    @Override
    public int InsterUser(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        Object[] params = { user.getUid(),user.getUsername(),user.getPassword(),
                            user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),
                            user.getSex(),user.getState(),user.getCode()
        };
        int i = queryRunner.update(sql,params);
        return i;
    }

    @Override
    public User findByCode(String code) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * form user where code = ?";
        User existUser = queryRunner.query(sql,new BeanHandler<User>(User.class),code);
        return existUser;
    }

    @Override
    public void update(User user) throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update user set username=?,password=?,name=?,email=?,telephone=?," +
                "birthday=?,sex=?,state=?,code=?where uid=?";
        Object[] params = new Object[]{user.getUsername(), user.getPassword(),
                user.getName(), user.getEmail(), user.getTelephone(), user.getBirthday(),
                user.getSex(), user.getState(), user.getCode(), user.getUid()};
        queryRunner.update(sql,params);
    }
}
