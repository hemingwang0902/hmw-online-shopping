package com.baizhi.answervote.action;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： AnswerVoteList.java<br>
 * 描述：  获取问题答案投票信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 16:22:26<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public abstract class AnswerVoteForm extends ActionSupport {
	private static final long serialVersionUID = 7234998080832649171L;
	private String VOTE_ID;//问题答案投票ID
	private String ANSWER_ID;//问题答案ID
	private String PROBLEM_ID;//问题ID(冗余字段)
	private String VOTE_TYPE;//投票类型(字典：1赞成Or拒绝、2感谢作者Or没有帮助)
	private String IS_AGREE;//是否赞成、感谢(0否、1是)
	private String USER_ID;//用户ID
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getVOTE_ID() {
		return VOTE_ID;
	}

	public void setVOTE_ID(String VOTE_ID) {
		this.VOTE_ID = VOTE_ID;
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
	
	public String getVOTE_TYPE() {
		return VOTE_TYPE;
	}

	public void setVOTE_TYPE(String VOTE_TYPE) {
		this.VOTE_TYPE = VOTE_TYPE;
	}
	
	public String getIS_AGREE() {
		return IS_AGREE;
	}

	public void setIS_AGREE(String IS_AGREE) {
		this.IS_AGREE = IS_AGREE;
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