package com.baizhi.index.action.ht;

import java.util.List;
import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HtymService;

/**
 * 类名： InitHtym<br>
 * 描述：跳转到话题页面<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class InitHtgc extends ActionSupport{
	private static final long serialVersionUID = 4027082091347478551L;
	private HtymService htymService;

	private List<Map<String, Object>> talkTypeAndTalkList;
	private List<Map<String, Object>> hottestTalkList; 

	public void setHtymService(HtymService htymService) {
		this.htymService = htymService;
	}

	public List<Map<String, Object>> getTalkTypeAndTalkList() {
		return talkTypeAndTalkList;
	}

	public List<Map<String, Object>> getHottestTalkList() {
		return hottestTalkList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		//热门话题列表
		Map<String,Object> hottestTalks = htymService.getHottestTalk(1, 10);
		if(!(hottestTalks == null || hottestTalks.isEmpty())){
			hottestTalkList = (List<Map<String, Object>>) hottestTalks.get(KEY_LIST);
		}
		
		//话题类型与话题之间的对应关系列表
		talkTypeAndTalkList = htymService.getTalkTypeAndTalk();
		
		return SUCCESS;
	}

}
