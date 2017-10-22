package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtils {

    private static SessionFactory sessionFactory;
    static {
        /**加载配置文件*/
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure();
        /**创建一个SessionFactory类型的对象*/
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession(){
        /**使用sessionFactory对象创建session对象*/
        Session session = sessionFactory.openSession();

        return session;
    }

    public static void closeSession(Session session){
        session.close();
    }

}
