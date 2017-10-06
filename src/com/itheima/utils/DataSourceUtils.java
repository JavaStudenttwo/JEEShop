package com.itheima.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * creater:litiecheng
 * createDate:2017-10-6
 * discription:数据库资源工具类，用来获取数据库连接
 * indetail:
 *
 */
public class DataSourceUtils {
	/**创建一个C3P0连接池对象*/
	private static DataSource dataSource = new ComboPooledDataSource();

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	/**返回一个C3P0连接池对象*/
	public static DataSource getDataSource() {
		return dataSource;
	}

	/**获取连接对象*/
	public static Connection getConnection() throws SQLException {
		Connection con = tl.get();
		if (con == null) {
			con = dataSource.getConnection();
			tl.set(con);
		}
		return con;
	}

	/**获取连接对象，开启事务*/
	public static Connection startTransaction() throws SQLException {
		Connection con = getConnection();
		if (con != null) {
			con.setAutoCommit(false);
		}
		return con;
	}

	/**事务回滚*/
	public static void rollback() throws SQLException {
		Connection con = getConnection();
		if (con != null) {
			con.rollback();
		}
	}

	/**事务提交，资源关闭*/
	public static void commitAndRelease() throws SQLException {
		Connection con = getConnection();
		if (con != null) {
			/**事务提交*/
			con.commit();
			/**关闭资源*/
			con.close();
			/**将连接从线程中移除*/
			tl.remove();
		}
	}

	/**关闭资源*/
	public static void closeConnection() throws SQLException {
		Connection con = getConnection();
		if (con != null) {
			con.close();
		}
	}

	public static void closeStatement(Statement st) throws SQLException {
		if (st != null) {
			st.close();
		}
	}

	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

}
