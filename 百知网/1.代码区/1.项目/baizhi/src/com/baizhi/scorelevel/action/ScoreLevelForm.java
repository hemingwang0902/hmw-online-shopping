package com.baizhi.scorelevel.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： ScoreLevelList.java<br>
 * 描述：  获取积分级别信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-21 00:43:41
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class ScoreLevelForm extends ActionSupport {
	
	private static final long serialVersionUID = 3919756819350933204L;
	
	private String SCORELEVEL_ID;//积分级别ID
	private String NAME;//级别名称
	private String SOCRE_UP;//积分上限
	private String SOCRE_DOWN;//积分下限
	private String REMARK;//备注
	
	public String getSCORELEVEL_ID() {
		return SCORELEVEL_ID;
	}

	public void setSCORELEVEL_ID(String SCORELEVEL_ID) {
		this.SCORELEVEL_ID = SCORELEVEL_ID;
	}
	
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	
	public String getSOCRE_UP() {
		return SOCRE_UP;
	}

	public void setSOCRE_UP(String SOCRE_UP) {
		this.SOCRE_UP = SOCRE_UP;
	}
	
	public String getSOCRE_DOWN() {
		return SOCRE_DOWN;
	}

	public void setSOCRE_DOWN(String SOCRE_DOWN) {
		this.SOCRE_DOWN = SOCRE_DOWN;
	}
	
	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}
	
}