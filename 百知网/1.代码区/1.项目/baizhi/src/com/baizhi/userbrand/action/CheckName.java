package com.baizhi.userbrand.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.userbrand.service.UserBrandService;

/**
 * 类名： CheckName.java<br>
 * 描述：<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-10 下午03:52:25<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class CheckName  extends UserBrandForm{
	
	private static final long serialVersionUID = -4484646216266396424L;
	
	private UserBrandService userBrandService;//用户品牌信息表业务类
	
	public UserBrandService getUserBrandService() {
		return userBrandService;
	}

	public void setUserBrandService(UserBrandService userBrandService) {
		this.userBrandService = userBrandService;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		//设置参数
		Map<String, Object> params = new HashMap<String, Object>();
		
		this.setMap(params, "NAME=?", this.getNAME());//品牌名称
		this.setMap(params, "BRAND_ID<>?", this.getBRAND_ID());//品牌名称
		
		int count=userBrandService.getUserBrandCount(params);
		if(count>0){
			returnMap.put("flag", false);
			returnMap.put("message", "品牌名称不能重复,请重新输入");
		}else{
			returnMap.put("flag", true);
		}
		this.setResult(returnMap);
		return JSONSUCCESS;
	}
}
