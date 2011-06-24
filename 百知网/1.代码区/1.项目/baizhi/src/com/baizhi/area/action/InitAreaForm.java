package com.baizhi.area.action;

/**
 * 
 * 类名：InitAreaForm.java
 * 描述： 地区信息表控制类，负责初始化新增操作参数
 * 创建者：江红
 * 创建日期：2011-06-19 23:15:19
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class InitAreaForm extends AreaForm{

	private static final long serialVersionUID = 4920758154110688206L;

	@Override
	public String execute() throws Exception {
		return SUCCESS + getAREA_LEVEL();
	}

}
