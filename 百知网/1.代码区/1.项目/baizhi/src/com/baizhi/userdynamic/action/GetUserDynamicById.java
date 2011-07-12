package com.baizhi.userdynamic.action;

import java.util.Map;
import com.baizhi.userdynamic.service.UserDynamicService;
/**
 * 
 * 类名：GetUserDynamicById.java
 * 描述： 获取单条用户动态信息表表单信息
 * 创建者：江红
 * 创建日期： 2011-07-05 00:34:20
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetUserDynamicById extends UserDynamicForm{
	
	private static final long serialVersionUID = -663301328488489813L;
	
	private UserDynamicService userDynamicService;//用户动态信息表业务类
	
	public UserDynamicService getUserDynamicService() {
		return userDynamicService;
	}

	public void setUserDynamicService(UserDynamicService userDynamicService) {
		this.userDynamicService = userDynamicService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = userDynamicService.getUserDynamicMapById(this.getDYNAMIC_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setTITLE(this.getValue(returnMap,"TITLE"));// 动态主题
			this.setBUSINESS_ID(this.getValue(returnMap,"BUSINESS_ID"));// 业务主键(回复问题ID、关注会员ID)
			this.setDYNAMIC_TYPE(this.getValue(returnMap,"DYNAMIC_TYPE"));// 动态类型(字典：1回答问题、2关注会员)
			this.setCONTENT(this.getValue(returnMap,"CONTENT"));// 动态内容(存放组织好的html内容)
			this.setWARN_USERID(this.getValue(returnMap,"WARN_USERID"));// 提醒用户ID
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
