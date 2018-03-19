package com.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.po.Cart;
import com.service.CartService;

public class CartAction {
	private String id; //��Ʒ��ID
	private String quantity; //��Ʒ������
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
	
	public String addCart(){//�����Ʒ
		System.out.println(id);
		//��֤�û��Ƿ��¼
		String username=(String)ActionContext.getContext().getSession().get("username");
		if(username==null){ //û�е�¼
			ActionContext.getContext().put("mess", "���ȵ�¼");			
			return "login";
		}
		
		//����service�������Ʒ
		Cart cart=new Cart();
		cart.setProductId(Integer.parseInt(id));
		cart.setCount(Integer.parseInt(quantity));
		cart.setUsername(username);
		if(this.cartService.addItem(cart)){
			ActionContext.getContext().put("mess", "��ӳɹ�");
			
		}else{
			ActionContext.getContext().put("mess", "��Ӳ��ɹ�");
			return "error";
		}
		
		//Ϊҳ���ṩ����ģ�ͣ������߼���ͼ����ת
		return "showCart"; //���ﳵ
	}
	
	public String showCart(){
		//��֤�û��Ƿ��¼
		String username=(String)ActionContext.getContext().getSession().get("username");
		if(username==null){ //û�е�¼
			ActionContext.getContext().put("mess", "���ȵ�¼");
					
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
		ActionContext.getContext().put("cart", "ɾ��ʧ��");
		return "error";
	}
	
	public String delUserCart(){
		String username=(String)ActionContext.getContext().getSession().get("username");
		System.out.println(username);
		if(this.cartService.delItemByUserId(username)){
			return "delUserCart";
		}
		ActionContext.getContext().put("cart", "ɾ��ʧ��");
		return "error";
	}
}
