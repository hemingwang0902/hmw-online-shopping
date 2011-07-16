package com.baizhi.index.action.hyym;

import java.util.List;
import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HyymService;

/**
 * 类名： GetUserBasicByUserId<br>
 * 描述：根据用户ID查询用户信息<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-7<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetUserBasicByUserId extends ActionSupport {
	private static final long serialVersionUID = 7879311708792543842L;
	private HyymService hyymService;
	private String userId;
	
	public void setHyymService(HyymService hyymService) {
		this.hyymService = hyymService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// 查询结果列表
		List<Map<String, Object>> returnList = (List<Map<String, Object>>) hyymService.getUserBasicByUserId(userId, getSessionUserId()).get(KEY_LIST);
		//判断是否存在查询记录
		if (returnList != null && returnList.size() != 0) {
			this.setResult(returnList.get(0));
		}
		return JSONSUCCESS;
	}
}
