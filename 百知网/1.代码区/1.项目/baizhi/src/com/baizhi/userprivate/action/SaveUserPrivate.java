package com.baizhi.userprivate.action;

import java.util.HashMap;
import java.util.Map;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.userprivate.service.UserPrivateService;
/**
 * 
 * 类名：UserPrivateSave.java
 * 描述： 用户私信信息表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-07-05 00:26:42
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveUserPrivate extends ActionSupport{
	
	private static final long serialVersionUID = -6058917527983240740L;
	
	private UserPrivateService userPrivateService;//用户私信信息表业务类
	
	public UserPrivateService getUserPrivateService() {
		return userPrivateService;
	}

	public void setUserPrivateService(UserPrivateService userPrivateService) {
		this.userPrivateService = userPrivateService;
	}
	
	private String USER_ID;
	
	private String CONTENT;
	
	public void setUSER_ID(String user_ids) {
		USER_ID = user_ids;
	}
	
	public void setCONTENT(String content) {
		CONTENT = content;
	}

	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		Element element1 = new DefaultElement("T_USER_PRIVATE");
		//
		Elements.setElementValue(element1, "USER_ID", USER_ID);// 收件人ID
		Elements.setElementValue(element1, "SEND_ID", this.getSessionUserId());// 发送人ID
		Elements.setElementValue(element1, "CONTENT", CONTENT);// 发送内容
		Elements.setElementValue(element1, "IS_READ", 0);// 是否阅读(0否、1是)
		Elements.setElementValue(element1, "PPRIVATE_ID", 0);// 父私信ID（私信、与私信回复为一张表）
		Elements.setElementValue(element1, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		Elements.setElementValue(element1, "SHOW_CONDITION", 1);// 显示条件
		Elements.setElementValue(element1, "IS_MYSELF", 1);// 主动
		
		Element element2 = new DefaultElement("T_USER_PRIVATE");
		Elements.setElementValue(element2, "USER_ID", this.getSessionUserId());// 收件人ID
		Elements.setElementValue(element2, "SEND_ID", USER_ID);// 发送人ID
		Elements.setElementValue(element2, "CONTENT", CONTENT);// 发送内容
		Elements.setElementValue(element2, "IS_READ", 1);// 是否阅读(0否、1是)
		Elements.setElementValue(element2, "PPRIVATE_ID", 0);// 父私信ID（私信、与私信回复为一张表）
		Elements.setElementValue(element2, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		Elements.setElementValue(element2, "SHOW_CONDITION", 1);// 显示条件
		Elements.setElementValue(element2, "IS_MYSELF", 0);// 被动
		
		flag = userPrivateService.saveUserPrivate(element1,element2);
		//判断主键是否为空，如果不为空，则保存成功
		if(flag){
			message="私信发送成功";
		}else{
			message="私信发送失败";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
}
