package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.utils.LoginUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 13718 on 2017/8/30.
 */
@WebServlet(name = "UserLoginServlet")
public class UserLoginServlet extends BaseServlet {
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String autoLogin = request.getParameter("autoLogin");
        if ("1".equals(autoLogin)){
            Cookie autoLoginCookie = new Cookie("autoLoginCookie" ,username+"@"+password);
            autoLoginCookie.setPath(request.getContextPath());
            autoLoginCookie.setMaxAge(60*60*24*7);
            response.addCookie(autoLoginCookie);
        }else{
            Cookie autoLoginCookie = new Cookie("autoLonginCookie","");
            autoLoginCookie.setPath(request.getContextPath());
            autoLoginCookie.setMaxAge(0);
            response.addCookie(autoLoginCookie);
        }


        User user = LoginUtils.login(username,password);
        if (user != null){
            request.getSession().setAttribute("loginUser",user);
            response.sendRedirect(request.getContextPath()+"/");
        }else {
            request.setAttribute("msg","用户名或密码不匹配或未激活");
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().removeAttribute("loginUser");

        Cookie cookie = new Cookie("autoLoginCookie","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        response.sendRedirect(request.getContextPath()+"/");
    }
}
