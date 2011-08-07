package com.baizhi.userscore.action;

import java.util.Map;
import com.baizhi.userscore.service.UserScoreService;
/**
 * 
 * 类名：GetUserScoreById.java
 * 描述： 获取单条用户积分明细表表单信息
 * 创建者：江红
 * 创建日期： 2011-08-07 20:03:25
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetUserScoreById extends UserScoreForm{
	
	private static final long serialVersionUID = 6009321735957042690L;
	
	private UserScoreService userScoreService;//用户积分明细表业务类
	
	public UserScoreService getUserScoreService() {
		return userScoreService;
	}

	public void setUserScoreService(UserScoreService userScoreService) {
		this.userScoreService = userScoreService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = userScoreService.getUserScoreMapById(this.getSCORE_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setBUSINESS_ID(this.getValue(returnMap,"BUSINESS_ID"));// 业务主键(提问题ID、回答ID)
			this.setBUSINESS_TYPE(this.getValue(returnMap,"BUSINESS_TYPE"));// 业务类型(字典：1、会员邀请朋友注册获得积分2、提问题3、回答问题)
			this.setSCORE(this.getValue(returnMap,"SCORE"));// 积分
			this.setDESCRIPTION(this.getValue(returnMap,"DESCRIPTION"));// 描述
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
