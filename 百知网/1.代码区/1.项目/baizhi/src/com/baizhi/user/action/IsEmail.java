package com.baizhi.user.action;

import java.util.HashMap;
import java.util.Map;

import com.baizhi.user.service.UserService;

/**
 * 类名： IsEmail.java<br>
 * 描述：验证邮箱是否存在<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-16 上午12:30:43<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class IsEmail  extends UserForm{
	
	private static final long serialVersionUID = -6958093244037785096L;
	
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
		
		int count=userService.getUserCount(params);
		if(count>0){
			returnMap.put("flag", true);
		}else{
			returnMap.put("flag", false);
			returnMap.put("message", "邮箱不存在,请输入正确的邮箱地址");
		}
		this.setResult(returnMap);
		return JSONSUCCESS;
	}

}
