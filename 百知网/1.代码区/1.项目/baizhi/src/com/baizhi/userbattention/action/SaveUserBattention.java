package com.baizhi.userbattention.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.userbattention.service.UserBattentionService;

/**
 * 类名：UserBattentionSave.java<br>
 * 描述： 用户关注品牌信息表控制类，负责处理新增、修改操作<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:10<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class SaveUserBattention extends UserBattentionForm{
	
	private static final long serialVersionUID = -6873932848598548963L;
	private UserBattentionService userBattentionService;//用户关注品牌信息表业务类
	
	public UserBattentionService getUserBattentionService() {
		return userBattentionService;
	}

	public void setUserBattentionService(UserBattentionService userBattentionService) {
		this.userBattentionService = userBattentionService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果用户关注品牌信息表ID为""，则为新增用户关注品牌信息表，否则更新用户关注品牌信息表
		if(StringUtils.isNotEmpty(this.getBATTENTION_ID())){
			element = userBattentionService.getUserBattentionEleById("BATTENTION_ID");
			Elements.setElementValue(element, "BATTENTION_ID", this.getBATTENTION_ID());// 用户关注品牌ID
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "BRAND_ID", this.getBRAND_ID());// 被关注品牌
			Elements.setElementValue(element, "IS_ATTENTION", this.getIS_ATTENTION());// 是否关注(0否、1是)
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			
			//如果保存成功，返回主键
			keyid = userBattentionService.saveOrUpdateUserBattention(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("用户关注品牌信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_USER_BATTENTION");
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "BRAND_ID", this.getBRAND_ID());// 被关注品牌
			Elements.setElementValue(element, "IS_ATTENTION", this.getIS_ATTENTION());// 是否关注(0否、1是)
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			//如果保存成功，返回主键
			keyid = userBattentionService.saveOrUpdateUserBattention(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
