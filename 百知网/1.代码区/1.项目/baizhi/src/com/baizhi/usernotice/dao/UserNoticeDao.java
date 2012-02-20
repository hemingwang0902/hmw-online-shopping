package com.baizhi.usernotice.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import org.hibernate.EntityMode;
import org.hibernate.Query;
import org.hibernate.Session;

import com.baizhi.IConstants;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
 /**
 * 
 * 类名：UserNoticeDao.java
 * 描述：用户通知设置表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-07-07 00:19:12
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class UserNoticeDao extends DaoSupport{
	
	/**
	 * 初始化消息设置信息
	 * @param USER_ID 用户ID
	 * @param session 数据库连接
	 * @return
	 * @throws Exception
	 */
	public boolean initUserNotice(Integer USER_ID,Session dom4jSession) throws Exception {
		IConstants.NoticeType[] noticeTypes = IConstants.NoticeType.values();
		for (int i = 0; i < noticeTypes.length; i++) {
			dom4jSession.save(this.getEle(USER_ID, noticeTypes[i].key, noticeTypes[i].defaultVal));
		}
		return true;
	}

	public boolean insertUserNotice(Integer userId, int noticetype, int setType,Session dom4jSession) throws Exception {
	    dom4jSession.save(this.getEle(userId, noticetype, setType));
	    return true;
	}
	
	/**
	 * 获取实体 
	 * @param USER_ID
	 * @param NOTICE_TYPE
	 * @param SET_TYPE
	 * @return
	 */
	private Element getEle(Integer USER_ID,Integer NOTICE_TYPE,Integer SET_TYPE) throws Exception{
		Element element = new DefaultElement("T_USER_NOTICE");
		Elements.setElementValue(element, "USER_ID", USER_ID);// 用户ID
		Elements.setElementValue(element, "NOTICE_TYPE", NOTICE_TYPE);// 通知类型(1：有人关注了我、2：有人问了我一个问题、3：有人邀请我回答一个问题、4：我关注的问题有了新答案、5：有人向我发送私信、6：谁可以给我发私信)
		Elements.setElementValue(element, "SET_TYPE", SET_TYPE);// 设置类型(0：否、1：是、3：所有人、4：我关注的人)
		Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		return element;
	}
	
	
	
	/**
	 * 修改用户通知设置表信息
	 * @param USER_ID  用户ID
	 * @param types  通知类型
	 * @return 返回<code>true</code>,失败返回 <code>false</code>
	 */
	public boolean updateUserNotice(int USER_ID, Map<Integer, Integer> types) {
		Session session = getSession().getSession(EntityMode.DOM4J);
		String sql="update T_USER_NOTICE set SET_TYPE=? where USER_ID=? and NOTICE_TYPE=?";
		try {
			session.beginTransaction();
			for (Iterator<Map.Entry<Integer, Integer>> iter = types.entrySet().iterator(); iter.hasNext();) {
			    Map.Entry<Integer, Integer> entry = iter.next();
                Query query = session.createQuery(sql);
                query.setInteger(0, entry.getValue());
                query.setInteger(1, USER_ID);
                query.setInteger(2, entry.getKey());
                int rows = query.executeUpdate();
                if(rows == 0){
                    insertUserNotice(USER_ID, entry.getKey(), entry.getValue(), session);
                }
            }
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			log.error("修改用户的通知设置信息失败！", e);
		} finally {
			session.close();
		}
		return false;
	}
	
	/**
     * 获取用户通知设置表信息
     * 
     * @param  params 参数
     * @return 成功返回用户通知设置表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserNoticeList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.NOTICE_ID as NOTICE_ID,")//通知ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.NOTICE_TYPE as NOTICE_TYPE,")//通知类型(1：有人关注了我、2：有人问了我一个问题、3：有人邀请我回答一个问题、4：我关注的问题有了新答案、5：有人向我发送私信、6：谁可以给我发私信)
		   .append("a.SET_TYPE as SET_TYPE) ")//设置类型(0：否、1：是、3：所有人、4：我关注的人)
		   .append("FROM T_USER_NOTICE a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions()+" order by NOTICE_TYPE ASC ");
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
	/**
	 *　判断是否发送消息
	 *
	 * @param USER_ID      用户ID
	 * @param NOTICE_TYPE  通知类型 1：有人关注了我、2：有人问了我一个问题、3：有人邀请我回答一个问题、4：我关注的问题有了新答案、5：有人关注了我的品牌、6：谁可以给我发私信
	 * 
	 * @return 返回是否发送通知消息，发送返回true，不发送返回false
	 */
	public boolean isUserNotice(Integer USER_ID, IConstants.NoticeType NOTICE_TYPE,Session session) throws Exception{
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT SET_TYPE FROM T_USER_NOTICE a WHERE a.USER_ID=? and NOTICE_TYPE=? ");
		boolean flag=false;
		int SET_TYPE=-1;
		Query query = setQueryParameters(session.createQuery(sql.toString()), new Object[]{USER_ID, NOTICE_TYPE.key});
		List<?> list=query.list();
		if(list!=null&&list.size()>0){
			SET_TYPE=Integer.parseInt(String.valueOf(list.get(0)));
		}
		if(SET_TYPE==-1||SET_TYPE==1){
			flag=true;
		}
		return flag;
	}
	
}

