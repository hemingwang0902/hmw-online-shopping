package com.baizhi.userdynamic.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： UserDynamicList.java<br>
 * 描述：  获取用户动态信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-07-05 00:34:20
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class UserDynamicForm extends ActionSupport {
	
	private static final long serialVersionUID = -6523804855391072856L;
	private String DYNAMIC_ID;//用户动态ID
	private String USER_ID;//用户ID
	private String TITLE;//动态主题
	private String BUSINESS_ID;//业务主键(回复问题ID、关注会员ID)
	private String DYNAMIC_TYPE;//动态类型(字典：1回答问题、2关注会员)
	private String CONTENT;//动态内容(存放组织好的html内容)
	private String WARN_USERID;//提醒用户ID
	private String IS_OPEN;//是否查看(0否、1是)
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getDYNAMIC_ID() {
		return DYNAMIC_ID;
	}

	public void setDYNAMIC_ID(String DYNAMIC_ID) {
		this.DYNAMIC_ID = DYNAMIC_ID;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String TITLE) {
		this.TITLE = TITLE;
	}
	
	public String getBUSINESS_ID() {
		return BUSINESS_ID;
	}

	public void setBUSINESS_ID(String BUSINESS_ID) {
		this.BUSINESS_ID = BUSINESS_ID;
	}
	
	public String getDYNAMIC_TYPE() {
		return DYNAMIC_TYPE;
	}

	public void setDYNAMIC_TYPE(String DYNAMIC_TYPE) {
		this.DYNAMIC_TYPE = DYNAMIC_TYPE;
	}
	
	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String CONTENT) {
		this.CONTENT = CONTENT;
	}
	
	public String getWARN_USERID() {
		return WARN_USERID;
	}

	public void setWARN_USERID(String WARN_USERID) {
		this.WARN_USERID = WARN_USERID;
	}
	
	public String getIS_OPEN() {
		return IS_OPEN;
	}

	public void setIS_OPEN(String IS_OPEN) {
		this.IS_OPEN = IS_OPEN;
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