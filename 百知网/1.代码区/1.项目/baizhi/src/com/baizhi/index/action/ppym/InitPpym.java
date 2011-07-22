package com.baizhi.index.action.ppym;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.PpymService;

/**
 * 类名： InitHyym<br>
 * 描述：跳转到品牌页面<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class InitPpym extends ActionSupport{

	private static final long serialVersionUID = -6389710365724898495L;
	private PpymService ppymService;
	private String BRAND_ID;
	private Map<String, Object> brand;
	private List<Map<String, Object>> wasAttentionUserList; 

	public void setPpymService(PpymService ppymService) {
		this.ppymService = ppymService;
	}

	public void setBRAND_ID(String bRANDID) {
		BRAND_ID = bRANDID;
	}

	public Map<String, Object> getBrand() {
		return brand;
	}

	public List<Map<String, Object>> getWasAttentionUserList() {
		return wasAttentionUserList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		int brandId = NumberUtils.toInt(BRAND_ID);
		if(brandId > 0){
			brand = ppymService.getBrandById(brandId, getSessionUserId());
			wasAttentionUserList = (List<Map<String, Object>>) ppymService.getWasAttentionUserListByBrandId(brandId, 1, 21).get(KEY_LIST);
		}
		return SUCCESS;
	}

}
