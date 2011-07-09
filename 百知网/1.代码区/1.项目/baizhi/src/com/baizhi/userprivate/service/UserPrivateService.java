package com.baizhi.userprivate.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.userprivate.dao.UserPrivateDao;
/**
 * 
 * 类名：UserPrivateService.java
 * 描述： 用户私信信息表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-07-05 00:26:42
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class UserPrivateService extends ServiceSupport{
	
	private static final long serialVersionUID = -6423365480339007655L;
	
	private UserPrivateDao userPrivateDao;
	
	public UserPrivateDao getUserPrivateDao() {
		return userPrivateDao;
	}

	public void setUserPrivateDao(UserPrivateDao userPrivateDao) {
		this.userPrivateDao = userPrivateDao;
	}
	
	/**
	 * 保存用户私信信息表信息
	 * 
	 * @param element1  主动实体对象
	 * @param element2  被动实体对象
	 * @return 成功返回true,失败返回false
	 */
	public boolean saveUserPrivate(Element element1,Element element2) {
		return userPrivateDao.saveUserPrivate(element1,element2);
	}
	
	/**
	 *　删除用户私信信息表信息
	 * 
	 * @param params  参数
	 * @return 返回boolean值,成功返回执行记录数　,失败返回-1
	 */
	public int deleteUserPrivate(Map<String, Object> params) {
		return userPrivateDao.deleteUserPrivate(params);
	}
	
	/**
	 *　删除用户私信信息表信息
	 * 
	 * @param params  参数
	 * @return 返回boolean值,成功返回执行记录数　,失败返回-1
	 */
	public int deleteUserByPrivate(Integer PRIVATE_ID,Integer USER_ID) {
		return userPrivateDao.deleteUserByPrivate(PRIVATE_ID,USER_ID);
	}
	/**
	 * 根据用户私信信息表ID获取用户私信信息表实体
	 * @param PRIVATE_ID 用户私信信息表ID
	 * @return 返回用户私信信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserPrivateEleById(String PRIVATE_ID){
		return userPrivateDao.getUserPrivateEleById(PRIVATE_ID);
	}
	
	/**
	 *　获取用户私信信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserPrivateCount(Map<String, Object> params) {
		return userPrivateDao.getUserPrivateCount(params);
	}
	
	/**
	 * 修改未阅读隐私
	 * @param USER_ID 用户ID
	 * @param SEND_ID 发件人ID
	 * @return 返回用户基本信息
	 */
	public Map<String,Object> ModifyNoReadPrivate(int USER_ID,int SEND_ID){
		return userPrivateDao.ModifyNoReadPrivate(USER_ID, SEND_ID);
	}
	
	/**
	 * 根据用户私信信息表ID获取用户私信信息表信息
	 * @param PRIVATE_ID 用户私信信息表ID
	 * @return 返回用户私信信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserPrivateMapById(String PRIVATE_ID){
		return userPrivateDao.getUserPrivateMapById(PRIVATE_ID);
	}
	
	/**
	 * 获取用户私信信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户私信信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserPrivateList(Map<String, Object> params,int nowPage,int onePageCount){
		return userPrivateDao.getUserPrivateList(params, nowPage, onePageCount);
	}
	
	/**
	 * 获取用户私信信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户私信信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserPrivateByList(Map<String, Object> params,int nowPage,int onePageCount){
		return userPrivateDao.getUserPrivateByList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取用户私信信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户私信信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserPrivateList(Map<String, Object> params){
		return userPrivateDao.getUserPrivateList(params);
	}

}
