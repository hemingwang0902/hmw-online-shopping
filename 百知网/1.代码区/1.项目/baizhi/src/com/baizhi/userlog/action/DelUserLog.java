package com.baizhi.userlog.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userlog.service.UserLogService;
/**
 * 
 * 类名：UserLogDel.java<br>
 * 描述： 删除用户日志表信息
 * 创建者：江红
 * 创建日期：2011-06-24 21:28:32
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class DelUserLog extends ActionSupport{
	
	private static final long serialVersionUID = -290623272903433121L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private UserLogService userLogService;//用户日志表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public UserLogService getUserLogService() {
		return userLogService;
	}

	public void setUserLogService(UserLogService userLogService) {
		this.userLogService = userLogService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = userLogService.deleteUserLog(IDS);
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