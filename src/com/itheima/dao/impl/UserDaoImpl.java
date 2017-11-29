package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import com.itheima.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:用户数据操作
 * indetail:
 *
 */
public class UserDaoImpl implements UserDao {

    @Override
    public User findByUsername(String username) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username = ? ";
        User existUser = queryRunner.query(sql,new BeanHandler<User>(User.class),username);
        return existUser;
    }

    /**
     * @Date 2017/10/13 16:02
     * @Author CycloneKid sk18810356@gmail.com
     * @MethodName: findByUsername_J
     * @Params: [username]
     * @ReturnType: com.itheima.domain.User
     * @Description:
     *
     */
    public User findByUsername_J(String username) throws SQLException, ClassNotFoundException {

        Connection connection = JDBCUtils.getDataSource();
        Statement statement = connection.createStatement();
        String sql = "select * from user where username = ? ";

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println("ID:" + resultSet.getString("uid") + "\tNAME:"+ resultSet.getString("name"));
        }

        resultSet.close();
        statement.close();
        connection.close();
        return null;
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

    @Override
    public User findByUid(String uid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where uid = ? ";
        User user = queryRunner.query(sql,new BeanHandler<User>(User.class),uid);
        return user;
    }
}
