package com.baizhi.talktype.action;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： TalktypeList.java<br>
 * 描述：  获取话题类型表列表信息
 * 创建者：江红
 * 创建日期： 2011-08-13 22:34:26
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class TalktypeForm extends ActionSupport {
	
	private static final long serialVersionUID = 928704362801687692L;
	
	private String TALKTYPE_ID;//话题类型ID
	private String TYPE_NAME;//类型名称
	private String REMARK;//备注
	private String CREATE_TIME;//创建时间
	private String MODIFY_TIME;//修改时间
	private String PICLOGO;//话题图片
	
	public String getTALKTYPE_ID() {
		return TALKTYPE_ID;
	}

	public void setTALKTYPE_ID(String TALKTYPE_ID) {
		this.TALKTYPE_ID = TALKTYPE_ID;
	}
	
	public String getTYPE_NAME() {
		return TYPE_NAME;
	}

	public void setTYPE_NAME(String TYPE_NAME) {
		this.TYPE_NAME = TYPE_NAME;
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

    public String getPICLOGO() {
		return PICLOGO;
	}

	public void setPICLOGO(String PICLOGO) {
		this.PICLOGO = PICLOGO;
	}
	
}