package com.itheima.dao;

import com.itheima.domain.Order;
import com.itheima.domain.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 13718 on 2017/9/6.
 */
public interface OrderDao {
    int findTotalRecordByUid(User loginUser) throws SQLException;

    List<Order> findAllByUid(User loginUser, int startIndex, int pageSize) throws SQLException, InvocationTargetException, IllegalAccessException;
}
