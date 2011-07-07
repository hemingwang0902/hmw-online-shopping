package com.baizhi.user.action;

import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.Encrypt;
import com.baizhi.user.service.UserService;

/**
 * 
 * 类名：CheckPassword.java
 * 描述：验证密码是否与原密码相同
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class CheckPassword  extends ActionSupport{
	
	private static final long serialVersionUID = -2635378995121021509L;
	
	private UserService userService;//用户信息表业务类
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private String R_PASSWORD;
	
	public String getR_PASSWORD() {
		return R_PASSWORD;
	}

	public void setR_PASSWORD(String r_password) {
		R_PASSWORD = r_password;
	}

	@Override
	public String execute() throws Exception {
		if(this.getSessionUserId()>0){
			Map<String, Object> returnMap=userService.getUserMapById(String.valueOf(this.getSessionUserId()));
			String DB_PASSWORD=String.valueOf(returnMap.get("PASSWORD"));
			if(!DB_PASSWORD.equals(Encrypt.edcryptMD5(R_PASSWORD))){
				returnMap.put("flag", false);
				returnMap.put("message", "密码与原密码不一致，请重新输入");
			}else{
				returnMap.put("flag", true);
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}


}
