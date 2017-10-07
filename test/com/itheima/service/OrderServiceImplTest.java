package com.itheima.service;

import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.service.impl.OrderServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * OrderServiceImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class OrderServiceImplTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: findByUid(User loginUser, int pageNumber, int pageSize)
     *
     */
    @Test
    public void testFindByUid() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: save(Order order)
     *
     */
    @Test
    public void testSave() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: findByOid(String oid)
     *
     */
    @Test
    public void testFindByOid() throws Exception {
//TODO: Test goes here...
        OrderService orderService = new OrderServiceImpl();
        Order order = orderService.findByOid("18149327-a18e-4216-ac52-2d2ce52bee29");
        System.out.println(order);
        for (OrderItem item:order.getOrderItems()) {
            System.out.println(item);
        }

    }


}
