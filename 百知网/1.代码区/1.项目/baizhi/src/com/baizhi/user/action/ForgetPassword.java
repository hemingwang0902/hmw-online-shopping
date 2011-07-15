package com.baizhi.user.action;

import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Encrypt;
import com.baizhi.user.service.UserService;

/**
 * 类名： ForgetPassword.java<br>
 * 描述：<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-15 下午11:45:39<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class ForgetPassword  extends ActionSupport{
	
	private static final long serialVersionUID = 2497317014134212571L;

	private UserService userService;
	
	private String EMAIL; //邮箱
	
	private String TIMEOUT;//时间
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String email) {
		EMAIL = email;
	}
	
	public String getTIMEOUT() {
		return TIMEOUT;
	}

	public void setTIMEOUT(String timeout) {
		TIMEOUT = timeout;
	}

	@Override
	public String execute() throws Exception {
		if(EMAIL==null&&TIMEOUT==null){
			this.setMessage("链接地址已经修改，密码修改失败");
			return ERROR;
		}
		//解密
		EMAIL=Encrypt.decodeBase64(EMAIL);
		TIMEOUT=Encrypt.decodeBase64(TIMEOUT);
		if(TIMEOUT.length()!=14){
			this.setMessage("链接地址已经修改，密码修改失败");
			return ERROR;
		}
		
		//获取当前时间
		String curtime=DateUtils.getCurrentTime(DateUtils.DB_DATE_FORMAT);
		//获取分钟
		double minus = DateUtils.getMinusTimes(curtime, TIMEOUT, DateUtils.DB_DATE_FORMAT)*1.0/60.0;
		if(minus>10){
			this.setMessage("修改密码已经超进，请尝试再次修改");
			return ERROR;
		}
		
		return SUCCESS;
	}
}
