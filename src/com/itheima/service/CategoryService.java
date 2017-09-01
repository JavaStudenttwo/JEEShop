package com.itheima.service;

import com.itheima.domain.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 13718 on 2017/9/1.
 */
public interface CategoryService {
    List<Category> findAll() throws SQLException;
}
