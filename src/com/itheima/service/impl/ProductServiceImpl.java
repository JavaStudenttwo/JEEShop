package com.itheima.service.impl;

import com.itheima.dao.ProductDao;
import com.itheima.dao.impl.ProductDaoImpl;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 13718 on 2017/8/28.
 */
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> findProductByword(String word) throws SQLException {

//        StringBuilder builder = new StringBuilder();
//        List<Object> paramList = new ArrayList<Object>();
//
//        if(word != null){
//            StringBuilder wordBuilder = new StringBuilder();
//            wordBuilder.append("%");
//            for (int i=0 ;i<word.length() ;i++){
//                wordBuilder.append(word.charAt(i)).append("%");
//            }
//            builder.append(" and pname like ?");
//            paramList.add(wordBuilder.toString());
//
//            builder.append(" or pinyin like ?");
//            paramList.add(wordBuilder.toString());
//        }
//
//        String condition = builder.toString();
//        Object[] params = paramList.toArray();
//
//        ProductDao productDao = new ProductDaoImpl();
//        return productDao.findProductByword(condition,params);
        ProductDao productDao = new ProductDaoImpl();
        return productDao.findProductByword(word);



    }
}
