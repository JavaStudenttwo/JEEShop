package com.itheima.dao.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.Product;
import com.itheima.domain.User;
import com.itheima.utils.DataSourceUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * creater:litiecheng
 * createDate:2017-10-6
 * discription:订单操作
 * indetail:
 *
 */
public class OrderDaoImpl implements OrderDao {

    /**
     * creater:litiecheng
     * createDate:2017-10-6
     * discription:根据用户id查找该用户的订单总数
     * indetail:
     *
     */
    @Override
    public int findTotalRecordByUid(User loginUser) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from orders where uid = ?";
        Long count = (Long) queryRunner.query(sql,new ScalarHandler(),loginUser.getUid());
        return count.intValue();
    }

    /**
     * creater:litiecheng
     * createDate:2017-10-6
     * discription:根据用户id查找该用户的所有订单详细信息
     * indetail:
     *
     */
    @Override
    public List<Order> findAllByUid(User loginUser, int startIndex, int pageSize) throws SQLException, InvocationTargetException, IllegalAccessException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        /**查询数据库获得该用户所有订单order*/
        String sql = "select * from orders where uid = ? order by ordertime desc limit ?,?";
        List<Order> list = queryRunner.query(sql,new BeanListHandler<Order>(Order.class), loginUser.getUid(),startIndex,pageSize);
        /**使用循环查询orderitem和product，将两张表的属性打乱封装到一个map中*/
        for (Order order : list){
            sql = "Select * from orderitem o ,product p where oid = ? and o.pid = p.pid";
            /**因为一个oid能查出多个orderitem(即一个订单中有多个订单项)，所以查询结果用List集合封装*/
            List<Map<String,Object>> oList = queryRunner.query(sql ,new MapListHandler(),order.getOid());
            for (Map<String,Object> map : oList){
                OrderItem orderItem = new OrderItem();
                BeanUtils.populate(orderItem,map);

                Product product = new Product();
                BeanUtils.populate(product,map);

                orderItem.setProduct(product);
                orderItem.setOrder(order);

                order.getOrderItems().add(orderItem);
            }

            order.setUser(loginUser);
        }
        return list;
    }

    @Override
    public void save(Connection connection, Order order) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into orders values (?,?,?,?,?,?,?,?)";
        Object[] params = {order.getOid(),order.getOrdertime(),order.getTotal(),
                           order.getState(),order.getAddress(),order.getName(),
                           order.getTelephone(),order.getUser().getUid()};
        queryRunner.update(connection,sql,params);
    }

    @Override
    public void save(Connection connection, OrderItem orderItem) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql = "insert into orderitem values (?,?,?,?,?)";
        Object[] params = {orderItem.getItemid(),orderItem.getCount(),
                           orderItem.getSubtotal(),orderItem.getProduct().getPid(),
                           orderItem.getOrder().getOid()};
        queryRunner.update(connection,sql,params);
    }

    /**
     * creater:litiecheng
     * createDate:2017-10-7
     * discription:根据订单id(oid)查询订单(错误方法，不可用)
     * indetail:查询订单只能使用多表查询，单表查询不可行
     *
     */
    /*@Override
    public Order findOrderByOid(String oid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from orders where oid = ?";
        Order order = queryRunner.query(sql,new BeanHandler<Order>(Order.class),oid);
        return order;
    }*/

    /**
     * creater:litiecheng
     * createDate:2017-10-7
     * discription:根据订单id(oid)查询订单项(错误方法，不可用)
     * indetail:查询订单只能使用多表查询，单表查询不可行
     *
     */
    /*@Override
    public List<OrderItem> findOrderItemByOid(String oid) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from OrderItem where oid = ?";
        List<OrderItem> list = queryRunner.query(sql,new BeanListHandler<OrderItem>(OrderItem.class),oid);
        return list;
    }*/

    /**
     * creater:litiecheng
     * createDate:2017-10-7
     * discription:根据订单id(oid)查询订单
     * indetail:多表查询
     *
     */
    @Override
    public Order findByOid(String oid) throws SQLException, InvocationTargetException, IllegalAccessException {
        QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from orders where oid = ? ";
        Order order = queryRunner.query(sql,new BeanHandler<Order>(Order.class),oid);

        sql = "Select * from orderitem o ,product p where oid = ? and o.pid = p.pid";
        List<Map<String,Object>> list = queryRunner.query(sql ,new MapListHandler(),oid);
        List<OrderItem> orderItemList = new LinkedList<OrderItem>();
        for (Map<String,Object> map : list){
            OrderItem orderItem = new OrderItem();
            BeanUtils.populate(orderItem,map);

            Product product = new Product();
            BeanUtils.populate(product,map);

            orderItem.setProduct(product);
            orderItem.setOrder(order);

            orderItemList.add(orderItem);
        }
        order.setOrderItems(orderItemList);
        return order;
    }

}
