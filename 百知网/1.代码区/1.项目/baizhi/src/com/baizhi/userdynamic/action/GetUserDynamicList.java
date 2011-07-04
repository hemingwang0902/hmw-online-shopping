package com.baizhi.userdynamic.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.userdynamic.service.UserDynamicService;
/**
 * 类名： UserDynamicList.java<br>
 * 描述：  获取用户动态信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-07-05 00:34:20
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetUserDynamicList extends UserDynamicForm {
	
	private static final long serialVersionUID = -9172165657120391794L;
	
	private UserDynamicService userDynamicService;//用户动态信息表业务类
	
	public UserDynamicService getUserDynamicService() {
		return userDynamicService;
	}

	public void setUserDynamicService(UserDynamicService userDynamicService) {
		this.userDynamicService = userDynamicService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "DYNAMIC_ID=?", this.getDYNAMIC_ID());// 用户动态ID
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "TITLE=?", this.getTITLE());// 动态主题
		this.setMap(params, "BUSINESS_ID=?", this.getBUSINESS_ID());// 业务主键(回复问题ID、关注会员ID)
		this.setMap(params, "DYNAMIC_TYPE=?", this.getDYNAMIC_TYPE());// 动态类型(字典：1回答问题、2关注会员)
		this.setMap(params, "CONTENT=?", this.getCONTENT());// 动态内容(存放组织好的html内容)
		this.setMap(params, "WARN_USERID=?", this.getWARN_USERID());// 提醒用户ID
		this.setMap(params, "IS_OPEN=?", this.getIS_OPEN());// 是否查看(0否、1是)
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询用户动态信息表列表
		Map<String, Object> returnMap = userDynamicService.getUserDynamicList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}