package com.itheima.domain;

import java.io.Serializable;

/**
 * creater:litiecheng
 * createDate:2017-9-6
 * discription:购物车项JavaBean
 * indetail:
 *
 */
public class CartItem implements Serializable{
    /**商品项*/
    private Product product;
    /**购买此商品的数量*/
    private int count;
    /**购买此商品的总价*/
    private double subtotal;

    public Product getProduct() { return product; }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**总价通过计算得到*/
    public double getSubtotal() {
        this.subtotal = count*product.getShop_price();
        return subtotal;
    }


}
