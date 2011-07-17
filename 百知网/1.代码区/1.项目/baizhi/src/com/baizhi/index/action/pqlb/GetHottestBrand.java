package com.baizhi.index.action.pqlb;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.PqlbService;

/**
 * 类名： GetHottestBrand<br>
 * 描述：最热品牌<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-17<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetHottestBrand  extends ActionSupport {
	private static final long serialVersionUID = -2045670228190168582L;
	private PqlbService pqlbService;//品牌列表业务类
	
	public PqlbService getPqlbService() {
		return pqlbService;
	}
	
	public void setPqlbService(PqlbService pqlbService) {
		this.pqlbService = pqlbService;
	}
	
	@Override
	public String execute() throws Exception {
		// 查询品牌列表
		Map<String, Object> returnMap = pqlbService.getHottestBrand(getNowPage(), getOnePageCount());
		this.setResult(returnMap);
		return JSONSUCCESS;
	}

	
}
