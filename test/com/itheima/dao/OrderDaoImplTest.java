package com.itheima.dao;

import com.itheima.dao.impl.OrderDaoImpl;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * OrderDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class OrderDaoImplTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: findTotalRecordByUid(User loginUser)
     *
     */
    @Test
    public void testFindTotalRecordByUid() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: findAllByUid(User loginUser, int startIndex, int pageSize)
     *
     */
    @Test
    public void testFindAllByUid() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: save(Connection connection, Order order)
     *
     */
    @Test
    public void testSaveForConnectionOrder() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: save(Connection connection, OrderItem orderItem)
     *
     */
    @Test
    public void testSaveForConnectionOrderItem() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: findAllByOid(String oid)
     *
     */
    @Test
    public void testFindAllByOid() throws Exception {
//TODO: Test goes here...
        OrderDao orderDao = new OrderDaoImpl();
        Order order = orderDao.findByOid("18149327-a18e-4216-ac52-2d2ce52bee29");
        OrderItem orderItem = new OrderItem();
        orderItem = order.getOrderItems().get(0);
        System.out.println(orderItem);

    }

    @Test
    public void testFindAll() throws Exception {
//TODO: Test goes here...
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> orderList = orderDao.orderList(4,8);

        System.out.println(orderList.get(0).getUser());
    }


}
