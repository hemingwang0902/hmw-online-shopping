package com.baizhi.usernotice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.usernotice.dao.UserNoticeDao;
/**
 * 
 * 类名：UserNoticeService.java
 * 描述： 用户通知设置表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-07-07 00:19:12
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class UserNoticeService extends ServiceSupport{
	
	private static final long serialVersionUID = 9142810879834418671L;
	
	private UserNoticeDao userNoticeDao;
	
	public UserNoticeDao getUserNoticeDao() {
		return userNoticeDao;
	}

	public void setUserNoticeDao(UserNoticeDao userNoticeDao) {
		this.userNoticeDao = userNoticeDao;
	}
	
	/**
	 * 修改用户通知设置表信息
	 * @param USER_ID  用户ID
	 * @param types  通知类型
	 * @return 返回 <code>true</code>,失败返回 <code>false</code>
	 */
	public boolean updateUserNotice(int USER_ID, Map<Integer, Integer> types) {
		return userNoticeDao.updateUserNotice(USER_ID, types);
	}
	
	
	/**
     * 获取用户通知设置表信息
     * 
     * @param  params 参数
     * @return 成功返回用户通知设置表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserNoticeList(Map<String, Object> params){
	    List<Map<String,Object>> list = userNoticeDao.getUserNoticeList(params);
	    return list == null ? new ArrayList<Map<String,Object>>() : list;
	}

}
