package com.baizhi.user.action;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.baizhi.commons.component.SendEmailUtils;
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
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setSendEmailUtils(SendEmailUtils sendEmailUtils) {
		this.sendEmailUtils = sendEmailUtils;
	}

	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		
		//如果用户ID为""，则为新增用户信息表，否则更新用户信息表
		if(StringUtils.isNotEmpty(this.getUSER_ID())){
			element = userService.getUserEleById("USER_ID");
			Elements.setElementValue(element, "PASSWORD",  Encrypt.edcryptMD5(this.getPASSWORD()));
			
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
			Elements.setElementValue(element, "PASSWORD",  Encrypt.edcryptMD5(this.getPASSWORD()));
			Elements.setElementValue(element, "REG_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));
			Elements.setElementValue(element, "IP", this.getIP());
			Elements.setElementValue(element, "MAC", this.getMAC());
			//如果保存成功，返回主键
			keyid = userService.saveOrUpdateUser(element);
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
