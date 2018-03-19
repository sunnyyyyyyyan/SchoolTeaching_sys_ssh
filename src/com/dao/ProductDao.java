package com.dao;

import java.util.List;

import com.po.Product;

public interface ProductDao {
	//²éÑ¯£¬Ìí¼Ó£¬É¾³ý£¬ÐÞ¸Ä
		public List<Product> getAllProduct(int pageNow, int pageSize);
		public int findProductSize();
		public List<Product> getProductBySort(String sort,int pageNow, int pageSize);
		public int findProductSizeBySort(String sort);
		public List<Product> getData(String hql);
		public boolean addProduct(Product product);
		public boolean delProduct(Product product);
		public boolean updateProduct(Product product);

}
