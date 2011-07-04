package com.baizhi.userprivate.action;

import java.util.Map;
import com.baizhi.userprivate.service.UserPrivateService;
/**
 * 
 * 类名：GetUserPrivateById.java
 * 描述： 获取单条用户私信信息表表单信息
 * 创建者：江红
 * 创建日期： 2011-07-05 00:26:42
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetUserPrivateById extends UserPrivateForm{
	
	private static final long serialVersionUID = 2828279329340585613L;
	
	private UserPrivateService userPrivateService;//用户私信信息表业务类
	
	public UserPrivateService getUserPrivateService() {
		return userPrivateService;
	}

	public void setUserPrivateService(UserPrivateService userPrivateService) {
		this.userPrivateService = userPrivateService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = userPrivateService.getUserPrivateMapById(this.getPRIVATE_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 收件人ID
			this.setSEND_ID(this.getValue(returnMap,"SEND_ID"));// 发送人ID
			this.setCONTENT(this.getValue(returnMap,"CONTENT"));// 发送内容
			this.setIS_READ(this.getValue(returnMap,"IS_READ"));// 是否阅读(0否、1是)
			this.setPPRIVATE_ID(this.getValue(returnMap,"PPRIVATE_ID"));// 父私信ID（私信、与私信回复为一张表）
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
		}
		return SUCCESS;
	}
	
}
