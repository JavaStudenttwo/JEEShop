package com.itheima.dao.impl;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-9-1
 * discription:对商品表进行数据库查询
 * indetail:
 *
 */
public class ProductDaoImpl implements ProductDao{

    @Override
    public List<Product> findProductByword(String word) throws SQLException{
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from Product where pname like ? limit 0,8";
        List<Product> list = queryRunner.query(sql,new BeanListHandler<Product>(Product.class),"%"+word+"%");
        return list;

    }

    @Override
    public List<Product> findByHot() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where is_hot = ? and pflag = ? order by pdate desc limit ?";
        List<Product> list = queryRunner.query(sql,new BeanListHandler<Product>(Product.class),1,0,9);
        return list;
    }

    @Override
    public List<Product> findByNew() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where is_hot = ? and pflag = ? order by pdate desc limit ?";
        List<Product> list = queryRunner.query(sql,new BeanListHandler<Product>(Product.class),0,1,9);
        return list;
    }


    @Override
    public Product findById(String pid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where pid = ?";
        Product product = queryRunner.query(sql,new BeanHandler<Product>(Product.class),pid);
        return product;
    }

    /**
     * creater:litiecheng
     * createDate:2017-9-7
     * discription:查询某一分类的商品的总数
     * indetail:
     *
     */
    @Override
    public int findTotalRecordByCid(String cid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from product where cid = ?";
        Long count = (Long) queryRunner.query(sql,new ScalarHandler(),cid);
        return count.intValue();
    }

    /**
     * creater:litiecheng
     * createDate:2017-9-7
     * discription:分页查询
     * indetail:
     *
     */
    @Override
    public List<Product> findAllByCid(String cid, int startIndex, int pageSize) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from product where cid = ? and pflag = ? order by pdate desc limit ?,?";
        List<Product> list = queryRunner.query(sql ,new BeanListHandler<Product>(Product.class),cid,0,startIndex,pageSize);
        return list;
    }



}
