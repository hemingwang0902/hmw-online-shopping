package com.baizhi.userprivate.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baizhi.userprivate.service.UserPrivateService;
/**
 * 类名： UserPrivateList.java<br>
 * 描述：  获取用户私信信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-07-05 00:26:42
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetUserPrivateList extends UserPrivateForm {
	
	private static final long serialVersionUID = 5554241177186132005L;
	
	private UserPrivateService userPrivateService;//用户私信信息表业务类
	
	public UserPrivateService getUserPrivateService() {
		return userPrivateService;
	}

	public void setUserPrivateService(UserPrivateService userPrivateService) {
		this.userPrivateService = userPrivateService;
	}
	
	@SuppressWarnings("all")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "a.USER_ID=?", this.getSessionUserId());// 收件人ID
		// 查询用户私信信息表列表
		Map<String, Object> returnMap = userPrivateService.getUserPrivateList(params, 1, 1000);
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			//判断是否存在列表数据，如果存在列表数据，则将日期格式转换
			if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
				List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> newmap = list.get(i);
					newmap.put("CREATE_TIME", getTime(newmap, "CREATE_TIME","M月dd日 HH:mm"));
					newmap.put("CONTENT", replacePrivateFace((String)newmap.get("CONTENT")));
				}
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}
}