package com.baizhi.userbasic.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： UserBasicList.java<br>
 * 描述：  获取用户基本信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-23 22:03:15
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class UserBasicForm extends ActionSupport {
	
	private static final long serialVersionUID = 1031113856060105387L;
	
	private String BASIC_ID;//用户基本信息ID
	private String USER_ID;//用户ID
	private String USER_TYPE;//用户类型(字典：1用户、2品牌)冗余字段
	private String NAME;//姓名/品牌名称
	private String SOURCE;//发源地(品牌特有)
	private String PROVINCE;//所在地区(省：地区信息表ID)
	private String CITY;//所在地区(市：地区信息表ID)
	private String INDUSTRY;//从事行业(字典)
	private String YEARS;//所在年代(字典、用户特有)
	private String LINK_MODE;//联系方式
	private String IS_OPEN;//是否对外开放(0否、1是)
	private String INTRODUCTION;//个人介绍/品牌介绍
	private String MOTTO;//人生格言(用户特有)
	private String IMAGE_PATH;//相片路径/LOGO路径
	private String WEBSITE;//个性网址
	private String PRIVATE_SET;//私信设置(字典：1所有人、2我关注的人)
	private String LEVEL;//级别
	private String SCORE;//积分
	private String REMARK;//备注
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	
	public String getBASIC_ID() {
		return BASIC_ID;
	}

	public void setBASIC_ID(String BASIC_ID) {
		this.BASIC_ID = BASIC_ID;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getUSER_TYPE() {
		return USER_TYPE;
	}

	public void setUSER_TYPE(String USER_TYPE) {
		this.USER_TYPE = USER_TYPE;
	}
	
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
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
	
	public String getYEARS() {
		return YEARS;
	}

	public void setYEARS(String YEARS) {
		this.YEARS = YEARS;
	}
	
	public String getLINK_MODE() {
		return LINK_MODE;
	}

	public void setLINK_MODE(String LINK_MODE) {
		this.LINK_MODE = LINK_MODE;
	}
	
	public String getIS_OPEN() {
		return IS_OPEN;
	}

	public void setIS_OPEN(String IS_OPEN) {
		this.IS_OPEN = IS_OPEN;
	}
	
	public String getINTRODUCTION() {
		return INTRODUCTION;
	}

	public void setINTRODUCTION(String INTRODUCTION) {
		this.INTRODUCTION = INTRODUCTION;
	}
	
	public String getMOTTO() {
		return MOTTO;
	}

	public void setMOTTO(String MOTTO) {
		this.MOTTO = MOTTO;
	}
	
	public String getIMAGE_PATH() {
		return IMAGE_PATH;
	}

	public void setIMAGE_PATH(String IMAGE_PATH) {
		this.IMAGE_PATH = IMAGE_PATH;
	}
	
	public String getWEBSITE() {
		return WEBSITE;
	}

	public void setWEBSITE(String WEBSITE) {
		this.WEBSITE = WEBSITE;
	}
	
	public String getPRIVATE_SET() {
		return PRIVATE_SET;
	}

	public void setPRIVATE_SET(String PRIVATE_SET) {
		this.PRIVATE_SET = PRIVATE_SET;
	}
	
	public String getLEVEL() {
		return LEVEL;
	}

	public void setLEVEL(String LEVEL) {
		this.LEVEL = LEVEL;
	}
	
	public String getSCORE() {
		return SCORE;
	}

	public void setSCORE(String SCORE) {
		this.SCORE = SCORE;
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