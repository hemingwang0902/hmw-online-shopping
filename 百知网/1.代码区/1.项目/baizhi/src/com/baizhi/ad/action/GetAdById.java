package com.baizhi.ad.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.baizhi.ad.service.AdService;
/**
 * 
 * 类名：GetAdById.java
 * 描述： 获取单条广告信息表表单信息
 * 创建者：江红
 * 创建日期： 2011-06-21 00:52:07
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetAdById extends AdForm{
	private static final long serialVersionUID = 4417652686619546224L;
	private AdService adService;//广告信息表业务类
	
	public AdService getAdService() {
		return adService;
	}

	public void setAdService(AdService adService) {
		this.adService = adService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = adService.getAdMapById(this.getAD_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setTITLE(this.getValue(returnMap,"TITLE"));// 主题
			this.setCONTENT(this.getValue(returnMap,"CONTENT"));// 内容(支持html内容)
			this.setIMAGE(this.getValue(returnMap,"IMAGE"));// 图片
			this.setSHOW_TYPE(this.getValue(returnMap,"SHOW_TYPE"));// 显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)
			this.setHREF(this.getValue(returnMap,"HREF"));// 链接地址
			this.setORDER_BY(this.getValue(returnMap,"ORDER_BY"));// 显示顺序
			this.setSTART_TIME(this.getValue(returnMap,"START_TIME"));// 起始时间
			this.setEND_TIME(this.getValue(returnMap,"END_TIME"));// 终止时间
			this.setSTATUS(this.getValue(returnMap,"STATUS"));// 状态(字典：1申请、2通过、3不通过)
			this.setREMARK(this.getValue(returnMap,"REMARK"));// 备注
		}
		ServletActionContext.getRequest().setAttribute("CONTENT", getCONTENT());
		
		return SUCCESS;
	}
	
}
