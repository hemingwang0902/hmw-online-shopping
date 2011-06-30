package com.baizhi.userattention.service;

import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.userattention.dao.UserAttentionDao;
/**
 * 
 * 类名：UserAttentionService.java
 * 描述： 用户关注人信息表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-07-01 00:54:40
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class UserAttentionService extends ServiceSupport{
	
	private static final long serialVersionUID = -2113343597899435839L;
	
	private UserAttentionDao userAttentionDao;
	
	public UserAttentionDao getUserAttentionDao() {
		return userAttentionDao;
	}

	public void setUserAttentionDao(UserAttentionDao userAttentionDao) {
		this.userAttentionDao = userAttentionDao;
	}
	
	/**
	 * 关注用户
	 * 
	 * @param element  实体对象
	 * @param was_element  被关注实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveUserAttention(Element element,Element was_element) {
		return userAttentionDao.saveUserAttention(element,was_element);
	}
	
	/**
	 *　取消用户关注
	 * 
	 * @param element  实体对象
	 * @param was_element  被关注实体对象
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean cancelUserAttention(Element element,Element was_element) {
		return userAttentionDao.cancelUserAttention(element,was_element);
	}
	
	/**
	 * 根据用户关注人信息表ID获取用户关注人信息表实体
	 * @param USER_ID 用户ID
	 * @param WAS_USERID 被关注人ID
	 * @return 返回用户关注人信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserAttentionEleById(int USER_ID,int WAS_USERID){
		return userAttentionDao.getUserAttentionEleById(USER_ID,WAS_USERID);
	}
	

}
