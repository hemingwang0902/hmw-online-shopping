package com.baizhi.problemcollection.action;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： ProblemCollectionList.java<br>
 * 描述：  获取问题收藏信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:13<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public abstract class ProblemCollectionForm extends ActionSupport {

	private static final long serialVersionUID = 2259304817418227344L;
	private String COLLECTION_ID;//问题收藏ID
	private String PROBLEM_ID;//问题ID
	private String IS_COLLECTION;//是否收藏(0否、1是)
	private String USER_ID;//用户ID
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getCOLLECTION_ID() {
		return COLLECTION_ID;
	}

	public void setCOLLECTION_ID(String COLLECTION_ID) {
		this.COLLECTION_ID = COLLECTION_ID;
	}
	
	public String getPROBLEM_ID() {
		return PROBLEM_ID;
	}

	public void setPROBLEM_ID(String PROBLEM_ID) {
		this.PROBLEM_ID = PROBLEM_ID;
	}
	
	public String getIS_COLLECTION() {
		return IS_COLLECTION;
	}

	public void setIS_COLLECTION(String IS_COLLECTION) {
		this.IS_COLLECTION = IS_COLLECTION;
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