package com.itheima.dao;

import com.itheima.domain.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 13718 on 2017/9/1.
 */
public interface CategoryDao {
    List<Category> findAll() throws SQLException;
}
