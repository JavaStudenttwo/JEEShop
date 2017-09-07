package com.itheima.web.servlet;

import com.itheima.domain.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 13718 on 2017/9/7.
 */
public class CartClearServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cart cart = CartServlet.getCart(request.getSession());

        cart.clearCart();

        response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
    }
































}
