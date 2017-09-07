package com.itheima.web.servlet;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 13718 on 2017/9/5.
 */
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cid = request.getParameter("cid");
        int pageNumber = 1;
        String page_number = request.getParameter("pageNumber");
        if ( page_number != null ){
            pageNumber = Integer.parseInt(page_number);
        }
//        pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = 12;
        ProductService productService = new ProductServiceImpl();

        PageBean<Product> pageBean = null;
        try {
            pageBean = productService.findByCid(cid,pageNumber,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("pageBean",pageBean.getData().get(0));
        response.sendRedirect(request.getContextPath()+"/jsp/product_list.jsp");















    }
}
