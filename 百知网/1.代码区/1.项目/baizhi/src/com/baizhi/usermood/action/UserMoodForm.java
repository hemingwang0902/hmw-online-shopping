package com.baizhi.usermood.action;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： UserMoodList.java<br>
 * 描述：  获取用户心情随记列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2012-02-19 15:00:28<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public abstract class UserMoodForm extends ActionSupport {
	
    private static final long serialVersionUID = -5901928628744489189L;
    private String id;//
	private String user_id;//用户ID
	private String descript;//心情随记的内容
	private String publish_time;//发表时间
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	public String getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}
	
}