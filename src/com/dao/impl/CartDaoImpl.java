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
			   
			//��SessionFactory�д���session
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
	public boolean addItemToCart(Cart cart) {//���º����
		// TODO Auto-generated method stub
		boolean isSuccess=false;
		try{
			 
			//��SessionFactory�д���session
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			session.save(cart); //����ֻ������session
			transaction.commit(); //�ύ�����ݿ�
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
			//��SessionFactory�д���session
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			//����û�
			session.delete(cart);
			//�ύ����
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
