package com.baizhi.userdynamic.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.userdynamic.service.UserDynamicService;
/**
 * 
 * 类名：UserDynamicSave.java
 * 描述： 用户动态信息表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-07-05 00:34:20
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveUserDynamic extends UserDynamicForm{
	
	private static final long serialVersionUID = 1636564380638352155L;
	private UserDynamicService userDynamicService;//用户动态信息表业务类
	
	public UserDynamicService getUserDynamicService() {
		return userDynamicService;
	}

	public void setUserDynamicService(UserDynamicService userDynamicService) {
		this.userDynamicService = userDynamicService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果用户动态信息表ID为""，则为新增用户动态信息表，否则更新用户动态信息表
		if(StringUtils.isNotEmpty(this.getDYNAMIC_ID())){
			element = userDynamicService.getUserDynamicEleById("DYNAMIC_ID");
			Elements.setElementValue(element, "DYNAMIC_ID", this.getDYNAMIC_ID());// 用户动态ID
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "TITLE", this.getTITLE());// 动态主题
			Elements.setElementValue(element, "BUSINESS_ID", this.getBUSINESS_ID());// 业务主键(回复问题ID、关注会员ID)
			Elements.setElementValue(element, "DYNAMIC_TYPE", this.getDYNAMIC_TYPE());// 动态类型(字典：1回答问题、2关注会员)
			Elements.setElementValue(element, "CONTENT", this.getCONTENT());// 动态内容(存放组织好的html内容)
			Elements.setElementValue(element, "WARN_USERID", this.getWARN_USERID());// 提醒用户ID
			Elements.setElementValue(element, "IS_OPEN", this.getIS_OPEN());// 是否查看(0否、1是)
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			
			//如果保存成功，返回主键
			keyid = userDynamicService.saveOrUpdateUserDynamic(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("用户动态信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_USER_DYNAMIC");
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "TITLE", this.getTITLE());// 动态主题
			Elements.setElementValue(element, "BUSINESS_ID", this.getBUSINESS_ID());// 业务主键(回复问题ID、关注会员ID)
			Elements.setElementValue(element, "DYNAMIC_TYPE", this.getDYNAMIC_TYPE());// 动态类型(字典：1回答问题、2关注会员)
			Elements.setElementValue(element, "CONTENT", this.getCONTENT());// 动态内容(存放组织好的html内容)
			Elements.setElementValue(element, "WARN_USERID", this.getWARN_USERID());// 提醒用户ID
			Elements.setElementValue(element, "IS_OPEN", this.getIS_OPEN());// 是否查看(0否、1是)
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			//如果保存成功，返回主键
			keyid = userDynamicService.saveOrUpdateUserDynamic(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
