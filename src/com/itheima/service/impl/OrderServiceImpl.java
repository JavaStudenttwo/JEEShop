package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.dao.impl.OrderDaoImpl;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.domain.PageBean;
import com.itheima.domain.User;
import com.itheima.service.OrderService;
import com.itheima.utils.DataSourceUtils;
import com.itheima.utils.JDBCUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-8-30
 * discription:订单业务处理
 * indetail:
 *
 */
public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();
    /**
     * creater:litiecheng
     * createDate:2017-10-6
     * discription:分页查询订单
     * indetail:
     *
     */
    @Override
    public PageBean<Order> findByUid(User loginUser, int pageNumber, int pageSize) throws SQLException, InvocationTargetException, IllegalAccessException {
        /**先查询数据库获得总的订单数*/
        int totalRecord = orderDao.findTotalRecordByUid(loginUser);
        /**通过pageBean的构造方法获取startIndex和pageSize*/
        PageBean<Order> pageBean = new PageBean<Order>(pageNumber,pageSize,totalRecord);
        /**分页查询*/
        List<Order> data = orderDao.findAllByUid(loginUser,pageBean.getStartIndex(),pageBean.getPageSize());

        pageBean.setData(data);
        return pageBean;
    }

    /**
     * creater:litiecheng
     * createDate:2017-10-6
     * discription:
     * indetail:
     *
     */
    public void save(Order order) throws SQLException {
        /**如果直接调用getConnection方法，会报aotoCommit异常，换用开启事务方法，禁止aotoCommit*/
        Connection connection = DataSourceUtils.startTransaction();
        orderDao.save(connection,order);
        for (OrderItem orderItem:order.getOrderItems()) {
            orderDao.save(connection,orderItem);
        }
        DataSourceUtils.commitAndRelease();
    }

    /**
     * creater:litiecheng
     * createDate:2017-10-7
     * discription:根据oid查找订单
     * indetail:
     *
     */
    @Override
    public Order findByOid(String oid) throws SQLException, InvocationTargetException, IllegalAccessException {
        /**尝试使用单表查询，失败*/
        /*Order order = orderDao.findOrderByOid(oid);
        List<OrderItem> orderItemlist = orderDao.findOrderItemByOid(oid);
        List<Product> productList = productDao.findByOid(oid);
        for (OrderItem oitem:orderItemlist) {
            String pid = oitem.getPid();
            for (Product pitem:productList) {
                if (pid == pitem.getPid()){
                    oitem.setProduct(pitem);
                    break;
                }
            }
        }
        order.setOrderItems(orderItemlist);
        return order;*/
        Order order = orderDao.findByOid(oid);
        return order;
    }

    /**
     * creater:litiecheng
     * createDate:2017-10-8
     * discription:商城后台显示所有订单
     * indetail:
     *
     */
    @Override
    public PageBean<Order> orderList(int pageNumber, int pageSize) throws IllegalAccessException, SQLException, InvocationTargetException {

        int totalRecord = orderDao.findTotalRecord();

        PageBean pageBean = new PageBean(pageNumber,pageSize,totalRecord);

        List<Order> list = orderDao.orderList(pageBean.getStartIndex(),pageBean.getPageSize());

        pageBean.setData(list);

        return pageBean;
    }

    /**
     * creater:litiecheng
     * createDate:2017-10-8
     * discription:商城后台按照订单状态显示订单
     * indetail:
     *
     */
    @Override
    public PageBean<Order> findOrderByState(int state, int pageNumber, int pageSize) throws IllegalAccessException, SQLException, InvocationTargetException {

        int totalRecord = orderDao.findTotalRecordByState(state);

        PageBean pageBean = new PageBean(pageNumber,pageSize,totalRecord);

        List<Order> list = orderDao.findOrderByState(state,pageBean.getStartIndex(),pageBean.getPageSize());

        pageBean.setData(list);

        return pageBean;
    }

    /**
     * @Date 2017/10/14 15:34
     * @Author CycloneKid sk18810356@gmail.com
     * @MethodName: transfer
     * @Params: [name, to, money]
     * @ReturnType: void
     * @Description:
     *
     */
    @Override
    public void transfer(String name, String to, String money) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        try {
            connection = JDBCUtils.getDataSource();
            /**开始事务*/
            connection.setAutoCommit(false);

            int money_int = Integer.parseInt(money);
            orderDao.outMoney(connection,name,money_int);

            orderDao.inMoney(connection,to,money_int);

            connection.commit();
        }catch (Exception e){
            try{
                if (connection != null){
                    /**发生错误则事务回滚*/
                    connection.rollback();
                }
            }catch (Exception e2){

            }
            throw new RuntimeException(e);
        }finally {
            /**关闭数据库资源*/
            JDBCUtils.closeResouce(connection,null,null);
        }



    }







}
