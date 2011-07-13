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
	
	private String NAME;//姓名　
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String name) {
		NAME = name;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = userService.getUserMapById(this.getUSER_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setUSER_TYPE(this.getValue(returnMap,"USER_TYPE"));//用户类型(字典：1用户、2品牌)
			this.setEMAIL(this.getValue(returnMap,"EMAIL"));//Email
			this.setNAME(this.getValue(returnMap,"NAME"));//NAME
			this.setPASSWORD(this.getValue(returnMap,"PASSWORD"));//密码
			this.setREG_TIME(this.getValue(returnMap,"REG_TIME"));//注册时间
			this.setLAST_LOGINTIME(this.getValue(returnMap,"LAST_LOGINTIME"));//最后登录时间
			this.setIP(this.getValue(returnMap,"IP"));//最后登录IP
			this.setMAC(this.getValue(returnMap,"MAC"));//最后登录MAC
			this.setLAST_FREEZETIME(this.getValue(returnMap,"LAST_FREEZETIME"));//最后冻结时间
		}
		return SUCCESS;
	}
	
}
