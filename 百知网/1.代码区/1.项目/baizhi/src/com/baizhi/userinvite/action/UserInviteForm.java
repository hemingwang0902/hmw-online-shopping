package com.baizhi.userinvite.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： UserInviteList.java<br>
 * 描述：  获取用户邀请信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-23 22:20:22
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class UserInviteForm extends ActionSupport {
	
	private static final long serialVersionUID = 5723831527366597230L;
	
	private String INVITE_ID;//用户邀请ID
	private String USER_ID;//用户ID
	private String IS_SUCCESS;//是否邀请成功(0否、1是)
	private String EMAIL;//邀请Email
	private String INVITE_CODE;//邀请码
	private String INVITE_TIME;//邀请时间
	private String INVITE_USERID;//邀请用户ID
	
	public String getINVITE_ID() {
		return INVITE_ID;
	}

	public void setINVITE_ID(String INVITE_ID) {
		this.INVITE_ID = INVITE_ID;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getIS_SUCCESS() {
		return IS_SUCCESS;
	}

	public void setIS_SUCCESS(String IS_SUCCESS) {
		this.IS_SUCCESS = IS_SUCCESS;
	}
	
	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String EMAIL) {
		this.EMAIL = EMAIL;
	}
	
	public String getINVITE_CODE() {
		return INVITE_CODE;
	}

	public void setINVITE_CODE(String INVITE_CODE) {
		this.INVITE_CODE = INVITE_CODE;
	}
	
	public String getINVITE_TIME() {
		return INVITE_TIME;
	}

	public void setINVITE_TIME(String INVITE_TIME) {
		this.INVITE_TIME = INVITE_TIME;
	}
	
	public String getINVITE_USERID() {
		return INVITE_USERID;
	}

	public void setINVITE_USERID(String INVITE_USERID) {
		this.INVITE_USERID = INVITE_USERID;
	}
	
}