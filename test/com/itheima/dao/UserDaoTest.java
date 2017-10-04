package com.itheima.dao;

import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * UserDaoImpl Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class UserDaoTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: findByUsername(String username)
     *
     */
    @Test
    public void testFindByUsername() throws Exception {
//TODO: Test goes here...

        /**
         * UserDao userDao = new UserDaoImpl();
         * User user = userDao.findByUsername(username);
         * return user;
         *
         */
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findByUsername("cc");
        System.out.println(user);
    }

    /**
     *
     * Method: InsterUser(User user)
     *
     */
    @Test
    public void testInsterUser() throws Exception {
//TODO: Test goes here...
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
     * Method: update(User user)
     *
     */
    @Test
    public void testUpdate() throws Exception {
//TODO: Test goes here...
    }


}
