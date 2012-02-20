package com.baizhi.usermood.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.usermood.dao.UserMoodDao;

/**
 * 类名：UserMoodService.java<br>
 * 描述： 用户心情随记服务类，负责增删改查<br>
 * 创建者：何明旺<br>
 * 创建日期： 2012-02-19 15:00:28<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class UserMoodService extends ServiceSupport{
	
    private static final long serialVersionUID = 69725984780264127L;
    private UserMoodDao userMoodDao;
	
	public UserMoodDao getUserMoodDao() {
		return userMoodDao;
	}

	public void setUserMoodDao(UserMoodDao userMoodDao) {
		this.userMoodDao = userMoodDao;
	}
	
	/**
	 * 新增或修改用户心情随记信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserMood(Element element) {
		return userMoodDao.saveOrUpdateUserMood(element);
	}
	
	/**
	 *　删除用户心情随记信息
	 * 
	 * @param idS  用户心情随记ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserMood(String idS) {
		return userMoodDao.deleteUserMood(idS);
	}
	
	/**
	 * 根据用户心情随记ID获取用户心情随记实体
	 * @param id 用户心情随记ID
	 * @return 返回用户心情随记实体,如果无查询记录则返回null
	 */
	public  Element getUserMoodEleById(String id){
		return userMoodDao.getUserMoodEleById(id);
	}
	
	/**
	 *　获取用户心情随记数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserMoodCount(Map<String, Object> params) {
		return userMoodDao.getUserMoodCount(params);
	}
	
	/**
	 * 根据用户心情随记ID获取用户心情随记信息
	 * @param id 用户心情随记ID
	 * @return 返回用户心情随记信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserMoodMapById(String id){
		return userMoodDao.getUserMoodMapById(id);
	}
	
	/**
	 * 获取用户心情随记列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户心情随记列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserMoodList(Map<String, Object> params,int nowPage,int onePageCount){
		return userMoodDao.getUserMoodList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取用户心情随记信息
     * 
     * @param  params 参数
     * @return 成功返回用户心情随记信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserMoodList(Map<String, Object> params){
		return userMoodDao.getUserMoodList(params);
	}

}
