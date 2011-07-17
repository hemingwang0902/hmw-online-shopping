package com.baizhi.userattentiontalk.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userattentiontalk.service.UserAttentiontalkService;

/**
 * 类名： CancelUserAttentiontalk.java<br>
 * 描述：取消关注<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午08:01:31<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class CancelUserAttentiontalk  extends ActionSupport{
	
	private static final long serialVersionUID = 3504833020232433771L;

	private UserAttentiontalkService userAttentiontalkService;
	
	private Integer TALK_ID;
	
	public UserAttentiontalkService getUserAttentiontalkService() {
		return userAttentiontalkService;
	}


	public void setUserAttentiontalkService(
			UserAttentiontalkService userAttentiontalkService) {
		this.userAttentiontalkService = userAttentiontalkService;
	}
	
	public Integer getTALK_ID() {
		return TALK_ID;
	}
	
	public void setTALK_ID(Integer talk_id) {
		TALK_ID = talk_id;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//取消关注
		boolean result = userAttentiontalkService.cancel(TALK_ID,this.getSessionUserId());
		//判断删除是否成功
		if(result){
			flag=true;
			message="取消关注成功";
		}else{
			message="取消关注失败";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
}
