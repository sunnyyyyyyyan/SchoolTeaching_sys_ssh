package com.dao.impl;

import com.dao.TestDao;
import com.po.Test;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TestDaoImpl implements TestDao {
    private SessionFactory sessionFactory;//接收注入sessonFactory；
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Test> getData(String sql) {
        List<Test> list=new ArrayList<>();//接口中只有方法和常量，没有构造方法；类是接口的实现类；隐式转换类型
        try{
            Session session=sessionFactory.openSession();
            //执行hql,将结果存入list
            list=session.createQuery(sql).list();
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.print(e);
        }

        return list;
    }

    @Override
    public boolean addTest(Test test) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //添加用户
            session.save(test);
            transaction.commit();
            isSuccess=true;
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return isSuccess;
    }

    @Override
    public boolean delTest(Test test) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //删除用户
            session.delete(test);
            transaction.commit();
            isSuccess=true;
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return isSuccess;
    }

    @Override
    public boolean updateTest(Test test) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //修改用户
            session.update(test);
            transaction.commit();
            isSuccess=true;
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return isSuccess;
    }

    @Override
    public List<Test> getAllTestData(int pageNow, int pageSize) {
        Session session = this.sessionFactory.openSession();
        String sql = "from Test";
        Query query = session.createQuery(sql);
        query.setFirstResult((pageNow - 1) * pageSize);
        query.setMaxResults(pageSize);
        List list = query.list();
        session.close();
        session=null;
        if (list.size() > 0) {
            return list;
        }
        return null;
    }

    @Override
    public int findAllTestSize() {
        Session session = this.sessionFactory.openSession();
        String sql = "from Test";
        int size = session.createQuery(sql).list().size();
        session.close();
        return size;
    }
}
