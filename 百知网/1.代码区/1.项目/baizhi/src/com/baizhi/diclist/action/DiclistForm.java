package com.baizhi.diclist.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： DiclistList.java<br>
 * 描述：  获取字典列表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-22 21:19:11
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class DiclistForm extends ActionSupport {
	
	private static final long serialVersionUID = 3448609132899074748L;
	
	private String DICLIST_ID;//字典列表ID
	private String NAME;//字典名称
	private String CODE;//字典代码
	private String ALLPIN;//字典全拼
	private String SIMPLEPIN;//字典简拼
	private String REMARK;//备注
	
	public String getDICLIST_ID() {
		return DICLIST_ID;
	}

	public void setDICLIST_ID(String DICLIST_ID) {
		this.DICLIST_ID = DICLIST_ID;
	}
	
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	
	public String getCODE() {
		return CODE;
	}

	public void setCODE(String CODE) {
		this.CODE = CODE;
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
	
	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}
	
}