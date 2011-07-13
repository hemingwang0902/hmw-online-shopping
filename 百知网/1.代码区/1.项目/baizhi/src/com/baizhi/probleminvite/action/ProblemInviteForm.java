package com.baizhi.probleminvite.action;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： ProblemInviteList.java<br>
 * 描述：  获取问题邀请人信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-12 11:03:45<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public abstract class ProblemInviteForm extends ActionSupport {
	private static final long serialVersionUID = -1081542198434937521L;
	private String INVITE_ID;//问题邀请人ID
	private String PROBLEM_ID;//问题ID
	private String IS_ATTENTION;//是否回答(0否、1是)
	private String USER_ID;//用户ID
	private String WAS_USER_ID;//被邀请的用户ID
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getINVITE_ID() {
		return INVITE_ID;
	}

	public void setINVITE_ID(String INVITE_ID) {
		this.INVITE_ID = INVITE_ID;
	}
	
	public String getPROBLEM_ID() {
		return PROBLEM_ID;
	}

	public void setPROBLEM_ID(String PROBLEM_ID) {
		this.PROBLEM_ID = PROBLEM_ID;
	}
	
	public String getIS_ATTENTION() {
		return IS_ATTENTION;
	}

	public void setIS_ATTENTION(String IS_ATTENTION) {
		this.IS_ATTENTION = IS_ATTENTION;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getWAS_USER_ID() {
		return WAS_USER_ID;
	}

	public void setWAS_USER_ID(String WAS_USER_ID) {
		this.WAS_USER_ID = WAS_USER_ID;
	}
	
	public String getCREATE_TIME() {
		return CREATE_TIME;
	}

	public void setCREATE_TIME(String CREATE_TIME) {
		this.CREATE_TIME = CREATE_TIME;
	}
	
	public String getMODIFY_TIME() {
		return MODIFY_TIME;
	}

	public void setMODIFY_TIME(String MODIFY_TIME) {
		this.MODIFY_TIME = MODIFY_TIME;
	}
	
}