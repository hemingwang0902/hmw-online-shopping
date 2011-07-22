package com.baizhi.index.action.home;

import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

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
	private String userId;

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String execute() throws Exception {
		int uid = NumberUtils.toInt(userId, getSessionUserId());
		// 查询结果列表
		Map<String, Object> returnMap = homeService.getWasAttentionUser(uid, getNowPage(), getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
