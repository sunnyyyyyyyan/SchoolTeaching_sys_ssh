package com.service;

import java.util.List;

import com.po.Online;


public interface onlineService {

	public String onlineText(Online online); 	
	public List<Online> getOnline(String username); 	
}
