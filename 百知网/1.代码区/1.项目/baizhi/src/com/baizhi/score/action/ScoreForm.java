package com.baizhi.score.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： ScoreList.java<br>
 * 描述：  获取积分信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-08-07 18:51:46
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class ScoreForm extends ActionSupport {
	
	private static final long serialVersionUID = -9131955283565317764L;
	private String SCORE_ID;//积分ID
	private String NAME;//积分名称
	private String SOCRE_TYPE;//积分类型(1、会员邀请朋友注册获得积分2、提问题3、回答问题)
	private String SOCRE;//积分
	private String IS_VALID;//是否禁用
	private String REMARK;//备注
	
	public String getSCORE_ID() {
		return SCORE_ID;
	}

	public void setSCORE_ID(String SCORE_ID) {
		this.SCORE_ID = SCORE_ID;
	}
	
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	
	public String getSOCRE_TYPE() {
		return SOCRE_TYPE;
	}

	public void setSOCRE_TYPE(String SOCRE_TYPE) {
		this.SOCRE_TYPE = SOCRE_TYPE;
	}
	
	public String getSOCRE() {
		return SOCRE;
	}

	public void setSOCRE(String SOCRE) {
		this.SOCRE = SOCRE;
	}
	
	public String getIS_VALID() {
		return IS_VALID;
	}

	public void setIS_VALID(String IS_VALID) {
		this.IS_VALID = IS_VALID;
	}
	
	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}
	
}