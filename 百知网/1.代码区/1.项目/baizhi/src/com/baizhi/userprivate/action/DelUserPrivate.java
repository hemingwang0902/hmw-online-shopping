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
	
	private Integer PRIVATE_ID;//主键ID
	
	private Integer SEND_ID;//发送人ID
	
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

	public void setSEND_ID(int send_id) {
		SEND_ID = send_id;
	}

	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		Map<String, Object> params = new HashMap<String, Object>();
		if(PRIVATE_ID!=null){
			//设置查询条件
			this.setMap(params, "PRIVATE_ID=?", PRIVATE_ID);// 收件人ID
		}else{
			//设置查询条件
			this.setMap(params, "USER_ID=?", this.getSessionUserId());// 收件人ID
			this.setMap(params, "SEND_ID=?", SEND_ID);// 收件人ID
		}
		
		//删除私信
		int count = userPrivateService.deleteUserPrivate(params);
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