package com.baizhi.index.action.home;

import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HomeService;

/**
 * 类名： GetMayInterestedUser<br>
 * 描述：获取可能感兴趣的用户（或品牌）列表<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-6<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetMayInterestedUser extends ActionSupport {
	private static final long serialVersionUID = 8706160028949988103L;
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
		Map<String, Object> returnMap = homeService.getMayInterestedUser(uid, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
