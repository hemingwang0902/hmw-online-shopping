package com.baizhi.usermood.action;

import java.util.Map;
import com.baizhi.usermood.service.UserMoodService;

/**
 * 类名：GetUserMoodById.java<br>
 * 描述： 获取单条用户心情随记表单信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2012-02-19 15:00:28<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetUserMoodById extends UserMoodForm{
	
    private static final long serialVersionUID = -1508079313585016755L;
    private UserMoodService userMoodService;//用户心情随记业务类
	
	public UserMoodService getUserMoodService() {
		return userMoodService;
	}

	public void setUserMoodService(UserMoodService userMoodService) {
		this.userMoodService = userMoodService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = userMoodService.getUserMoodMapById(this.getId());
		if(returnMap!=null&&returnMap.size()>0){
			this.setUser_id(this.getValue(returnMap,"user_id"));// 用户ID
			this.setDescript(this.getValue(returnMap,"descript"));// 心情随记的内容
			this.setPublish_time(this.getValue(returnMap,"publish_time"));// 发表时间
		}
		return SUCCESS;
	}
	
}
