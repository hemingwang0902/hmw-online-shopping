package com.baizhi.problem.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： ProblemList.java<br>
 * 描述：  获取问题信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-21 00:45:57
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class ProblemForm extends ActionSupport {
	
	private String PROBLEM_ID;//问题ID
	private String PROBLEM_TYPE;//问题类型(字典：1普通、2我问的问题)
	private String CONTENT;//问题内容
	private String IS_ANONYMITY;//是否匿名(0否、1是)
	private String RELEVANT_DETAILS;//相关细节
	private String USER_ID;//用户ID
	private String WAS_USERID;//被问用户ID
	private String ANSWER_COUNT;//答案数量
	private String REVIEW_COUNT;//评论数量
	private String ATTENTION_COUNT;//关注数量
	private String COLLECTION_COUNT;//收藏数量
	private String BROWSE_COUNT;//浏览次数
	private String IS_REPORT;//是否举报(0否、1是)
	private String REPORT_COUNT;//举报次数
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getPROBLEM_ID() {
		return PROBLEM_ID;
	}

	public void setPROBLEM_ID(String PROBLEM_ID) {
		this.PROBLEM_ID = PROBLEM_ID;
	}
	
	public String getPROBLEM_TYPE() {
		return PROBLEM_TYPE;
	}

	public void setPROBLEM_TYPE(String PROBLEM_TYPE) {
		this.PROBLEM_TYPE = PROBLEM_TYPE;
	}
	
	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String CONTENT) {
		this.CONTENT = CONTENT;
	}
	
	public String getIS_ANONYMITY() {
		return IS_ANONYMITY;
	}

	public void setIS_ANONYMITY(String IS_ANONYMITY) {
		this.IS_ANONYMITY = IS_ANONYMITY;
	}
	
	public String getRELEVANT_DETAILS() {
		return RELEVANT_DETAILS;
	}

	public void setRELEVANT_DETAILS(String RELEVANT_DETAILS) {
		this.RELEVANT_DETAILS = RELEVANT_DETAILS;
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
	
	public String getANSWER_COUNT() {
		return ANSWER_COUNT;
	}

	public void setANSWER_COUNT(String ANSWER_COUNT) {
		this.ANSWER_COUNT = ANSWER_COUNT;
	}
	
	public String getREVIEW_COUNT() {
		return REVIEW_COUNT;
	}

	public void setREVIEW_COUNT(String REVIEW_COUNT) {
		this.REVIEW_COUNT = REVIEW_COUNT;
	}
	
	public String getATTENTION_COUNT() {
		return ATTENTION_COUNT;
	}

	public void setATTENTION_COUNT(String ATTENTION_COUNT) {
		this.ATTENTION_COUNT = ATTENTION_COUNT;
	}
	
	public String getCOLLECTION_COUNT() {
		return COLLECTION_COUNT;
	}

	public void setCOLLECTION_COUNT(String COLLECTION_COUNT) {
		this.COLLECTION_COUNT = COLLECTION_COUNT;
	}
	
	public String getBROWSE_COUNT() {
		return BROWSE_COUNT;
	}

	public void setBROWSE_COUNT(String BROWSE_COUNT) {
		this.BROWSE_COUNT = BROWSE_COUNT;
	}
	
	public String getIS_REPORT() {
		return IS_REPORT;
	}

	public void setIS_REPORT(String IS_REPORT) {
		this.IS_REPORT = IS_REPORT;
	}
	
	public String getREPORT_COUNT() {
		return REPORT_COUNT;
	}

	public void setREPORT_COUNT(String REPORT_COUNT) {
		this.REPORT_COUNT = REPORT_COUNT;
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