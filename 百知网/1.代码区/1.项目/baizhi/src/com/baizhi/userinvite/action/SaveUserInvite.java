package com.baizhi.userinvite.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.MessagingException;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import org.springframework.mail.javamail.MimeMessageHelper;
import com.baizhi.commons.component.SendEmailUtils;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.userinvite.service.UserInviteService;
/**
 * 
 * 类名：UserInviteSave.java
 * 描述： 用户邀请信息表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-06-23 22:20:22
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveUserInvite extends UserInviteForm{
	
	private static final long serialVersionUID = 7178009414609239506L;
	
	private UserInviteService userInviteService;//用户邀请信息表业务类
	
	private SendEmailUtils  sendEmailUtils;
	
	public void setSendEmailUtils(SendEmailUtils sendEmailUtils) {
		this.sendEmailUtils = sendEmailUtils;
	}
	
	public UserInviteService getUserInviteService() {
		return userInviteService;
	}

	public void setUserInviteService(UserInviteService userInviteService) {
		this.userInviteService = userInviteService;
	}
	
	@Override
	public String execute() throws Exception {
		boolean flag=false;
		if(this.getEMAIL()!=null&&!this.getEMAIL().trim().equals("")){
			List<Element> list=new ArrayList<Element>();
			String[] temp_email=this.getEMAIL().split(",");
			//验证邮箱是否正确
			boolean is_email=false;
			String error_email="";
			for (int i = 0; i < temp_email.length; i++) {
				is_email=getEmail(temp_email[i].trim());
				if(!is_email){
					error_email=temp_email[i].trim();
					break;
				}
			}
			if(!is_email){
				this.setMessage("提示:邮箱地址“"+error_email+"”错误，请输入正确的邮箱地址!");
				return ERROR;
			}
			
			//新增用户邀请信息表
			for (int i = 0; i < temp_email.length; i++) {
				if(temp_email[i]!=null&&!temp_email[i].trim().equals("")){
					list.add(this.getElement(temp_email[i]));
				}
			}
			
			for (int i = 0; i < temp_email.length; i++) {
				sendEmail(temp_email[i]);
			}
			//如果保存成功，返回主键
			flag = userInviteService.saveUserInvite(list);
			//判断主键是否为空，如果不为空，则保存成功
			if(flag){
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
	/**
	 * 实体
	 * @param EMAIL
	 * @return
	 */
	public Element getElement(String EMAIL){
		Element element = null;
		element = new DefaultElement("T_USER_INVITE");
		Elements.setElementValue(element, "USER_ID", this.getSessionUserId());// 用户ID
		Elements.setElementValue(element, "IS_SUCCESS",0);// 是否邀请成功(0否、1是)
		Elements.setElementValue(element, "EMAIL", EMAIL);// 邀请Email
		Elements.setElementValue(element, "INVITE_TIME",DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 邀请时间
		return element;
	}
	
	/**
	 * 验证邮箱是否正确
	 * @param email
	 * @return
	 */
	private boolean getEmail(String email) {
		Pattern p = Pattern
				.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher m = p.matcher(email);
		return m.find();
	}
	
	private void sendEmail(String email) {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("name", "");
		rootMap.put("email", "");
		rootMap.put("password","");
		
		try {
			MimeMessageHelper helper = sendEmailUtils.getMimeMessageHelper();
			helper.setTo(this.getEMAIL());
			helper.setSubject("邀请您加入百知网");
			sendEmailUtils.sendTemplateMail("AfterUserRegist.ftl", rootMap);
		} catch (MessagingException e) {
			log.error("发送注册通知邮件至" + this.getEMAIL() + "失败。", e);
		}
	}

}
