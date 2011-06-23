package com.baizhi.userinvite.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.userinvite.dao.UserInviteDao;
/**
 * 
 * 类名：UserInviteService.java
 * 描述： 用户邀请信息表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-06-23 22:20:22
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class UserInviteService extends ServiceSupport{
	
	private static final long serialVersionUID = 5960475101643538410L;
	
	private UserInviteDao userInviteDao;
	
	public UserInviteDao getUserInviteDao() {
		return userInviteDao;
	}

	public void setUserInviteDao(UserInviteDao userInviteDao) {
		this.userInviteDao = userInviteDao;
	}
	
	/**
	 * 新增或修改用户邀请信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserInvite(Element element) {
		return userInviteDao.saveOrUpdateUserInvite(element);
	}
	
	/**
	 * 新增用户邀请信息表信息
	 * 
	 * @param  list  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public boolean saveUserInvite(List<Element> list) {
		return userInviteDao.saveUserInvite(list);
	}
	
	/**
	 *　删除用户邀请信息表信息
	 * 
	 * @param INVITE_IDS  用户邀请信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserInvite(String INVITE_IDS) {
		return userInviteDao.deleteUserInvite(INVITE_IDS);
	}
	
	/**
	 * 根据用户邀请信息表ID获取用户邀请信息表实体
	 * @param INVITE_ID 用户邀请信息表ID
	 * @return 返回用户邀请信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserInviteEleById(String INVITE_ID){
		return userInviteDao.getUserInviteEleById(INVITE_ID);
	}
	
	/**
	 *　获取用户邀请信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserInviteCount(Map<String, Object> params) {
		return userInviteDao.getUserInviteCount(params);
	}
	
	/**
	 * 根据用户邀请信息表ID获取用户邀请信息表信息
	 * @param INVITE_ID 用户邀请信息表ID
	 * @return 返回用户邀请信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserInviteMapById(String INVITE_ID){
		return userInviteDao.getUserInviteMapById(INVITE_ID);
	}
	
	/**
	 * 获取用户邀请信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户邀请信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserInviteList(Map<String, Object> params,int nowPage,int onePageCount){
		return userInviteDao.getUserInviteList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取用户邀请信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户邀请信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserInviteList(Map<String, Object> params){
		return userInviteDao.getUserInviteList(params);
	}

}
