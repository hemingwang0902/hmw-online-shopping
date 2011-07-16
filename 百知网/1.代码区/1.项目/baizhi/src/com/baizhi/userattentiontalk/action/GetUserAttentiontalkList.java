package com.baizhi.userattentiontalk.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.userattentiontalk.service.UserAttentiontalkService;

/**
 * 类名： UserAttentiontalkList.java<br>
 * 描述：  获取用户关注话题信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-16 14:04:18<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetUserAttentiontalkList extends UserAttentiontalkForm {

	private static final long serialVersionUID = 7773043613427431557L;
	private UserAttentiontalkService userAttentiontalkService;//用户关注话题信息表业务类
	
	public UserAttentiontalkService getUserAttentiontalkService() {
		return userAttentiontalkService;
	}

	public void setUserAttentiontalkService(UserAttentiontalkService userAttentiontalkService) {
		this.userAttentiontalkService = userAttentiontalkService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "ATTENTIONTALK_ID=?", this.getATTENTIONTALK_ID());// 用户关注话题ID
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "TALK_ID=?", this.getTALK_ID());// 问题话题ID
		this.setMap(params, "IS_ATTENTION=?", this.getIS_ATTENTION());// 是否关注(0否、1是)
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询用户关注话题信息表列表
		Map<String, Object> returnMap = userAttentiontalkService.getUserAttentiontalkList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}