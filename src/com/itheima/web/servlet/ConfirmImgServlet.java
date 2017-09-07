package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by 13718 on 2017/8/30.
 */
public class ConfirmImgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String confirm = (String) request.getAttribute("comfirmimg");

//        request.getSession().setAttribute("checkcode_session", word);


        HttpSession session = request.getSession();
        String word = (String) session.getAttribute("checkcode_session");
        if(confirm.equals(word)){
            response.getWriter().println("1");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
