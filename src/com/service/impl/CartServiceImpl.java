package com.service.impl;

import java.util.List;

import com.dao.CartDao;
import com.po.Cart;
import com.service.CartService;

public class CartServiceImpl implements CartService {
	private CartDao cartDao;
	
	
	
	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public boolean addItem(Cart cart) {
		//cart������productId,count,username����ֵ
		// TODO Auto-generated method stub
		boolean isAdd=false;
		//��ȡ���û��Ĺ��ﳵ����Ϣ���Ƿ���ڸ���Ʒ
		String hql="from Cart where productId="+cart.getProductId()
				+"  and username='"+cart.getUsername()+"'";
		List<Cart> list=this.cartDao.getData(hql);
		//�����ڣ�����¹��ﳵ�и���Ʒ���������������
		if(list.size()==0){    //������
			isAdd=this.cartDao.addItemToCart(cart);
		}else{
			Cart oldCart=list.get(0);
			oldCart.setCount(cart.getCount()+oldCart.getCount());
			isAdd=this.cartDao.addItemToCart(oldCart);
		}
		
		return isAdd;
	}

	@Override
	public List<Cart> getCartByUser(String username) {
		// TODO Auto-generated method stub
		//Integer id, Integer productId, Integer count, String username,
		//String productName, float price, float total
		String hql="select new Cart(c.id,p.id,c.count,c.username,p.name,p.price,p.price*c.count) from Product p, Cart c where p.id=c.productId and username='"+username+"'";
		List<Cart> list=this.cartDao.getData(hql);
		return list;
	}

	@Override
	public boolean delItemByCartId(String id) {
		// TODO Auto-generated method stub
		boolean isAdd=false;
		String hql="from Cart where id='"+id+"'";
		List<Cart> list=this.cartDao.getData(hql);
		System.out.println(list.size());
		Cart cart=list.get(0);
		if(this.cartDao.deletItemFromCart(cart)){
			isAdd=true;
		}
		return isAdd;
	}

	@Override
	public boolean delItemByUserId(String username) {
		// TODO Auto-generated method stub
		boolean isAdd=false;
		String hql="from Cart where username='"+username+"'";
		List<Cart> list=this.cartDao.getData(hql);
		for(int i=0;i<list.size();i++){
			Cart cart=list.get(i);
			if(this.cartDao.deletItemFromCart(cart)){
				isAdd=true;
			}
		}
		return isAdd;
	}

}
