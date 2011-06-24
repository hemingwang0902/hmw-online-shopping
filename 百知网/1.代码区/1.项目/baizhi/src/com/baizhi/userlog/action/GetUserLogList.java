package com.baizhi.userlog.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.userlog.service.UserLogService;
/**
 * 类名： UserLogList.java<br>
 * 描述：  获取用户日志表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-24 21:28:32
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetUserLogList extends UserLogForm {
	
	private static final long serialVersionUID = 5757644349723950384L;
	
	private UserLogService userLogService;//用户日志表业务类
	
	public UserLogService getUserLogService() {
		return userLogService;
	}

	public void setUserLogService(UserLogService userLogService) {
		this.userLogService = userLogService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "LOG_ID=?", this.getLOG_ID());// 用户日志ID
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "LOGIN_TIME=?", this.getLOGIN_TIME());// 登录时间
		this.setMap(params, "IP=?", this.getIP());// IP
		this.setMap(params, "MAC=?", this.getMAC());// MAC
		// 查询用户日志表列表
		Map<String, Object> returnMap = userLogService.getUserLogList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}