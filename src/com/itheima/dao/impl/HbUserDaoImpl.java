package com.itheima.dao.impl;

import com.itheima.domain.TUser;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * @Date 2017/10/19 19:57
 * @Author CycloneKid sk18810356@gmail.com
 * @PackageName: com.itheima.dao.impl
 * @ClassName: HbUserDaoImpl
 * @Description:
 *
 */
public class HbUserDaoImpl {

    /**
     * @Date 2017/10/19 19:57
     * @Author CycloneKid sk18810356@gmail.com
     * @MethodName: findByUsername
     * @Params: [username]
     * @ReturnType: com.itheima.domain.User
     * @Description: 测试使用Hibernate查询数据库
     *
     */
    public void query() throws SQLException {

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "from TUser";
        Query query = session.createQuery(hql);
        query.setFirstResult(5);
        query.setMaxResults(7);
        List<TUser> list = query.list();
        for (TUser user : list ){
            System.out.println(user.getName());
        }

        transaction.commit();
        HibernateUtils.closeSession(session);

    }

    /**
     * @Date 2017/10/20 22:58
     * @Author CycloneKid sk18810356@gmail.com
     * @MethodName: QBCQuery
     * @Params: []
     * @ReturnType: void
     * @Description: 使用QBC查询数据库
     *
     */
    public void QBCQuery(){

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(TUser.class);

        criteria.setFirstResult(5);
        criteria.setMaxResults(7);
        criteria.addOrder(Order.asc("uid"));

        List<TUser> list = criteria.list();
        for (TUser user : list ){
            System.out.println(user.getName());
        }

        transaction.commit();
        HibernateUtils.closeSession(session);

    }


    /**
     * @Date 2017/10/22 19:51
     * @Author CycloneKid sk18810356@gmail.com
     * @PackageName: com.itheima.dao.impl
     * @ClassName: HbUserDaoImpl
     * @Description:
     *
     */
    public void add(){

        Session session = HibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();

        TUser user = new TUser();
        user.setName("呜呜");
        user.setPassword("2222");
        session.delete(user);

        transaction.commit();
        HibernateUtils.closeSession(session);

    }


}
