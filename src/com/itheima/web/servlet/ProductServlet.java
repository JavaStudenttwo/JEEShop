package com.itheima.web.servlet;


import com.google.gson.Gson;
import com.itheima.domain.Category;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.CategoryService;
import com.itheima.service.ProductService;
import com.itheima.service.impl.CategoryServiceImpl;
import com.itheima.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-9-1
 * discription:处理和商品相关的请求
 * indetail:1.用户登录
 *          2.用户退出
 *          3.用户注册
 *          4.AJAX异步校验用户名是否可用
 *          5.AJAX异步校验验证码
 *          6.验证激活码
 *
 */
@WebServlet(name = "ProductServlet",urlPatterns = "/productServlet")
public class ProductServlet extends BaseServlet {

    /**
     * creater:litiecheng
     * createDate:2017-9-1
     * discription:查询数据库中的商品，并展示在商品展示页(product_list.jsp)
     * indetail:
     *
     */
    public void productList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cid = request.getParameter("cid");
        int pageNumber = 1;
        String page_number = request.getParameter("pageNumber");
        if ( page_number != null ){
            pageNumber = Integer.parseInt(page_number);
        }
//        pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize = 12;
        ProductService productService = new ProductServiceImpl();

        PageBean<Product> pageBean = null;
        try {
            pageBean = productService.findByCid(cid,pageNumber,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("pageBean",pageBean.getData().get(0));
        response.sendRedirect(request.getContextPath()+"/jsp/product_list.jsp");


    }

    /**
     * creater:litiecheng
     * createDate:2017-9-7
     * discription:首页根据商品的id(pid)，查找数据库查询商品信息并展示在商品信息页(product_info.jsp)
     * indetail:
     *
     */
    public void productInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pid = request.getParameter("pid");
        ProductService productService = new ProductServiceImpl();

        Product product = null;
        try {
            product = productService.findById(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("product", product);

        /*//浏览历史相关
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

        }*/
        response.sendRedirect(request.getContextPath() + "/jsp/product_info.jsp");

    }

    /**
     * creater:litiecheng
     * createDate:2017-9-1
     * discription:查询数据库中的商品，并展示在商品展示页(product_list.jsp)
     * indetail:
     *
     */
    public void queryByKeyword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        String word = request.getParameter("word");
        ProductService productService = new ProductServiceImpl();
        List<Product> list = null;
        try {
            list = productService.findProductByword(word);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String json = gson.toJson(list);
        response.getWriter().println(json);

    }

    /**
     * creater:litiecheng
     * createDate:2017-9-4
     * discription:查询数据库中的商品，并展示在商品展示页(product_list.jsp)
     * indetail:
     *
     */
    public void listAtHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductServiceImpl();
        List<Product> hotList = null;
        List<Product> newList = null;
        try {
            hotList = productService.findByHOt();
            newList = productService.findByNew();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("hotList",hotList);
        request.getSession().setAttribute("newList",newList);

        response.sendRedirect(request.getContextPath()+"/jsp/index.jsp");
    }

    /**
     * creater:litiecheng
     * createDate:2017-9-4
     * discription:异步查询商品种类
     * indetail:
     *
     */
    public void category(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> allCategory = null;
        try {
            allCategory = categoryService.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        String json = gson.toJson(allCategory);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);
    }


}
