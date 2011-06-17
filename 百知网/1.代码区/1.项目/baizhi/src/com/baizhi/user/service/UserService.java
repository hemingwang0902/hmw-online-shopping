package com.baizhi.user.service;

import java.util.Map;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.user.dao.UserDao;

/**
 * 
 * 类名：UserService<br>
 * 描述： 注册用户信息类，负责处理本身业务增删改查<br>
 * 创建者：陈明坤 <br>
 * 创建日期： 2011-3-11<br>
 * 版本：V0.9 <br>
 * 修改者：        <br>
 * 修改日期：   <br>
 */
public class UserService extends ServiceSupport{ 
	
	private static final long serialVersionUID = 6731599937424957265L;
	
	private UserDao   userDao; 
	 
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * 用户登录
	 * @param username  用户名
	 * @param userpwd   用户密码
	 * @param ip        IP地址
	 * @param mac       Mac地址
	 * @return          返回用户信息
	 */
	public Map<String,Object> login(String username,String userpwd,String ip,String mac){
		return userDao.login(username, userpwd,ip,mac);
	}
	
	
}
