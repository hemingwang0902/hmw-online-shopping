package com.baizhi.usernotice.action;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.usernotice.service.UserNoticeService;
/**
 * 
 * 类名：UserNoticeSave.java
 * 描述： 用户通知设置表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-07-07 00:19:12
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveUserNotice extends UserNoticeForm{
	
	private static final long serialVersionUID = -4922332671988178647L;
	
	private String values;
	
	private UserNoticeService userNoticeService;//用户通知设置表业务类
	
	public UserNoticeService getUserNoticeService() {
		return userNoticeService;
	}

	public void setUserNoticeService(UserNoticeService userNoticeService) {
		this.userNoticeService = userNoticeService;
	}
	
	public String getValues() {
		return values;
	}

	public void setValues(String values) {
		this.values = values;
	}
/*
	@Override
	public String execute() throws Exception {
		boolean flag=false;
		
		// 通知类型(1：有人关注了我、2：有人问了我一个问题、3：有人邀请我回答一个问题、4：我关注的问题有了新答案、5：有人向我发送私信、6：谁可以给我发私信)
		int[] types=new int[]{1,2,3,4,5,6};
		
		// 设置类型(0：否、1：是、3：所有人、4：我关注的人)
		String[] vals=values.split(",");
		
		//如果保存成功，返回true
		flag = userNoticeService.updateUserNotice(this.getSessionUserId(),types,vals);
		//判断主键是否为空，如果不为空，则保存成功
		if(flag){
			this.setMessage("通知设置成功");
			return SUCCESS;
		}
		this.setMessage("通知设置失败");
		return ERROR;
	}
*/
    @Override
    public String execute() throws Exception {
        boolean flag=false;
        
        String[] types = values.split(",");
        Map<Integer, Integer> typeMap = new LinkedHashMap<Integer, Integer>(types.length);
        for (String str : types) {
            String[] keyVal = str.split("=");
            typeMap.put(NumberUtils.createInteger(keyVal[0]), NumberUtils.createInteger(keyVal[1]));
        }
        
        //如果保存成功，返回true
        flag = userNoticeService.updateUserNotice(this.getSessionUserId(),typeMap);

        Map<String, Object> returnMap = new HashMap<String, Object>();
        returnMap.put("flag", flag);
        this.setResult(returnMap);
        return JSONSUCCESS;
    }
}
