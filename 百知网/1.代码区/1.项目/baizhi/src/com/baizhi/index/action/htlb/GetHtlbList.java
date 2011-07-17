package com.baizhi.index.action.htlb;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HtlbService;

/**
 * 类名： GetHtlbList.java<br>
 * 描述：话题列表<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午07:06:24<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetHtlbList extends ActionSupport{
	
	private static final long serialVersionUID = 6479093207725370061L;
	
	private HtlbService htlbService;
	
	public HtlbService getHtlbService() {
		return htlbService;
	}
	
	public void setHtlbService(HtlbService htlbService) {
		this.htlbService = htlbService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("USER_ID", this.getSessionUserId());
		Map<String, Object> returnMap = htlbService.getHtlbList(params, this.getNowPage(), this.getOnePageCount());
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
