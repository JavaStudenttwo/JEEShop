package com.itheima.domain;

import java.io.Serializable;

/**
 * creater:litiecheng
 * createDate:2017-9-6
 * discription:订单项JavaBean
 * indetail:
 *
 */
public class OrderItem implements Serializable{
    /**订单项的id*/
    private String itemid;
    /**订单项内商品的购买数量*/
    private int count;
    /**订单项小计*/
    private double subtotal;
    /**订单项内部的商品*/
    private Product product;
    /**该订单项属于哪个订单*/
    private Order order;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
