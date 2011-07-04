package com.baizhi.userdynamic.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.userdynamic.dao.UserDynamicDao;
/**
 * 
 * 类名：UserDynamicService.java
 * 描述： 用户动态信息表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-07-05 00:34:20
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class UserDynamicService extends ServiceSupport{
	
	private static final long serialVersionUID = 950474720467799564L;
	
	private UserDynamicDao userDynamicDao;
	
	public UserDynamicDao getUserDynamicDao() {
		return userDynamicDao;
	}

	public void setUserDynamicDao(UserDynamicDao userDynamicDao) {
		this.userDynamicDao = userDynamicDao;
	}
	
	/**
	 * 新增或修改用户动态信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserDynamic(Element element) {
		return userDynamicDao.saveOrUpdateUserDynamic(element);
	}
	
	/**
	 *　删除用户动态信息表信息
	 * 
	 * @param DYNAMIC_IDS  用户动态信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserDynamic(String DYNAMIC_IDS) {
		return userDynamicDao.deleteUserDynamic(DYNAMIC_IDS);
	}
	
	/**
	 * 根据用户动态信息表ID获取用户动态信息表实体
	 * @param DYNAMIC_ID 用户动态信息表ID
	 * @return 返回用户动态信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserDynamicEleById(String DYNAMIC_ID){
		return userDynamicDao.getUserDynamicEleById(DYNAMIC_ID);
	}
	
	/**
	 *　获取用户动态信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserDynamicCount(Map<String, Object> params) {
		return userDynamicDao.getUserDynamicCount(params);
	}
	
	/**
	 * 根据用户动态信息表ID获取用户动态信息表信息
	 * @param DYNAMIC_ID 用户动态信息表ID
	 * @return 返回用户动态信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserDynamicMapById(String DYNAMIC_ID){
		return userDynamicDao.getUserDynamicMapById(DYNAMIC_ID);
	}
	
	/**
	 * 获取用户动态信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户动态信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserDynamicList(Map<String, Object> params,int nowPage,int onePageCount){
		return userDynamicDao.getUserDynamicList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取用户动态信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户动态信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserDynamicList(Map<String, Object> params){
		return userDynamicDao.getUserDynamicList(params);
	}

}
