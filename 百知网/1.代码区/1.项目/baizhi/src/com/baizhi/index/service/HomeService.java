package com.baizhi.index.service;

import java.util.Map;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.HomeDao;

public class HomeService  extends ServiceSupport{
	
	private static final long serialVersionUID = 7308230389953671913L;
	
	private HomeDao homeDao;
	
	public HomeDao getHomeDao() {
		return homeDao;
	}

	public void setHomeDao(HomeDao homeDao) {
		this.homeDao = homeDao;
	}
	
	public Map<String,Object> getUserOrProblemByTitleList(String title, int nowPage, int onePageCount){
		return homeDao.getUserOrProblemByTitleList(title, nowPage, onePageCount);
	}
}
