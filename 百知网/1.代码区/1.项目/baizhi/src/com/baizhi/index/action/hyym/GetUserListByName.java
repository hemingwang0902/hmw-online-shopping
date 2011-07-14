package com.baizhi.index.action.hyym;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HyymService;

public class GetUserListByName extends ActionSupport {
	private static final long serialVersionUID = 7949568327860949543L;

	private HyymService hyymService;
	private String name;
	
	public void setHyymService(HyymService hyymService) {
		this.hyymService = hyymService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String execute() throws Exception {
		// 查询结果列表
		Map<String, Object> returnMap = hyymService.getUserListByName(name, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
