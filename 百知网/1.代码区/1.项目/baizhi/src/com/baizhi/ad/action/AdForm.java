package com.baizhi.ad.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： AdList.java<br>
 * 描述：  获取广告信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-21 00:52:07
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class AdForm extends ActionSupport {
	private static final long serialVersionUID = -4678595680170884717L;
	private String AD_ID;//广告ID
	private String TITLE;//主题
	private String CONTENT;//内容(支持html内容)
	private String IMAGE;//图片
	private String SHOW_TYPE;//显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)
	private String HREF;//链接地址
	private String ORDER_BY;//显示顺序
	private String START_TIME;//起始时间
	private String END_TIME;//终止时间
	private String STATUS;//状态(字典：1申请、2通过、3不通过)
	private String REMARK;//备注
	
	public String getAD_ID() {
		return AD_ID;
	}

	public void setAD_ID(String AD_ID) {
		this.AD_ID = AD_ID;
	}
	
	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String TITLE) {
		this.TITLE = TITLE;
	}
	
	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String CONTENT) {
		this.CONTENT = CONTENT;
	}
	
	public String getIMAGE() {
		return IMAGE;
	}

	public void setIMAGE(String IMAGE) {
		this.IMAGE = IMAGE;
	}
	
	public String getSHOW_TYPE() {
		return SHOW_TYPE;
	}

	public void setSHOW_TYPE(String SHOW_TYPE) {
		this.SHOW_TYPE = SHOW_TYPE;
	}
	
	public String getHREF() {
		return HREF;
	}

	public void setHREF(String HREF) {
		this.HREF = HREF;
	}
	
	public String getORDER_BY() {
		return ORDER_BY;
	}

	public void setORDER_BY(String ORDER_BY) {
		this.ORDER_BY = ORDER_BY;
	}
	
	public String getSTART_TIME() {
		return START_TIME;
	}

	public void setSTART_TIME(String START_TIME) {
		this.START_TIME = START_TIME;
	}
	
	public String getEND_TIME() {
		return END_TIME;
	}

	public void setEND_TIME(String END_TIME) {
		this.END_TIME = END_TIME;
	}
	
	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String STATUS) {
		this.STATUS = STATUS;
	}
	
	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}
	
}