package com.baizhi.userlog.action;

import java.util.Map;
import com.baizhi.userlog.service.UserLogService;
/**
 * 
 * 类名：GetUserLogById.java
 * 描述： 获取单条用户日志表表单信息
 * 创建者：江红
 * 创建日期： 2011-06-24 21:28:32
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetUserLogById extends UserLogForm{
	
	private static final long serialVersionUID = -6701824537748446567L;
	
	private UserLogService userLogService;//用户日志表业务类
	
	public UserLogService getUserLogService() {
		return userLogService;
	}

	public void setUserLogService(UserLogService userLogService) {
		this.userLogService = userLogService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = userLogService.getUserLogMapById(this.getLOG_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setLOGIN_TIME(this.getValue(returnMap,"LOGIN_TIME"));// 登录时间
			this.setIP(this.getValue(returnMap,"IP"));// IP
			this.setMAC(this.getValue(returnMap,"MAC"));// MAC
		}
		return SUCCESS;
	}
	
}
