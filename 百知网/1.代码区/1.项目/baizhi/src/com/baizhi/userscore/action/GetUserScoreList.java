package com.baizhi.userscore.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.userscore.service.UserScoreService;
/**
 * 类名： UserScoreList.java<br>
 * 描述：  获取用户积分明细表列表信息
 * 创建者：江红
 * 创建日期： 2011-08-07 20:03:25
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetUserScoreList extends UserScoreForm {
	
	private static final long serialVersionUID = -8438671700683335793L;
	
	private UserScoreService userScoreService;//用户积分明细表业务类
	
	public UserScoreService getUserScoreService() {
		return userScoreService;
	}

	public void setUserScoreService(UserScoreService userScoreService) {
		this.userScoreService = userScoreService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "SCORE_ID=?", this.getSCORE_ID());// 用户积分明细ID
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "BUSINESS_ID=?", this.getBUSINESS_ID());// 业务主键(提问题ID、回答ID)
		this.setMap(params, "BUSINESS_TYPE=?", this.getBUSINESS_TYPE());// 业务类型(字典：1、会员邀请朋友注册获得积分2、提问题3、回答问题)
		this.setMap(params, "SCORE=?", this.getSCORE());// 积分
		this.setMap(params, "DESCRIPTION=?", this.getDESCRIPTION());// 描述
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询用户积分明细表列表
		Map<String, Object> returnMap = userScoreService.getUserScoreList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}