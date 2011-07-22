package com.baizhi.index.action.home;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HomeService;

/**
 * 类名： GetLatestProblemList<br>
 * 描述：获取最新问题列表<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-6<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetLatestProblemList extends ActionSupport {
	private static final long serialVersionUID = 1464968933246801463L;
	private HomeService homeService;

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	@Override
	public String execute() throws Exception {
		// 查询结果列表
		Map<String, Object> returnMap = homeService.getLatestProblemList(getSessionUserId(), this.getNowPage(), this.getOnePageCount());
		this.setResult(returnMap);
		
		return JSONSUCCESS;
	}

}
