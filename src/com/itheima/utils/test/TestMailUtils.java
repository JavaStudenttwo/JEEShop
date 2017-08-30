package com.itheima.utils.test;

import com.itheima.utils.MailUtils;

import javax.mail.MessagingException;

/**
 * Created by 13718 on 2017/8/29.
 */
public class TestMailUtils {
    public void testMailUtils() throws MessagingException {
        String email = "wtlf_229@163.com";
        String mailMasg = "恭喜您注册成功，请点击下面的连接进行激活账户"
                + "<a href='http://localhost:8080/HeimaShop/useractive?activeCode=123456'>"
                + "http://localhost:8080/HeimaShop/useractive?activeCode=123456</a>";
        MailUtils.sendMail(email,mailMasg);
    }
}
