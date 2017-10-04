package com.itheima.service;

import com.itheima.domain.Order;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:订单业务处理
 * indetail:
 *
 */
public interface OrderService {
    PageBean<Order> findByUid(User loginUser, int pageNumber, int pageSize) throws SQLException, InvocationTargetException, IllegalAccessException;
}
