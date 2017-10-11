package com.itheima.dao;

import com.itheima.dao.impl.ProductDaoImpl;
import com.itheima.domain.Product;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Date;
import java.util.List;

/**
 * ProductDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class ProductDaoImplTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: findProductByword(String word)
     *
     */
    @Test
    public void testFindProductByword() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: findByHot()
     *
     */
    @Test
    public void testFindByHot() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: findByNew()
     *
     */
    @Test
    public void testFindByNew() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: findById(String pid)
     *
     */
    @Test
    public void testFindById() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: findTotalRecordByCid(String cid)
     *
     */
    @Test
    public void testFindTotalRecordByCid() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: findAllByCid(String cid, int startIndex, int pageSize)
     *
     */
    @Test
    public void testFindAllByCid() throws Exception {
//TODO: Test goes here...
        ProductDao productDao = new ProductDaoImpl();
        List<Product> list = productDao.findAllByCid("2",1,4);
        for (Product item: list) {
            System.out.println(item);
        }

    }

    @Test
    public void testProductAdd() throws Exception {
//TODO: Test goes here...
        ProductDao productDao = new ProductDaoImpl();
        Product product = new Product();
        product.setPid("1");
        product.setCid("1");
        product.setPdate(new Date());
        int i = productDao.productAdd(product);
        System.out.println(i);

    }

    @Test
    public void test(){
        int totalRecord = 8;
        int pageSize = 4;
        int totalPage = 0;
        if ( totalRecord % pageSize == 0){
            totalPage = totalRecord / pageSize ;
        }else {
            totalPage = totalRecord / pageSize + 1 ;
        }
        System.out.println(totalPage);
    }


}
