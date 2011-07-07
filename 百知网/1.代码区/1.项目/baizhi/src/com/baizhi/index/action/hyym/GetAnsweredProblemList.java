package com.baizhi.index.action.hyym;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HyymService;

/**
 * 类名： GetAnsweredProblemList<br>
 * 描述：获取回答的问题列表<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-7<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetAnsweredProblemList extends ActionSupport {
	private static final long serialVersionUID = -8738299162596523063L;

	private HyymService hyymService;
	private int userId;
	
	public void setHyymService(HyymService hyymService) {
		this.hyymService = hyymService;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String execute() throws Exception {
		// 查询结果列表
		Map<String, Object> returnMap = hyymService.getAnsweredProblemList(userId, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}
}
