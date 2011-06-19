package com.baizhi.user.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.user.dao.UserDao;

/**
 * 
 * 类名：UserService.java
 * 描述：用户信息表业务操作类，负责业务处理
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
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
	 * 新增或修改用户信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUser(Element element) {
		return userDao.saveOrUpdateUser(element);
	}
	
	/**
	 *　删除用户信息表信息
	 * 
	 * @param USER_IDS  用户信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUser(String USER_IDS) {
		return userDao.deleteUser(USER_IDS);
	}
	
	/**
	 * 根据用户信息表ID获取用户信息表实体
	 * @param USER_ID 用户信息表ID
	 * @return 返回用户信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserEleById(String USER_ID){
		return userDao.getUserEleById(USER_ID);
	}
	
	/**
	 *　获取用户信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserCount(Map<String, Object> params) {
		return userDao.getUserCount(params);
	}
	
	/**
	 * 根据用户信息表ID获取用户信息表信息
	 * @param USER_ID 用户信息表ID
	 * @return 返回用户信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserMapById(String USER_ID){
		return userDao.getUserMapById(USER_ID);
	}
	
	/**
	 * 获取用户信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserList(Map<String, Object> params,int nowPage,int onePageCount){
		return userDao.getUserList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取用户信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserList(Map<String, Object> params){
		return userDao.getUserList(params);
	}
	
}
