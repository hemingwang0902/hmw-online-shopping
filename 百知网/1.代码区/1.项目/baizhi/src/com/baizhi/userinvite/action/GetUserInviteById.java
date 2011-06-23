package com.baizhi.userinvite.action;

import java.util.Map;
import com.baizhi.userinvite.service.UserInviteService;
/**
 * 
 * 类名：GetUserInviteById.java
 * 描述： 获取单条用户邀请信息表表单信息
 * 创建者：江红
 * 创建日期： 2011-06-23 22:20:22
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetUserInviteById extends UserInviteForm{
	
	private static final long serialVersionUID = -2105646542536311377L;
	
	private UserInviteService userInviteService;//用户邀请信息表业务类
	
	public UserInviteService getUserInviteService() {
		return userInviteService;
	}

	public void setUserInviteService(UserInviteService userInviteService) {
		this.userInviteService = userInviteService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = userInviteService.getUserInviteMapById(this.getINVITE_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setIS_SUCCESS(this.getValue(returnMap,"IS_SUCCESS"));// 是否邀请成功(0否、1是)
			this.setEMAIL(this.getValue(returnMap,"EMAIL"));// 邀请Email
			this.setINVITE_CODE(this.getValue(returnMap,"INVITE_CODE"));// 邀请码
			this.setINVITE_TIME(this.getValue(returnMap,"INVITE_TIME"));// 邀请时间
			this.setINVITE_USERID(this.getValue(returnMap,"INVITE_USERID"));// 邀请用户ID
		}
		return SUCCESS;
	}
	
}
