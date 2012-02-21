package com.baizhi.userprivate.action;

import org.apache.commons.lang.StringUtils;

import com.baizhi.commons.ActionSupport;
/**
 * 类名： UserPrivateList.java<br>
 * 描述：  获取用户私信信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-07-05 00:26:42
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public abstract class UserPrivateForm extends ActionSupport {
	
    public static final String FACE_REGEX = "\\[em:\\s*(\\d+)\\s*:\\]";
	private static final long serialVersionUID = 365585920828411117L;
	
	private String PRIVATE_ID;//私信ID
	private String USER_ID;//收件人ID
	private String SEND_ID;//发送人ID
	private String CONTENT;//发送内容
	private String IS_READ;//是否阅读(0否、1是)
	private String PPRIVATE_ID;//父私信ID（私信、与私信回复为一张表）
	private String CREATE_TIME;//创建时间
	
	public String getPRIVATE_ID() {
		return PRIVATE_ID;
	}

	public void setPRIVATE_ID(String PRIVATE_ID) {
		this.PRIVATE_ID = PRIVATE_ID;
	}
	
	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String USER_ID) {
		this.USER_ID = USER_ID;
	}
	
	public String getSEND_ID() {
		return SEND_ID;
	}

	public void setSEND_ID(String SEND_ID) {
		this.SEND_ID = SEND_ID;
	}
	
	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String CONTENT) {
		this.CONTENT = CONTENT;
	}
	
	public String getIS_READ() {
		return IS_READ;
	}

	public void setIS_READ(String IS_READ) {
		this.IS_READ = IS_READ;
	}
	
	public String getPPRIVATE_ID() {
		return PPRIVATE_ID;
	}

	public void setPPRIVATE_ID(String PPRIVATE_ID) {
		this.PPRIVATE_ID = PPRIVATE_ID;
	}
	
	public String getCREATE_TIME() {
		return CREATE_TIME;
	}

	public void setCREATE_TIME(String CREATE_TIME) {
		this.CREATE_TIME = CREATE_TIME;
	}
	
	/**
	 * 替换私信内容中的表情符号
	 * @param content 私信内容
	 * @return 替换过表情符号后的私信内容
	 */
    protected String replacePrivateFace(String content) {
        return StringUtils.trimToEmpty(content).replaceAll(FACE_REGEX,  "<img src='" + getContext_path() + "/images/face/$1.gif'/>");
    }
}