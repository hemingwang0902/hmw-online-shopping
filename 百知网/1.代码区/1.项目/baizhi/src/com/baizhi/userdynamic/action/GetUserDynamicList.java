package com.baizhi.userdynamic.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.userdynamic.service.UserDynamicService;
/**
 * 类名： UserDynamicList.java<br>
 * 描述：  获取用户动态信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-07-05 00:34:20
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetUserDynamicList extends UserDynamicForm {
	
	private static final long serialVersionUID = -9172165657120391794L;
	
	private UserDynamicService userDynamicService;//用户动态信息表业务类
	
	public UserDynamicService getUserDynamicService() {
		return userDynamicService;
	}

	public void setUserDynamicService(UserDynamicService userDynamicService) {
		this.userDynamicService = userDynamicService;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		params.put("WARN_USERID", this.getSessionUserId());
		this.setMap(params, "IS_OPEN", this.getIS_OPEN());
		
		
		// 查询用户动态信息表列表
		Map<String, Object> returnMap = userDynamicService.getUserDynamicList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			//判断是否存在列表数据，如果存在列表数据，则将日期格式转换
			if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
				List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> newmap = list.get(i);
					newmap.put("CREATE_TIME", getTime(newmap, "CREATE_TIME"));
				}
				
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}