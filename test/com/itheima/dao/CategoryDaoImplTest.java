package com.itheima.dao.impl;

import com.itheima.dao.CategoryDao;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * CategoryDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class CategoryDaoImplTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: findAll()
     *
     */
    @Test
    public void testFindAll() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: remove(String cid)
     *
     */
    @Test
    public void testRemove() throws Exception {
//TODO: Test goes here...
        CategoryDao categoryDao = new CategoryDaoImpl();
        int i = categoryDao.remove("9");
        System.out.println(i);

    }

    @Test
    public void testAdd() throws Exception {
        CategoryDao categoryDao = new CategoryDaoImpl();
        int i = categoryDao.add("9","hahaha");
        System.out.println(i);

    }

    @Test
    public void testUpdate() throws Exception {
        CategoryDao categoryDao = new CategoryDaoImpl();
        int i = categoryDao.update("7","汽车工具");
        System.out.println(i);

    }


}
