package com.baizhi.user.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.user.service.UserService;
/**
 * 
 * 类名：CheckEmail.java
 * 描述：验证Email不能为重复
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class CheckEmail  extends UserForm{
	
	private static final long serialVersionUID = -2635378995121021509L;
	
	private UserService userService;//用户信息表业务类
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		//设置参数
		Map<String, Object> params = new HashMap<String, Object>();
		this.setMap(params, "EMAIL=?", this.getEMAIL());// Email
		this.setMap(params, "USER_ID<>?", this.getUSER_ID());//用户ID
		
		int count=userService.getUserCount(params);
		if(count>0){
			returnMap.put("flag", false);
			returnMap.put("message", "邮箱已经存在,如果已经注册请登录");
		}else{
			returnMap.put("flag", true);
		}
		this.setResult(returnMap);
		return JSONSUCCESS;
	}

}
