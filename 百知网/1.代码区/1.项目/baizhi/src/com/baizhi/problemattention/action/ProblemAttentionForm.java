package com.baizhi.problemattention.action;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： ProblemAttentionList.java<br>
 * 描述：  获取问题关注信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:14<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public abstract class ProblemAttentionForm extends ActionSupport {
	private static final long serialVersionUID = -6544133243627363384L;
	private String ATTENTION_ID;//问题关注ID
	private String PROBLEM_ID;//问题ID
	private String IS_ATTENTION;//是否关注(0否、1是)
	private String USER_ID;//用户ID
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getATTENTION_ID() {
		return ATTENTION_ID;
	}

	public void setATTENTION_ID(String ATTENTION_ID) {
		this.ATTENTION_ID = ATTENTION_ID;
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