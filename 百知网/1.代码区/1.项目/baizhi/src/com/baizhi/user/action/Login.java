package com.baizhi.user.action;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.IConstants;
import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.component.CookieUtils;
import com.baizhi.commons.ip.IPSeeker;
import com.baizhi.commons.support.Encrypt;
import com.baizhi.user.service.UserService;

/**
 * 类名：Login<br>
 * 描述：用户登录<br>
 * 创建者：江红 <br>
 * 创建日期： 2011-3-30<br>
 * 版本：V0.9 <br>
 * 修改者：       何明旺 <br>
 * 修改日期：  2011-07-21 <br>
 */
public class Login extends ActionSupport{
	
	private static final long serialVersionUID = -7476230007375981305L;
	
	private UserService userService;  
	
	private String username; //用户名
	private String userpwd;  //密码
	private String remenberMe;  //记住我
	private String redirect;  //转发的URL
	//是否是从Cookie中读取的用户名和密码（上次登录时勾选了“记住我”）
	private Boolean isCookie = false; 
	
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

	public String getRemenberMe() {
		return remenberMe;
	}

	public void setRemenberMe(String remenberMe) {
		this.remenberMe = remenberMe;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public Boolean getIsCookie() {
		return isCookie;
	}

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		// 用户名为空，检查 Cookie
		if(StringUtils.isBlank(username)){
			isCookie = checkCookie(request);
		}
		
		if(username==null||username.trim().equals("")||userpwd==null||userpwd.trim().equals("")){
			return ERROR;
		}
		
		//获取IP地址
		IPSeeker ipSeeker = IPSeeker.getInstance();
		String IP = ipSeeker.getRemoteAddr(request);
		
		//将密码设置成MD5加密
		if(!isCookie){
			userpwd=Encrypt.edcryptMD5(userpwd);
		}
	
		//验证用户名密码是否正确
		Map<String, Object> data = userService.login(username, userpwd,IP);
		//判断登录是否正确
		if(data==null||data.get("USER_ID")==null||String.valueOf(data.get("USER_ID")).trim().equals("")){
			this.setMessage("提示信息：用户名密码错误");
			return ERROR;
		}  
		
		data.put("CHANGE_TYPE", 2);
		Object USER_ID = data.get("USER_ID");
		
		//获取Session对象
		HttpSession session = request.getSession();
		//将值设置到Session对象中
		session.setAttribute(IConstants.SESSION_USERINFO, data);
		session.setAttribute(IConstants.SESSION_USER_ID, USER_ID);
		session.setAttribute(IConstants.SESSION_USER_ID_ENCODE, Encrypt.encodeBase64(""+USER_ID));
		//判断用户类型，如果为普通用户则跳转到主页，否则跳转到后台管理页
		int USER_TYPE=Integer.valueOf(this.getValue(data, "USER_TYPE"));
		
		//将用户名和密码保存至 Cookie
		if(BooleanUtils.toBoolean(remenberMe)){
			saveCookie(request, response);
		}
		
		if(StringUtils.isBlank(redirect)){
			if(USER_TYPE ==  IConstants.USER_TYPE_ADMIN){
				return SUCCESS;
			}else{
				return "index";
			}
		}else{
			return "blank";
		}
	}

	/**
	 * 检查 Cookie 中是否有记录用户的登录信息（曾经登录时勾选了“记住我”）
	 * @param request
	 * @return 如果Cookie中有记录用户登录的信息，则返回 true, 否则返回 false
	 */
	private boolean checkCookie(HttpServletRequest request){
		Cookie cookie = CookieUtils.getCookie(request, IConstants.COOKIE_REMEBER_ME);
		if(cookie != null){
			String[] nameAndPwd = Encrypt.decodeBase64(cookie.getValue()).split("\\|", 2);
			if(nameAndPwd.length == 2){
				username = nameAndPwd[0];
				userpwd = nameAndPwd[1]; //该密码是已经经过加密后的
				return true;
			}
		}
		return false;
	}
	
	public void saveCookie(HttpServletRequest request, HttpServletResponse response){
		Cookie cookie = CookieUtils.getCookie(request, IConstants.COOKIE_REMEBER_ME);
		String value = Encrypt.encodeBase64(username + "|" + userpwd);
		if(cookie == null){
			cookie = new Cookie(IConstants.COOKIE_REMEBER_ME, value);
		}else{
			cookie.setValue(value);
		}
		// 设置 cookie 的有效期为 60 天
		cookie.setMaxAge(Long.valueOf(DateUtils.MILLIS_PER_DAY * 60 / 1000).intValue());
		response.addCookie(cookie);
	}
}
