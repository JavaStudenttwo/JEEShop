package com.itheima.utils.test;

import org.junit.Test;

import java.sql.*;

public class TestJDBCUtils {

    @Test
    public void testJDBC() throws ClassNotFoundException, SQLException {
        /**
         * 1.常用反射的方式注册驱动
         * 使用registerDriver()方法注册驱动最终会组测两次驱动，因为Driver对象中有一个静态代码块用来注册驱动
         *
         */
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        Class.forName("com.mysql.jdbc.Driver");

        /**2.通过DriverManager获取连接对象*/
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/shop", "root", "123");

        /**3.通过Connection获取一个操作sql语句的对象Statement*/
        Statement statement = connection.createStatement();
        /**
         * 4.执行sql语句(select) 得到一个ResultSet
         * 使用executeQuery方法执行查询会有结果集，使用executeUpdate方法执行更新则没有结果集
         */
        String sql = "select * from USER ";
        ResultSet resultSet = statement.executeQuery(sql);
        /**
         * 5.操作结果集，得到数据(使用类似迭代器)
         * ResultSet就是一张二位表格,它内部有一个"行光标"，光标默认的位置在"第一行上方"，我们可以调用ResultSet对象的next()方法把"行光标"向下移动一行，当第一次调用next()方法之后，"行光标"就到了第一行记录的位置，这时就可以使用ResultSet提供的getXXX(int col)方法来获取指定列的数据了
         * resultSet.next();//光标移动到第一行
         * resultSet.getInt(1);//获取第一行第一列的数据
         *
         */
        while (resultSet.next()) {
            System.out.println("ID:" + resultSet.getString("uid") + "\tNAME:"+ resultSet.getString("name"));
        }
        /**
         * 6.释放资源
         * 包括结果集 resultSet
         * 负责向数据库发送sql语句的对象 statement
         * 数据库连接对象 connection
         * 关闭是有顺序的，先得到的后关闭，后得到的先关闭
         *
         */
        resultSet.close();
        statement.close();
        connection.close();
    }

}
