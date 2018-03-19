package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.onlineDao;
import com.po.Online;

public class onlineDaoImpl implements onlineDao {
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	} 
	

	@Override
	public List<Online> getData(String hql) {
		// TODO Auto-generated method stub
		List<Online> list=new ArrayList<Online>();
		try{
			   
			//从SessionFactory中创建session
			Session session=sessionFactory.openSession();	
			list=session.createQuery(hql).list();
			session.clear();
			session.close();
		}catch(Exception e){
			System.err.print(e);
		}
		
		return list;
	}

	@Override
	public boolean addOnline(Online online) {
		// TODO Auto-generated method stub
		boolean isSuccess=false;
		try{
			 
			//从SessionFactory中创建session
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(online); //仅仅只保存于session
			transaction.commit(); //提交到数据库
			isSuccess=true;
			session.clear();
			session.close();
		}catch(Exception e){
			System.err.print(e);
		}
		return isSuccess;
	}

}
