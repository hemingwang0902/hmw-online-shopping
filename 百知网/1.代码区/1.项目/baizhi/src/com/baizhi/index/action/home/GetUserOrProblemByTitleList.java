package com.baizhi.index.action.home;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HomeService;

/**
 * 类名： UserBasicList.java<br>
 * 描述： 获取品牌列表列表信息 创建者：江红 创建日期： 2011-06-23 22:03:15 版本：V0.9 修改者： 修改日期：
 */
public class GetUserOrProblemByTitleList extends ActionSupport {

	private static final long serialVersionUID = 5465713969149938078L;
	private HomeService homeService;// 品牌列表业务类
	private String q;
	private int nowPage;
	private int onePageCount;

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getOnePageCount() {
		return onePageCount;
	}

	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}

	@Override
	public String execute() throws Exception {
		// 查询结果列表
		Map<String, Object> returnMap = homeService.getUserOrProblemByTitleList(q + "%", nowPage, onePageCount);
		this.setResult(returnMap);
		return JSONSUCCESS;
	}

}
