package com.baizhi.userbrand.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： UserBrandList.java<br>
 * 描述：  获取用户品牌信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-07-10 13:09:53
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class UserBrandForm extends ActionSupport {
	
	private String BRAND_ID;//品牌ID
	private String USER_ID;//用户ID
	private String NAME;//品牌名称
	private String INTRODUCTION;//品牌介绍
	private String SOURCE;//发源地(品牌特有)
	private String PROVINCE;//所在地区(省：地区信息表ID)
	private String CITY;//所在地区(市：地区信息表ID)
	private String INDUSTRY;//从事行业(字典)
	private String LINK_NAME;//联系人姓名
	private String LINK_MODE;//联系方式
	private String EMAIL;//电子邮箱
	private String IMAGE_PATH;//相片路径/LOGO路径
	private String STAUS;//状态(1：未申请、2：申请、3：通过、4：未通过)
	private String AUDIT_ID;//审核人
	private String AUDIT_TIME;//审核时间
	private String REASON;//不通过原因
	private String REMARK;//备注
	private String BRAND_LABEL;
	public String getBRAND_LABEL() {
		return BRAND_LABEL;
	}

	public void setBRAND_LABEL(String brand_label) {
		BRAND_LABEL = brand_label;
	}

	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getBRAND_ID() {
		return BRAND_ID;
	}

	public void setBRAND_ID(String BRAND_ID) {
		this.BRAND_ID = BRAND_ID;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	
	public String getINTRODUCTION() {
		return INTRODUCTION;
	}

	public void setINTRODUCTION(String INTRODUCTION) {
		this.INTRODUCTION = INTRODUCTION;
	}
	
	public String getSOURCE() {
		return SOURCE;
	}

	public void setSOURCE(String SOURCE) {
		this.SOURCE = SOURCE;
	}
	
	public String getPROVINCE() {
		return PROVINCE;
	}

	public void setPROVINCE(String PROVINCE) {
		this.PROVINCE = PROVINCE;
	}
	
	public String getCITY() {
		return CITY;
	}

	public void setCITY(String CITY) {
		this.CITY = CITY;
	}
	
	public String getINDUSTRY() {
		return INDUSTRY;
	}

	public void setINDUSTRY(String INDUSTRY) {
		this.INDUSTRY = INDUSTRY;
	}
	
	public String getLINK_NAME() {
		return LINK_NAME;
	}

	public void setLINK_NAME(String LINK_NAME) {
		this.LINK_NAME = LINK_NAME;
	}
	
	public String getLINK_MODE() {
		return LINK_MODE;
	}

	public void setLINK_MODE(String LINK_MODE) {
		this.LINK_MODE = LINK_MODE;
	}
	
	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String EMAIL) {
		this.EMAIL = EMAIL;
	}
	
	public String getIMAGE_PATH() {
		return IMAGE_PATH;
	}

	public void setIMAGE_PATH(String IMAGE_PATH) {
		this.IMAGE_PATH = IMAGE_PATH;
	}
	
	public String getSTAUS() {
		return STAUS;
	}

	public void setSTAUS(String STAUS) {
		this.STAUS = STAUS;
	}
	
	public String getAUDIT_ID() {
		return AUDIT_ID;
	}

	public void setAUDIT_ID(String AUDIT_ID) {
		this.AUDIT_ID = AUDIT_ID;
	}
	
	public String getAUDIT_TIME() {
		return AUDIT_TIME;
	}

	public void setAUDIT_TIME(String AUDIT_TIME) {
		this.AUDIT_TIME = AUDIT_TIME;
	}
	
	public String getREASON() {
		return REASON;
	}

	public void setREASON(String REASON) {
		this.REASON = REASON;
	}
	
	public String getREMARK() {
		return REMARK;
	}

	public void setREMARK(String REMARK) {
		this.REMARK = REMARK;
	}
	
	public String getCREATE_TIME() {
		return CREATE_TIME;
	}

	public void setCREATE_TIME(String CREATE_TIME) {
		this.CREATE_TIME = CREATE_TIME;
	}
	
	public String getMODIFY_TIME() {
		return MODIFY_TIME;
	}

	public void setMODIFY_TIME(String MODIFY_TIME) {
		this.MODIFY_TIME = MODIFY_TIME;
	}
	
}