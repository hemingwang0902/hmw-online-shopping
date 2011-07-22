package com.baizhi.index.action.sz;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.index.service.SzService;

/**
 * 类名： SaveBasic.java<br>
 * 描述：保存基本信息<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-9 上午11:17:12<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class SaveBasic extends ActionSupport{
	
	private static final long serialVersionUID = -6096587748774864886L;

	private SzService szService;
	
	
	public SzService getSzService() {
		return szService;
	}
	
	public void setSzService(SzService szService) {
		this.szService = szService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		
		//获取基本信息
		Map<String, Object> data = szService.getUserBasicMapById(this.getSessionUserId());
		
		String o_name=this.getValue(data, "NAME");
		String o_name_modifytime=getTime(data, "NAME_MODIFYTIME");
		String o_website=this.getValue(data, "WEBSITE");
		String o_website_modifytime=getTime(data, "WEBSITE_MODIFYTIME");
		
		
		Map<String, Object> params=new HashMap<String, Object>();
		boolean exec=true;
		//判断姓名是否修改
		if(!o_name.equals(NAME)&&(o_name_modifytime.equals("")||isTime(o_name_modifytime))){
			params.put("NAME", StringUtils.trimToEmpty(NAME));
			params.put("NAME_MODIFYTIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));
		}else if(!o_name.equals(NAME)){
			message="姓名修改失败,一个月只能修改一次";
			exec=false;
		}
		//判断个性网址是否修改
		if(!o_website.equals(WEBSITE)&&(o_website_modifytime.equals("")||isTime(o_website_modifytime))){
			params.put("WEBSITE", StringUtils.trimToEmpty(WEBSITE));
			params.put("WEBSITE_MODIFYTIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));
		}else if(!o_website.equals(WEBSITE)){
			message="个性网址修改失败,一个月只能修改一次";
			exec=false;
		}
		if(exec){
			params.put("INTRODUCTION", INTRODUCTION);
			int count=szService.updateUserBasic(params, this.getSessionUserId());
			if(count>0){
				flag=true;
				message="基本信息设置成功";
			}else{
				message="基本信息设置失败";
			}
		}
		
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
	private boolean isTime(String time){
		boolean flag=false;
		//获取当前时间
		String curtime=DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT);
		double day=DateUtils.getMinusTimes(curtime, time, DateUtils.SHOW_DATE_FORMAT)/(60*60*24*1.0);
		if(day>30){
			flag=true;
		}
		return flag;
	}
	
	private String NAME;
	
	private String INTRODUCTION;
	
	private String WEBSITE;

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String name) {
		NAME = name;
	}

	public String getINTRODUCTION() {
		return INTRODUCTION;
	}

	public void setINTRODUCTION(String introduction) {
		INTRODUCTION = introduction;
	}

	public String getWEBSITE() {
		return WEBSITE;
	}

	public void setWEBSITE(String website) {
		WEBSITE = website;
	}
	
	

}
