package com.baizhi.user.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.user.service.UserService;

/**
 * 
 * 类名：GetUserList.java
 * 描述：获取用户信息表列表信息
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class GetUserList extends UserForm {
	
	private static final long serialVersionUID = -8483371984012838275L;
	
	private UserService userService;//用户信息表业务类

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "USER_TYPE=?", this.getUSER_ID());// 用户类型(字典：1用户、2品牌)
		this.setMap(params, "EMAIL=?", this.getEMAIL());// Email
		this.setMap(params, "PASSWORD=?", this.getPASSWORD());// 密码
		this.setMap(params, "REG_TIME=?", this.getREG_TIME());// 注册时间
		this.setMap(params, "LAST_LOGINTIME=?", this.getLAST_LOGINTIME());// 最后登录时间
		this.setMap(params, "IP=?", this.getIP());// 最后登录IP
		this.setMap(params, "MAC=?", this.getMAC());// 最后登录MAC
		this.setMap(params, "LAST_FREEZETIME=?", this.getLAST_FREEZETIME());// 最后冻结时间
		// 查询用户信息表列表
		Map<String, Object> returnMap = userService.getUserList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}
	
}
