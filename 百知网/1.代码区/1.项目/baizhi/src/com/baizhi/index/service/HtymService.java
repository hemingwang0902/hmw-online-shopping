package com.baizhi.index.service;

import java.util.Map;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.HtymDao;

public class HtymService  extends ServiceSupport{
	
	private static final long serialVersionUID = 5535064051007903340L;
	
	private HtymDao htymDao;
	
	public void setHtymDao(HtymDao htymDao) {
		this.htymDao = htymDao;
	}

	public Map<String,Object> getTalkById(int TALK_ID, int loginUserId){
		return htymDao.getTalkById(TALK_ID, loginUserId);
	}
	
	public Map<String,Object> getWasAttentionUserListByTalkId(int TALK_ID, int nowPage, int onePageCount){
		return htymDao.getWasAttentionUserListByTalkId(TALK_ID, nowPage, onePageCount);
	}

	public Map<String,Object> getProblemListByTalkId(int TALK_ID, int nowPage, int onePageCount){
		return htymDao.getProblemListByTalkId(TALK_ID, nowPage, onePageCount);
	}
}
