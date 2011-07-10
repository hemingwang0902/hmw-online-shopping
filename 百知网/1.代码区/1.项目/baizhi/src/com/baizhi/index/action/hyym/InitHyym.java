package com.baizhi.index.action.hyym;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： InitHyym<br>
 * 描述：跳转到会员页面<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class InitHyym extends ActionSupport {
	private static final long serialVersionUID = 4289411773333642991L;
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}
}
