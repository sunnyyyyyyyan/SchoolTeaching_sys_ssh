package com.dao.impl;

import com.dao.GradeTypeDao;
import com.po.GradeType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class GradeTypeDaoImpl implements GradeTypeDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public boolean addGradeType(GradeType gradeType) {
        boolean isSuccess=false;
        try{
            //从SessionFactory中创建session
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            session.save(gradeType); //仅仅只保存于session
            transaction.commit(); //提交到数据库
            isSuccess=true;
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.print(e);
        }
        return isSuccess;
    }

    @Override
    public boolean updateGradeType(GradeType gradeType) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //修改用户
            session.update(gradeType);
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
    public List<GradeType> getGradeTypeData(String sql) {
        List<GradeType> list = new ArrayList<>();
        try{
            //从SessionFactory中创建session
            Session session=sessionFactory.openSession();
            list=session.createQuery(sql).list();
            session.clear();
            session.close();
        }catch(Exception e){
            System.err.print(e);
        }
        return list;
    }

    @Override
    public boolean delGradeType(GradeType gradeType) {
        boolean isSuccess=false;
        try{
            Session session=sessionFactory.openSession();
            Transaction transaction=session.beginTransaction();
            //删除用户
            session.delete(gradeType);
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
