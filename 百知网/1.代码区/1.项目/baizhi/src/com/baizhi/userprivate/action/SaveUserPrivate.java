package com.baizhi.userprivate.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
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
public class SaveUserPrivate extends UserPrivateForm{
	
	private static final long serialVersionUID = -6058917527983240740L;
	
	private UserPrivateService userPrivateService;//用户私信信息表业务类
	
	public UserPrivateService getUserPrivateService() {
		return userPrivateService;
	}

	public void setUserPrivateService(UserPrivateService userPrivateService) {
		this.userPrivateService = userPrivateService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果用户私信信息表ID为""，则为新增用户私信信息表，否则更新用户私信信息表
		if(StringUtils.isNotEmpty(this.getPRIVATE_ID())){
			element = userPrivateService.getUserPrivateEleById("PRIVATE_ID");
			Elements.setElementValue(element, "PRIVATE_ID", this.getPRIVATE_ID());// 私信ID
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 收件人ID
			Elements.setElementValue(element, "SEND_ID", this.getSEND_ID());// 发送人ID
			Elements.setElementValue(element, "CONTENT", this.getCONTENT());// 发送内容
			Elements.setElementValue(element, "IS_READ", this.getIS_READ());// 是否阅读(0否、1是)
			Elements.setElementValue(element, "PPRIVATE_ID", this.getPPRIVATE_ID());// 父私信ID（私信、与私信回复为一张表）
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			
			//如果保存成功，返回主键
			keyid = userPrivateService.saveOrUpdateUserPrivate(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("用户私信信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_USER_PRIVATE");
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 收件人ID
			Elements.setElementValue(element, "SEND_ID", this.getSEND_ID());// 发送人ID
			Elements.setElementValue(element, "CONTENT", this.getCONTENT());// 发送内容
			Elements.setElementValue(element, "IS_READ", this.getIS_READ());// 是否阅读(0否、1是)
			Elements.setElementValue(element, "PPRIVATE_ID", this.getPPRIVATE_ID());// 父私信ID（私信、与私信回复为一张表）
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			//如果保存成功，返回主键
			keyid = userPrivateService.saveOrUpdateUserPrivate(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
