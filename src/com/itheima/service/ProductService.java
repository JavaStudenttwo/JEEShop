package com.itheima.service;

import com.itheima.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 13718 on 2017/8/28.
 */
public interface ProductService {
    List<Product> findProductByword(String word) throws SQLException;

    List<Product> findByHOt() throws SQLException;

    List<Product> findByNew() throws SQLException;

    Product findById(String pid) throws SQLException;
}
