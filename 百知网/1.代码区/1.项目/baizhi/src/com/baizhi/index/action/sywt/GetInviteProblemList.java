package com.baizhi.index.action.sywt;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.SywtService;

/**
 * 类名： GetAllProblemList<br>
 * 描述：获取邀请我回答的问题列表<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-6<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetInviteProblemList extends ActionSupport {

	private static final long serialVersionUID = -3487129607730214473L;
	private SywtService sywtService;

	public void setSywtService(SywtService sywtService) {
		this.sywtService = sywtService;
	}

	@Override
	public String execute() throws Exception {
		// 查询结果列表
		Map<String, Object> returnMap = sywtService.getInviteProblemList(getSessionUserId(), getSessionUserId(), this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
