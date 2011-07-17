package com.baizhi.index.service;

import java.util.Map;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.PpymDao;

public class PpymService  extends ServiceSupport{
	
	private static final long serialVersionUID = 5535064051007903340L;
	
	private PpymDao ppymDao;
	
	public void setPpymDao(PpymDao ppymDao) {
		this.ppymDao = ppymDao;
	}
	
	public Map<String,Object> getBrandById(int BRAND_ID, int loginUserId){
		return ppymDao.getBrandById(BRAND_ID, loginUserId);
	}
	
	public Map<String,Object> getWasAttentionUserListByBrandId(int BRAND_ID, int nowPage, int onePageCount){
		return ppymDao.getWasAttentionUserListByBrandId(BRAND_ID, nowPage, onePageCount);
	}

	public Map<String,Object> getProblemListByBrandId(int BRAND_ID, int nowPage, int onePageCount){
		return ppymDao.getProblemListByBrandId(BRAND_ID, nowPage, onePageCount);
	}
}
