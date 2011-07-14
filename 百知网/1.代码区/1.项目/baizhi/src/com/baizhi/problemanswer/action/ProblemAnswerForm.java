package com.baizhi.problemanswer.action;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： ProblemAnswerList.java<br>
 * 描述：  获取问题答案信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 10:39:37<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public abstract class ProblemAnswerForm extends ActionSupport {
	
	private String ANSWER_ID;//问题答案ID
	private String PROBLEM_ID;//问题ID
	private String CONTENT;//内容
	private String USER_ID;//用户ID
	private String AGREE_COUNT;//赞成数量
	private String DISAGREE_COUNT;//反对数量
	private String THANK_COUNT;//感觉作者数量
	private String DISTHANK_COUNT;//没有帮助数量
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
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
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getAGREE_COUNT() {
		return AGREE_COUNT;
	}

	public void setAGREE_COUNT(String AGREE_COUNT) {
		this.AGREE_COUNT = AGREE_COUNT;
	}
	
	public String getDISAGREE_COUNT() {
		return DISAGREE_COUNT;
	}

	public void setDISAGREE_COUNT(String DISAGREE_COUNT) {
		this.DISAGREE_COUNT = DISAGREE_COUNT;
	}
	
	public String getTHANK_COUNT() {
		return THANK_COUNT;
	}

	public void setTHANK_COUNT(String THANK_COUNT) {
		this.THANK_COUNT = THANK_COUNT;
	}
	
	public String getDISTHANK_COUNT() {
		return DISTHANK_COUNT;
	}

	public void setDISTHANK_COUNT(String DISTHANK_COUNT) {
		this.DISTHANK_COUNT = DISTHANK_COUNT;
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