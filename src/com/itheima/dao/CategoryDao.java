package com.itheima.dao;

import com.itheima.domain.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-9-4
 * discription:购物车操作
 * indetail: 实现类:
 *              com.itheima.dao.impl.CategoryDaoImpl
 *
 */
public interface CategoryDao {
    List<Category> findAll() throws SQLException;

    int remove(String cid) throws SQLException;

    int add(String cid, String cname) throws SQLException;

    int update(String cid, String cname) throws SQLException;
}
