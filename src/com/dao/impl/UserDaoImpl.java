package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

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
	public List<User> getData(String sql) {
		List<User> list=new ArrayList<User>();//接口中只有方法和常量，没有构造方法；类是接口的实现类；隐式转换类型
		try{
			//读取spring配置文件
			//ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			//获取spring中的sessionFactory
			//sessionFactory=ctx.getBean("sessionFactory",SessionFactory.class);
			Session session=sessionFactory.openSession();
			
			/*//加载hibernate配置文件
			SessionFactory sfc=new Configuration().configure().buildSessionFactory();
			//创建会话
			Session session=sfc.openSession();*/
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
			//读取spring配置文件
			//ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			//获取spring中的sessionFactory
			//sessionFactory=ctx.getBean("sessionFactory",SessionFactory.class);
			Session session=sessionFactory.openSession();
			/*//加载配置文件hibernate.cfg.xml
			SessionFactory sfc=new Configuration().configure().buildSessionFactory();
			//创建会话
			Session session=sfc.openSession();*/			
			//启用事务
			Transaction transaction=session.beginTransaction();
			//添加用户
			session.save(user);
			//提交事务
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
			//读取spring配置文件
			//ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			//获取spring中的sessionFactory
			//sessionFactory=ctx.getBean("sessionFactory",SessionFactory.class);
			Session session=sessionFactory.openSession();
			/*//加载配置文件hibernate.cfg.xml
			SessionFactory sfc=new Configuration().configure().buildSessionFactory();
			//创建会话
			Session session=sfc.openSession();	*/		
			//启用事务
			Transaction transaction=session.beginTransaction();
			//删除用户
			session.delete(user);
			//提交事务
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
			//读取spring配置文件
			//ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			//获取spring中的sessionFactory
			//sessionFactory=ctx.getBean("sessionFactory",SessionFactory.class);
			Session session=sessionFactory.openSession();
			/*//加载配置文件hibernate.cfg.xml
			SessionFactory sfc=new Configuration().configure().buildSessionFactory();
			//创建会话
			Session session=sfc.openSession();	*/		
			//启用事务
			Transaction transaction=session.beginTransaction();
			//修改用户
			session.update(user);
			//提交事务
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
