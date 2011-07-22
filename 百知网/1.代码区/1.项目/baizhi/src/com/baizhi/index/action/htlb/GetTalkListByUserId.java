package com.baizhi.index.action.htlb;

import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HtlbService;

/**
 * 类名： GetTalkListByUserId<br>
 * 描述：根据用户ID查询用户关注的话题<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-22<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetTalkListByUserId  extends ActionSupport{
	private static final long serialVersionUID = 2964162796983620496L;

	private HtlbService htlbService;
	
	private String userId;

	public void setHtlbService(HtlbService htlbService) {
		this.htlbService = htlbService;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String execute() throws Exception {
		int uid = NumberUtils.toInt(userId);
		if(uid > 0){
			// 查询结果列表
			Map<String, Object> returnMap = htlbService.GetTalkListByUserId(uid, getSessionUserId(), getNowPage(), getOnePageCount());
			setResult(returnMap);
		}
		return JSONSUCCESS;
	}
}
