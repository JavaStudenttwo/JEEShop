package com.itheima.service;

import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:商品业务处理
 * indetail: 实现类:
 *              com.itheima.service.impl.ProductServiceImpl
 *
 */
public interface ProductService {

    List<Product> findProductByword(String word) throws SQLException;

    List<Product> findByHOt() throws SQLException;

    List<Product> findByNew() throws SQLException;

    Product findById(String pid) throws SQLException;

    PageBean<Product> findByCid(String cid, int pageNumber, int pageSize) throws SQLException;

    PageBean<Product> findAll(int pageNumber, int pageSize) throws SQLException;

    int productDelete(String pid) throws SQLException;
}
