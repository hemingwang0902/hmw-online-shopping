package com.baizhi.ad.action;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.ad.service.AdService;
import com.baizhi.commons.support.Elements;
/**
 * 
 * 类名：AdSave.java
 * 描述： 广告信息表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-06-21 00:52:07
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveAd extends AdForm{

	private static final long serialVersionUID = -3213122859132112752L;
	private AdService adService;//广告信息表业务类
	
	public AdService getAdService() {
		return adService;
	}

	public void setAdService(AdService adService) {
		this.adService = adService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果广告信息表ID为""，则为新增广告信息表，否则更新广告信息表
		if(StringUtils.isNotEmpty(this.getAD_ID())){
			element = adService.getAdEleById("AD_ID");
			Elements.setElementValue(element, "AD_ID", this.getAD_ID());// 广告ID
			Elements.setElementValue(element, "TITLE", this.getTITLE());// 主题
			Elements.setElementValue(element, "CONTENT", this.getCONTENT());// 内容(支持html内容)
			Elements.setElementValue(element, "IMAGE", this.getIMAGE());// 图片
			Elements.setElementValue(element, "SHOW_TYPE", this.getSHOW_TYPE());// 显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)
			Elements.setElementValue(element, "HREF", this.getHREF());// 链接地址
			Elements.setElementValue(element, "ORDER_BY", StringUtils.defaultIfEmpty(this.getORDER_BY(), "" + Integer.MAX_VALUE));// 显示顺序
			Elements.setElementValue(element, "START_TIME", this.getSTART_TIME());// 起始时间
			Elements.setElementValue(element, "END_TIME", this.getEND_TIME());// 终止时间
			Elements.setElementValue(element, "STATUS", this.getSTATUS());// 状态(字典：1申请、2通过、3不通过)
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			
			//如果保存成功，返回主键
			keyid = adService.saveOrUpdateAd(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("广告信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_AD");
			Elements.setElementValue(element, "TITLE", this.getTITLE());// 主题
			Elements.setElementValue(element, "CONTENT", this.getCONTENT());// 内容(支持html内容)
			Elements.setElementValue(element, "IMAGE", this.getIMAGE());// 图片
			Elements.setElementValue(element, "SHOW_TYPE", this.getSHOW_TYPE());// 显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)
			Elements.setElementValue(element, "HREF", this.getHREF());// 链接地址
			Elements.setElementValue(element, "ORDER_BY", StringUtils.defaultIfEmpty(this.getORDER_BY(), "" + Integer.MAX_VALUE));// 显示顺序
			Elements.setElementValue(element, "START_TIME", this.getSTART_TIME());// 起始时间
			Elements.setElementValue(element, "END_TIME", this.getEND_TIME());// 终止时间
			Elements.setElementValue(element, "STATUS", this.getSTATUS());// 状态(字典：1申请、2通过、3不通过)
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			//如果保存成功，返回主键
			keyid = adService.saveOrUpdateAd(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		ServletActionContext.getRequest().setAttribute("CONTENT", getCONTENT());
		return ERROR;
	}

}
