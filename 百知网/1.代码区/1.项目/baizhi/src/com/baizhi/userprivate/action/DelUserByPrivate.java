package com.baizhi.userprivate.action;

import java.util.HashMap;
import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.userprivate.service.UserPrivateService;

/**
 * 类名： DelUserByPrivate.java<br>
 * 描述：<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-10 上午02:30:36<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class DelUserByPrivate  extends ActionSupport{
	
	private static final long serialVersionUID = -4382432958928373263L;
	
	private Integer PRIVATE_ID;//主键ID
	
	
	private UserPrivateService userPrivateService;//用户私信信息表业务类
	
	public UserPrivateService getUserPrivateService() {
		return userPrivateService;
	}

	public void setUserPrivateService(UserPrivateService userPrivateService) {
		this.userPrivateService = userPrivateService;
	}
	
	public void setPRIVATE_ID(int private_id) {
		PRIVATE_ID = private_id;
	}
	

	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		
		//删除私信
		int count = userPrivateService.deleteUserByPrivate(PRIVATE_ID,this.getSessionUserId());
		//判断删除是否成功
		if(count>0){
			flag=true;
			message="私信删除成功";
		}else{
			message="私信删除失败";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}