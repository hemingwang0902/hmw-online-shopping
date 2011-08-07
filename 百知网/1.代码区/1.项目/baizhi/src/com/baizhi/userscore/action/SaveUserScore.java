package com.baizhi.userscore.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.userscore.service.UserScoreService;
/**
 * 
 * 类名：UserScoreSave.java
 * 描述： 用户积分明细表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-08-07 20:03:25
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveUserScore extends UserScoreForm{
	
	private static final long serialVersionUID = -3821741695991723957L;
	
	private UserScoreService userScoreService;//用户积分明细表业务类
	
	public UserScoreService getUserScoreService() {
		return userScoreService;
	}

	public void setUserScoreService(UserScoreService userScoreService) {
		this.userScoreService = userScoreService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果用户积分明细表ID为""，则为新增用户积分明细表，否则更新用户积分明细表
		if(StringUtils.isNotEmpty(this.getSCORE_ID())){
			element = userScoreService.getUserScoreEleById("SCORE_ID");
			Elements.setElementValue(element, "SCORE_ID", this.getSCORE_ID());// 用户积分明细ID
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "BUSINESS_ID", this.getBUSINESS_ID());// 业务主键(提问题ID、回答ID)
			Elements.setElementValue(element, "BUSINESS_TYPE", this.getBUSINESS_TYPE());// 业务类型(字典：1、会员邀请朋友注册获得积分2、提问题3、回答问题)
			Elements.setElementValue(element, "SCORE", this.getSCORE());// 积分
			Elements.setElementValue(element, "DESCRIPTION", this.getDESCRIPTION());// 描述
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			
			//如果保存成功，返回主键
			keyid = userScoreService.saveOrUpdateUserScore(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("用户积分明细表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_USER_SCORE");
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "BUSINESS_ID", this.getBUSINESS_ID());// 业务主键(提问题ID、回答ID)
			Elements.setElementValue(element, "BUSINESS_TYPE", this.getBUSINESS_TYPE());// 业务类型(字典：1、会员邀请朋友注册获得积分2、提问题3、回答问题)
			Elements.setElementValue(element, "SCORE", this.getSCORE());// 积分
			Elements.setElementValue(element, "DESCRIPTION", this.getDESCRIPTION());// 描述
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			//如果保存成功，返回主键
			keyid = userScoreService.saveOrUpdateUserScore(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
