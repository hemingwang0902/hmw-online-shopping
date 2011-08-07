package com.baizhi.userscore.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userscore.service.UserScoreService;
/**
 * 
 * 类名：UserScoreDel.java<br>
 * 描述： 删除用户积分明细表信息
 * 创建者：江红
 * 创建日期：2011-08-07 20:03:25
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class DelUserScore extends ActionSupport{
	
	private static final long serialVersionUID = -3975402897046638670L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private UserScoreService userScoreService;//用户积分明细表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public UserScoreService getUserScoreService() {
		return userScoreService;
	}

	public void setUserScoreService(UserScoreService userScoreService) {
		this.userScoreService = userScoreService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = userScoreService.deleteUserScore(IDS);
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