package com.dao;

import java.util.List;

import com.po.Online;


public interface onlineDao {
	public List<Online> getData(String hql); //查询
	public boolean addOnline(Online online); //增加，修改
}
