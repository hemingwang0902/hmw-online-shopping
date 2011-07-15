package com.baizhi.user.action;

import java.util.HashMap;
import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Encrypt;
import com.baizhi.user.service.UserService;

/**
 * 类名： Password.java<br>
 * 描述：忘记密码修改密码<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-16 上午12:03:51<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class Password  extends ActionSupport{
	
	private static final long serialVersionUID = -4124117568407779883L;
	
	private UserService  userService;//用户信息表业务类
	
	private String EMAIL;
	
	private String PASSWORD;
	
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
	
	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String password) {
		PASSWORD = password;
	}
	
	public String getTIMEOUT() {
		return TIMEOUT;
	}

	public void setTIMEOUT(String timeout) {
		TIMEOUT = timeout;
	}

	@Override
	public String execute() throws Exception {
		int count=-1;
		boolean flag=true;
		
		//解密
		EMAIL=Encrypt.decodeBase64(EMAIL);
		TIMEOUT=Encrypt.decodeBase64(TIMEOUT);
		
		if(EMAIL==null&&TIMEOUT==null){
			this.setMessage("链接地址已经修改，密码修改失败");
			flag=false;
		}else if(TIMEOUT.length()!=14){
			this.setMessage("链接地址已经修改，密码修改失败");
			flag=false;
		}
		
		
		
		if(flag){
			//获取当前时间
			String curtime=DateUtils.getCurrentTime(DateUtils.DB_DATE_FORMAT);
			//获取分钟
			double minus = DateUtils.getMinusTimes(curtime, TIMEOUT, DateUtils.DB_DATE_FORMAT)*1.0/60.0;
			if(minus>10){
				this.setMessage("修改密码已经超进，请尝试再次修改");
				flag=false;
			}
		}
		
		if(flag){
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("a.EMAIL=?", EMAIL);
			
			int num=userService.getUserCount(params);
			if(num<=0){
				this.setMessage("链接地址已经修改，密码修改失败");
				flag=false;
			}
		}
		
		if(flag){
			//判断参数是否为空
			if(PASSWORD!=null&&!PASSWORD.trim().equals("")){
				count=userService.modifyPassword(EMAIL, Encrypt.edcryptMD5(PASSWORD));
				if(count<=0){
					this.setMessage("密码修改失败");
					flag=false;
				}
			}
		}
		
		if(flag){
			return SUCCESS;
		}
		return ERROR;
	}

}