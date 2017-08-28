package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 13718 on 2017/8/27.
 */
public class CheckUsernameServlet extends HttpServlet {

    public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        UserService userService = new UserServiceImpl();
        User user = null;

        try {
            user = userService.findByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(user == null){
            response.getWriter().println(1);

        }else if(user != null){
            response.getWriter().println(2);
        }

    }
    public void doPost(HttpServletRequest request ,HttpServletResponse response)throws IOException, ServletException {

    }
}
