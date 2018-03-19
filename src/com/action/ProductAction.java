package com.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.po.PageShow;
import com.po.Product;
import com.service.ProductService;

public class ProductAction {
	private int pageNow=1;
	private int pageSize=9;
	private String id;
	private String sort;
	private String textfield;
	
	//接收注入ProductService
	private ProductService productService;
	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTextfield() {
		return textfield;
	}

	public void setTextfield(String textfield) {
		this.textfield = textfield;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	
	
	
	public String showAllProduct(){
		List<Product> list=this.productService.getAllProduct(pageNow,pageSize);
		if(list.size()>0){
			ActionContext.getContext().put("allProduct", list);
			PageShow page=new PageShow(pageNow, this.productService.findProductSize(), pageSize);
			ActionContext.getContext().put("page", page);
			return "showAllProduct";
		}
		return "showAllProductError";
	}
	
	
	public String  showProductByID(){
		Product product=this.productService.getProductByID(id);
		ActionContext.getContext().put("product", product);
		return "showProductByID";
	}
	
	
	public String showProductBySort(){
		List<Product> list=this.productService.getProductBySort(sort,pageNow,pageSize);
		if(list.size()>0){
			ActionContext.getContext().put("SortProduct", list);
			PageShow page=new PageShow(pageNow, this.productService.findProductSizeBySort(sort), pageSize);
			ActionContext.getContext().put("page1", page);
			return "showProductBySort";
		}
		return "showProductBySortError";
	}
	

	
	public String getProductByKey(){
		List<Product> list=this.productService.getProductBykey(textfield);
		if(list.size()>0){			
			ActionContext.getContext().put("keyProduct", list);
			return "getProductByKey";
		}
		else{
			ActionContext.getContext().put("mess", "该商品不存在！");
			return "Error";
		}
		
		
	}
}
