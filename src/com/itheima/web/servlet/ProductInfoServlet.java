package com.itheima.web.servlet;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.service.impl.ProductServiceImpl;
import com.itheima.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by 13718 on 2017/9/4.
 */
@WebServlet(name = "ProductInfoServlet", urlPatterns = "/ProductInfoServlet" )
public class ProductInfoServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pid = request.getParameter("pid");
        ProductService productService = new ProductServiceImpl();

        Product product = null;
        try {
            product = productService.findById(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("product", product);





        //浏览历史相关
        Cookie cookie = CookieUtils.findCookie(request.getCookies(),"history");

        if (cookie == null){
            Cookie c = new Cookie("history",pid);
            c.setPath("/");
            c.setMaxAge(7*24*60*60);
            response.addCookie(c);
        }else{
            String value = cookie.getValue();
            String[] ids = value.split("-");
            LinkedList<String> list = new LinkedList<String>(Arrays.asList(ids));

            if (list.contains(pid)){
                list.remove(pid);
                list.addFirst(pid);
            }else{
                if (list.size() >= 6){
                    list.removeLast();
                    list.addFirst(pid);
                }else{
                    list.addFirst(pid);
                }
            }

            StringBuffer sb = new StringBuffer();
            for (String id : list){
                sb.append(id+"-");
            }

            String history = sb.substring(0, sb.length()-1);
            Cookie c = new Cookie("history",history);
            c.setPath("/");
            c.setMaxAge(7*24*60*60);
            response.addCookie(c);

        }


        response.sendRedirect(request.getContextPath() + "/jsp/product_info.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }





















}
