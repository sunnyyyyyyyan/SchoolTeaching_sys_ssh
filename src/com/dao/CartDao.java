package com.dao;
import java.util.List;
import com.po.Cart;

public interface CartDao {
	public List<Cart> getData(String hql); //��ѯ
	public boolean addItemToCart(Cart cart); //���ӣ��޸�
	public boolean deletItemFromCart(Cart cart);//ɾ��
}
