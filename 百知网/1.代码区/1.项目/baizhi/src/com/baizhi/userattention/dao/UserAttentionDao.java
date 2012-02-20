package com.baizhi.userattention.dao;

import org.dom4j.Element;
import org.hibernate.EntityMode;
import org.hibernate.Session;

import com.baizhi.IConstants;
import com.baizhi.commons.DaoSupport;
import com.baizhi.userdynamic.dao.UserDynamicDao;
import com.baizhi.usernotice.dao.UserNoticeDao;
/**
 * 
 * 类名：UserAttentionDao.java
 * 描述：用户关注人信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-07-01 00:54:40
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class UserAttentionDao extends DaoSupport{
	
	private UserNoticeDao userNoticeDao;
	
	private UserDynamicDao userDynamicDao;
	
	public UserNoticeDao getUserNoticeDao() {
		return userNoticeDao;
	}

	public void setUserNoticeDao(UserNoticeDao userNoticeDao) {
		this.userNoticeDao = userNoticeDao;
	}
	
	public UserDynamicDao getUserDynamicDao() {
		return userDynamicDao;
	}

	public void setUserDynamicDao(UserDynamicDao userDynamicDao) {
		this.userDynamicDao = userDynamicDao;
	}

	/**
	 * 关注用户
	 * 
	 * @param element  实体对象
	 * @param was_element  被关注实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveUserAttention(Element element,Element was_element) {
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		String idValue = "";
		try {
			dom4jSession.beginTransaction();
			dom4jSession.save(element);
			//如果被关注实体对象不为空，则修改被关注实体对象
			if(was_element!=null){
				dom4jSession.update(was_element);
			}
			//判断对方是否设置是屏蔽加我为好友，如果没有屏蔽则添加消息
			if(userNoticeDao.isUserNotice(Integer.parseInt(element.elementText("WAS_USERID")), IConstants.NoticeType.attentionMe, dom4jSession)){
				userDynamicDao.saveUserDynamic(Integer.parseInt(element.elementText("USER_ID")), "", Integer.parseInt(element.elementText("ATTENTION_ID")), IConstants.NoticeType.attentionMe, "关注了你", Integer.parseInt(element.elementText("WAS_USERID")), dom4jSession);
			}
			dom4jSession.getTransaction().commit();
			idValue = element.elementText("ATTENTION_ID");
		} catch (Exception e) {
			dom4jSession.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return idValue;
	}
	
	/**
	 *　取消用户关注
	 * 
	 * @param element  实体对象
	 * @param was_element  被关注实体对象
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean cancelUserAttention(Element element,Element was_element) {
		
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		boolean flag=false;
		try {
			dom4jSession.beginTransaction();
			dom4jSession.delete(element);
			//如果被关注实体对象不为空，则修改被关注实体对象
			if(was_element!=null){
				dom4jSession.update(was_element);
			}
			dom4jSession.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			dom4jSession.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return flag;
		
	}
	
	/**
	 * 根据用户关注人信息表ID获取用户关注人信息表实体
	 * @param USER_ID 用户ID
	 * @param WAS_USERID 被关注人ID
	 * @return 返回用户关注人信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserAttentionEleById(int USER_ID,int WAS_USERID){
		//组织查询语句
		String sql = "FROM T_USER_ATTENTION where USER_ID=? and WAS_USERID=?";
		return this.getElementById(sql.toString(), new Object[]{USER_ID,WAS_USERID});
	}
	
}

