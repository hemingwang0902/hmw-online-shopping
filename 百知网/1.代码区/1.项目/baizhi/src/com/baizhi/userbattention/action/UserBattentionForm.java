package com.baizhi.userbattention.action;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： UserBattentionList.java<br>
 * 描述：  获取用户关注品牌信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:10<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public abstract class UserBattentionForm extends ActionSupport {
	
	private static final long serialVersionUID = -4468483121951037771L;
	private String BATTENTION_ID;//用户关注品牌ID
	private String USER_ID;//用户ID
	private String BRAND_ID;//被关注品牌
	private String IS_ATTENTION;//是否关注(0否、1是)
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getBATTENTION_ID() {
		return BATTENTION_ID;
	}

	public void setBATTENTION_ID(String BATTENTION_ID) {
		this.BATTENTION_ID = BATTENTION_ID;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getBRAND_ID() {
		return BRAND_ID;
	}

	public void setBRAND_ID(String BRAND_ID) {
		this.BRAND_ID = BRAND_ID;
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