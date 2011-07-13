package com.baizhi.user.action;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.baizhi.commons.component.SendEmailUtils;
import com.baizhi.commons.ip.IPSeeker;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.Encrypt;
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
	private SendEmailUtils  sendEmailUtils;
	
	private String NAME;//姓名　
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setSendEmailUtils(SendEmailUtils sendEmailUtils) {
		this.sendEmailUtils = sendEmailUtils;
	}
	
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String name) {
		NAME = name;
	}

	@Override
	public String execute() throws Exception {
		//获取IP地址
		HttpServletRequest request = ServletActionContext.getRequest();
		IPSeeker ipSeeker = IPSeeker.getInstance();
		String IP = ipSeeker.getRemoteAddr(request);
		
		//如果用户ID为""，则为新增用户信息表，否则更新用户信息表
		if(StringUtils.isNotEmpty(this.getUSER_ID())){
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("USER_ID", this.getUSER_ID());
			params.put("PASSWORD", Encrypt.edcryptMD5(this.getPASSWORD()));
			params.put("NAME", NAME);
			//如果保存成功，返回主键
			boolean flag = userService.modifyUser(params);
			//判断主键是否为空，如果不为空，则保存成功
			if(flag){
				this.setMessage("用户信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			Element element = new DefaultElement("T_USER");
			Elements.setElementValue(element, "USER_TYPE", this.getUSER_TYPE());
			Elements.setElementValue(element, "EMAIL", this.getEMAIL());
			Elements.setElementValue(element, "PASSWORD",  Encrypt.edcryptMD5(this.getPASSWORD()));
			Elements.setElementValue(element, "REG_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));
			Elements.setElementValue(element, "IP", IP);
			Elements.setElementValue(element, "MAC", this.getMAC());
			
			Element basicelement = new DefaultElement("T_USER_BASIC");
			Elements.setElementValue(basicelement, "NAME", NAME);// 姓名/品牌名称
			Elements.setElementValue(basicelement, "USER_TYPE", this.getUSER_TYPE());
			
			//如果保存成功，返回主键
			String keyid = userService.saveUser(element,basicelement);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				// 发送邮件通知用户注册成功
				sendEmail();
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
	private void sendEmail() {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("name", "");
		rootMap.put("email", this.getEMAIL());
		rootMap.put("password", this.getPASSWORD());
		
		try {
			MimeMessageHelper helper = sendEmailUtils.getMimeMessageHelper();
			helper.setTo(this.getEMAIL());
			helper.setSubject("欢迎注册百知网");
			sendEmailUtils.sendTemplateMail("AfterUserRegist.ftl", rootMap);
		} catch (MessagingException e) {
			log.error("发送注册通知邮件至" + this.getEMAIL() + "失败。", e);
		}
	}
}
