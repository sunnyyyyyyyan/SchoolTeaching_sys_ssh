package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.ProductDao;
import com.po.Product;

public class ProductDaoImpl implements ProductDao {
	//接收sessionFactory
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Product> getAllProduct(int pageNow, int pageSize){// 查询所有学生 分页页  
        Session session = this.sessionFactory.openSession();//父类方法  
        String hql = "from Product";
        Query query = session.createQuery(hql);//执行查询操作  
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
    public int findProductSize() {// 所有个数  
        Session session =this.sessionFactory.openSession(); 
        String hql = "from Product";  
        int size = session.createQuery(hql).list().size();  
        session.close();  
        return size;  
    }
    public List<Product> getProductBySort(String sort, int pageNow, int pageSize){// 查询所有学生 分页页  
        Session session = this.sessionFactory.openSession();//父类方法  
        String hql = "from Product where sort="+sort;
        Query query = session.createQuery(hql);//执行查询操作  
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
    public int findProductSizeBySort(String sort) {// 所有个数  
        Session session =this.sessionFactory.openSession(); 
        String hql = "from Product where sort="+sort;  
        int size = session.createQuery(hql).list().size();  
        session.close();  
        return size;  
    }
	
	@Override
	public List<Product> getData(String hql) {
		// TODO Auto-generated method stub
		List<Product> list=new ArrayList<Product>();
		try{
			//从SessionFactory中获取Session对象
			Session session=this.sessionFactory.openSession();
			list=session.createQuery(hql).list();
			session.clear();
			session.close();
			
			
		}catch(Exception e){
			System.err.print(e);
		}
		return list;
	}

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

}
