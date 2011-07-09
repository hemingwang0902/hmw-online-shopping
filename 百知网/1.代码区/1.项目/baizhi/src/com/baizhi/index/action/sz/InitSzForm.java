package com.baizhi.index.action.sz;

import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.index.service.SzService;
/**
 * 
 * 类名：InitSzForm.java
 * 描述： 初始化新增表单
 * 创建者：江红
 * 创建日期：2011-06-21 00:52:07
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class InitSzForm  extends ActionSupport{
	
	private static final long serialVersionUID = 3476750499318310318L;
	
	private SzService szService;

	private Map<String, Object> returnMap;
	
	public Map<String, Object> getReturnMap() {
		return returnMap;
	}
	
	public void setReturnMap(Map<String, Object> returnMap) {
		this.returnMap = returnMap;
	}

	public SzService getSzService() {
		return szService;
	}

	public void setSzService(SzService szService) {
		this.szService = szService;
	}

	@Override
	public String execute() throws Exception {
		returnMap=szService.getUserBasicMapById(this.getSessionUserId());
		if(returnMap!=null&&returnMap.size()>0){
			String NAME_MODIFYTIME=this.getValue(returnMap, "NAME_MODIFYTIME");
			boolean IS_NAME_MODIFY=true;
			if(!NAME_MODIFYTIME.equals("")){
				long minus = DateUtils.getMinusTimes(DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT),NAME_MODIFYTIME,DateUtils.SHOW_DATE_FORMAT);
				double day=minus/(60*60*24*1.0);
				if(day<=30){
					IS_NAME_MODIFY=false;
				}
			}
			returnMap.put("IS_NAME_MODIFY", IS_NAME_MODIFY);
			
			String WEBSITE_MODIFYTIME=this.getValue(returnMap, "WEBSITE_MODIFYTIME");
			boolean IS_WEBSITE_MODIFY=false;
			String WEBSITE_NAME="";
			if(!WEBSITE_MODIFYTIME.equals("")){
				long minus = DateUtils.getMinusTimes(DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT),WEBSITE_MODIFYTIME,DateUtils.SHOW_DATE_FORMAT);
				//获取天数
				double day=minus/(60*60*24*1.0);
				if(day<30&&day>=28){
					WEBSITE_NAME="（四周前修改过）";
				}else if(day<28&&day>=21){
					WEBSITE_NAME="（三周前修改过）";
				}else if(day<28&&day>=14){
					WEBSITE_NAME="（二周前修改过）";
				}else if(day<28&&day>=7){
					WEBSITE_NAME="（一周前修改过）";
				}else if(day<7&&day>=0){
					WEBSITE_NAME="（本周修改过）";
				}else{
					IS_WEBSITE_MODIFY=true;
				}
			}else{
				IS_WEBSITE_MODIFY=true;
			}
			returnMap.put("IS_WEBSITE_MODIFY", IS_WEBSITE_MODIFY);
			returnMap.put("WEBSITE_NAME", WEBSITE_NAME);
		}
		return SUCCESS;
	}

}
