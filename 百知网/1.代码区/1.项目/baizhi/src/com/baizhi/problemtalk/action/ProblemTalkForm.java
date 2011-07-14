package com.baizhi.problemtalk.action;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： ProblemTalkList.java<br>
 * 描述：  获取问题话题信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 10:39:35<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public abstract class ProblemTalkForm extends ActionSupport {
	
	private String PROBLEMTALK_ID;//问题话题ID
	private String TALK_ID;//话题ID
	private String PROBLEM_ID;//问题ID
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getPROBLEMTALK_ID() {
		return PROBLEMTALK_ID;
	}

	public void setPROBLEMTALK_ID(String PROBLEMTALK_ID) {
		this.PROBLEMTALK_ID = PROBLEMTALK_ID;
	}
	
	public String getTALK_ID() {
		return TALK_ID;
	}

	public void setTALK_ID(String TALK_ID) {
		this.TALK_ID = TALK_ID;
	}
	
	public String getPROBLEM_ID() {
		return PROBLEM_ID;
	}

	public void setPROBLEM_ID(String PROBLEM_ID) {
		this.PROBLEM_ID = PROBLEM_ID;
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