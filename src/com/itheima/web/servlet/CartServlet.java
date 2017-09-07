package com.itheima.web.servlet;

import com.itheima.domain.Cart;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 13718 on 2017/9/7.
 */
@WebServlet(name = "CartServlet" , urlPatterns = "/CartServlet")
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pid = request.getParameter("pid");
        String countStr = request.getParameter("count");
        int count = Integer.parseInt(countStr);

        ProductService productService = new ProductServiceImpl();
        Product product = null;
        try {
            product = productService.findById(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Cart cart = getCart(request.getSession());
        cart.addCart(product,count);

        String str = "Heimashop";
        request.setAttribute("str",str);

        response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");

    }

    public static Cart getCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        return cart;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }








































}
