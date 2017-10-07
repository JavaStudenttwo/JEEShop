package com.itheima.web.servlet;

import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.service.impl.CategoryServiceImpl;
import com.itheima.utils.UUIDUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-10-7
 * discription:处理和后台商品管理相关的请求
 * indetail:
 *
 */
@WebServlet(name = "AdminProductServlet" ,urlPatterns = "/adminProductServlet")
public class AdminProductServlet extends BaseServlet {

    CategoryService categoryService = new CategoryServiceImpl();

    /**
     * creater:litiecheng
     * createDate:2017-10-7
     * discription:查询分类
     * indetail:
     */
    public void categoryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> allCategory = new LinkedList<Category>();
        try {
            allCategory = categoryService.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("allCategory", allCategory);
        response.sendRedirect(request.getContextPath() + "/admin/category/list.jsp");
    }

    /**
     * creater:litiecheng
     * createDate:2017-10-7
     * discription:删除分类
     * indetail:
     */
    public String  categoryRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String cid = request.getParameter("cid");
        int i = categoryService.remove(cid);

        return "/adminProductServlet?method=categoryList";
    }

    /**
     * creater:litiecheng
     * createDate:2017-10-7
     * discription:添加分类
     * indetail:
     */
    public String categoryAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String cname = request.getParameter("cname");
        String cid = UUIDUtils.getUUID();
        int i = categoryService.add(cid,cname);

        return "/adminProductServlet?method=categoryList";
    }

    /**
     * creater:litiecheng
     * createDate:2017-10-7
     * discription:跳转的修改页面
     * indetail:
     */
    public void toUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String cname = request.getParameter("cname");
        String cid = request.getParameter("cid");
        Category category = new Category();
        category.setCname(cname);
        category.setCid(cid);
        request.getSession().setAttribute("categoryItem",category);

        response.sendRedirect(request.getContextPath() + "/admin/category/edit.jsp");
    }

    /**
     * creater:litiecheng
     * createDate:2017-10-7
     * discription:修改分类
     * indetail:
     */
    public String categoryUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        String cname = request.getParameter("cname");
        String cid = request.getParameter("cid");
        int i = categoryService.update(cid,cname);

        return "/adminProductServlet?method=categoryList";
    }


}
