package com.service;

import java.util.List;

import com.po.Cart;

public interface CartService {
	public boolean addItem(Cart cart);//��ӹ��ﳵ
	public List<Cart> getCartByUser(String username);//��ȡ���û��Ĺ��ﳵ��Ϣ
	public boolean delItemByCartId(String id);//����cartIdɾ��һ����Ʒ
	public boolean delItemByUserId(String username);//��ո��û��Ĺ��ﳵ
}
