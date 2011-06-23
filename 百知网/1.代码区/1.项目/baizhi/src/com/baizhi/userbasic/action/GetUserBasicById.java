package com.baizhi.userbasic.action;

import java.util.Map;
import com.baizhi.userbasic.service.UserBasicService;
/**
 * 
 * 类名：GetUserBasicById.java
 * 描述： 获取单条用户基本信息表表单信息
 * 创建者：江红
 * 创建日期： 2011-06-23 22:03:15
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetUserBasicById extends UserBasicForm{
	
	private static final long serialVersionUID = 700180542524615237L;
	
	private UserBasicService userBasicService;//用户基本信息表业务类
	
	public UserBasicService getUserBasicService() {
		return userBasicService;
	}

	public void setUserBasicService(UserBasicService userBasicService) {
		this.userBasicService = userBasicService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = userBasicService.getUserBasicMapById(this.getBASIC_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setUSER_TYPE(this.getValue(returnMap,"USER_TYPE"));// 用户类型(字典：1用户、2品牌)冗余字段
			this.setNAME(this.getValue(returnMap,"NAME"));// 姓名/品牌名称
			this.setSOURCE(this.getValue(returnMap,"SOURCE"));// 发源地(品牌特有)
			this.setPROVINCE(this.getValue(returnMap,"PROVINCE"));// 所在地区(省：地区信息表ID)
			this.setCITY(this.getValue(returnMap,"CITY"));// 所在地区(市：地区信息表ID)
			this.setINDUSTRY(this.getValue(returnMap,"INDUSTRY"));// 从事行业(字典)
			this.setYEARS(this.getValue(returnMap,"YEARS"));// 所在年代(字典、用户特有)
			this.setLINK_MODE(this.getValue(returnMap,"LINK_MODE"));// 联系方式
			this.setIS_OPEN(this.getValue(returnMap,"IS_OPEN"));// 是否对外开放(0否、1是)
			this.setINTRODUCTION(this.getValue(returnMap,"INTRODUCTION"));// 个人介绍/品牌介绍
			this.setMOTTO(this.getValue(returnMap,"MOTTO"));// 人生格言(用户特有)
			this.setIMAGE_PATH(this.getValue(returnMap,"IMAGE_PATH"));// 相片路径/LOGO路径
			this.setWEBSITE(this.getValue(returnMap,"WEBSITE"));// 个性网址
			this.setPRIVATE_SET(this.getValue(returnMap,"PRIVATE_SET"));// 私信设置(字典：1所有人、2我关注的人)
			this.setLEVEL(this.getValue(returnMap,"LEVEL"));// 级别
			this.setSCORE(this.getValue(returnMap,"SCORE"));// 积分
			this.setREMARK(this.getValue(returnMap,"REMARK"));// 备注
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
