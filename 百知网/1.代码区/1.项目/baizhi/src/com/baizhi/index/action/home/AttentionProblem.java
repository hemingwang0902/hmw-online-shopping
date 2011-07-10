package com.baizhi.index.action.home;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HomeService;

/**
 * 类名： AttentionProblem<br>
 * 描述：关注问题<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AttentionProblem extends ActionSupport {
	private static final long serialVersionUID = 4226083040066849977L;
	private HomeService homeService;
	private int problemId;

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	public int getProblemId() {
		return problemId;
	}

	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}



	@Override
	public String execute() throws Exception {
		homeService.attentionProblem(getSessionUserId(), getProblemId());
		return JSONSUCCESS;
	}

}
