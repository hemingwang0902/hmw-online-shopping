package com.baizhi.answerreview.action;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： AnswerReviewList.java<br>
 * 描述：  获取问题答案评论信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 16:22:27<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public abstract class AnswerReviewForm extends ActionSupport {
	private static final long serialVersionUID = -4084520057170541681L;
	private String REVIEW_ID;//问题答案评论ID
	private String ANSWER_ID;//问题答案ID
	private String PROBLEM_ID;//问题ID(冗余字段)
	private String CONTENT;//内容
	private String PREVIEW_ID;//问题答案评论ID父ID
	private String USER_ID;//用户ID
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getREVIEW_ID() {
		return REVIEW_ID;
	}

	public void setREVIEW_ID(String REVIEW_ID) {
		this.REVIEW_ID = REVIEW_ID;
	}
	
	public String getANSWER_ID() {
		return ANSWER_ID;
	}

	public void setANSWER_ID(String ANSWER_ID) {
		this.ANSWER_ID = ANSWER_ID;
	}
	
	public String getPROBLEM_ID() {
		return PROBLEM_ID;
	}

	public void setPROBLEM_ID(String PROBLEM_ID) {
		this.PROBLEM_ID = PROBLEM_ID;
	}
	
	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String CONTENT) {
		this.CONTENT = CONTENT;
	}
	
	public String getPREVIEW_ID() {
		return PREVIEW_ID;
	}

	public void setPREVIEW_ID(String PREVIEW_ID) {
		this.PREVIEW_ID = PREVIEW_ID;
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