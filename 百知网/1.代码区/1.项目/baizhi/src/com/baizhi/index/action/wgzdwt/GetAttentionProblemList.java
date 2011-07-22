package com.baizhi.index.action.wgzdwt;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.WgzdwtService;

/**
 * 类名： GetAllProblemList<br>
 * 描述：获取所有问题列表<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-6<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetAttentionProblemList extends ActionSupport {
	private static final long serialVersionUID = -6640146567721850692L;
	private WgzdwtService wgzdwtService;

	public void setWgzdwtService(WgzdwtService wgzdwtService) {
		this.wgzdwtService = wgzdwtService;
	}

	@Override
	public String execute() throws Exception {
		// 查询结果列表
		Map<String, Object> returnMap = wgzdwtService.getAttentionProblemList(getSessionUserId(), this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
