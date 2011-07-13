package com.baizhi.index.action.home;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HomeService;

public class GetListByTitleWithFull extends ActionSupport {
	private static final long serialVersionUID = 4724258461599626077L;
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
		Map<String, Object> returnMap = homeService.getListByTitleWithFull(q + "%",getNowPage(), getOnePageCount());
		this.setResult(returnMap);
		return JSONSUCCESS;
	}

}
