package com.service;

import java.util.List;

import com.po.Cart;

public interface CartService {
	public boolean addItem(Cart cart);//添加购物车
	public List<Cart> getCartByUser(String username);//获取该用户的购物车信息
	public boolean delItemByCartId(String id);//根据cartId删除一条商品
	public boolean delItemByUserId(String username);//清空该用户的购物车
}
