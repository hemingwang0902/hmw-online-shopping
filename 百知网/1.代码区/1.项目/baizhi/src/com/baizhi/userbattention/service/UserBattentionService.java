package com.baizhi.userbattention.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.userbattention.dao.UserBattentionDao;

/**
 * 类名：UserBattentionService.java<br>
 * 描述： 用户关注品牌信息表服务类，负责增删改查<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:10<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class UserBattentionService extends ServiceSupport{
	
	private static final long serialVersionUID = -8854806524565405553L;
	private UserBattentionDao userBattentionDao;
	
	public UserBattentionDao getUserBattentionDao() {
		return userBattentionDao;
	}

	public void setUserBattentionDao(UserBattentionDao userBattentionDao) {
		this.userBattentionDao = userBattentionDao;
	}
	
	/**
	 * 新增或修改用户关注品牌信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserBattention(Element element) {
		return userBattentionDao.saveOrUpdateUserBattention(element);
	}
	
	/**
	 *　删除用户关注品牌信息表信息
	 * 
	 * @param BATTENTION_IDS  用户关注品牌信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserBattention(String BATTENTION_IDS) {
		return userBattentionDao.deleteUserBattention(BATTENTION_IDS);
	}
	
	/**
	 * 根据用户关注品牌信息表ID获取用户关注品牌信息表实体
	 * @param BATTENTION_ID 用户关注品牌信息表ID
	 * @return 返回用户关注品牌信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserBattentionEleById(String BATTENTION_ID){
		return userBattentionDao.getUserBattentionEleById(BATTENTION_ID);
	}
	
	/**
	 *　获取用户关注品牌信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserBattentionCount(Map<String, Object> params) {
		return userBattentionDao.getUserBattentionCount(params);
	}
	
	/**
	 * 根据用户关注品牌信息表ID获取用户关注品牌信息表信息
	 * @param BATTENTION_ID 用户关注品牌信息表ID
	 * @return 返回用户关注品牌信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserBattentionMapById(String BATTENTION_ID){
		return userBattentionDao.getUserBattentionMapById(BATTENTION_ID);
	}
	
	/**
	 * 获取用户关注品牌信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户关注品牌信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserBattentionList(Map<String, Object> params,int nowPage,int onePageCount){
		return userBattentionDao.getUserBattentionList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取用户关注品牌信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户关注品牌信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserBattentionList(Map<String, Object> params){
		return userBattentionDao.getUserBattentionList(params);
	}

}
