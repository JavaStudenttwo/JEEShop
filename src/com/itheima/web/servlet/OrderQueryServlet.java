package com.itheima.web.servlet;

import com.itheima.domain.Order;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.OrderService;
import com.itheima.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * Created by 13718 on 2017/9/6.
 */
public class OrderQueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pageNumber = 1;
        pageNumber = Integer.getInteger(request.getParameter("pageNumber"));

        int pageSize = 3;

        User loginUser = (User) request.getSession().getAttribute("loginUser");

        OrderService orderService = new OrderServiceImpl();
        try {
            PageBean<Order> pageBean = orderService.findByUid(loginUser,pageNumber,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }






























}
