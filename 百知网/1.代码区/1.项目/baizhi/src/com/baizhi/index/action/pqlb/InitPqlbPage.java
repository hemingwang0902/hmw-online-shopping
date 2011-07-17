package com.baizhi.index.action.pqlb;

import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.PqlbService;

/**
 * 类名： InitPqlb.java<br>
 * 描述：初始化品牌页面<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午02:17:22<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class InitPqlbPage extends ActionSupport {
	
	private static final long serialVersionUID = -5876555053491188603L;
	
	private PqlbService pqlbService;//品牌列表业务类
	
	private Map<String, Object> returnMap;
	
	public PqlbService getPqlbService() {
		return pqlbService;
	}
	
	public void setPqlbService(PqlbService pqlbService) {
		this.pqlbService = pqlbService;
	}
	
	public Map<String, Object> getReturnMap() {
		return returnMap;
	}

	public void setReturnMap(Map<String, Object> returnMap) {
		this.returnMap = returnMap;
	}

	@Override
	public String execute() throws Exception {
		returnMap=pqlbService.getBrandList( 1, 10);
		return SUCCESS;
	}
}
