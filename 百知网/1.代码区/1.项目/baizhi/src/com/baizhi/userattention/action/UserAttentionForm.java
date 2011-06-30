package com.baizhi.userattention.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： UserAttentionList.java<br>
 * 描述：  获取用户关注人信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-07-01 00:54:40
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class UserAttentionForm extends ActionSupport {
	
	private static final long serialVersionUID = 4717046936172449877L;
	
	private String ATTENTION_ID;//用户关注人ID
	private String USER_ID;//用户ID
	private String WAS_USERID;//被关注用户
	private String IS_ATTENTION;//是否关注(0否、1是)
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getATTENTION_ID() {
		return ATTENTION_ID;
	}

	public void setATTENTION_ID(String ATTENTION_ID) {
		this.ATTENTION_ID = ATTENTION_ID;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getWAS_USERID() {
		return WAS_USERID;
	}

	public void setWAS_USERID(String WAS_USERID) {
		this.WAS_USERID = WAS_USERID;
	}
	
	public String getIS_ATTENTION() {
		return IS_ATTENTION;
	}

	public void setIS_ATTENTION(String IS_ATTENTION) {
		this.IS_ATTENTION = IS_ATTENTION;
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