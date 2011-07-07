package com.baizhi.index.service;

import java.util.List;
import java.util.Map;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.HyymDao;

public class HyymService extends ServiceSupport{
	
	private static final long serialVersionUID = -7475180249774681389L;
	
	private HyymDao hyymDao;
	
	public void setHyymDao(HyymDao hyymDao) {
		this.hyymDao = hyymDao;
	}
	
	public Map<String,Object> getProblemListByUserId(int userId, int nowPage, int onePageCount){
		return hyymDao.getProblemListByUserId(userId, nowPage, onePageCount);
	}
	
	public Map<String,Object> getAnsweredProblemList(int userId, int nowPage, int onePageCount){
		return hyymDao.getAnsweredProblemList(userId, nowPage, onePageCount);
	}
	
	public Map<String,Object> getUserListByName(String name, int userType, int nowPage, int onePageCount){
		return hyymDao.getUserListByName(name, userType, nowPage, onePageCount);
	}
	
	public Map<String,Object> getAttentionTalkList(int userId, int nowPage, int onePageCount){
		return hyymDao.getAttentionTalkList(userId, nowPage, onePageCount);
	}
	
	public List<Map<String, Object>> getUserBasicByUserId(String userId){
		return hyymDao.getUserBasicMapByUserId(userId);
	}
}
