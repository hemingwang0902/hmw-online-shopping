package com.baizhi.index.action.home;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HomeService;

/**
 * 类名： GetUserOrProblemByTitleList<br>
 * 描述：根据名称（标题）查询会员、品牌和问题列表<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-3<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetUserOrProblemByTitleList extends ActionSupport {
	private static final long serialVersionUID = 1680897793903369039L;
	private HomeService homeService;
	private String q;

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	@Override
	public String execute() throws Exception {
		// 查询结果列表
		Map<String, Object> returnMap = homeService.getUserOrProblemByTitleList(q + "%", getNowPage(), getOnePageCount());
		this.setResult(returnMap);
		return JSONSUCCESS;
	}

}
