package com.dao;
import java.util.List;
import com.po.Cart;

public interface CartDao {
	public List<Cart> getData(String hql); //查询
	public boolean addItemToCart(Cart cart); //增加，修改
	public boolean deletItemFromCart(Cart cart);//删除
}
