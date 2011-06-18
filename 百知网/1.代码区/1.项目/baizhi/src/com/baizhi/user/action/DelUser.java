package com.baizhi.user.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.user.service.UserService;

/**
 * 
 * 类名：    DelUser.java
 * 描述：    删除用户信息表信息
 * 创建者：  江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：    V0.9
 * 修改者：  
 * 修改日期：
 */
public class DelUser  extends ActionSupport{
	
	private static final long serialVersionUID = -4653540582906166131L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private UserService userService;//用户信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = userService.deleteUser(IDS);
			//判断删除是否成功
			if(result){
				flag=true;
				message="用户删除成功";
			}else{
				message="用户删除失败";
			}
		}else{
			message="请选择要删除的用户";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}