package com.baizhi.index.action.ppym;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： InitHyym<br>
 * 描述：跳转到品牌页面<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class InitPpym extends ActionSupport{

	private static final long serialVersionUID = -6389710365724898495L;
	private int BRAND_ID;

	public int getBRAND_ID() {
		return BRAND_ID;
	}

	public void setBRAND_ID(int bRANDID) {
		BRAND_ID = bRANDID;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
