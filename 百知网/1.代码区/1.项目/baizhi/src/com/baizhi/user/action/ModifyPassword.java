package com.baizhi.user.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.Encrypt;
import com.baizhi.user.service.UserService;

/**
 * 
 * 类名：ModifyPassword.java
 * 描述：修改密码信息
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class ModifyPassword  extends ActionSupport{
	
	private static final long serialVersionUID = -4124117568407779883L;
	
	private UserService  userService;//用户信息表业务类
	
	private String PASSWORD;
	
	
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String password) {
		PASSWORD = password;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		int count=-1;
		String message="";
		boolean flag=false;
		//判断参数是否为空
		if(PASSWORD!=null&&!PASSWORD.trim().equals("")){
			count=userService.modifyPassword(this.getSessionUserId(), Encrypt.edcryptMD5(PASSWORD));
			if(count>0){
				message="密码设置成功";
				flag=true;
			}else{
				message="密码设置失败";
			}
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}

}
