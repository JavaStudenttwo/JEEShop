package com.itheima.dao.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.Product;
import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by 13718 on 2017/9/6.
 */
public class OrderDaoImpl implements OrderDao {

    @Override
    public int findTotalRecordByUid(User loginUser) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from orders where uid = ?";
        Long count = (Long) queryRunner.query(sql,new ScalarHandler(),loginUser.getUid());
        return count.intValue();
    }

    @Override
    public List<Order> findAllByUid(User loginUser, int startIndex, int pageSize) throws SQLException, InvocationTargetException, IllegalAccessException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "selectt * from orders where uid = ? order by ordertime desc limit ?,?";
        List<Order> list = queryRunner.query(sql,new BeanListHandler<Order>(Order.class), loginUser.getUid(),startIndex,pageSize);
        for (Order order : list){
            sql = "Select * from orderitem o ,product p where oid = ? and o.pid = p.pid";
            List<Map<String,Object>> oList = queryRunner.query(sql ,new MapListHandler(),order.getOid());
            for (Map<String,Object> map : oList){
                OrderItem orderItem = new OrderItem();
                BeanUtils.populate(orderItem,map);

                Product product = new Product();
                BeanUtils.populate(product,map);

                orderItem.setProduct(product);
                orderItem.setOrder(order);

//                order.getList().add(orderItem);
            }

            order.setUser(loginUser);
        }
        return null;
    }






















}
