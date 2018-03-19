package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dao.CartDao;
import com.po.Cart;

public class CartDaoImpl implements CartDao {
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	} 
	
	@Override
	public List<Cart> getData(String hql) {
		// TODO Auto-generated method stub
		List<Cart> list=new ArrayList<Cart>();
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
	public boolean addItemToCart(Cart cart) {//更新和添加
		// TODO Auto-generated method stub
		boolean isSuccess=false;
		try{
			 
			//从SessionFactory中创建session
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(cart); //仅仅只保存于session
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
	public boolean deletItemFromCart(Cart cart) {
		// TODO Auto-generated method stub
		boolean isSuccess=false;
		try{
			//从SessionFactory中创建session
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			//添加用户
			session.delete(cart);
			//提交事务
			transaction.commit();
			isSuccess=true;
			session.clear();
			session.close();
		}catch(Exception e){
			System.err.print(e);
		}
		return isSuccess;
	}

}
