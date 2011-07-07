package com.baizhi.usernotice.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： UserNoticeList.java<br>
 * 描述：  获取用户通知设置表列表信息
 * 创建者：江红
 * 创建日期： 2011-07-07 00:19:12
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class UserNoticeForm extends ActionSupport {
	
	private static final long serialVersionUID = -3122830862799909397L;
	
	private String NOTICE_ID;//通知ID
	private String USER_ID;//用户ID
	private String NOTICE_TYPE;//通知类型(1：有人关注了我、2：有人问了我一个问题、3：有人邀请我回答一个问题、4：我关注的问题有了新答案、5：有人向我发送私信、6：谁可以给我发私信)
	private String SET_TYPE;//设置类型(0：否、1：是、3：所有人、4：我关注的人)
	private String CREATE_TIME;//创建时间
	private String Modify_TIME;//修改时间
	
	public String getNOTICE_ID() {
		return NOTICE_ID;
	}

	public void setNOTICE_ID(String NOTICE_ID) {
		this.NOTICE_ID = NOTICE_ID;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getNOTICE_TYPE() {
		return NOTICE_TYPE;
	}

	public void setNOTICE_TYPE(String NOTICE_TYPE) {
		this.NOTICE_TYPE = NOTICE_TYPE;
	}
	
	public String getSET_TYPE() {
		return SET_TYPE;
	}

	public void setSET_TYPE(String SET_TYPE) {
		this.SET_TYPE = SET_TYPE;
	}
	
	public String getCREATE_TIME() {
		return CREATE_TIME;
	}

	public void setCREATE_TIME(String CREATE_TIME) {
		this.CREATE_TIME = CREATE_TIME;
	}
	
	public String getModify_TIME() {
		return Modify_TIME;
	}

	public void setModify_TIME(String Modify_TIME) {
		this.Modify_TIME = Modify_TIME;
	}
	
}