package com.baizhi.index.action.hylb;

import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HylbService;

/**
 * 类名： InitHylbPage.java<br>
 * 描述：初始化会员页面<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午12:05:55<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class InitHylbPage extends ActionSupport{
	
	private static final long serialVersionUID = -1422381902637841507L;
	
	private  HylbService hylbService;
	
	private Map<String, Object> returnMap;
	
	public HylbService getHylbService() {
		return hylbService;
	}

	public void setHylbService(HylbService hylbService) {
		this.hylbService = hylbService;
	}
	
	public Map<String, Object> getReturnMap() {
		return returnMap;
	}

	public void setReturnMap(Map<String, Object> returnMap) {
		this.returnMap = returnMap;
	}

	@Override
	public String execute() throws Exception {
		returnMap=hylbService.getUserList(this.getSessionUserId(), 1, 10);
		return SUCCESS;
	}

}
