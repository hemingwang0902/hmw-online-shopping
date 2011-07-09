package com.baizhi.userprivate.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baizhi.userprivate.service.UserPrivateService;

/**
 * 类名： GetUserPrivateByList.java<br>
 * 描述：<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-10 上午02:14:31<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetUserPrivateByList  extends UserPrivateForm {
	
	private static final long serialVersionUID = -8311480067715555032L;
	
	private UserPrivateService userPrivateService;//用户私信信息表业务类
	
	public UserPrivateService getUserPrivateService() {
		return userPrivateService;
	}

	public void setUserPrivateService(UserPrivateService userPrivateService) {
		this.userPrivateService = userPrivateService;
	}
	
	private Integer SEND_ID;
	
	public void setSEND_ID(Integer send_id) {
		SEND_ID = send_id;
	}

	@SuppressWarnings("all")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "a.USER_ID=?", this.getSessionUserId());// 收件人ID
		this.setMap(params, "a.SEND_ID=?", SEND_ID);// 收件人ID
		// 查询用户私信信息表列表
		Map<String, Object> returnMap = userPrivateService.getUserPrivateByList(params, 1, 1000);
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			//判断是否存在列表数据，如果存在列表数据，则将日期格式转换
			if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
				List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> newmap = list.get(i);
					newmap.put("CREATE_TIME", getTime(newmap, "CREATE_TIME","M月dd日 HH:mm"));
				}
				
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}