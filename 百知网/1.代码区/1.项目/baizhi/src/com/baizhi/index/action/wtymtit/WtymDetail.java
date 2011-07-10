package com.baizhi.index.action.wtymtit;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： WtymDetail<br>
 * 描述：跳转到问题详细页面<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class WtymDetail  extends ActionSupport{

	private static final long serialVersionUID = -6091216231613960668L;
	
	private int problemId;

	public int getProblemId() {
		return problemId;
	}

	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}

	@Override
	public String execute() throws Exception {
		// TODO 跳到到页面之前将问题的浏览数加 1
		return SUCCESS;
	}

}
