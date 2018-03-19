package com.po;

public class Cart {

	private Integer id;
	private Integer productId;
	private Integer count;
	private String username;
	
	//显示数据
	private String productName;
	private float price;
	private float total;
		
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Cart(){
		
	}
	
	//添加商品
	public Cart(Integer productId, Integer count, String username) {
		super();
		this.productId = productId;
		this.count = count;
		this.username = username;
	}
	//显示购物车
	public Cart(Integer id, Integer productId, Integer count, String username,
			String productName, float price, float total) {
		super();
		this.id = id;
		this.productId = productId;
		this.count = count;
		this.username = username;
		this.productName = productName;
		this.price = price;
		this.total = total;
	}	
}
