package com.baizhi.userattentiontalk.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.hibernate.EntityMode;
import org.hibernate.Session;

import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
import com.baizhi.userdynamic.dao.UserDynamicDao;
import com.baizhi.usernotice.dao.UserNoticeDao;

 /**
 * 类名：UserAttentiontalkDao.java<br>
 * 描述：用户关注话题信息表数据操作类，负责增删改查<br>
 * 创建者： 何明旺<br>
 * 创建日期：2011-07-16 14:04:18<br>
 * 版本：V0.9<br>
 * 修改者：  <br>
 * 修改日期：
 */
public class UserAttentiontalkDao extends DaoSupport{

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
	 * 新增或修改用户关注话题信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserAttentiontalk(Element element) {
		return this.saveOrUpdate(element, "ATTENTIONTALK_ID");
	}
	
	/**
	 * 新增品牌关注话题信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String save(Element element) {
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		String keyid = "";
		try {
			dom4jSession.beginTransaction();
			Serializable serializableid = dom4jSession.save(element);
			if(serializableid!=null&&!serializableid.equals("")){
				keyid=serializableid.toString();
			}
			dom4jSession.getTransaction().commit();
		} catch (Exception e) {
			dom4jSession.beginTransaction().rollback();
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return keyid;
	}
	
	/**
	 *　删除用户关注话题信息表信息
	 * 
	 * @param ATTENTIONTALK_IDS   用户关注话题信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserAttentiontalk(String ATTENTIONTALK_IDS) {
		return this.delete("T_USER_ATTENTIONTALK","ATTENTIONTALK_ID", ATTENTIONTALK_IDS);
	}
	
	/**
	 * 取消用户关注
	 * @param TALK_ID 话题ID
	 * @param USER_ID  用户ID
	 * @return
	 */
	public boolean cancel(Integer TALK_ID,Integer USER_ID) {
		int count=-1;
		count=this.executeUpdate("delete from T_USER_ATTENTIONTALK where TALK_ID=? and USER_ID=?", new Object[]{TALK_ID,USER_ID});
		if(count>0){
			return true;
		}
		return false;
	}
	
	
	/**
	 * 根据用户关注话题信息表ID获取用户关注话题信息表实体
	 * @param ATTENTIONTALK_ID 用户关注话题信息表ID
	 * @return 返回用户关注话题信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserAttentiontalkEleById(String ATTENTIONTALK_ID){
		return this.getElementById("T_USER_ATTENTIONTALK", "ATTENTIONTALK_ID", ATTENTIONTALK_ID);
	}
	
	/**
	 *　获取用户关注话题信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserAttentiontalkCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_USER_ATTENTIONTALK a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据用户关注话题信息表ID获取用户关注话题信息表信息
	 * @param ATTENTIONTALK_ID 用户关注话题信息表ID
	 * @return 返回用户关注话题信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserAttentiontalkMapById(String ATTENTIONTALK_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.ATTENTIONTALK_ID as ATTENTIONTALK_ID,")//用户关注话题ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.TALK_ID as TALK_ID,")//问题话题ID
		   .append("a.IS_ATTENTION as IS_ATTENTION,")//是否关注(0否、1是)
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_ATTENTIONTALK a WHERE a.ATTENTIONTALK_ID=? ");
		return this.getById(sql.toString(), new Object[]{ATTENTIONTALK_ID});
	}
	
	/**
	 * 获取用户关注话题信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户关注话题信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserAttentiontalkList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.ATTENTIONTALK_ID as ATTENTIONTALK_ID,")//用户关注话题ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.TALK_ID as TALK_ID,")//问题话题ID
		   .append("a.IS_ATTENTION as IS_ATTENTION,")//是否关注(0否、1是)
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_ATTENTIONTALK a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_USER_ATTENTIONTALK", nowPage, onePageCount);
	}
	
	/**
     * 获取用户关注话题信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户关注话题信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserAttentiontalkList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.ATTENTIONTALK_ID as ATTENTIONTALK_ID,")//用户关注话题ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.TALK_ID as TALK_ID,")//问题话题ID
		   .append("a.IS_ATTENTION as IS_ATTENTION,")//是否关注(0否、1是)
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_ATTENTIONTALK a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
	public Element getUserAttentionEleById(int USER_ID, int TALK_ID){
		String sql = "FROM T_USER_ATTENTIONTALK where USER_ID=? and TALK_ID=?";
		return this.getElementById(sql.toString(), new Object[]{USER_ID,TALK_ID});
	}
}

