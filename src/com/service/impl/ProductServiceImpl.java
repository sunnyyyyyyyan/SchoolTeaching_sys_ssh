package com.service.impl;

import java.util.List;

import com.dao.ProductDao;
import com.po.Product;
import com.service.ProductService;

public class ProductServiceImpl implements ProductService {
	public ProductDao productDao;
	

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public int findProductSize(){		
		return this.productDao.findProductSize();
	}
	public int findProductSizeBySort(String sort){
		return this.productDao.findProductSizeBySort(sort);
	}
	
	
	
	@Override
	public List<Product> getAllProduct(int page,int pageSize) {
		// TODO Auto-generated method stub
		List<Product> list=this.productDao.getAllProduct(page, pageSize);
		return list;
	}

	@Override
	public Product getProductByID(String id) {
		// TODO Auto-generated method stub
		String hql="from Product where id="+id;
		List<Product> list=this.productDao.getData(hql);
		
		return list.get(0);
	}
	public List<Product> getProductBySort(String sort,int page,int pageSize){
		List<Product> list=this.productDao.getProductBySort(sort, page, pageSize);
		return list;		
	}

	
	public List<Product> getProductBykey(String textfield ){
		String hql="from Product where name like '%"+textfield+"%'";
		List<Product> list=this.productDao.getData(hql);
		return list;
	}
}
