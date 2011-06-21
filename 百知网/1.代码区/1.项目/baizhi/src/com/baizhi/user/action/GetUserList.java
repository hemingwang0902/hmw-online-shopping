package com.baizhi.user.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.user.service.UserService;
/**
 * 
 * 类名：GetUserList.java
 * 描述：获取用户信息表列表信息
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class GetUserList extends UserForm {
	
	private static final long serialVersionUID = -8483371984012838275L;
	
	private UserService userService;//用户信息表业务类
	
	private String REG_TIME_END;//注册时间(止)
	
	private String LAST_LOGINTIME_END;//最后登录时间(止)
	
	private String LAST_FREEZETIME_END;//最后冻结时间(止)

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getREG_TIME_END() {
		return REG_TIME_END;
	}

	public void setREG_TIME_END(String reg_time_end) {
		REG_TIME_END = reg_time_end;
	}

	public String getLAST_LOGINTIME_END() {
		return LAST_LOGINTIME_END;
	}

	public void setLAST_LOGINTIME_END(String last_logintime_end) {
		LAST_LOGINTIME_END = last_logintime_end;
	}

	public String getLAST_FREEZETIME_END() {
		return LAST_FREEZETIME_END;
	}

	public void setLAST_FREEZETIME_END(String last_freezetime_end) {
		LAST_FREEZETIME_END = last_freezetime_end;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "USER_TYPE=?", this.getUSER_TYPE());// 用户类型(字典：1用户、2品牌)
		this.setMap(params, "EMAIL=?", this.getEMAIL());// Email
		this.setMap(params, "REG_TIME>=?", this.getREG_TIME());// 注册时间(起)
		this.setMap(params, "LAST_LOGINTIME>=?", this.getLAST_LOGINTIME());// 最后登录时间(起)
		this.setMap(params, "LAST_FREEZETIME>=?", this.getLAST_FREEZETIME());// 最后冻结时间(起)
		this.setMap(params, "REG_TIME<=?", REG_TIME_END);// 注册时间(止)
		this.setMap(params, "LAST_LOGINTIME<=?", LAST_LOGINTIME_END);// 最后登录时间(止)
		this.setMap(params, "LAST_FREEZETIME<=?", LAST_FREEZETIME_END);// 最后冻结时间(止)
		
		
		// 查询用户信息表列表
		Map<String, Object> returnMap = userService.getUserList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			//判断是否存在列表数据，如果存在列表数据，则将日期格式转换
			if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
				List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> newmap = list.get(i);
					newmap.put("REG_TIME", getTime(newmap, "REG_TIME"));
					String LAST_LOGINTIME=getTime(newmap, "LAST_LOGINTIME");
					String LAST_FREEZETIME=getTime(newmap, "LAST_FREEZETIME");
					
					newmap.put("LAST_LOGINTIME", LAST_LOGINTIME.equals("")?"&nbsp;":LAST_LOGINTIME);
					newmap.put("LAST_FREEZETIME",LAST_FREEZETIME.equals("")?"&nbsp;":LAST_FREEZETIME);
				}
				
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}
	
	
	
}
