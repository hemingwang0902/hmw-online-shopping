package com.baizhi.userbrand.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userbrand.service.UserBrandService;

/**
 * 类名： AuditBrand.java<br>
 * 描述：<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-10 下午07:17:25<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AuditBrand  extends ActionSupport{
	
	private static final long serialVersionUID = 3580455372499196194L;

	private UserBrandService userBrandService;//用户品牌信息表业务类
	
	private String BRAND_IDS;//ID集合
	
	private String REASON;//原因
	
	private int TYPE;//类型 3同意,4不同意
	
	public UserBrandService getUserBrandService() {
		return userBrandService;
	}

	public void setUserBrandService(UserBrandService userBrandService) {
		this.userBrandService = userBrandService;
	}
	
	public String getBRAND_IDS() {
		return BRAND_IDS;
	}
	
	public void setBRAND_IDS(String brand_ids) {
		BRAND_IDS = brand_ids;
	}
	
	public String getREASON() {
		return REASON;
	}

	public void setREASON(String reason) {
		REASON = reason;
	}
	
	public int getTYPE() {
		return TYPE;
	}

	public void setTYPE(int type) {
		TYPE = type;
	}

	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(BRAND_IDS!=null&&!BRAND_IDS.trim().equals("")){
			//审核通过品牌
			boolean result = userBrandService.audit(BRAND_IDS,REASON,TYPE,this.getSessionUserId());
			//判断删除是否成功
			if(result){
				flag=true;
				message="操作成功";
			}else{
				message="操作失败";
			}
		}else{
			message="请选择要操作的品牌";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
}
