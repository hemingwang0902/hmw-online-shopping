package com.baizhi.userattentiontalk.action;

import java.util.HashMap;
import java.util.Map;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.userattentiontalk.service.UserAttentiontalkService;

/**
 * 类名： AddUserAttentiontalk.java<br>
 * 描述：关注<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午08:01:18<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AddUserAttentiontalk extends ActionSupport{
	
	private static final long serialVersionUID = -5367596036045860957L;
	
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
		Map<String, Object> returnMap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		
		//获取当前登录用户ID
		int USER_ID=this.getSessionUserId();
		
		Element element = new DefaultElement("T_USER_ATTENTIONTALK");
		Elements.setElementValue(element, "USER_ID", USER_ID);// 用户ID
		Elements.setElementValue(element, "TALK_ID", TALK_ID);
		Elements.setElementValue(element, "IS_ATTENTION",0);// 是否关注(0否、1是)
		Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		
		//如果保存成功，返回主键
		String keyid = userAttentiontalkService.save(element);
		if(keyid!=null&&!keyid.equals("")){
			flag=true;
			message="添加关注成功";
		}else{
			message="添加关注失败";
		}
		returnMap.put("flag", flag);
		returnMap.put("message", message);
		this.setResult(returnMap);
		return JSONSUCCESS;
	}

}
