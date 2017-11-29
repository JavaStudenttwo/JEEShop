package com.itheima.service;

import com.itheima.domain.User;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Date 2017/11/29 19:19
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: com.itheima.service
 * @ClassName: UserServiceImplTest
 * @Description: 测试使用Spring框架
 *
 */
public class UserServiceImplTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * @Date 2017/11/29 19:19
     * @Author CycloneKid sk18810356@gmail.com
     * @MethodName: testFindByUsername
     * @Params: []
     * @ReturnType: void
     * @Description: 测试使用Spring框架
     *
     */
    @Test
    public void testFindByUsername() throws Exception {
//TODO: Test goes here...

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("UserServiceImpl");
        User user = userService.findByUsername("张三");
        System.out.println(user);
    }

    /**
     *
     * Method: regist(User user)
     *
     */
    @Test
    public void testRegist() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: activeUser(String code)
     *
     */
    @Test
    public void testActiveUser() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: login(String username, String password)
     *
     */
    @Test
    public void testLogin() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: setUserDaoimpl(UserDaoImpl UserDaoimpl)
     *
     */
    @Test
    public void testSetUserDaoimpl() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: getUserDaoimpl()
     *
     */
    @Test
    public void testGetUserDaoimpl() throws Exception {
//TODO: Test goes here...
    }


}
