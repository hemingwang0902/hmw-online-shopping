package com.baizhi.userbattention.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.userbattention.service.UserBattentionService;

/**
 * 类名： UserBattentionList.java<br>
 * 描述：  获取用户关注品牌信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:10<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetUserBattentionList extends UserBattentionForm {
	
	private static final long serialVersionUID = 3527665742232176518L;
	private UserBattentionService userBattentionService;//用户关注品牌信息表业务类
	
	public UserBattentionService getUserBattentionService() {
		return userBattentionService;
	}

	public void setUserBattentionService(UserBattentionService userBattentionService) {
		this.userBattentionService = userBattentionService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "BATTENTION_ID=?", this.getBATTENTION_ID());// 用户关注品牌ID
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "BRAND_ID=?", this.getBRAND_ID());// 被关注品牌
		this.setMap(params, "IS_ATTENTION=?", this.getIS_ATTENTION());// 是否关注(0否、1是)
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询用户关注品牌信息表列表
		Map<String, Object> returnMap = userBattentionService.getUserBattentionList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}