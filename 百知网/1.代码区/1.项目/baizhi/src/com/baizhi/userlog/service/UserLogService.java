package com.baizhi.userlog.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.userlog.dao.UserLogDao;
/**
 * 
 * 类名：UserLogService.java
 * 描述： 用户日志表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-06-24 21:28:32
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class UserLogService extends ServiceSupport{
	
	private static final long serialVersionUID = 8983361101176778717L;
	
	private UserLogDao userLogDao;
	
	public UserLogDao getUserLogDao() {
		return userLogDao;
	}

	public void setUserLogDao(UserLogDao userLogDao) {
		this.userLogDao = userLogDao;
	}
	
	/**
	 * 新增或修改用户日志表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserLog(Element element) {
		return userLogDao.saveOrUpdateUserLog(element);
	}
	
	/**
	 *　删除用户日志表信息
	 * 
	 * @param LOG_IDS  用户日志表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserLog(String LOG_IDS) {
		return userLogDao.deleteUserLog(LOG_IDS);
	}
	
	/**
	 * 根据用户日志表ID获取用户日志表实体
	 * @param LOG_ID 用户日志表ID
	 * @return 返回用户日志表实体,如果无查询记录则返回null
	 */
	public  Element getUserLogEleById(String LOG_ID){
		return userLogDao.getUserLogEleById(LOG_ID);
	}
	
	/**
	 *　获取用户日志表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserLogCount(Map<String, Object> params) {
		return userLogDao.getUserLogCount(params);
	}
	
	/**
	 * 根据用户日志表ID获取用户日志表信息
	 * @param LOG_ID 用户日志表ID
	 * @return 返回用户日志表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserLogMapById(String LOG_ID){
		return userLogDao.getUserLogMapById(LOG_ID);
	}
	
	/**
	 * 获取用户日志表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户日志表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserLogList(Map<String, Object> params,int nowPage,int onePageCount){
		return userLogDao.getUserLogList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取用户日志表信息
     * 
     * @param  params 参数
     * @return 成功返回用户日志表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserLogList(Map<String, Object> params){
		return userLogDao.getUserLogList(params);
	}

}
