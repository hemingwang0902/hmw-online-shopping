package com.baizhi.userbattention.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
import com.baizhi.userbrand.dao.UserBrandDao;
import com.baizhi.userdynamic.dao.UserDynamicDao;
import com.baizhi.usernotice.dao.UserNoticeDao;

 /**
 * 类名：UserBattentionDao.java<br>
 * 描述：用户关注品牌信息表数据操作类，负责增删改查<br>
 * 创建者： 何明旺<br>
 * 创建日期：2011-07-10 13:47:10<br>
 * 版本：V0.9<br>
 * 修改者：  <br>
 * 修改日期：
 */
public class UserBattentionDao extends DaoSupport{
	
	private UserNoticeDao userNoticeDao;
	
	private UserDynamicDao userDynamicDao;
	
	private UserBrandDao userBrandDao;
	
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
	
	public UserBrandDao getUserBrandDao() {
		return userBrandDao;
	}

	public void setUserBrandDao(UserBrandDao userBrandDao) {
		this.userBrandDao = userBrandDao;
	}

	/**
	 * 新增或修改用户关注品牌信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserBattention(Element element) {
		return this.saveOrUpdate(element, "BATTENTION_ID");
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * 新增品牌关注品牌信息表信息
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
			Integer BRAND_ID=Integer.parseInt(element.elementText("BRAND_ID"));
			//新增关注品牌人数
			userBrandDao.modifyAttUserCount(BRAND_ID, 1, dom4jSession);
			//判断对方是否设置是屏蔽关注我的品牌提醒，如果没有屏蔽则添加消息
			//获取新增品牌人
			List<Map<String, Object>> list=setQueryParameters(session.createQuery("select new Map(a.USER_ID as USER_ID,b.NAME as NAME) from T_USER_BATTENTION a,T_USER_BRAND b where a.BRAND_ID=b.BRAND_ID and a.BRAND_ID=?"), new Object[]{BRAND_ID}).list();
			if(list!=null&&list.size()>0){
				Map<String, Object> newMap = list.get(0);
				Integer USER_ID=Integer.parseInt(String.valueOf(newMap.get("USER_ID")));
				String NAME=String.valueOf(newMap.get("NAME"));
				if(userNoticeDao.isUserNotice(USER_ID, 5, dom4jSession)){
					userDynamicDao.saveUserDynamic(Integer.parseInt(element.elementText("USER_ID")), "", Integer.parseInt(keyid), "5", "<span onclick=\"location.href='../index/initPpym.go?BRAND_ID="+BRAND_ID+"';\">关注了《"+NAME+"》</span>", USER_ID, dom4jSession);
				}
			}else{
				dom4jSession.getTransaction().rollback();
			}
			
			dom4jSession.getTransaction().commit();
		} catch (Exception e) {
			dom4jSession.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return keyid;
	}
	
	/**
	 * 取消用户关注
	 * @param BRAND_ID 品牌ID
	 * @param USER_ID  用户ID
	 * @return
	 */
	public boolean cancel(Integer BRAND_ID,Integer USER_ID) {
		int count=-1;
		Session session = getSession();
		try {
			session.beginTransaction();
			count = setQueryParameters(session.createQuery("delete from T_USER_BATTENTION where BRAND_ID=? and USER_ID=?"), new Object[]{BRAND_ID,USER_ID}).executeUpdate();
			//删除关注品牌人数
			userBrandDao.modifyAttUserCount(BRAND_ID, -1, session);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		if(count>0){
			return true;
		}
		return false;
	}
	
	
	/**
	 *　删除用户关注品牌信息表信息
	 * 
	 * @param BATTENTION_IDS   用户关注品牌信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserBattention(String BATTENTION_IDS) {
		return this.delete("T_USER_BATTENTION","BATTENTION_ID", BATTENTION_IDS);
	}
	
	/**
	 * 根据用户关注品牌信息表ID获取用户关注品牌信息表实体
	 * @param BATTENTION_ID 用户关注品牌信息表ID
	 * @return 返回用户关注品牌信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserBattentionEleById(String BATTENTION_ID){
		return this.getElementById("T_USER_BATTENTION", "BATTENTION_ID", BATTENTION_ID);
	}
	
	
	/**
	 *　获取用户关注品牌信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserBattentionCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_USER_BATTENTION a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据用户关注品牌信息表ID获取用户关注品牌信息表信息
	 * @param BATTENTION_ID 用户关注品牌信息表ID
	 * @return 返回用户关注品牌信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserBattentionMapById(String BATTENTION_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.BATTENTION_ID as BATTENTION_ID,")//用户关注品牌ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.BRAND_ID as BRAND_ID,")//被关注品牌
		   .append("a.IS_ATTENTION as IS_ATTENTION,")//是否关注(0否、1是)
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_BATTENTION a WHERE a.BATTENTION_ID=? ");
		return this.getById(sql.toString(), new Object[]{BATTENTION_ID});
	}
	
	/**
	 * 获取用户关注品牌信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户关注品牌信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserBattentionList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.BATTENTION_ID as BATTENTION_ID,")//用户关注品牌ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.BRAND_ID as BRAND_ID,")//被关注品牌
		   .append("a.IS_ATTENTION as IS_ATTENTION,")//是否关注(0否、1是)
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_BATTENTION a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_USER_BATTENTION", nowPage, onePageCount);
	}
	
	/**
     * 获取用户关注品牌信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户关注品牌信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserBattentionList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.BATTENTION_ID as BATTENTION_ID,")//用户关注品牌ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.BRAND_ID as BRAND_ID,")//被关注品牌
		   .append("a.IS_ATTENTION as IS_ATTENTION,")//是否关注(0否、1是)
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_BATTENTION a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}

	public  Element getUserBattentionEleById(int USER_ID, int BRAND_ID){
		//组织查询语句
		String sql = "FROM T_USER_BATTENTION where USER_ID=? and BRAND_ID=?";
		return this.getElementById(sql.toString(), new Object[]{USER_ID, BRAND_ID});
	}
}