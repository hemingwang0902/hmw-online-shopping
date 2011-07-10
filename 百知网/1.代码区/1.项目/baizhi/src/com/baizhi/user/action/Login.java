package com.baizhi.user.action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.ip.IPSeeker;
import com.baizhi.commons.support.Encrypt;
import com.baizhi.user.service.UserService;

/**
 * 
 * 类名：Login<br>
 * 描述：用户登录<br>
 * 创建者：江红 <br>
 * 创建日期： 2011-3-30<br>
 * 版本：V0.9 <br>
 * 修改者：        <br>
 * 修改日期：   <br>
 */
public class Login extends ActionSupport{
	
	private static final long serialVersionUID = -7476230007375981305L;
	
	private UserService userService;  
	
	private String username; //用户名
	
	private String userpwd;  //密码

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	@Override
	public String execute() throws Exception {
		if(username==null||username.trim().equals("")||userpwd==null||userpwd.trim().equals("")){
			return ERROR;
		}
		//获取IP地址
		HttpServletRequest request = ServletActionContext.getRequest();
		IPSeeker ipSeeker = IPSeeker.getInstance();
		String IP = ipSeeker.getRemoteAddr(request);
		
		//将密码设置成MD5加密
		userpwd=Encrypt.edcryptMD5(userpwd);
		//验证用户名密码是否正确
		Map<String, Object> data = userService.login(username, userpwd,IP);
		//判断登录是否正确
		if(data==null||data.get("USER_ID")==null||String.valueOf(data.get("USER_ID")).trim().equals("")){
			this.setMessage("用户名密码错误");
			return ERROR;
		}  
		
		//获取Session对象
		HttpSession session = request.getSession();
		//将值设置到Session对象中
		session.setAttribute("userinfo", data);
		session.setAttribute("USER_ID", data.get("USER_ID"));
		//判断用户类型，如果为普通用户则跳转到主页，否则跳转到后台管理页
		int USER_TYPE=Integer.valueOf(this.getValue(data, "USER_TYPE"));
		if(USER_TYPE>2){
			return SUCCESS;
		}else{
			return "index";
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Encrypt.edcryptMD5("111111"));
	}
}
