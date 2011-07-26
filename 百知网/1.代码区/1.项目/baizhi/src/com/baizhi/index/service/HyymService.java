package com.baizhi.index.service;

import java.util.List;
import java.util.Map;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.HomeDao;
import com.baizhi.index.dao.HyymDao;

public class HyymService extends ServiceSupport{
	
	private static final long serialVersionUID = -7475180249774681389L;
	
	private HyymDao hyymDao;
	private HomeDao homeDao;
	
	public void setHyymDao(HyymDao hyymDao) {
		this.hyymDao = hyymDao;
	}
	
	public void setHomeDao(HomeDao homeDao) {
		this.homeDao = homeDao;
	}

	/**
	 * 他问过的问题
	 * @param userId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getProblemListByUserId(int userId, int loginUserId, int nowPage, int onePageCount){
		return hyymDao.getProblemListByUserId(userId, loginUserId, nowPage, onePageCount);
	}
	
	/**
	 * 他回答的问题
	 * @param userId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getAnsweredProblemList(int userId, int loginUserId, int nowPage, int onePageCount){
		return hyymDao.getAnsweredProblemList(userId, loginUserId, nowPage, onePageCount);
	}
	
	/**
	 * 根据会员姓名模糊搜索会员
	 * @param name
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getUserListByName(String name, int loginUserId, int nowPage, int onePageCount){
		return hyymDao.getUserListByName(name, loginUserId, nowPage, onePageCount);
	}
	
	/**
	 * 关注的话题
	 * @param userId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getAttentionTalkList(int userId, int loginUserId, int nowPage, int onePageCount){
		return hyymDao.getAttentionTalkList(userId, loginUserId, nowPage, onePageCount);
	}
	
	/**
	 * 他关注的人
	 * @param userId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getAttentionUserList(int userId, int nowPage, int onePageCount){
		return homeDao.getAttentionUser(userId, nowPage, onePageCount);
	}
	
	/**
	 * 关注他的人
	 * @param userId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getWasAttentionUserList(int userId, int nowPage, int onePageCount){
		return homeDao.getWasAttentionUser(userId, nowPage, onePageCount);
	}
	
	/**
	 * 根据用户ID查询用户详细信息
	 * @param userId
	 * @return
	 */
	public Map<String, Object> getUserBasicByUserId(String userId, int loginUserId){
		List<Map<String, Object>> list = hyymDao.getUserBasicMapByUserId(userId, loginUserId);
		if(list == null || list.isEmpty())
			return null;
		return list.get(0);
	}
}
