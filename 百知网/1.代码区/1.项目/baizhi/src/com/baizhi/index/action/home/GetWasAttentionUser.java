package com.baizhi.index.action.home;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HomeService;

/**
 * 类名： GetWasAttentionUser<br>
 * 描述：关注他的人<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-6<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetWasAttentionUser extends ActionSupport {
	private static final long serialVersionUID = -6106804401390579226L;
	private HomeService homeService;
	private int userId;

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String execute() throws Exception {
		if(userId == 0){
			userId = getSessionUserId();
		} 
		// 查询结果列表
		Map<String, Object> returnMap = homeService.getWasAttentionUser(userId, getNowPage(), getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
