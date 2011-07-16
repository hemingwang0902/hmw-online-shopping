package com.baizhi.userattentiontalk.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userattentiontalk.service.UserAttentiontalkService;

/**
 * 类名：UserAttentiontalkDel.java<br>
 * 描述： 删除用户关注话题信息表信息<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-07-16 14:04:18<br>
 * 版本：V0.9 <br>
 * 修改者： <br>
 * 修改日期：
 */
public class DelUserAttentiontalk extends ActionSupport{

	private static final long serialVersionUID = -7679553660529758541L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private UserAttentiontalkService userAttentiontalkService;//用户关注话题信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public UserAttentiontalkService getUserAttentiontalkService() {
		return userAttentiontalkService;
	}

	public void setUserAttentiontalkService(UserAttentiontalkService userAttentiontalkService) {
		this.userAttentiontalkService = userAttentiontalkService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = userAttentiontalkService.deleteUserAttentiontalk(IDS);
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