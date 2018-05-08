package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UserDao;
import com.po.User;

public class UserDaoImpl implements UserDao{
	private SessionFactory sessionFactory;//接收注入sessonFactory；
	//private ApplicationContext ctx;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> getAllUserData(int pageNow, int pageSize) {
		Session session = this.sessionFactory.openSession();
		String sql = "from User";
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
	public int findAllUserSize() {
		Session session = this.sessionFactory.openSession();
		String sql = "from User";
		int size = session.createQuery(sql).list().size();
		session.close();
		return size;
	}
	
	@Override
	public List<User> getData(String sql) {
		List<User> list=new ArrayList<>();//接口中只有方法和常量，没有构造方法；类是接口的实现类；隐式转换类型
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
	public boolean addUser(User user) {
		boolean isSuccess=false;
		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			//添加用户
			session.save(user);
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
	public boolean delUser(User user) {
		boolean isSuccess=false;
		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			//删除用户
			session.delete(user);
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
	public boolean updateUser(User user) {
		boolean isSuccess=false;
		try{
			Session session=sessionFactory.openSession();
			Transaction transaction=session.beginTransaction();
			//修改用户
			session.update(user);
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
	public List<User> getAllUserByTeacherData(String userId, int pageNow, int pageSize) {
		return null;
	}

}
