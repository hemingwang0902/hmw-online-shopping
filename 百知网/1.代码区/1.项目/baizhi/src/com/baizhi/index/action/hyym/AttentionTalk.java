package com.baizhi.index.action.hyym;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.commons.ActionSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.userattentiontalk.service.UserAttentiontalkService;

/**
 * 类名： AttentionTalk<br>
 * 描述：关注/取消关注 话题<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-15<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AttentionTalk extends ActionSupport {

	private static final long serialVersionUID = 2015784261932508599L;
	private UserAttentiontalkService userAttentiontalkService;//用户关注人信息表业务类
	//被关注话题的ID
	private int TALK_ID;
	//为true时，表示为取消关注
	private boolean isDisAttention;

	public void setUserAttentiontalkService(
			UserAttentiontalkService userAttentiontalkService) {
		this.userAttentiontalkService = userAttentiontalkService;
	}

	public void setTALK_ID(int tALKID) {
		TALK_ID = tALKID;
	}

	public void setDisAttention(boolean isDisAttention) {
		this.isDisAttention = isDisAttention;
	}

	@Override
	public String execute() throws Exception {
		boolean flag=false;
		
		//获取当前登录用户ID
		int USER_ID=this.getSessionUserId();
		
		//获取被光注用户实体
		Element element = userAttentiontalkService.getUserAttentionEleById(USER_ID, TALK_ID);
		if(isDisAttention){ //取消关注
			if(element!=null){
				flag = userAttentiontalkService.deleteUserAttentiontalk(element.elementTextTrim("ATTENTIONTALK_ID"));
			}else{
				flag = true;
			}
		}else{
			if(element!=null){ //已经存在
				flag = true;
			}else{
				element = new DefaultElement("T_USER_ATTENTIONTALK");
				Elements.setElementValue(element, "USER_ID", USER_ID);// 用户ID
				Elements.setElementValue(element, "TALK_ID", TALK_ID);// 问题话题ID
				Elements.setElementValue(element, "IS_ATTENTION", 0);// 是否关注(0否、1是)
				Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
				Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
				//如果保存成功，返回主键
				String keyid = userAttentiontalkService.saveOrUpdateUserAttentiontalk(element);
				//判断主键是否为空，如果不为空，则保存成功
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
