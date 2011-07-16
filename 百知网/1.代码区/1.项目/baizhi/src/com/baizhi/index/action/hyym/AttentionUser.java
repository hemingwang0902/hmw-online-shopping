package com.baizhi.index.action.hyym;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.BooleanUtils;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.userattention.service.UserAttentionService;

/**
 * 类名： AttentionUser<br>
 * 描述：关注/取消关注 用户<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-15<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AttentionUser extends ActionSupport {
	private static final long serialVersionUID = 7879311708792543842L;
	private UserAttentionService userAttentionService;//用户关注人信息表业务类
	//被关注人的ID
	private int WAS_USER_ID;
	//为true时，表示为取消关注
	private String disAttention;

	public void setWAS_USER_ID(int wASUSERID) {
		WAS_USER_ID = wASUSERID;
	}

	public void setUserAttentionService(UserAttentionService userAttentionService) {
		this.userAttentionService = userAttentionService;
	}

	public void setDisAttention(String disAttention) {
		this.disAttention = disAttention;
	}


	@Override
	public String execute() throws Exception {
		boolean flag=false;
		
		//获取当前登录用户ID
		int USER_ID=this.getSessionUserId();
		
		//获取被光注用户实体
		Element element = userAttentionService.getUserAttentionEleById(USER_ID, WAS_USER_ID);
		if(BooleanUtils.toBoolean(disAttention)){ //取消关注
			if(element!=null){
				flag = userAttentionService.cancelUserAttention(element, null);
			}else{
				flag = true;
			}
		}else{
			if(element!=null){ //已经存在
				flag = true;
			}else{
				element = new DefaultElement("T_USER_ATTENTION");
				Elements.setElementValue(element, "USER_ID", USER_ID);// 用户ID
				Elements.setElementValue(element, "WAS_USERID", WAS_USER_ID);// 被关注用户
				Elements.setElementValue(element, "IS_ATTENTION",0);// 是否关注(0否、1是)
				Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
				Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
				//如果保存成功，返回主键
				String keyid = userAttentionService.saveUserAttention(element,null);
				if(keyid!=null&&!keyid.equals("")){
					flag=true;
				}
			}
		}
		
		Map<String, Object> returnMap=new HashMap<String, Object>();
		returnMap.put("flag", flag);
		this.setResult(returnMap);
		return JSONSUCCESS;
	}
}
