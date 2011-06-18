package com.baizhi.user.action;

import com.baizhi.commons.ActionSupport;

/**
 * 
 * 类名：    UserForm.java
 * 描述：    用户信息表表单信息
 * 创建者：  江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：    V0.9
 * 修改者：  
 * 修改日期：
 */
public abstract class UserForm  extends ActionSupport{

	private static final long serialVersionUID = 113453827985409844L;
	
	private String USER_ID;//用户ID
	private String USER_TYPE;//用户类型(字典：1用户、2品牌)
	private String EMAIL;//Email
	private String PASSWORD;//密码
	private String REG_TIME;//注册时间
	private String LAST_LOGINTIME;//最后登录时间
	private String IP;//最后登录IP
	private String MAC;//最后登录MAC
	private String LAST_FREEZETIME;//最后冻结时间
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	
	public String getUSER_TYPE() {
		return USER_TYPE;
	}

	public void setUSER_TYPE(String USER_TYPE) {
		this.USER_TYPE = USER_TYPE;
	}
	
	
	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String EMAIL) {
		this.EMAIL = EMAIL;
	}
	
	
	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String PASSWORD) {
		this.PASSWORD = PASSWORD;
	}
	
	
	public String getREG_TIME() {
		return REG_TIME;
	}

	public void setREG_TIME(String REG_TIME) {
		this.REG_TIME = REG_TIME;
	}
	
	
	public String getLAST_LOGINTIME() {
		return LAST_LOGINTIME;
	}

	public void setLAST_LOGINTIME(String LAST_LOGINTIME) {
		this.LAST_LOGINTIME = LAST_LOGINTIME;
	}
	
	
	public String getIP() {
		return IP;
	}

	public void setIP(String IP) {
		this.IP = IP;
	}
	
	
	public String getMAC() {
		return MAC;
	}

	public void setMAC(String MAC) {
		this.MAC = MAC;
	}
	
	
	public String getLAST_FREEZETIME() {
		return LAST_FREEZETIME;
	}

	public void setLAST_FREEZETIME(String LAST_FREEZETIME) {
		this.LAST_FREEZETIME = LAST_FREEZETIME;
	}

}
