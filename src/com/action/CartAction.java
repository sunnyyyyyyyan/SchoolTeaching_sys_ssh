package com.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.po.Cart;
import com.service.CartService;

public class CartAction {
	private String id; //商品的ID
	private String quantity; //商品的数量
	private CartService cartService;

	public CartService getCartService() {
		return cartService;
	}
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}	
	
	public String addCart(){//添加商品
		System.out.println(id);
		//验证用户是否登录
		String username=(String)ActionContext.getContext().getSession().get("username");
		if(username==null){ //没有登录
			ActionContext.getContext().put("mess", "请先登录");			
			return "login";
		}
		
		//调用service层添加商品
		Cart cart=new Cart();
		cart.setProductId(Integer.parseInt(id));
		cart.setCount(Integer.parseInt(quantity));
		cart.setUsername(username);
		if(this.cartService.addItem(cart)){
			ActionContext.getContext().put("mess", "添加成功");
			
		}else{
			ActionContext.getContext().put("mess", "添加不成功");
			return "error";
		}
		
		//为页面提供数据模型，设置逻辑试图并跳转
		return "showCart"; //购物车
	}
	
	public String showCart(){
		//验证用户是否登录
		String username=(String)ActionContext.getContext().getSession().get("username");
		if(username==null){ //没有登录
			ActionContext.getContext().put("mess", "请先登录");
					
			return "login";
		}
		
		List<Cart> list=this.cartService.getCartByUser(username);
		ActionContext.getContext().put("cartInfo", list);
		
		return "showCart";
	}
	
	
	public String delByCartId(){
		System.out.println(this.id);
		if(this.cartService.delItemByCartId(id)){			
			return "delByCartId";
		}
		ActionContext.getContext().put("cart", "删除失败");
		return "error";
	}
	
	public String delUserCart(){
		String username=(String)ActionContext.getContext().getSession().get("username");
		System.out.println(username);
		if(this.cartService.delItemByUserId(username)){
			return "delUserCart";
		}
		ActionContext.getContext().put("cart", "删除失败");
		return "error";
	}
}
