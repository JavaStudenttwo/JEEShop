package com.itheima.domain;

/**
 * Created by 13718 on 2017/9/6.
 */
public class CartItem {
    private Product product;
    private int count;
    private double subtotal;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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


}
