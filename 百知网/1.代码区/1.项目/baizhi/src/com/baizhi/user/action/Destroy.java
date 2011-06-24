package com.baizhi.user.action;

import org.apache.struts2.ServletActionContext;

import com.baizhi.commons.ActionSupport;
/**
 * 
 * 类名：Destroy<br>
 * 描述：用户注销<br>
 * 创建者：江红 <br>
 * 创建日期： 2011-3-30<br>
 * 版本：V0.9 <br>
 * 修改者：        <br>
 * 修改日期：   <br>
 */
public class Destroy extends ActionSupport{
	
	private static final long serialVersionUID = 135613692390026078L;

	@Override
	public String execute() throws Exception {
		ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}

}
