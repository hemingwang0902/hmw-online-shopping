package com.baizhi.index.action.home;

import org.apache.commons.lang.BooleanUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HomeService;

/**
 * 类名： CollectionProblem<br>
 * 描述：收藏/取消收藏问题<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class CollectionProblem extends ActionSupport {

	private static final long serialVersionUID = 2676108399354856644L;
	private HomeService homeService;
	private int problemId;
	//为true时，表示为取消收藏
	private String disCollection;

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	public int getProblemId() {
		return problemId;
	}

	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	
	public void setDisCollection(String disCollection) {
		this.disCollection = disCollection;
	}

	@Override
	public String execute() throws Exception {
		homeService.collectionProblem(getSessionUserId(), getProblemId(), BooleanUtils.toBoolean(disCollection));
		return JSONSUCCESS;
	}

}
