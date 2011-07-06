package com.baizhi.userdynamic.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.userdynamic.service.UserDynamicService;
/**
 * 类名： UserDynamicList.java<br>
 * 描述：  获取用户动态信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-07-05 00:34:20
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetUserDynamicList extends UserDynamicForm {
	
	private static final long serialVersionUID = -9172165657120391794L;
	
	private UserDynamicService userDynamicService;//用户动态信息表业务类
	
	public UserDynamicService getUserDynamicService() {
		return userDynamicService;
	}

	public void setUserDynamicService(UserDynamicService userDynamicService) {
		this.userDynamicService = userDynamicService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		params.put("CUR_USER_ID", this.getSessionUserId());
		
		// 查询用户动态信息表列表
		Map<String, Object> returnMap = userDynamicService.getUserDynamicList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}