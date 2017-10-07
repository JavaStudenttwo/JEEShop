package com.itheima.service;

import com.itheima.domain.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:购物车相关业务处理
 * indetail: 实现类:
 *              com.itheima.service.impl.CategoryServiceImpl
 *
 */
public interface CategoryService {
    List<Category> findAll() throws SQLException;

    int remove(String cid) throws SQLException;

    int add(String cid, String cname) throws SQLException;

    int update(String cid, String cname) throws SQLException;
}
