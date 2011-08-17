package com.baizhi.index.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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

	public Map<String,Object> getProblemListByTalkId(int TALK_ID, int loginUserId, int nowPage, int onePageCount){
		return htymDao.getProblemListByTalkId(TALK_ID, loginUserId, nowPage, onePageCount);
	}
	
	/**
	 * 修改话题的Logo
	 * @param IMAGE_PATH
	 * @param TALK_ID
	 * @return
	 */
	public int updateTalkImagePath(String IMAGE_PATH,int TALK_ID){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IMAGE_PATH", IMAGE_PATH);
		params.put("MODIFY_TIME", new Date());
		return htymDao.updateTalk(params, TALK_ID);
	} 
	
	/**
	 * 修改话题的介绍
	 * @param introduction
	 * @param TALK_ID
	 * @return
	 */
	public int updateTalkIntroduction(String introduction,int TALK_ID){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("INTRODUCTION", introduction);
		params.put("MODIFY_TIME", new Date());
		return htymDao.updateTalk(params, TALK_ID);
	} 
	
	/**
	 * 查询热门话题
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getHottestTalk(int nowPage, int onePageCount){
		return htymDao.getHottestTalk(nowPage, onePageCount);
	}
	
	/**
	 * 查询话题类型和话题之间的对应关系
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getTalkTypeAndTalk(){
		List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
		
		List<Map<String,Object>> talkTypeAndTalkList = htymDao.getTalkTypeAndTalk();
		if(!(talkTypeAndTalkList == null || talkTypeAndTalkList.isEmpty())){
			String TALKTYPE_ID;
			Map<String,Object> talkType;
			Map<String,Map<String,Object>> talkTypes = new LinkedHashMap<String, Map<String,Object>>();
			for (Map<String, Object> talk : talkTypeAndTalkList) {
				TALKTYPE_ID = "" + talk.get("TALKTYPE_ID");
				talkType = talkTypes.get(TALKTYPE_ID);
				if(talkType == null){
					talkType = new HashMap<String, Object>();
					talkType.put("TALKTYPE_ID", TALKTYPE_ID);
					talkType.put("TYPE_NAME", talk.get("TYPE_NAME"));
					talkType.put("REMARK", talk.get("REMARK"));
					talkType.put("TALKS", new ArrayList<Map<String,Object>>());
					talkTypes.put(TALKTYPE_ID, talkType);
				}
				((List<Map<String,Object>>)talkType.get("TALKS")).add(talk);
			}
			result.addAll(talkTypes.values());
		}
		return result;
	}
}
