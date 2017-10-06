package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.dao.impl.OrderDaoImpl;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.OrderService;
import com.itheima.utils.DataSourceUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:订单业务处理
 * indetail:
 *
 */
public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();

    /**
     * creater:litiecheng
     * createDate:2017-10-6
     * discription:分页查询订单
     * indetail:
     *
     */
    @Override
    public PageBean<Order> findByUid(User loginUser, int pageNumber, int pageSize) throws SQLException, InvocationTargetException, IllegalAccessException {
        /**先查询数据库获得总的订单数*/
        int totalRecord = orderDao.findTotalRecordByUid(loginUser);
        /**通过pageBean的构造方法获取startIndex和pageSize*/
        PageBean<Order> pageBean = new PageBean<Order>(pageNumber,pageSize,totalRecord);
        /**分页查询*/
        List<Order> data = orderDao.findAllByUid(loginUser,pageBean.getStartIndex(),pageBean.getPageSize());

        pageBean.setData(data);
        return pageBean;
    }

    /**
     * creater:litiecheng
     * createDate:2017-10-6
     * discription:
     * indetail:
     *
     */
    public void save(Order order) throws SQLException {
        /**如果直接调用getConnection方法，会报aotoCommit异常，换用开启事务方法，禁止aotoCommit*/
        Connection connection = DataSourceUtils.startTransaction();
        orderDao.save(connection,order);
        for (OrderItem orderItem:order.getOrderItems()) {
            orderDao.save(connection,orderItem);
        }
        DataSourceUtils.commitAndRelease();
    }






















}
