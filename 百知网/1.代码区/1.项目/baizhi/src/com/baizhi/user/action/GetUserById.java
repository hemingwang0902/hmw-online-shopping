package com.baizhi.user.action;

import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.user.service.UserService;

/**
 * 
 * 类名：    GetUserById.java
 * 描述：    获取单条用户信息表表单信息
 * 创建者：  江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：    V0.9
 * 修改者：  
 * 修改日期：
 */
public class GetUserById  extends ActionSupport{

	private static final long serialVersionUID = -3214836874323392205L;

	private String USER_ID;//用户信息表ID
	
	private Map<String, Object> returnMap;//查询数据信息
	
	private UserService  userService;//用户信息表业务类
	
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String user_id) {
		USER_ID = user_id;
	}

	public Map<String, Object> getReturnMap() {
		return returnMap;
	}

	public void setReturnMap(Map<String, Object> returnMap) {
		this.returnMap = returnMap;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		returnMap = userService.getUserMapById(USER_ID);
		return SUCCESS;
	}
	
}
