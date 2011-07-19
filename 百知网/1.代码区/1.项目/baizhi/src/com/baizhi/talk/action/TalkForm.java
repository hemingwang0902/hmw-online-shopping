package com.baizhi.talk.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： TalkList.java<br>
 * 描述：  获取话题信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-20 23:49:03
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class TalkForm extends ActionSupport {
	
	private static final long serialVersionUID = 8253312102363058513L;
	
	private String TALK_ID;//话题ID
	private String CONTENT;//内容
	private String USER_ID;//用户ID
	private String INTRODUCTION;//用户ID
	private String IMAGE_PATH;//用户ID
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getTALK_ID() {
		return TALK_ID;
	}

	public void setTALK_ID(String TALK_ID) {
		this.TALK_ID = TALK_ID;
	}
	
	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String CONTENT) {
		this.CONTENT = CONTENT;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getINTRODUCTION() {
		return INTRODUCTION;
	}

	public void setINTRODUCTION(String iNTRODUCTION) {
		INTRODUCTION = iNTRODUCTION;
	}

	public String getIMAGE_PATH() {
		return IMAGE_PATH;
	}

	public void setIMAGE_PATH(String iMAGEPATH) {
		IMAGE_PATH = iMAGEPATH;
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