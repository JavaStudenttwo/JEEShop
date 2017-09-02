package com.itheima.web.servlet;

import com.google.gson.Gson;
import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 13718 on 2017/9/1.
 */
@WebServlet(name = "IndexServlet")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> allCategory = null;
        try {
            allCategory = categoryService.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        String json = gson.toJson(allCategory);

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);


        response.sendRedirect("/jsp/index.jsp");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


}
