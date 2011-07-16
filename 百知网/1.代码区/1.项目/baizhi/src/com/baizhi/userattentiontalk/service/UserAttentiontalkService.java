package com.baizhi.userattentiontalk.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.userattentiontalk.dao.UserAttentiontalkDao;

/**
 * 类名：UserAttentiontalkService.java<br>
 * 描述： 用户关注话题信息表服务类，负责增删改查<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-16 14:04:18<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class UserAttentiontalkService extends ServiceSupport{
	private static final long serialVersionUID = -4211688679704830833L;
	private UserAttentiontalkDao userAttentiontalkDao;
	
	public UserAttentiontalkDao getUserAttentiontalkDao() {
		return userAttentiontalkDao;
	}

	public void setUserAttentiontalkDao(UserAttentiontalkDao userAttentiontalkDao) {
		this.userAttentiontalkDao = userAttentiontalkDao;
	}
	
	/**
	 * 新增或修改用户关注话题信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserAttentiontalk(Element element) {
		return userAttentiontalkDao.saveOrUpdateUserAttentiontalk(element);
	}
	
	/**
	 *　删除用户关注话题信息表信息
	 * 
	 * @param ATTENTIONTALK_IDS  用户关注话题信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserAttentiontalk(String ATTENTIONTALK_IDS) {
		return userAttentiontalkDao.deleteUserAttentiontalk(ATTENTIONTALK_IDS);
	}
	
	/**
	 * 根据用户关注话题信息表ID获取用户关注话题信息表实体
	 * @param ATTENTIONTALK_ID 用户关注话题信息表ID
	 * @return 返回用户关注话题信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserAttentiontalkEleById(String ATTENTIONTALK_ID){
		return userAttentiontalkDao.getUserAttentiontalkEleById(ATTENTIONTALK_ID);
	}
	
	/**
	 *　获取用户关注话题信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserAttentiontalkCount(Map<String, Object> params) {
		return userAttentiontalkDao.getUserAttentiontalkCount(params);
	}
	
	/**
	 * 根据用户关注话题信息表ID获取用户关注话题信息表信息
	 * @param ATTENTIONTALK_ID 用户关注话题信息表ID
	 * @return 返回用户关注话题信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserAttentiontalkMapById(String ATTENTIONTALK_ID){
		return userAttentiontalkDao.getUserAttentiontalkMapById(ATTENTIONTALK_ID);
	}
	
	/**
	 * 获取用户关注话题信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户关注话题信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserAttentiontalkList(Map<String, Object> params,int nowPage,int onePageCount){
		return userAttentiontalkDao.getUserAttentiontalkList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取用户关注话题信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户关注话题信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserAttentiontalkList(Map<String, Object> params){
		return userAttentiontalkDao.getUserAttentiontalkList(params);
	}
	
	public Element getUserAttentionEleById(int USER_ID, int TALK_ID){
		return userAttentiontalkDao.getUserAttentionEleById(USER_ID, TALK_ID);
	}

}
