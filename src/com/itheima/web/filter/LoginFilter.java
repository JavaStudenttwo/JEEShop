package com.itheima.web.filter;

import com.itheima.domain.User;
import com.itheima.utils.CookieUtils;
import com.itheima.utils.LoginUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 13718 on 2017/8/31.
 */
@WebFilter(filterName = "LoginFilter" )
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        //已经登陆放行
        User loginUser = (User)request.getSession().getAttribute("loginUser");
        if (loginUser != null){
            chain.doFilter(request,response);
            return;
        }

        Cookie userCookie = CookieUtils.findCookie(request.getCookies(),"autoLoginCookie");
        if (userCookie != null){
            String[] u = userCookie.getValue().split("@");
            String username = u[0];
            String password = u[1];
            User user = LoginUtils.login(username,password);
            session.setAttribute("loginUser",user);
        }

        chain.doFilter(request,response);





    }

    public void init(FilterConfig config) throws ServletException {

    }

}
