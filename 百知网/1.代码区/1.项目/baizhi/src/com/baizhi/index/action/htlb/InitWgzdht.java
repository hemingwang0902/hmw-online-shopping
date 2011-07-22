package com.baizhi.index.action.htlb;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HtlbService;

/**
 * 类名： InitWgzdht<br>
 * 描述：进入“他关注的会员”列表页<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-22<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class InitWgzdht  extends ActionSupport{

	private static final long serialVersionUID = 2750909070539304598L;

	private HtlbService htlbService;
	
	private String userId;
	private List<Map<String, Object>> lastestTalkList;
	private List<Map<String, Object>> hottestTalkList;

	public void setHtlbService(HtlbService htlbService) {
		this.htlbService = htlbService;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public List<Map<String, Object>> getLastestTalkList() {
		return lastestTalkList;
	}

	public List<Map<String, Object>> getHottestTalkList() {
		return hottestTalkList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		int uid = NumberUtils.toInt(userId);
		if(uid <= 0){
			return ERROR; //传入的参数错误
		}
		
		int onePageCount = 4;
		// 查询结果列表
		lastestTalkList = (List<Map<String, Object>>) htlbService.getLastestTalkList(1, onePageCount).get(KEY_LIST);
		hottestTalkList = (List<Map<String, Object>>) htlbService.getHottestTalkList(1, onePageCount).get(KEY_LIST);
		return SUCCESS;
	}
}
