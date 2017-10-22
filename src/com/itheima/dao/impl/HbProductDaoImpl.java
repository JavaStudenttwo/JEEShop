package com.itheima.dao.impl;

import com.itheima.domain.TProduct;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

/** 
 * @Date 2017/10/19 19:58
 * @Author CycloneKid sk18810356@gmail.com 
 * @PackageName: com.itheima.dao.impl
 * @ClassName: HbProductDaoImpl 
 * @Description: 学习使用Hibernate操作数据库
 *
 */
public class HbProductDaoImpl {


    /**
     * @Date 2017/10/20 22:57
     * @Author CycloneKid sk18810356@gmail.com
     * @MethodName: findProductByword
     * @Params: [word]
     * @ReturnType: java.util.List<com.itheima.domain.TProduct>
     * @Description: 最原始的Hibernate使用方式
     *
     */
    public List<TProduct> findProductByword(String word) throws SQLException {

        /**加载配置文件*/
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure();
        /**创建一个SessionFactory类型的对象*/
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        /**使用sessionFactory对象创建session对象*/
        Session session = sessionFactory.openSession();
        /**开启事务*/
        Transaction transaction = session.beginTransaction();

        String hql = "from TProduct where pname like '%?%'";

        Query query = session.createQuery(hql);

        List<TProduct> list = query.list();

        transaction.commit();
        session.close();

        return list;
    }


}
