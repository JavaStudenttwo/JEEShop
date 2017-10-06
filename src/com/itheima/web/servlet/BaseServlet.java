package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * creater:litiecheng
 * createDate:2017-9-5
 * discription:抽取各servelt的共有功能--使用反射执行方法
 * indetail:
 *
 */
@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {

    /**
     * creater:litiecheng
     * createDate:2017-9-5
     * discription:
     * indetail:1.
     *
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        try {
            /**1、获得请求的method的名称*/
            String methodName = req.getParameter("method");
            if (methodName == null){
                methodName = "excute";
            }
            /**2、获得当前被访问的对象的字节码对象*/
            Class clazz = this.getClass();
            /**3、获得当前字节码对象的中的指定方法*/
            Method method = clazz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);

            /**4、执行相应功能方法*/
            String jsPath = (String) method.invoke(this, req,resp);
            if (jsPath != null){
                req.getRequestDispatcher(jsPath).forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * creater:litiecheng
     * createDate:2017-9-5
     * discription:默认执行此方法
     * indetail:
     *
     */
    public void excute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException, IOException{
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/jsp/index.jsp");

    }

}
