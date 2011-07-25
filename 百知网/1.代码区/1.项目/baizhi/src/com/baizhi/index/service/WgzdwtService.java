package com.baizhi.index.service;

import java.util.Map;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.WgzdwtDao;

public class WgzdwtService  extends ServiceSupport{
	
	private static final long serialVersionUID = -7920753256643945818L;
	
	private WgzdwtDao wgzdwtDao;
	
	public WgzdwtDao getWgzdwtDao() {
		return wgzdwtDao;
	}

	public void setWgzdwtDao(WgzdwtDao wgzdwtDao) {
		this.wgzdwtDao = wgzdwtDao;
	}
	
	public Map<String,Object> getAttentionProblemList(int userId, int loginUserId, int nowPage, int onePageCount){
		return wgzdwtDao.getAttentionProblemList(userId, loginUserId, nowPage, onePageCount);
	}
}
