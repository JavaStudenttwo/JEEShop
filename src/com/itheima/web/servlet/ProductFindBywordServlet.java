package com.itheima.web.servlet;

import com.google.gson.Gson;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 13718 on 2017/8/28.
 */
public class ProductFindBywordServlet extends BaseServlet {


    public void checkName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        String word = request.getParameter("word");
        ProductService productService = new ProductServiceImpl();
        List<Product> list = null;
        try {
            list = productService.findProductByword(word);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String json = gson.toJson(list);
        response.getWriter().println(json);



    }

}
