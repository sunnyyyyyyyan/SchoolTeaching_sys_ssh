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
	private SessionFactory sessionFactory;//����ע��sessonFactory��
	//private ApplicationContext ctx;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public List<User> getData(String hql) {
		List<User> list=new ArrayList<User>();//�ӿ���ֻ�з����ͳ�����û�й��췽�������ǽӿڵ�ʵ���ࣻ��ʽת������
		try{
			//��ȡspring�����ļ�
			//ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			//��ȡspring�е�sessionFactory
			//sessionFactory=ctx.getBean("sessionFactory",SessionFactory.class);
			Session session=sessionFactory.openSession();
			
			/*//����hibernate�����ļ�
			SessionFactory sfc=new Configuration().configure().buildSessionFactory();
			//�����Ự
			Session session=sfc.openSession();*/
			//ִ��hql,���������list
			list=session.createQuery(hql).list();
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
			//��ȡspring�����ļ�
			//ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			//��ȡspring�е�sessionFactory
			//sessionFactory=ctx.getBean("sessionFactory",SessionFactory.class);
			Session session=sessionFactory.openSession();
			/*//���������ļ�hibernate.cfg.xml
			SessionFactory sfc=new Configuration().configure().buildSessionFactory();
			//�����Ự
			Session session=sfc.openSession();*/			
			//��������
			Transaction transaction=session.beginTransaction();
			//����û�
			session.save(user);
			//�ύ����
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
			//��ȡspring�����ļ�
			//ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			//��ȡspring�е�sessionFactory
			//sessionFactory=ctx.getBean("sessionFactory",SessionFactory.class);
			Session session=sessionFactory.openSession();
			/*//���������ļ�hibernate.cfg.xml
			SessionFactory sfc=new Configuration().configure().buildSessionFactory();
			//�����Ự
			Session session=sfc.openSession();	*/		
			//��������
			Transaction transaction=session.beginTransaction();
			//ɾ���û�
			session.delete(user);
			//�ύ����
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
			//��ȡspring�����ļ�
			//ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
			//��ȡspring�е�sessionFactory
			//sessionFactory=ctx.getBean("sessionFactory",SessionFactory.class);
			Session session=sessionFactory.openSession();
			/*//���������ļ�hibernate.cfg.xml
			SessionFactory sfc=new Configuration().configure().buildSessionFactory();
			//�����Ự
			Session session=sfc.openSession();	*/		
			//��������
			Transaction transaction=session.beginTransaction();
			//�޸��û�
			session.update(user);
			//�ύ����
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
