package com.itheima.web.servlet;

import com.itheima.utils.MailUtils;

import javax.mail.MessagingException;

/**
 * Created by 13718 on 2017/8/29.
 */
public class TestMail {

    public void tsetMial() throws MessagingException {
        MailUtils.sendMail("13718703372@163.com","http://localhost:8080/HeimaShop/active?activeCode=");
    }
}
