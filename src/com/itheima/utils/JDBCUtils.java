package com.itheima.utils;

import java.sql.*;

public class JDBCUtils {

    private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();

    public static Connection getDataSource() throws ClassNotFoundException, SQLException {
        /**
         * 1.常用反射的方式注册驱动
         * 使用registerDriver()方法注册驱动最终会组测两次驱动，因为Driver对象中有一个静态代码块用来注册驱动
         *
         */
        Class.forName("com.mysql.jdbc.Driver");

        /**2.通过DriverManager获取连接对象*/
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shop", "root", "123");

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        /**
         * 1.常用反射的方式注册驱动
         * 使用registerDriver()方法注册驱动最终会组测两次驱动，因为Driver对象中有一个静态代码块用来注册驱动
         *
         */
        Class.forName("com.mysql.jdbc.Driver");

        try{
            Connection connection = local.get();
            if (connection == null){
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/shop", "root", "123");
                local.set(connection);
            }
            return connection;

        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }



    public static void closeResouce(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {

        if (resultSet != null){
            resultSet.close();
        }
        if (statement != null){
            statement.close();
        }
        if (connection != null){
            connection.close();
        }
    }



}
