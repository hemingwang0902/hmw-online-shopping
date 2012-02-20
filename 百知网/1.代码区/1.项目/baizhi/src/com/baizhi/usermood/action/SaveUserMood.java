package com.baizhi.usermood.action;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.usermood.service.UserMoodService;

/**
 * 类名：UserMoodSave.java<br>
 * 描述： 用户心情随记控制类，负责处理新增、修改操作<br>
 * 创建者：何明旺<br>
 * 创建日期： 2012-02-19 15:00:28<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class SaveUserMood extends UserMoodForm{

    private static final long serialVersionUID = 784632223841215199L;
    private UserMoodService userMoodService;//用户心情随记业务类
    private int ajax;
	
	public void setUserMoodService(UserMoodService userMoodService) {
		this.userMoodService = userMoodService;
	}
	
	public void setAjax(int ajax) {
        this.ajax = ajax;
    }

    @Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果用户心情随记ID为""，则为新增用户心情随记，否则更新用户心情随记
		if(StringUtils.isNotEmpty(this.getId())){
			element = userMoodService.getUserMoodEleById("id");
			Elements.setElementValue(element, "id", this.getId());// 
			Elements.setElementValue(element, "user_id", this.getUser_id());// 用户ID
			Elements.setElementValue(element, "descript", this.getDescript());// 心情随记的内容
			Elements.setElementValue(element, "publish_time", this.getPublish_time());// 发表时间
			
			//如果保存成功，返回主键
			keyid = userMoodService.saveOrUpdateUserMood(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("用户心情随记信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_USER_MOOD");
			Elements.setElementValue(element, "user_id", getSessionUserId());// 用户ID
			Elements.setElementValue(element, "descript", this.getDescript());// 心情随记的内容
			Elements.setElementValue(element, "publish_time", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 发表时间
			//如果保存成功，返回主键
			keyid = userMoodService.saveOrUpdateUserMood(element);
			
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
			    if(ajax == 1){
			        Map<String, Object> returnMap = new HashMap<String, Object>();
    		        returnMap.put("flag", true);
    		        this.setResult(returnMap);
    		        return JSONSUCCESS;
		        }else{
			        return SUCCESS;
			    }
			}else{
			    
			}
		}
		return ERROR;
	}

}
