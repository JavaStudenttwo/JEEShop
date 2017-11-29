package com.itheima.dao;

import com.itheima.dao.impl.HbUserDaoImpl;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * HbUserDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class HbUserDaoImplTest {

    HbUserDaoImpl hbUserDao = new HbUserDaoImpl();
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: query()
     *
     */
    @Test
    public void testQuery() throws Exception {
//TODO: Test goes here...
        hbUserDao.query();
    }

    /**
     *
     * Method: findByUsername(String username)
     *
     */
    @Test
    public void testQBC() throws Exception {
//TODO: Test goes here...
        hbUserDao.QBCQuery();
    }

    /**
     *
     * Method: InsterUser(User user)
     *
     */
    @Test
    public void testInsterUser() throws Exception {
//TODO: Test goes here...
        hbUserDao.add();
    }

    /**
     *
     * Method: findByCode(String code)
     *
     */
    @Test
    public void testFindByCode() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: update(User existUser)
     *
     */
    @Test
    public void testUpdate() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: findByUid(String username)
     *
     */
    @Test
    public void testFindByUid() throws Exception {
//TODO: Test goes here...
    }


}
