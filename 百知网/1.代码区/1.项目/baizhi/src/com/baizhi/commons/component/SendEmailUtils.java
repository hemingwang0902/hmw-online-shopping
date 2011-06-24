package com.baizhi.commons.component;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.baizhi.exception.BaizhiException;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * 类名： SendEmailUtils<br>
 * 描述：发送邮件的工具类<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-6-19<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class SendEmailUtils {
	private JavaMailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	private MimeMessageHelper mimeMessageHelper;
	private Configuration freeMarkerConfiguration;
	private String templateDirectory;

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public SimpleMailMessage getSimpleMailMessage() {
		return simpleMailMessage;
	}

	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public MimeMessageHelper getMimeMessageHelper() {
		return mimeMessageHelper;
	}

	public void setMimeMessageHelper(MimeMessageHelper mimeMessageHelper) {
		this.mimeMessageHelper = mimeMessageHelper;
	}

	public Configuration getFreeMarkerConfiguration() {
		return freeMarkerConfiguration;
	}

	public void setFreeMarkerConfiguration(Configuration freeMarkerConfiguration) {
		this.freeMarkerConfiguration = freeMarkerConfiguration;
	}

	public String getTemplateDirectory() {
		return templateDirectory;
	}

	public void setTemplateDirectory(String templateDirectory) {
		this.templateDirectory = templateDirectory;
	}

	/**
	 * 发送纯文本邮件
	 */
	public void sendSimpleMail() {
		mailSender.send(simpleMailMessage);
	}
	
	/**
	 * 发送富文本邮件
	 */
	public void sendMimeMail() {
		mailSender.send(mimeMessageHelper.getMimeMessage());
	}
	
	/**
	 * 发送模板邮件
	 * @param templateName 模板名称
	 * @param rootMap 模板中要替换的 key-value
	 */
	public void sendTemplateMail(String templateName, Map<String, Object> rootMap){
		StringWriter out = new StringWriter();
		try {
			File dir = new File(getClass().getClassLoader().getResource(templateDirectory).toURI());
			//按模板生成文件
			freeMarkerConfiguration.setDirectoryForTemplateLoading(dir);
			freeMarkerConfiguration.setObjectWrapper(new DefaultObjectWrapper());
			Template temp=freeMarkerConfiguration.getTemplate(templateName);
			temp.process(rootMap, out);
			mimeMessageHelper.setText(out.getBuffer().toString(), true);
		} catch (Exception e) {
			throw new BaizhiException(e);
		}finally{
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		mailSender.send(mimeMessageHelper.getMimeMessage());
	}

	  /**
	   * @param args
	 * @throws MessagingException 
	   */
	  public static void main(String[] args) throws MessagingException {
		  ApplicationContext context = new ClassPathXmlApplicationContext("spring/commons/ac-email.xml");
		  SendEmailUtils sender = (SendEmailUtils) context .getBean("sendEmailUtils");
		  /*
		  // 发送纯文本邮件
		  sender.sendSimpleMail();
		  */  
		  
		  /*
		  // 发送富文本邮件（带有附件）
		  MimeMessageHelper helper = sender.getMimeMessageHelper();
		  helper.setFrom("hemingwang0902@qq.com");
		  helper.setTo("532320690@qq.com");
		  helper.setText("此邮件是由系统自动发送，请勿回复！<br><img src='cid:pic_018'>", true);
		  helper.addInline("pic_018", new File("E:/temp/018.png"));
		  helper.addAttachment("log4j.properties", new ClassPathResource("log4j.properties"));
		  sender.sendMimeMail();
		  */
		  
		  // 发送模板邮件
		  Map<String, Object> rootMap = new HashMap<String, Object>();
		  rootMap.put("name", "江红");
		  rootMap.put("email", "jianghong0806@gmail.com");
		  rootMap.put("password", "123456");
		  MimeMessageHelper helper = sender.getMimeMessageHelper();
		  helper.setFrom("hemingwang0902@qq.com");
		  helper.setTo(new String[]{"532320690@qq.com", "331008019@qq.com"});
		  helper.setSubject("发送模板邮件测试");
		  sender.sendTemplateMail("AfterUserRegist.ftl", rootMap);
	  }
}
