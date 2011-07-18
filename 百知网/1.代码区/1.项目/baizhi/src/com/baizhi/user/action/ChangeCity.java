package com.baizhi.user.action;

import java.util.Map;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： ChangeCity.java<br>
 * 描述：切换城市<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-16 下午10:49:12<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class ChangeCity extends ActionSupport{
	
	private static final long serialVersionUID = -12556759649925427L;

	private String CITY;
	
	private String CITY_NAME;
	
	private Integer CHANGE_TYPE;
	
	public String getCITY() {
		return CITY;
	}
	
	public void setCITY(String city) {
		CITY = city;
	}
	
	public String getCITY_NAME() {
		return CITY_NAME;
	}

	public void setCITY_NAME(String city_name) {
		CITY_NAME = city_name;
	}
	
	public Integer getCHANGE_TYPE() {
		return CHANGE_TYPE;
	}

	public void setCHANGE_TYPE(Integer change_type) {
		CHANGE_TYPE = change_type;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> userinfo = this.getSessionUserInfo();
		userinfo.put("CITY", CITY);
		userinfo.put("CITY_NAME", CITY_NAME);
		userinfo.put("CHANGE_TYPE", CHANGE_TYPE);
		return JSONSUCCESS;
	}

}
