package com.itheima.dao.impl;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 13718 on 2017/8/28.
 */
public class ProductDaoImpl implements ProductDao{

    @Override
    public List<Product> findProductByword(String conditon ,Object[] params) throws SQLException{

        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from Product where where 1=1  " + conditon;
        List<Product> list = queryRunner.query(sql,new BeanListHandler<Product>(Product.class),params);
        return list;

    }
}
