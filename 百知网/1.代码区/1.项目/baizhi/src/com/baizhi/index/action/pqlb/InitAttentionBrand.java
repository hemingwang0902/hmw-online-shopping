package com.baizhi.index.action.pqlb;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.PqlbService;

/**
 * 类名： InitAttentionBrand<br>
 * 描述：进入“他关注的品牌”页面<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-17<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class InitAttentionBrand  extends ActionSupport {
	private static final long serialVersionUID = 5530351017892598037L;
	private PqlbService pqlbService;//品牌列表业务类
	private String USER_ID;
	private String USER_NAME;
	private List<Map<String, Object>> hottestBrandList;
	private List<Map<String, Object>> LastestBrandList;

	public void setPqlbService(PqlbService pqlbService) {
		this.pqlbService = pqlbService;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSERID) {
		USER_ID = uSERID;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public List<Map<String, Object>> getHottestBrandList() {
		return hottestBrandList;
	}

	public List<Map<String, Object>> getLastestBrandList() {
		return LastestBrandList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		USER_NAME = pqlbService.getUserNameByUserId(NumberUtils.toInt(USER_ID));
		if(USER_NAME == null)
			return INPUT;
		
		// 查询最热品牌列表
		Map<String, Object> returnMap = pqlbService.getHottestBrand(1, 4);
		hottestBrandList = (List<Map<String, Object>>) returnMap.get(KEY_LIST);
		
		// 查询最新品牌列表
		Map<String, Object> map = pqlbService.getLastestBrand(1, 4);
		LastestBrandList = (List<Map<String, Object>>) map.get(KEY_LIST);

		return SUCCESS;
	}

	
}
