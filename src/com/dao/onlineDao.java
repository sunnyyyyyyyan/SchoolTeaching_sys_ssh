package com.dao;

import java.util.List;

import com.po.Online;


public interface onlineDao {
	public List<Online> getData(String hql); //��ѯ
	public boolean addOnline(Online online); //���ӣ��޸�
}
