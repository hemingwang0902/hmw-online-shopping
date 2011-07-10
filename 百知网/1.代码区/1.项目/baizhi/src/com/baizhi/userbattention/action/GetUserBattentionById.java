package com.baizhi.userbattention.action;

import java.util.Map;
import com.baizhi.userbattention.service.UserBattentionService;

/**
 * 类名：GetUserBattentionById.java<br>
 * 描述： 获取单条用户关注品牌信息表表单信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:10<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetUserBattentionById extends UserBattentionForm{
	
	private static final long serialVersionUID = 5554493851991074833L;
	private UserBattentionService userBattentionService;//用户关注品牌信息表业务类
	
	public UserBattentionService getUserBattentionService() {
		return userBattentionService;
	}

	public void setUserBattentionService(UserBattentionService userBattentionService) {
		this.userBattentionService = userBattentionService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = userBattentionService.getUserBattentionMapById(this.getBATTENTION_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setBRAND_ID(this.getValue(returnMap,"BRAND_ID"));// 被关注品牌
			this.setIS_ATTENTION(this.getValue(returnMap,"IS_ATTENTION"));// 是否关注(0否、1是)
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
