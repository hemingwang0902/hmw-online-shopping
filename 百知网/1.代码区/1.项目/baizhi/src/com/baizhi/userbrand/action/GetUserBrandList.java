package com.baizhi.userbrand.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.userbrand.service.UserBrandService;
/**
 * 类名： UserBrandList.java<br>
 * 描述：  获取用户品牌信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-07-10 13:09:53
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetUserBrandList extends UserBrandForm {
	
	private static final long serialVersionUID = -1644104947293829623L;
	
	private UserBrandService userBrandService;//用户品牌信息表业务类
	
	public UserBrandService getUserBrandService() {
		return userBrandService;
	}

	public void setUserBrandService(UserBrandService userBrandService) {
		this.userBrandService = userBrandService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "USER_ID=?", this.getSessionUserId());// 用户ID
		// 查询用户品牌信息表列表
		Map<String, Object> returnMap =new HashMap<String, Object>();
		List<Map<String, Object>> list = userBrandService.getUserBrandList(params);
		//判断是否存在查询记录
		if (list != null && list.size() > 0) {
			returnMap.put("list", list);
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}