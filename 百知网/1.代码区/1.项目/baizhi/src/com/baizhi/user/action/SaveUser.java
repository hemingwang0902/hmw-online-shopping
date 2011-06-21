package com.baizhi.user.action;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.user.service.UserService;

/**
 * 
 * 类名：SaveUser.java
 * 描述：新增或者修改用户信息表信息
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class SaveUser extends UserForm{

	private static final long serialVersionUID = -8075832185081472628L;
	
	private UserService  userService;//用户信息表业务类
	
	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		
		//如果用户ID为""，则为新增用户信息表，否则更新用户信息表
		if(StringUtils.isNotEmpty(this.getUSER_ID())){
			element = userService.getUserEleById("USER_ID");
			Elements.setElementValue(element, "PASSWORD", this.getPASSWORD());
			
			//如果保存成功，返回主键
			keyid = userService.saveOrUpdateUser(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("用户信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_USER");
			Elements.setElementValue(element, "USER_TYPE", this.getUSER_TYPE());
			Elements.setElementValue(element, "EMAIL", this.getEMAIL());
			Elements.setElementValue(element, "PASSWORD", this.getPASSWORD());
			Elements.setElementValue(element, "REG_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));
			Elements.setElementValue(element, "IP", this.getIP());
			Elements.setElementValue(element, "MAC", this.getMAC());
			//如果保存成功，返回主键
			keyid = userService.saveOrUpdateUser(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
	/**
	 * 获取IP地址
	 * @param request
	 * @return
	 */
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
}
