package com.itheima.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * creater:litiecheng
 * createDate:2017-9-6
 * discription:订单JavaBean
 * indetail:
 *
 */
public class Order implements Serializable{
    /**该订单的订单号*/
    private String oid;
    /**下单时间*/
    private Date ordertime;
    /**该订单的总金额*/
    private double total;
    /**订单支付状态，1代表未付款，2代表已付款未发货，3代表已发货为收货，4代表收货订单结束 */
    private int state;
    /**收货地址*/
    private String address;
    /**收货人*/
    private String name;
    /**收货人电话*/
    private String telephone;
    /**该订单属于哪个用户*/
    private User user;
    /**该订单中的订单项*/
    List<OrderItem> orderItems = new ArrayList<OrderItem>();



    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
