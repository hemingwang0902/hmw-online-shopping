package com.baizhi.index.action.home;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HomeService;

/**
 * 类名： GetAdByPosition<br>
 * 描述：查询广告<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-8-3<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetAdByPosition extends ActionSupport{

	private static final long serialVersionUID = 4291631833332229528L;
	private HomeService homeService;
	private String SHOW_TYPE;
	private Map<String, Object> ad;

	public Map<String, Object> getAd() {
		return ad;
	}

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	public void setSHOW_TYPE(String sHOWTYPE) {
		SHOW_TYPE = sHOWTYPE;
	}

	@Override
	public String execute() throws Exception {
		if(StringUtils.isNotBlank(SHOW_TYPE))
			ad = homeService.GetAdByPosition(SHOW_TYPE);
		return SUCCESS;
	}

}
