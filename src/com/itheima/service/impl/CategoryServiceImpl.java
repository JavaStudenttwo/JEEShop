package com.itheima.service.impl;

import com.itheima.dao.CategoryDao;
import com.itheima.dao.impl.CategoryDaoImpl;
import com.itheima.domain.Category;
import com.itheima.service.CategoryService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 13718 on 2017/9/1.
 */
public class CategoryServiceImpl implements CategoryService{

    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() throws SQLException {
        List<Category> list = categoryDao.findAll();
        return list;
    }
}
