package com.itheima.web.servlet;

import com.itheima.domain.Order;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.OrderService;
import com.itheima.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * creater:litiecheng
 * createDate:2017-10-6
 * discription:处理和订单相关的请求
 * indetail:
 *
 */
@WebServlet(name = "OrderServlet" ,urlPatterns = "/orderServlet")
public class OrderServlet extends HttpServlet {

    public void orderHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
