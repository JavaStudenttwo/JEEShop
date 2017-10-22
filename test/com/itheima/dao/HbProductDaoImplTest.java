package com.itheima.dao;

import com.itheima.dao.impl.HbProductDaoImpl;
import com.itheima.domain.TProduct;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * HbProductDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class HbProductDaoImplTest {

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
        HbProductDaoImpl productDao = new HbProductDaoImpl();
        List<TProduct> list = (List<TProduct>) productDao.findProductByword("123");

        for (TProduct product : list ){
            System.out.println(product.getPname());
        }
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
    }

    /**
     *
     * Method: findTotalRecord()
     *
     */
    @Test
    public void testFindTotalRecord() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: findAll(int startIndex, int pageSize)
     *
     */
    @Test
    public void testFindAll() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: productDelete(String pid)
     *
     */
    @Test
    public void testProductDelete() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: productAdd(Product product)
     *
     */
    @Test
    public void testProductAdd() throws Exception {
//TODO: Test goes here...
    }


}
