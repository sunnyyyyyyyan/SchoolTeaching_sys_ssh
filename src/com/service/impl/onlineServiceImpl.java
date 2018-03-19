package com.service.impl;

import java.util.List;

import com.dao.onlineDao;
import com.opensymphony.xwork2.ActionContext;
import com.po.Online;
import com.po.User;
import com.service.onlineService;

public class onlineServiceImpl implements onlineService {

	private onlineDao onlineDao;
	
	public onlineDao getOnlineDao() {
		return onlineDao;
	}

	public void setOnlineDao(onlineDao onlineDao) {
		this.onlineDao = onlineDao;
	}

	@Override
	public String onlineText(Online online) {
		// TODO Auto-generated method stub
		String hql = "from Online where id='" + online.getId() + "'";
		List<Online> list = this.onlineDao.getData(hql);
		if(this.onlineDao.addOnline(online)){
			return "success";
		}
		return "error";
	}

	@Override
	public List<Online> getOnline(String username) {
		// TODO Auto-generated method stub
		String hql = "from Online where username='" +username+ "'";
		List<Online> list=this.onlineDao.getData(hql);
		return list;
	}

}
