package com.baizhi.userinvite.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userinvite.service.UserInviteService;
/**
 * 
 * 类名：UserInviteDel.java<br>
 * 描述： 删除用户邀请信息表信息
 * 创建者：江红
 * 创建日期：2011-06-23 22:20:22
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class DelUserInvite extends ActionSupport{
	
	private static final long serialVersionUID = -3264179304240228589L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private UserInviteService userInviteService;//用户邀请信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public UserInviteService getUserInviteService() {
		return userInviteService;
	}

	public void setUserInviteService(UserInviteService userInviteService) {
		this.userInviteService = userInviteService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = userInviteService.deleteUserInvite(IDS);
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