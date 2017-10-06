package com.itheima.web.servlet;

import com.itheima.domain.*;
import com.itheima.service.OrderService;
import com.itheima.service.impl.OrderServiceImpl;
import com.itheima.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;

/**
 * creater:litiecheng
 * createDate:2017-10-6
 * discription:处理和订单相关的请求
 * indetail:
 *
 */
@WebServlet(name = "OrderServlet" ,urlPatterns = "/orderServlet")
public class OrderServlet extends BaseServlet {

    public void findByUid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IllegalAccessException, SQLException, InvocationTargetException {
        /**设置页码*/
        int pageNumber = 1;
        String number =  request.getParameter("pageNumber");
        if (number != null){
            pageNumber = Integer.getInteger(number);
        }
        /**每页显示数(暂定)*/
        int pageSize = 3;

        User loginUser = (User) request.getSession().getAttribute("loginUser");

        OrderService orderService = new OrderServiceImpl();
        PageBean<Order> pageBean = orderService.findByUid(loginUser,pageNumber,pageSize);

        request.getSession().setAttribute("orderList",pageBean);

        response.sendRedirect(request.getContextPath()+"/jsp/order_list.jsp");
    }

    /**
     * creater:litiecheng
     * createDate:2017-10-6
     * discription:根据购物车中的商品创建订单
     * indetail:
     *
     */
    public void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if (loginUser == null){
            request.getSession().setAttribute("msg", "请登陆后继续购买商品");
           response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        }
        Order order = new Order();
        order.setOid(UUIDUtils.getUUID());
        order.setState(1);
        order.setOrdertime(new Date());
        order.setTotal(cart.getTotal());
        order.setUser(loginUser);
        for (CartItem cartItem: cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemid(UUIDUtils.getUUID());
            orderItem.setCount(cartItem.getCount());
            orderItem.setSubtotal(cartItem.getSubtotal());
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setOrder(order);
            order.getOrderItems().add(orderItem);
        }
        OrderService orderService = new OrderServiceImpl();
        orderService.save(order);

        cart.clearCart();
        request.getSession().setAttribute("order",order);
        response.sendRedirect(request.getContextPath()+"/jsp/order_info.jsp");
    }





























    }
