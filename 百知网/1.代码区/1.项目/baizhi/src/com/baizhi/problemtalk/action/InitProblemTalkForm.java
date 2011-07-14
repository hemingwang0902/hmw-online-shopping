package com.baizhi.problemtalk.action;

import com.baizhi.commons.ActionSupport;

/**
 * 类名：InitProblemTalkForm.java<br>
 * 描述： 问题话题信息表控制类，负责初始化新增操作参数<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-07-14 10:39:35<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class InitProblemTalkForm extends ActionSupport{
	private static final long serialVersionUID = 4798078128834136506L;

	private String CURR_CREATE_BY;//创建人
	
	private String CURR_CREATE_TIME;//创建时间
	
	public String getCURR_CREATE_BY() {
		return CURR_CREATE_BY;
	}

	public void setCURR_CREATE_BY(String cURR_CREATE_BY) {
		CURR_CREATE_BY = cURR_CREATE_BY;
	}
	
	public String getCURR_CREATE_TIME() {
		return CURR_CREATE_TIME;
	}

	public void setCURR_CREATE_TIME(String cURR_CREATE_TIME) {
		CURR_CREATE_TIME = cURR_CREATE_TIME;
	}

	@Override
	public String execute() throws Exception {
		//this.setCURR_CREATE_BY(this.getSessionUserName());
		//this.setCURR_CREATE_TIME(DateUtils.getCurrentTime("yyyy-MM-dd HH:mm:ss"));
		return SUCCESS;
	}

}
