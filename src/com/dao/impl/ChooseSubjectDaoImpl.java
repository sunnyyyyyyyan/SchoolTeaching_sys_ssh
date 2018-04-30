package com.dao.impl;

import com.dao.ChooseSubjectDao;
import com.po.ChooseSubject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ChooseSubjectDaoImpl implements ChooseSubjectDao {
    private SessionFactory sessionFactory;//接收注入sessonFactory；
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<ChooseSubject> getData(String sql) {
        List<ChooseSubject> list=new ArrayList<>();//接口中只有方法和常量，没有构造方法；类是接口的实现类；隐式转换类型
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
    public boolean addChooseSubject(ChooseSubject chooseSubject) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //添加用户
            session.save(chooseSubject);
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
    public boolean delChooseSubject(ChooseSubject chooseSubject) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //删除用户
            session.delete(chooseSubject);
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
    public boolean updateChooseSubject(ChooseSubject chooseSubject) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //修改用户
            session.update(chooseSubject);
            transaction.commit();
            isSuccess=true;
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.println(e);
        }
        return isSuccess;
    }
}
