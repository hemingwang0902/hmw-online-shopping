package com.baizhi.userscore.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： UserScoreList.java<br>
 * 描述：  获取用户积分明细表列表信息
 * 创建者：江红
 * 创建日期： 2011-08-07 20:03:25
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class UserScoreForm extends ActionSupport {
	
	private static final long serialVersionUID = 2537129809650074740L;
	
	private String SCORE_ID;//用户积分明细ID
	private String USER_ID;//用户ID
	private String BUSINESS_ID;//业务主键(提问题ID、回答ID)
	private String BUSINESS_TYPE;//业务类型(字典：1、会员邀请朋友注册获得积分2、提问题3、回答问题)
	private String SCORE;//积分
	private String DESCRIPTION;//描述
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getSCORE_ID() {
		return SCORE_ID;
	}

	public void setSCORE_ID(String SCORE_ID) {
		this.SCORE_ID = SCORE_ID;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getBUSINESS_ID() {
		return BUSINESS_ID;
	}

	public void setBUSINESS_ID(String BUSINESS_ID) {
		this.BUSINESS_ID = BUSINESS_ID;
	}
	
	public String getBUSINESS_TYPE() {
		return BUSINESS_TYPE;
	}

	public void setBUSINESS_TYPE(String BUSINESS_TYPE) {
		this.BUSINESS_TYPE = BUSINESS_TYPE;
	}
	
	public String getSCORE() {
		return SCORE;
	}

	public void setSCORE(String SCORE) {
		this.SCORE = SCORE;
	}
	
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}

	public void setDESCRIPTION(String DESCRIPTION) {
		this.DESCRIPTION = DESCRIPTION;
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