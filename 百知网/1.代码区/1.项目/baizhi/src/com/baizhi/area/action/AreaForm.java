package com.baizhi.area.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： AreaList.java<br>
 * 描述：  获取地区信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-19 23:15:19
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class AreaForm extends ActionSupport {
	private static final long serialVersionUID = -7921660718540727790L;
	private String AREA_ID;//地区ID
	private String DIC_CODE;//地区代码(根据级别制定规则定义)
	private String DIC_NAME;//地区名称
	private String PAREA_ID;//地区上级代码
	private String ALLPIN;//地区全拼
	private String SIMPLEPIN;//地区简拼
	private String ORDER_BY;//显示顺序
	private String IP_START;//IP起始段
	private String IP_END;//IP终止段
	private String AREA_LEVEL;//地区级别(字典：1省、2市、3县、4镇、5村)暂时定义省、市两级
	private String REMARK;//备注
	
	public String getAREA_ID() {
		return AREA_ID;
	}

	public void setAREA_ID(String AREA_ID) {
		this.AREA_ID = AREA_ID;
	}
	
	public String getDIC_CODE() {
		return DIC_CODE;
	}

	public void setDIC_CODE(String DIC_CODE) {
		this.DIC_CODE = DIC_CODE;
	}
	
	public String getDIC_NAME() {
		return DIC_NAME;
	}

	public void setDIC_NAME(String DIC_NAME) {
		this.DIC_NAME = DIC_NAME;
	}
	
	public String getPAREA_ID() {
		return PAREA_ID;
	}

	public void setPAREA_ID(String PAREA_ID) {
		this.PAREA_ID = PAREA_ID;
	}
	
	public String getALLPIN() {
		return ALLPIN;
	}

	public void setALLPIN(String ALLPIN) {
		this.ALLPIN = ALLPIN;
	}
	
	public String getSIMPLEPIN() {
		return SIMPLEPIN;
	}

	public void setSIMPLEPIN(String SIMPLEPIN) {
		this.SIMPLEPIN = SIMPLEPIN;
	}
	
	public String getORDER_BY() {
		return ORDER_BY;
	}

	public void setORDER_BY(String ORDER_BY) {
		this.ORDER_BY = ORDER_BY;
	}
	
	public String getIP_START() {
		return IP_START;
	}

	public void setIP_START(String IP_START) {
		this.IP_START = IP_START;
	}
	
	public String getIP_END() {
		return IP_END;
	}

	public void setIP_END(String IP_END) {
		this.IP_END = IP_END;
	}
	
	public String getAREA_LEVEL() {
		return AREA_LEVEL;
	}

	public void setAREA_LEVEL(String AREA_LEVEL) {
		this.AREA_LEVEL = AREA_LEVEL;
	}
	
	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}
	
}