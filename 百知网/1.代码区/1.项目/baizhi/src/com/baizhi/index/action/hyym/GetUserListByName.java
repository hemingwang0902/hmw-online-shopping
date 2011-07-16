package com.baizhi.index.action.hyym;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.BooleanUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HyymService;

public class GetUserListByName extends ActionSupport {
	private static final long serialVersionUID = 7949568327860949543L;

	private HyymService hyymService;
	private String q;
	private List<Map<String, Object>> userList;
	private boolean ajax;
	
	public void setHyymService(HyymService hyymService) {
		this.hyymService = hyymService;
	}

	public List<Map<String, Object>> getUserList() {
		return userList;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	public void setAjax(boolean ajax) {
		this.ajax = ajax;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// 查询结果列表
		Map<String, Object> returnMap = hyymService.getUserListByName(q, this.getNowPage(), this.getOnePageCount());
		if(BooleanUtils.toBoolean(ajax)){
			this.setResult(returnMap);
			return JSONSUCCESS;
		}else {
			userList = (List<Map<String, Object>>) returnMap.get(KEY_LIST);
			return SUCCESS;
		}
		
	}

}
