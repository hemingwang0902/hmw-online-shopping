package com.baizhi.userattentiontalk.action;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： UserAttentiontalkList.java<br>
 * 描述：  获取用户关注话题信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-16 14:04:18<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public abstract class UserAttentiontalkForm extends ActionSupport {

	private static final long serialVersionUID = -8753336780544384976L;
	private String ATTENTIONTALK_ID;//用户关注话题ID
	private String USER_ID;//用户ID
	private String TALK_ID;//问题话题ID
	private String IS_ATTENTION;//是否关注(0否、1是)
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getATTENTIONTALK_ID() {
		return ATTENTIONTALK_ID;
	}

	public void setATTENTIONTALK_ID(String ATTENTIONTALK_ID) {
		this.ATTENTIONTALK_ID = ATTENTIONTALK_ID;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getTALK_ID() {
		return TALK_ID;
	}

	public void setTALK_ID(String TALK_ID) {
		this.TALK_ID = TALK_ID;
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