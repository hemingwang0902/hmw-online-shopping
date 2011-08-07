package com.baizhi.userscore.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.userscore.dao.UserScoreDao;
/**
 * 
 * 类名：UserScoreService.java
 * 描述： 用户积分明细表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-08-07 20:03:25
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class UserScoreService extends ServiceSupport{
	
	private static final long serialVersionUID = 1415404333035856642L;
	
	private UserScoreDao userScoreDao;
	
	public UserScoreDao getUserScoreDao() {
		return userScoreDao;
	}

	public void setUserScoreDao(UserScoreDao userScoreDao) {
		this.userScoreDao = userScoreDao;
	}
	
	/**
	 * 新增或修改用户积分明细表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserScore(Element element) {
		return userScoreDao.saveOrUpdateUserScore(element);
	}
	
	/**
	 *　删除用户积分明细表信息
	 * 
	 * @param SCORE_IDS  用户积分明细表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserScore(String SCORE_IDS) {
		return userScoreDao.deleteUserScore(SCORE_IDS);
	}
	
	/**
	 * 根据用户积分明细表ID获取用户积分明细表实体
	 * @param SCORE_ID 用户积分明细表ID
	 * @return 返回用户积分明细表实体,如果无查询记录则返回null
	 */
	public  Element getUserScoreEleById(String SCORE_ID){
		return userScoreDao.getUserScoreEleById(SCORE_ID);
	}
	
	/**
	 *　获取用户积分明细表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserScoreCount(Map<String, Object> params) {
		return userScoreDao.getUserScoreCount(params);
	}
	
	/**
	 * 根据用户积分明细表ID获取用户积分明细表信息
	 * @param SCORE_ID 用户积分明细表ID
	 * @return 返回用户积分明细表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserScoreMapById(String SCORE_ID){
		return userScoreDao.getUserScoreMapById(SCORE_ID);
	}
	
	/**
	 * 获取用户积分明细表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户积分明细表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserScoreList(Map<String, Object> params,int nowPage,int onePageCount){
		return userScoreDao.getUserScoreList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取用户积分明细表信息
     * 
     * @param  params 参数
     * @return 成功返回用户积分明细表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserScoreList(Map<String, Object> params){
		return userScoreDao.getUserScoreList(params);
	}

}
