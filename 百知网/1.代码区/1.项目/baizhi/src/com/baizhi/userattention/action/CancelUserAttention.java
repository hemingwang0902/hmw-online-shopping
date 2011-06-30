package com.baizhi.userattention.action;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Element;

import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.Elements;
import com.baizhi.userattention.service.UserAttentionService;
/**
 * 
 * 类名：CancelUserAttention.java<br>
 * 描述： 取消用户关注
 * 创建者：江红
 * 创建日期：2011-07-01 00:54:40
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class CancelUserAttention extends ActionSupport{
	
	private static final long serialVersionUID = -5887095416005568278L;

	private UserAttentionService userAttentionService;//用户关注人信息表业务类
	
	private int WAS_USERID;// 被关注用户
	
	public UserAttentionService getUserAttentionService() {
		return userAttentionService;
	}

	public void setUserAttentionService(UserAttentionService userAttentionService) {
		this.userAttentionService = userAttentionService;
	}
	
	public int getWAS_USERID() {
		return WAS_USERID;
	}

	public void setWAS_USERID(int was_userid) {
		WAS_USERID = was_userid;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//获取当前登录用户ID
		int USER_ID=this.getSessionUserId();
		
		//获取光注用户实体
		Element element = userAttentionService.getUserAttentionEleById(USER_ID,WAS_USERID);
		
		//获取被光注用户实体
		Element was_element = userAttentionService.getUserAttentionEleById(WAS_USERID,USER_ID);
		if(was_element!=null){
			Elements.setElementValue(was_element, "IS_ATTENTION",0);// 是否关注(0否、1是)
		}
		
		//取消关注
		boolean result = userAttentionService.cancelUserAttention(element, was_element);
		//判断取消关注是否成功
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