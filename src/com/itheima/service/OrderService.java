package com.itheima.service;

import com.itheima.domain.Order;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Created by 13718 on 2017/9/6.
 */
public interface OrderService {
    PageBean<Order> findByUid(User loginUser, int pageNumber, int pageSize) throws SQLException, InvocationTargetException, IllegalAccessException;
}
