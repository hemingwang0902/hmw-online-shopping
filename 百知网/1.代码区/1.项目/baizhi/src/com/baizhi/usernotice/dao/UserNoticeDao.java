package com.baizhi.usernotice.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
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
	 * 修改用户通知设置表信息
	 * @param USER_ID  用户ID
	 * @param types  通知类型
	 * @param vals  设置类型 
	 * @return 返回主键ID,失败返回""
	 */
	public boolean updateUserNotice(int USER_ID,int[] types,String[] vals) {
		Session session = getSession();
		String sql="update T_USER_NOTICE set SET_TYPE=? where USER_ID=? and NOTICE_TYPE=?";
		try {
			session.beginTransaction();
			for (int i = 0; i < types.length; i++) {
				Query query = session.createQuery(sql);
				query.setString(0, vals[i]);
				query.setInteger(1, USER_ID);
				query.setInteger(2, types[i]);
				query.executeUpdate();
			}
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.beginTransaction().rollback();
			e.printStackTrace();
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
	
	@SuppressWarnings("unchecked")
	/**
	 *　判断是否发送消息
	 *
	 * @param USER_ID      用户ID
	 * @param NOTICE_TYPE  通知类型 1：有人关注了我、2：有人问了我一个问题、3：有人邀请我回答一个问题、4：我关注的问题有了新答案、5：有人关注了我的品牌、6：谁可以给我发私信
	 * 
	 * @return 返回是否发送通知消息，发送返回true，不发送返回false
	 */
	public boolean isUserNotice(Integer USER_ID,Integer NOTICE_TYPE,Session session) throws Exception{
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT SET_TYPE FROM T_USER_NOTICE a WHERE a.USER_ID=? ");
		boolean flag=false;
		int SET_TYPE=-1;
		Query query = setQueryParameters(session.createQuery(sql.toString()), new Object[]{USER_ID,NOTICE_TYPE});
		List list=query.list();
		if(list!=null&&list.size()>0){
			SET_TYPE=Integer.parseInt(String.valueOf(list.get(0)));
		}
		if(SET_TYPE==-1||SET_TYPE==1){
			flag=true;
		}
		return flag;
	}
	
}

