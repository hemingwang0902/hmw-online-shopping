package com.baizhi.userdynamic.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userdynamic.service.UserDynamicService;

/**
 * 类名：GetUserDynamicCount.java<br>
 * 描述：获取消息数量<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-16 下午03:56:40<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetUserDynamicCount  extends ActionSupport{
	
	private static final long serialVersionUID = -4703758284640669643L;
	
	private UserDynamicService userDynamicService;//用户动态信息表业务类
	
	private Integer IS_OPEN;
	
	public UserDynamicService getUserDynamicService() {
		return userDynamicService;
	}
	
	public void setUserDynamicService(UserDynamicService userDynamicService) {
		this.userDynamicService = userDynamicService;
	}
	
	public Integer getIS_OPEN() {
		return IS_OPEN;
	}

	public void setIS_OPEN(Integer is_open) {
		IS_OPEN = is_open;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("WARN_USERID=?", this.getSessionUserId());
		params.put("IS_OPEN=?", IS_OPEN);
		int count=userDynamicService.getUserDynamicCount(params);
		returnmap.put("count", count);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}

}
