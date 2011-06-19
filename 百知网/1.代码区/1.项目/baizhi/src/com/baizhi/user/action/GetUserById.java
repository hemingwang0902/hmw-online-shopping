package com.baizhi.user.action;

import java.util.Map;
import com.baizhi.user.service.UserService;
/**
 * 
 * 类名：GetUserById.java
 * 描述：获取单条用户信息表表单信息
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class GetUserById  extends UserForm{

	private static final long serialVersionUID = -3214836874323392205L;
	
	private UserService  userService;//用户信息表业务类
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = userService.getUserMapById(this.getUSER_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setUSER_TYPE(this.setValue(returnMap,"USER_TYPE"));//用户类型(字典：1用户、2品牌)
			this.setEMAIL(this.setValue(returnMap,"EMAIL"));//Email
			this.setPASSWORD(this.setValue(returnMap,"PASSWORD"));//密码
			this.setREG_TIME(this.setValue(returnMap,"REG_TIME"));//注册时间
			this.setLAST_LOGINTIME(this.setValue(returnMap,"LAST_LOGINTIME"));//最后登录时间
			this.setIP(this.setValue(returnMap,"IP"));//最后登录IP
			this.setMAC(this.setValue(returnMap,"MAC"));//最后登录MAC
			this.setLAST_FREEZETIME(this.setValue(returnMap,"LAST_FREEZETIME"));//最后冻结时间
		}
		return SUCCESS;
	}
	
}
