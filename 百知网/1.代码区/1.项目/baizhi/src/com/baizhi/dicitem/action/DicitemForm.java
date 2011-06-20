package com.baizhi.dicitem.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： DicitemList.java<br>
 * 描述：  获取字典列表清单列表信息
 * 创建者：何明旺
 * 创建日期： 2011-06-20 21:02:57
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class DicitemForm extends ActionSupport {
	
	private String DICITEM_ID;//字典清单ID
	private String CODE;//列表字典代码
	private String DIC_CODE;//字典代码
	private String DIC_NAME;//字典名称
	private String PDIC_CODE;//字典上级代码
	private String ALLPIN;//字典全拼
	private String SIMPLEPIN;//字典简拼
	private String ORDER_BY;//显示顺序
	private String REMARK;//备注
	
	public String getDICITEM_ID() {
		return DICITEM_ID;
	}

	public void setDICITEM_ID(String DICITEM_ID) {
		this.DICITEM_ID = DICITEM_ID;
	}
	
	public String getCODE() {
		return CODE;
	}

	public void setCODE(String CODE) {
		this.CODE = CODE;
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
	
	public String getPDIC_CODE() {
		return PDIC_CODE;
	}

	public void setPDIC_CODE(String PDIC_CODE) {
		this.PDIC_CODE = PDIC_CODE;
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
	
	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}
	
}