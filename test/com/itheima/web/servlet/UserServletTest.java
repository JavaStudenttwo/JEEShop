package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.utils.UserBeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * UserServlet Tester.
 *
 * @author <Authors name>
 * @version 1.0
 */
public class UserServletTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: login(HttpServletRequest request, HttpServletResponse response)
     *
     */
    @Test
    public void testLogin() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: logout(HttpServletRequest request, HttpServletResponse response)
     *
     */
    @Test
    public void testLogout() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: register(HttpServletRequest request, HttpServletResponse response)
     *
     */
    @Test
    public void testRegister() throws Exception {
//TODO: Test goes here...


        Map<String ,String[]> map = new HashMap<String,String[]>();
        Set<String> set = new HashSet<String>();
        set.add("username");
        set.add("password");
        set.add("name");
        String [] strings = {"cici","123","mimi"};
        map.put(set.toString(),strings);
        System.out.println(set.toString());

        User user = new User();

        try {
            //populate(移植)将前端发送来的数据搞到user对象中
            UserBeanUtils.populate(user, map);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(user);
    }

    /**
     *
     * Method: checkUserName(HttpServletRequest request, HttpServletResponse response)
     *
     */
    @Test
    public void testCheckUserName() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: checkValidatecode(HttpServletRequest request, HttpServletResponse response)
     *
     */
    @Test
    public void testCheckValidatecode() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: active(HttpServletRequest request, HttpServletResponse response)
     *
     */
    @Test
    public void testActive() throws Exception {
//TODO: Test goes here...
    }


}
