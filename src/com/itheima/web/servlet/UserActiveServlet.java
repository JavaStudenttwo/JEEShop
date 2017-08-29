package com.itheima.web.servlet;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 13718 on 2017/8/29.
 */
@WebServlet(name = "UserActiveServlet")
public class UserActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code = request.getParameter("code");

        UserService userService = new UserServiceImpl();
        Boolean bool = null;
        try {
            bool = userService.activeUser(code);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (bool == true){
            request.setAttribute("msg","激活成功，请登录");
            response.sendRedirect(request.getContextPath()+"/longin.jsp");
        }else{
            request.setAttribute("msg","激活失败，请重新发送邮件");
            response.sendRedirect(request.getContextPath()+"/registerFail.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
