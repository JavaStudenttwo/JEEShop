package com.itheima.dao;

import com.itheima.domain.Order;
import com.itheima.domain.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-10-6
 * discription:订单操作
 * indetail: 实现类:
 *              com.itheima.dao.impl.OrderDaoImpl
 *
 */
public interface OrderDao {
    int findTotalRecordByUid(User loginUser) throws SQLException;

    List<Order> findAllByUid(User loginUser, int startIndex, int pageSize) throws SQLException, InvocationTargetException, IllegalAccessException;
}
