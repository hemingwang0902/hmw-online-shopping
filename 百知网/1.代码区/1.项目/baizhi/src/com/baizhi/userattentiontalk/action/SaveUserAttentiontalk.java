package com.baizhi.userattentiontalk.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.userattentiontalk.service.UserAttentiontalkService;

/**
 * 类名：UserAttentiontalkSave.java<br>
 * 描述： 用户关注话题信息表控制类，负责处理新增、修改操作<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-16 14:04:18<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class SaveUserAttentiontalk extends UserAttentiontalkForm{

	private static final long serialVersionUID = 1874454371547148359L;
	private UserAttentiontalkService userAttentiontalkService;//用户关注话题信息表业务类
	
	public UserAttentiontalkService getUserAttentiontalkService() {
		return userAttentiontalkService;
	}

	public void setUserAttentiontalkService(UserAttentiontalkService userAttentiontalkService) {
		this.userAttentiontalkService = userAttentiontalkService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果用户关注话题信息表ID为""，则为新增用户关注话题信息表，否则更新用户关注话题信息表
		if(StringUtils.isNotEmpty(this.getATTENTIONTALK_ID())){
			element = userAttentiontalkService.getUserAttentiontalkEleById("ATTENTIONTALK_ID");
			Elements.setElementValue(element, "ATTENTIONTALK_ID", this.getATTENTIONTALK_ID());// 用户关注话题ID
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "TALK_ID", this.getTALK_ID());// 问题话题ID
			Elements.setElementValue(element, "IS_ATTENTION", this.getIS_ATTENTION());// 是否关注(0否、1是)
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			
			//如果保存成功，返回主键
			keyid = userAttentiontalkService.saveOrUpdateUserAttentiontalk(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("用户关注话题信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_USER_ATTENTIONTALK");
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "TALK_ID", this.getTALK_ID());// 问题话题ID
			Elements.setElementValue(element, "IS_ATTENTION", this.getIS_ATTENTION());// 是否关注(0否、1是)
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			//如果保存成功，返回主键
			keyid = userAttentiontalkService.saveOrUpdateUserAttentiontalk(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
