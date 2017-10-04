package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import com.itheima.utils.UUIDUtils;
import com.itheima.utils.UserBeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:处理和用户信息相关的请求
 * indetail:1.用户登录
 *          2.用户退出
 *          3.用户注册
 *          4.AJAX异步校验用户名是否可用
 *          5.AJAX异步校验验证码
 *          6.验证激活码
 *
 */
@WebServlet(name = "UserServlet" , urlPatterns = "/userServlet")
public class UserServlet extends BaseServlet {


    /**
     * creater:litiecheng
     * createDate:2017-8-30
     * discription:用户登录处理
     * indetail:1.查询数据库验证用户名和密码
     *          2.如果使用自动登录，再添加一个cookie
     *
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

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

        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);
        if (user != null) {
            request.getSession().setAttribute("loginUser", user);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            request.setAttribute("msg", "用户名或密码不匹配或未激活");
            response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
        }
    }

    /**
     * creater:litiecheng
     * createDate:2017-8-30
     * discription:用户退出
     * indetail:1.删除session中的用户信息
     *          2.删除cookie中的自动登录相关信息
     *
     */
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().removeAttribute("loginUser");

        Cookie cookie = new Cookie("autoLoginCookie","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        response.sendRedirect(request.getContextPath()+"/");
    }

    /**
     * creater:litiecheng
     * createDate:2017-8-31
     * discription:用户注册
     * indetail:1.从前端获取用户数据
     *          2.将用户数据存入数据库
     *          3.*发送邮件激活
     *
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        User user = new User();

        try {
            //populate(移植)将前端发送来的数据搞到user对象中
            UserBeanUtils.populate(user, request.getParameterMap());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        user.setUid(UUIDUtils.getUUID());
        user.setTelephone(null);
        user.setCode(UUIDUtils.getUUID());
        user.setState(0);

        UserService userService = new UserServiceImpl();
        int i = 0;
        try {
            i = userService.regist(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (i>0 ){

            /*request.setAttribute("msg","注册成功，请邮件激活后登陆");

            String mailMasg = "恭喜您注册成功，请点击下面的连接进行激活账户"
                    + "<a href='http://localhost:8080/HeimaShop/useractive?activeCode="+user.getCode()+"'>"
                    + "http://localhost:8080/HeimaShop/useractive?activeCode="+user.getCode()+"</a>";
            try {
                MailUtils.sendMail(user.getEmail(),mailMasg);
            } catch (MessagingException e) {
                e.printStackTrace();
            }*/

            //注册成功后转到登录页面
            response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");

        }else {
            //出现问题则转到注册页面
            response.sendRedirect(request.getContextPath()+"/jsp/register.jsp");
        }

    }

    /**
     * creater:litiecheng
     * createDate:2017-8-31
     * discription:AJAX异步校验用户名是否可用
     * indetail:1.查询数据库获得用户名信息
     *
     */
    public void checkUserName(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        UserService userService = new UserServiceImpl();
        User user = null;

        try {
            user = userService.findByUsername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Boolean isExist = false;

        if(user == null){
            isExist = false;
        }else if(user != null){
            isExist = true;
        }
        response.getWriter().write("{\"isExist\":"+isExist+"}");

    }

    /**
     * creater:litiecheng
     * createDate:2017-10-4
     * discription:AJAX异步校验验证码
     * indetail:1.检验用户输入的验证码是否正确
     *
     */
    public void checkValidatecode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String confirm = request.getParameter("validatecode");

        HttpSession session = request.getSession();
        String word = (String) session.getAttribute("key");
        boolean boole;
        if (confirm.equals(word)) {
            boole = true;
        }else {
            boole = false;
        }
        response.getWriter().write("{\"boole\":"+boole+"}");

    }

    /**
     * creater:litiecheng
     * createDate:2017-9-5
     * discription:验证激活码
     * indetail:
     *
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code = request.getParameter("activecode");

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




}