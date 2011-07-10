package com.baizhi.userbrand.action;

import java.util.Map;
import com.baizhi.userbrand.service.UserBrandService;
/**
 * 
 * 类名：GetUserBrandById.java
 * 描述： 获取单条用户品牌信息表表单信息
 * 创建者：江红
 * 创建日期： 2011-07-10 13:09:53
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetUserBrandById extends UserBrandForm{
	
	private static final long serialVersionUID = 5949328438682579931L;
	
	private UserBrandService userBrandService;//用户品牌信息表业务类
	
	public UserBrandService getUserBrandService() {
		return userBrandService;
	}

	public void setUserBrandService(UserBrandService userBrandService) {
		this.userBrandService = userBrandService;
	}
	
	private String STAUS_NAME;
	
	public String getSTAUS_NAME() {
		return STAUS_NAME;
	}

	public void setSTAUS_NAME(String staus_name) {
		STAUS_NAME = staus_name;
	}

	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = userBrandService.getUserBrandMapById(this.getBRAND_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setNAME(this.getValue(returnMap,"NAME"));// 品牌名称
			this.setINTRODUCTION(this.getValue(returnMap,"INTRODUCTION"));// 品牌介绍
			this.setSOURCE(this.getValue(returnMap,"SOURCE"));// 发源地(品牌特有)
			this.setPROVINCE(this.getValue(returnMap,"PROVINCE"));// 所在地区(省：地区信息表ID)
			this.setCITY(this.getValue(returnMap,"CITY"));// 所在地区(市：地区信息表ID)
			this.setINDUSTRY(this.getValue(returnMap,"INDUSTRY"));// 从事行业(字典)
			this.setLINK_NAME(this.getValue(returnMap,"LINK_NAME"));// 联系人姓名
			this.setLINK_MODE(this.getValue(returnMap,"LINK_MODE"));// 联系方式
			this.setEMAIL(this.getValue(returnMap,"EMAIL"));// 电子邮箱
			this.setIMAGE_PATH(this.getContext_path()+this.getValue(returnMap,"IMAGE_PATH"));// 相片路径/LOGO路径
			String STAUS=this.getValue(returnMap,"STAUS");
			
			if(STAUS.equals("4")){
				STAUS_NAME="审核未通过";
				this.setREASON("审核不通过原因："+this.getValue(returnMap,"REASON"));// 不通过原因
			}else if(STAUS.equals("3")){
				STAUS_NAME="审核通过";
			}else if(STAUS.equals("2")){
				STAUS_NAME="正在审核中";
			}else{
				STAUS_NAME="未提交审核";
			}
			
			this.setSTAUS(STAUS);// 状态(1：未申请、2：申请、3：通过、4：未通过)
			this.setAUDIT_ID(this.getValue(returnMap,"AUDIT_ID"));// 审核人
			this.setAUDIT_TIME(this.getValue(returnMap,"AUDIT_TIME"));// 审核时间
			
			this.setREMARK(this.getValue(returnMap,"REMARK"));// 备注
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
			this.setBRAND_LABEL(this.getValue(returnMap,"BRAND_LABEL"));
			
			
		}
		return SUCCESS;
	}
	
}
