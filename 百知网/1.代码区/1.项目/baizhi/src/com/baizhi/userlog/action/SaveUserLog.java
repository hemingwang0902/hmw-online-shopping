package com.baizhi.userlog.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.userlog.service.UserLogService;
/**
 * 
 * 类名：UserLogSave.java
 * 描述： 用户日志表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-06-24 21:28:32
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveUserLog extends UserLogForm{
	
	private static final long serialVersionUID = 683413680264341634L;
	
	private UserLogService userLogService;//用户日志表业务类
	
	public UserLogService getUserLogService() {
		return userLogService;
	}

	public void setUserLogService(UserLogService userLogService) {
		this.userLogService = userLogService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果用户日志表ID为""，则为新增用户日志表，否则更新用户日志表
		if(StringUtils.isNotEmpty(this.getLOG_ID())){
			element = userLogService.getUserLogEleById("LOG_ID");
			Elements.setElementValue(element, "LOG_ID", this.getLOG_ID());// 用户日志ID
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "LOGIN_TIME", this.getLOGIN_TIME());// 登录时间
			Elements.setElementValue(element, "IP", this.getIP());// IP
			Elements.setElementValue(element, "MAC", this.getMAC());// MAC
			
			//如果保存成功，返回主键
			keyid = userLogService.saveOrUpdateUserLog(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("用户日志表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_USER_LOG");
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "LOGIN_TIME", this.getLOGIN_TIME());// 登录时间
			Elements.setElementValue(element, "IP", this.getIP());// IP
			Elements.setElementValue(element, "MAC", this.getMAC());// MAC
			//如果保存成功，返回主键
			keyid = userLogService.saveOrUpdateUserLog(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
