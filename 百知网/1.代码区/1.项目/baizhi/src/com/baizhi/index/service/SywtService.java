package com.baizhi.index.service;

import java.util.Map;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.SywtDao;

public class SywtService extends ServiceSupport{
	
	private static final long serialVersionUID = 728325753861617281L;
	
	private SywtDao sywtDao;
	
	public SywtDao getSywtDao() {
		return sywtDao;
	}

	public void setSywtDao(SywtDao sywtDao) {
		this.sywtDao = sywtDao;
	}
	
	public Map<String,Object> getAllProblemList(int userId, int nowPage, int onePageCount){
		return sywtDao.getAllProblemList(userId, nowPage, onePageCount);
	}
	
	public Map<String,Object> getAskMeProblemList(int userId, int nowPage, int onePageCount){
		return sywtDao.getAskMeProblemList(userId, nowPage, onePageCount);
	}
	
	public Map<String,Object> getInviteProblemList(int userId, int nowPage, int onePageCount){
		return sywtDao.getInviteProblemList(userId, nowPage, onePageCount);
	}
}
