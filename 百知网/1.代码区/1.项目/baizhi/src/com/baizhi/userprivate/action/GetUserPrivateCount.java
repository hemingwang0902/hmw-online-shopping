package com.baizhi.userprivate.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userprivate.service.UserPrivateService;

/**
 * 类名： GetUserPrivateCount.java<br>
 * 描述：获取私信数量<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-10 上午03:39:40<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetUserPrivateCount extends ActionSupport{
	
	private static final long serialVersionUID = -8344837662592438173L;
		
	private UserPrivateService userPrivateService;//用户私信信息表业务类
	
	public UserPrivateService getUserPrivateService() {
		return userPrivateService;
	}

	public void setUserPrivateService(UserPrivateService userPrivateService) {
		this.userPrivateService = userPrivateService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("USER_ID=?", this.getSessionUserId());
		int count=userPrivateService.getUserPrivateCount(params);
		returnmap.put("count", count);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}

}
