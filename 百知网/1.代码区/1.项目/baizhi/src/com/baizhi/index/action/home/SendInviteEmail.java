package com.baizhi.index.action.home;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.mail.javamail.MimeMessageHelper;

import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.component.SendEmailUtils;

public class SendInviteEmail extends ActionSupport{
	private static final long serialVersionUID = -6422467270830467465L;
	private SendEmailUtils  sendEmailUtils;
	private String email;
	private String url;

	public void setSendEmailUtils(SendEmailUtils sendEmailUtils) {
		this.sendEmailUtils = sendEmailUtils;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("userName", getSessionUserName());
		rootMap.put("url", getUrl());
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			MimeMessageHelper helper = sendEmailUtils.getMimeMessageHelper();
			helper.setTo(this.getEmail());
			helper.setSubject(getSessionUserName() + "邀请您加入百知网");
			sendEmailUtils.sendTemplateMail("InviteUserRegist.ftl", rootMap);
			resultMap.put("success", "true");
		} catch (MessagingException e) {
			log.error("发送注册通知邮件至" + this.getEmail() + "失败。", e);
			resultMap.put("success", "false");
		}
		this.setResult(resultMap);
		return JSONSUCCESS;
	}
}
