package com.service;

import java.util.List;

import com.po.Product;

public interface ProductService {
	public List<Product> getAllProduct(int page,int pageSize);
	public int findProductSize();
	public int findProductSizeBySort(String sort);
	public Product getProductByID(String id);
	public List<Product> getProductBySort(String sort,int page,int pageSize);
	public List<Product> getProductBykey(String textfield );
}
