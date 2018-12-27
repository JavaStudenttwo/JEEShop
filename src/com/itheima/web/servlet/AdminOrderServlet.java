package com.itheima.web.servlet;

import com.itheima.domain.Order;
import com.itheima.domain.PageBean;
import com.itheima.service.OrderService;
import com.itheima.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * creater:litiecheng
 * createDate:2017-10-8
 * discription:后台订单管理
 * indetail:
 *
 */
@WebServlet(name = "AdminOrderServlet" ,urlPatterns = "/adminOrderServlet")
public class AdminOrderServlet extends BaseServlet {

    OrderService orderService = new OrderServiceImpl();

    /**
     * creater:litiecheng
     * createDate:2017-10-7
     * discription:修改分类
     * indetail:
     */
    public void orderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, InvocationTargetException, IllegalAccessException {

        String state_param = request.getParameter("state");

        int pageNumber = 1;
        String page_number = request.getParameter("pageNumber");
        if ( page_number != null ){
            pageNumber = Integer.parseInt(page_number);
        }

        int pageSize = 8;
        PageBean<Order> pageBean = null;
        try {
            pageBean = orderService.orderList(pageNumber,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("pageBean",pageBean);
        response.sendRedirect(request.getContextPath() + "/admin/order/list.jsp");

    }

    /**
     * creater:litiecheng
     * createDate:2017-10-7
     * discription:修改分类
     * indetail:
     */
    public String findOrderByState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, InvocationTargetException, IllegalAccessException {

        String state_param = request.getParameter("state");
        int state = 0;
        if (state_param != null){
            state = Integer.parseInt(state_param);
        }

        int pageNumber = 1;
        String page_number = request.getParameter("pageNumber");
        if ( page_number != null ){
            pageNumber = Integer.parseInt(page_number);
        }

        int pageSize = 8;
        PageBean<Order> pageBean = null;
        try {
            pageBean = orderService.findOrderByState(state,pageNumber,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("pageBean",pageBean);

        return "/adminOrderServlet?method=findOrderByState";
    }
}