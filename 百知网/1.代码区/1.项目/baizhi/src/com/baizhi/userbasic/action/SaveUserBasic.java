package com.baizhi.userbasic.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.userbasic.service.UserBasicService;
/**
 * 
 * 类名：UserBasicSave.java
 * 描述： 用户基本信息表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-06-23 22:03:15
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveUserBasic extends UserBasicForm{
	
	private static final long serialVersionUID = 6725872963430790761L;
	
	private UserBasicService userBasicService;//用户基本信息表业务类
	
	public UserBasicService getUserBasicService() {
		return userBasicService;
	}

	public void setUserBasicService(UserBasicService userBasicService) {
		this.userBasicService = userBasicService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果用户基本信息表ID为""，则为新增用户基本信息表，否则更新用户基本信息表
		if(StringUtils.isNotEmpty(this.getBASIC_ID())){
			element = userBasicService.getUserBasicEleById("BASIC_ID");
			Elements.setElementValue(element, "BASIC_ID", this.getBASIC_ID());// 用户基本信息ID
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "USER_TYPE", this.getUSER_TYPE());// 用户类型(字典：1用户、2品牌)冗余字段
			Elements.setElementValue(element, "NAME", this.getNAME());// 姓名/品牌名称
			Elements.setElementValue(element, "SOURCE", this.getSOURCE());// 发源地(品牌特有)
			Elements.setElementValue(element, "PROVINCE", this.getPROVINCE());// 所在地区(省：地区信息表ID)
			Elements.setElementValue(element, "CITY", this.getCITY());// 所在地区(市：地区信息表ID)
			Elements.setElementValue(element, "INDUSTRY", this.getINDUSTRY());// 从事行业(字典)
			Elements.setElementValue(element, "YEARS", this.getYEARS());// 所在年代(字典、用户特有)
			Elements.setElementValue(element, "LINK_MODE", this.getLINK_MODE());// 联系方式
			Elements.setElementValue(element, "IS_OPEN", this.getIS_OPEN());// 是否对外开放(0否、1是)
			Elements.setElementValue(element, "INTRODUCTION", this.getINTRODUCTION());// 个人介绍/品牌介绍
			Elements.setElementValue(element, "MOTTO", this.getMOTTO());// 人生格言(用户特有)
			Elements.setElementValue(element, "IMAGE_PATH", this.getIMAGE_PATH());// 相片路径/LOGO路径
			Elements.setElementValue(element, "WEBSITE", this.getWEBSITE());// 个性网址
			Elements.setElementValue(element, "PRIVATE_SET", this.getPRIVATE_SET());// 私信设置(字典：1所有人、2我关注的人)
			Elements.setElementValue(element, "LEVEL", this.getLEVEL());// 级别
			Elements.setElementValue(element, "SCORE", this.getSCORE());// 积分
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			
			//如果保存成功，返回主键
			keyid = userBasicService.saveOrUpdateUserBasic(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("用户基本信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_USER_BASIC");
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "USER_TYPE", this.getUSER_TYPE());// 用户类型(字典：1用户、2品牌)冗余字段
			Elements.setElementValue(element, "NAME", this.getNAME());// 姓名/品牌名称
			Elements.setElementValue(element, "SOURCE", this.getSOURCE());// 发源地(品牌特有)
			Elements.setElementValue(element, "PROVINCE", this.getPROVINCE());// 所在地区(省：地区信息表ID)
			Elements.setElementValue(element, "CITY", this.getCITY());// 所在地区(市：地区信息表ID)
			Elements.setElementValue(element, "INDUSTRY", this.getINDUSTRY());// 从事行业(字典)
			Elements.setElementValue(element, "YEARS", this.getYEARS());// 所在年代(字典、用户特有)
			Elements.setElementValue(element, "LINK_MODE", this.getLINK_MODE());// 联系方式
			Elements.setElementValue(element, "IS_OPEN", this.getIS_OPEN());// 是否对外开放(0否、1是)
			Elements.setElementValue(element, "INTRODUCTION", this.getINTRODUCTION());// 个人介绍/品牌介绍
			Elements.setElementValue(element, "MOTTO", this.getMOTTO());// 人生格言(用户特有)
			Elements.setElementValue(element, "IMAGE_PATH", this.getIMAGE_PATH());// 相片路径/LOGO路径
			Elements.setElementValue(element, "WEBSITE", this.getWEBSITE());// 个性网址
			Elements.setElementValue(element, "PRIVATE_SET", this.getPRIVATE_SET());// 私信设置(字典：1所有人、2我关注的人)
			Elements.setElementValue(element, "LEVEL", this.getLEVEL());// 级别
			Elements.setElementValue(element, "SCORE", this.getSCORE());// 积分
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			//如果保存成功，返回主键
			keyid = userBasicService.saveOrUpdateUserBasic(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
