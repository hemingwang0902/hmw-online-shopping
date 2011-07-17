package com.baizhi.index.action.htlb;

import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HtlbService;

/**
 * 类名： InitHtlbPage.java<br>
 * 描述：<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午07:04:55<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class InitHtlbPage extends ActionSupport{
	
	private static final long serialVersionUID = 315500498585384140L;
	
	private HtlbService htlbService;
	
	private Map<String, Object> returnMap;
	
	public HtlbService getHtlbService() {
		return htlbService;
	}
	
	public void setHtlbService(HtlbService htlbService) {
		this.htlbService = htlbService;
	}
	
	public Map<String, Object> getReturnMap() {
		return returnMap;
	}

	public void setReturnMap(Map<String, Object> returnMap) {
		this.returnMap = returnMap;
	}

	@Override
	public String execute() throws Exception {
		returnMap=htlbService.getTalkList( 1, 10);
		return SUCCESS;
	}

}
