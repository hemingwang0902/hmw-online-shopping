package com.baizhi.userattention.action;

import java.util.HashMap;
import java.util.Map;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.userattention.service.UserAttentionService;
/**
 * 
 * 类名：SaveUserAttention.java
 * 描述： 关注人、品牌
 * 创建者：江红
 * 创建日期： 2011-07-01 00:54:40
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveUserAttention extends ActionSupport{
	
	private static final long serialVersionUID = -8350060573154793572L;
	
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
		Map<String, Object> returnMap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		
		//获取当前登录用户ID
		int USER_ID=this.getSessionUserId();
		
		//获取被光注用户实体
		Element was_element = userAttentionService.getUserAttentionEleById(WAS_USERID,USER_ID);
		int IS_ATTENTION=0;
		if(was_element!=null){
			Elements.setElementValue(was_element, "IS_ATTENTION",1);// 是否关注(0否、1是)
			IS_ATTENTION=1;
		}
		
		Element element = new DefaultElement("T_USER_ATTENTION");
		Elements.setElementValue(element, "USER_ID", USER_ID);// 用户ID
		Elements.setElementValue(element, "WAS_USERID", WAS_USERID);// 被关注用户
		Elements.setElementValue(element, "IS_ATTENTION",IS_ATTENTION);// 是否关注(0否、1是)
		Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		
		//如果保存成功，返回主键
		String keyid = userAttentionService.saveUserAttention(element,was_element);
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
