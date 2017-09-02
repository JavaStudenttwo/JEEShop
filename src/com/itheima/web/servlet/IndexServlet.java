package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 13718 on 2017/9/1.
 */
@WebServlet(name = "IndexServlet")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/jsp/index.jsp");
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.sendRedirect("/jsp/index.jsp");
    }


}
