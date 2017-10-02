package com.itheima.web.servlet.MenuControl;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.service.impl.ProductServiceImpl;
import com.itheima.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 13718 on 2017/9/1.
 */
@WebServlet(name = "IndexServlet" , urlPatterns = "/IndexServlet")
public class IndexServlet extends BaseServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductServiceImpl();
        List<Product> hotList = null;
        List<Product> newList = null;
        try {
            hotList = productService.findByHOt();
            newList = productService.findByNew();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("hotList",hotList);
        request.setAttribute("newList",newList);


        response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");

//        request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





//        Gson gson = new Gson();
//        String hotjson = gson.toJson(hotList);
//        String newjson = gson.toJson(newList);
//        String json = hotjson + "#" + newjson;
//
//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().print(json);

    }


}
