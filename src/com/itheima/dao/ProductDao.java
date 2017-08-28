package com.itheima.dao;

import com.itheima.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 13718 on 2017/8/28.
 */
public interface ProductDao {
    List<Product> findProductByword(String condition, Object[] params) throws SQLException;
}
