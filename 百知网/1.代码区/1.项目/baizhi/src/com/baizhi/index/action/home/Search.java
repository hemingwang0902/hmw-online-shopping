package com.baizhi.index.action.home;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： Search<br>
 * 描述：跳转到模糊搜索用户、品牌、问题和话题的结果页<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-3<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class Search extends ActionSupport {
	private static final long serialVersionUID = 2068239711393552265L;
	private String q;

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

}
