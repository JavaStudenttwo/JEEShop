package com.itheima.web.servlet.UserControl;

import com.itheima.domain.User;
import com.itheima.utils.LoginUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 13718 on 2017/8/30.
 */
@WebServlet(name = "UserLoginServlet" , urlPatterns = "/userlogin")
public class UserLoginServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        /** 获取页面自动登陆选项框的值*/
        String autoLogin = request.getParameter("autoLogin");
        /**如果用户点击了自动登陆*/
        if ("1".equals(autoLogin)) {
            /**1.创建一个Cookie用于记住用户的登录名和密码*/
            Cookie autoLoginCookie = new Cookie("autoLoginCookie", username + "@" + password);
            /**2.设置Cookie的路径为当前路径（即用户登陆）*/
            autoLoginCookie.setPath(request.getContextPath());
            /**3.设置Cookie的生命周期为一周*/
            autoLoginCookie.setMaxAge(60 * 60 * 24 * 7);
            /**4.将Cookie发送到浏览器*/
            response.addCookie(autoLoginCookie);
        } else {
            /**如果用户没有点击自动登陆*/
            Cookie autoLoginCookie = new Cookie("autoLonginCookie", "");
            autoLoginCookie.setPath(request.getContextPath());
            autoLoginCookie.setMaxAge(0);
            response.addCookie(autoLoginCookie);
        }


        User user = LoginUtils.login(username, password);
        if (user != null) {
            request.getSession().setAttribute("loginUser", user);
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            request.setAttribute("msg", "用户名或密码不匹配或未激活");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}