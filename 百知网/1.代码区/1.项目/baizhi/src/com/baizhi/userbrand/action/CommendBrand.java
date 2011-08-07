package com.baizhi.userbrand.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userbrand.service.UserBrandService;

/**
 * 类名： AuditBrand.java<br>
 * 描述：推荐品牌<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-10 下午07:17:25<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class CommendBrand  extends ActionSupport{
	
	private static final long serialVersionUID = 5982110470943679246L;

	private UserBrandService userBrandService;//用户品牌信息表业务类
	
	private Integer BRAND_ID;//品牌ID
	
	
	private int IS_COMMEND;//是否推荐 0:否、1:是
	
	public UserBrandService getUserBrandService() {
		return userBrandService;
	}

	public void setUserBrandService(UserBrandService userBrandService) {
		this.userBrandService = userBrandService;
	}
	
	
	public Integer getBRAND_ID() {
		return BRAND_ID;
	}

	public void setBRAND_ID(Integer brand_id) {
		BRAND_ID = brand_id;
	}

	public int getIS_COMMEND() {
		return IS_COMMEND;
	}

	public void setIS_COMMEND(int is_commend) {
		IS_COMMEND = is_commend;
	}

	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(BRAND_ID>0){
			//审核通过品牌
			boolean result = userBrandService.modifyCommend(BRAND_ID, IS_COMMEND);
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
