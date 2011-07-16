package com.baizhi.user.action;

import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.mail.javamail.MimeMessageHelper;
import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.component.SendEmailUtils;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Encrypt;
import com.baizhi.user.service.UserService;

/**
 * 类名： Forget.java<br>
 * 描述：忘记密码<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-15 下午10:46:38<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class Forget extends ActionSupport{
	
	private static final long serialVersionUID = -7476230007375981305L;
	
	private UserService userService;  
	
	private SendEmailUtils  sendEmailUtils;
	
	private String EMAIL; //邮箱
	
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

	public SendEmailUtils getSendEmailUtils() {
		return sendEmailUtils;
	}

	public void setSendEmailUtils(SendEmailUtils sendEmailUtils) {
		this.sendEmailUtils = sendEmailUtils;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		boolean flag=true;
		if(EMAIL==null||EMAIL.trim().equals("")){
			flag=false;
		}
		if(flag){
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("a.EMAIL=?", EMAIL);
			
			int count=userService.getUserCount(params);
			if(count<=0){
				flag=false;
			}
			if(flag){
				
				//发送邮件
				sendEmail();
			}
		}
		returnMap.put("flag", flag);
		this.setResult(returnMap);
		return JSONSUCCESS;
	}
	
	public static void main(String[] args) {
		System.out.println(Encrypt.decodeBase64("YWFAcXEuY29t"));
		
		System.out.println(Encrypt.encodeBase64("aa@qq.com"));
	}
	
	private void sendEmail() {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		
		//链接地址,将地址加密
		HttpServletRequest request = ServletActionContext.getRequest();
		StringBuffer href=new StringBuffer();
		href.append("http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath())
			.append("/forgetPassword.go?EMAIL="+Encrypt.encodeBase64(EMAIL))
			.append("&TIMEOUT="+Encrypt.encodeBase64(DateUtils.getCurrentTime(DateUtils.DB_DATE_FORMAT)));
		
		rootMap.put("href", href);
		
		try {
			MimeMessageHelper helper = sendEmailUtils.getMimeMessageHelper();
			helper.setTo(this.getEMAIL());
			helper.setSubject("百知网");
			sendEmailUtils.sendTemplateMail("Forget.ftl", rootMap);
		} catch (MessagingException e) {
			log.error("发送注册通知邮件至" + this.getEMAIL() + "失败。", e);
		}
	}
}
