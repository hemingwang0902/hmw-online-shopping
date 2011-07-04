package com.baizhi.userprivate.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userprivate.service.UserPrivateService;
/**
 * 
 * 类名：UserPrivateDel.java<br>
 * 描述： 删除用户私信信息表信息
 * 创建者：江红
 * 创建日期：2011-07-05 00:26:42
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class DelUserPrivate extends ActionSupport{
	
	private static final long serialVersionUID = -4382432958928373263L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private UserPrivateService userPrivateService;//用户私信信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public UserPrivateService getUserPrivateService() {
		return userPrivateService;
	}

	public void setUserPrivateService(UserPrivateService userPrivateService) {
		this.userPrivateService = userPrivateService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = userPrivateService.deleteUserPrivate(IDS);
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