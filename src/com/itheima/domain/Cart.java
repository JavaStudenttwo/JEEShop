package com.itheima.domain;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 13718 on 2017/9/6.
 */
public class Cart {

    private Map<String,CartItem> map = new LinkedHashMap<String ,CartItem>();
    private double total;


    public Collection<CartItem> getCartItems() {
        return map.values();
    }

    public double getTotal(){
        total = 0;
        for (Map.Entry<String,CartItem> entry : map.entrySet()){
            CartItem cartItem = entry.getValue();
            total += cartItem.getSubtotal();
        }
        return total;
    }

    public void addCart(Product product,int count){

        if(product == null){
            return;
        }

        CartItem cartItem = map.get(product.getPid());

        if(cartItem == null){
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCount(count);
            map.put(product.getPid(),cartItem);
        }else{
            cartItem.setCount(cartItem.getCount()+count);
        }

//        total += cartItem.getSubtotal();
//        total += count * product.getShop_price();
    }

    public void removeCart(String id){

        CartItem cartItem = map.remove(id);
        total -= cartItem.getSubtotal();

    }

    public void clearCart(){
        map.clear();
        total = 0;
    }































}
