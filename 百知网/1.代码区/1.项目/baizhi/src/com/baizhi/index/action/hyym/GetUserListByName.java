package com.baizhi.index.action.hyym;

import java.util.Map;

import org.apache.commons.lang.BooleanUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HylbService;
import com.baizhi.index.service.HyymService;

public class GetUserListByName extends ActionSupport {
	private static final long serialVersionUID = 7949568327860949543L;

	private HyymService hyymService;
	private HylbService hylbService;
	private Map<String, Object> returnMap;
	private String q;
	private String ajax;
	
	public void setHyymService(HyymService hyymService) {
		this.hyymService = hyymService;
	}

	public void setHylbService(HylbService hylbService) {
		this.hylbService = hylbService;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}
	
	public void setAjax(String ajax) {
		this.ajax = ajax;
	}

	public Map<String, Object> getReturnMap() {
		return returnMap;
	}

	@Override
	public String execute() throws Exception {
		// 查询结果列表
		if(BooleanUtils.toBoolean(ajax)){
			returnMap = hyymService.getUserListByName(q+"%", getSessionUserId(), this.getNowPage(), this.getOnePageCount());
			this.setResult(returnMap);
			return JSONSUCCESS;
		}else {
			returnMap = hylbService.getUserList(this.getSessionUserId(), 1, 10);
			return SUCCESS;
		}
	}
}
