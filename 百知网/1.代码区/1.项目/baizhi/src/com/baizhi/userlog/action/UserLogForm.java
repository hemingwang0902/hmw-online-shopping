package com.baizhi.userlog.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： UserLogList.java<br>
 * 描述：  获取用户日志表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-24 21:28:32
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class UserLogForm extends ActionSupport {
	
	private static final long serialVersionUID = -961224044427002255L;
	
	private String LOG_ID;//用户日志ID
	private String USER_ID;//用户ID
	private String LOGIN_TIME;//登录时间
	private String IP;//IP
	private String MAC;//MAC
	
	public String getLOG_ID() {
		return LOG_ID;
	}

	public void setLOG_ID(String LOG_ID) {
		this.LOG_ID = LOG_ID;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getLOGIN_TIME() {
		return LOGIN_TIME;
	}

	public void setLOGIN_TIME(String LOGIN_TIME) {
		this.LOGIN_TIME = LOGIN_TIME;
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
	
}