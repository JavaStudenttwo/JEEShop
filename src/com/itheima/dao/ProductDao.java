package com.itheima.dao;

import com.itheima.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:商品数据操作
 * indetail: 实现类:
 *              com.itheima.dao.impl.ProductDaoImpl
 *
 */
public interface ProductDao {
    List<Product> findProductByword(String word) throws SQLException;

    List<Product> findByHot() throws SQLException;

    List<Product> findByNew() throws SQLException;

    Product findById(String pid) throws SQLException;

    int findTotalRecordByCid(String cid) throws SQLException;

    List<Product> findAllByCid(String cid, int startIndex, int pageSize) throws SQLException;

    int findTotalRecord() throws SQLException;

    List<Product> findAll(int startIndex, int pageSize) throws SQLException;

    int productDelete(String pid) throws SQLException;

    /**该方法不能使用*/
    /*List<Product> findByOid(String oid) throws SQLException;*/

}
