package com.baizhi.userattentiontalk.action;

import java.util.Map;
import com.baizhi.userattentiontalk.service.UserAttentiontalkService;

/**
 * 类名：GetUserAttentiontalkById.java<br>
 * 描述： 获取单条用户关注话题信息表表单信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-16 14:04:18<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetUserAttentiontalkById extends UserAttentiontalkForm{

	private static final long serialVersionUID = -4571007230973208099L;
	private UserAttentiontalkService userAttentiontalkService;//用户关注话题信息表业务类
	
	public UserAttentiontalkService getUserAttentiontalkService() {
		return userAttentiontalkService;
	}

	public void setUserAttentiontalkService(UserAttentiontalkService userAttentiontalkService) {
		this.userAttentiontalkService = userAttentiontalkService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = userAttentiontalkService.getUserAttentiontalkMapById(this.getATTENTIONTALK_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setTALK_ID(this.getValue(returnMap,"TALK_ID"));// 问题话题ID
			this.setIS_ATTENTION(this.getValue(returnMap,"IS_ATTENTION"));// 是否关注(0否、1是)
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
