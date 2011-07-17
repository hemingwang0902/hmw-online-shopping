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
public class InitHtym extends ActionSupport{
	private static final long serialVersionUID = 4027082091347478551L;
	private HtymService htymService;
	private int TALK_ID;
	private Map<String, Object> talk;
	private List<Map<String, Object>> wasAttentionUserList; 

	public Map<String, Object> getTalk() {
		return talk;
	}

	public void setHtymService(HtymService htymService) {
		this.htymService = htymService;
	}

	public void setTALK_ID(int tALKID) {
		TALK_ID = tALKID;
	}

	public List<Map<String, Object>> getWasAttentionUserList() {
		return wasAttentionUserList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		talk = htymService.getTalkById(TALK_ID, getSessionUserId());
		wasAttentionUserList = (List<Map<String, Object>>) htymService.getWasAttentionUserListByTalkId(TALK_ID, 1, 21).get(KEY_LIST);
		return SUCCESS;
	}

}
