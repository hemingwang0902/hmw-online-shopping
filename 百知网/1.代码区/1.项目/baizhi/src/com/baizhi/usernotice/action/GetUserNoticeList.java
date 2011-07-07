package com.baizhi.usernotice.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.usernotice.service.UserNoticeService;
/**
 * 类名： UserNoticeList.java<br>
 * 描述：  获取用户通知设置表列表信息
 * 创建者：江红
 * 创建日期： 2011-07-07 00:19:12
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetUserNoticeList extends UserNoticeForm {
	
	private static final long serialVersionUID = -7058348073383523992L;
	
	private UserNoticeService userNoticeService;//用户通知设置表业务类
	
	private Map<String, Object> returnMap;
	
	public UserNoticeService getUserNoticeService() {
		return userNoticeService;
	}

	public void setUserNoticeService(UserNoticeService userNoticeService) {
		this.userNoticeService = userNoticeService;
	}
	
	public Map<String, Object> getReturnMap() {
		return returnMap;
	}

	public void setReturnMap(Map<String, Object> returnMap) {
		this.returnMap = returnMap;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "USER_ID=?",this.getSessionUserId());// 用户ID
		// 查询用户通知设置表列表
		returnMap = new HashMap<String, Object>();
		List<Map<String, Object>> list = userNoticeService.getUserNoticeList(params);
		
		//通知类型(1：有人关注了我、2：有人问了我一个问题、3：有人邀请我回答一个问题、4：我关注的问题有了新答案、5：有人向我发送私信、6：谁可以给我发私信)
		//设置类型(0：否、1：是、3：所有人、4：我关注的人)
		
		String[] SET_TYPES=new String[]{"SET_TYPE_1","SET_TYPE_2","SET_TYPE_3","SET_TYPE_4","SET_TYPE_5","SET_TYPE_6"}; 
		//判断是否存在查询记录
		if (list != null && list.size() > 0) {
			String values="";
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = list.get(i);
				values+=values.trim().equals("")?String.valueOf(map.get("SET_TYPE")):","+String.valueOf(map.get("SET_TYPE"));
				returnMap.put(SET_TYPES[i],map.get("SET_TYPE"));
			}
			returnMap.put("values",	values);
			this.setResult(returnMap);
		}
		return SUCCESS;
	}

	
	
}