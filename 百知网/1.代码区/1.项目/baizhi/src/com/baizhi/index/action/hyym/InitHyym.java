package com.baizhi.index.action.hyym;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HyymService;

/**
 * 类名： InitHyym<br>
 * 描述：跳转到会员页面<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class InitHyym extends ActionSupport {
	private static final long serialVersionUID = 4289411773333642991L;
	private HyymService hyymService;
	private String userId;
	//会员基本信息
	private Map<String, Object> userBasic;
	//关注的话题列表
	private List<Map<String, Object>> attentionTalkList;
	//他关注的人
	private List<Map<String, Object>> attentionUserList;
	//他关注的人的数量
	private int attentionUserSize;
	//关注他的人
	private List<Map<String, Object>> wasAttentionUserList;
	//关注他的人的数量
	private int wasAttentionUserSize;
	
	public void setHyymService(HyymService hyymService) {
		this.hyymService = hyymService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map<String, Object> getUserBasic() {
		return userBasic;
	}

	public List<Map<String, Object>> getAttentionTalkList() {
		return attentionTalkList;
	}

	public List<Map<String, Object>> getAttentionUserList() {
		return attentionUserList;
	}

	public List<Map<String, Object>> getWasAttentionUserList() {
		return wasAttentionUserList;
	}

	public int getAttentionUserSize() {
		return attentionUserSize;
	}

	public int getWasAttentionUserSize() {
		return wasAttentionUserSize;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		userBasic = hyymService.getUserBasicByUserId(userId, getSessionUserId());
		if(userBasic == null || userBasic.isEmpty())
			return INPUT;
		
		int uid = NumberUtils.toInt(userId);
		
		attentionTalkList = (List<Map<String, Object>>) hyymService.getAttentionTalkList(uid, getSessionUserId(), 1, 4).get(KEY_LIST);
		
		attentionUserList = (List<Map<String, Object>>) hyymService.getAttentionUserList(uid, 1, 21).get(KEY_LIST);
		if(attentionUserList != null){
			attentionUserSize = attentionUserList.size();
		}
		
		wasAttentionUserList = (List<Map<String, Object>>) hyymService.getWasAttentionUserList(uid, 1, 21).get(KEY_LIST);
		if(wasAttentionUserList != null){
			wasAttentionUserSize = wasAttentionUserList.size();
		}
		return SUCCESS;
	}
}
