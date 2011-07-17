package com.baizhi.userbattention.action;

import java.util.HashMap;
import java.util.Map;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.userbattention.service.UserBattentionService;

/**
 * 类名： AddUserBAttention.java<br>
 * 描述：添加关注<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午03:52:02<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AddUserBAttention  extends ActionSupport{
	
	private static final long serialVersionUID = -8350060573154793572L;
	
	private UserBattentionService userBattentionService;//用户关注人信息表业务类
	
	private Integer BRAND_ID;//品牌ID
	
	public UserBattentionService getUserBattentionService() {
		return userBattentionService;
	}

	public void setUserBattentionService(UserBattentionService userBattentionService) {
		this.userBattentionService = userBattentionService;
	}
	
	public Integer getBRAND_ID() {
		return BRAND_ID;
	}

	public void setBRAND_ID(Integer brand_id) {
		BRAND_ID = brand_id;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		
		//获取当前登录用户ID
		int USER_ID=this.getSessionUserId();
		
		Element element = new DefaultElement("T_USER_BATTENTION");
		Elements.setElementValue(element, "USER_ID", USER_ID);// 用户ID
		Elements.setElementValue(element, "BRAND_ID", BRAND_ID);// 用户ID
		Elements.setElementValue(element, "IS_ATTENTION",0);// 是否关注(0否、1是)
		Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		
		//如果保存成功，返回主键
		String keyid = userBattentionService.save(element);
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

