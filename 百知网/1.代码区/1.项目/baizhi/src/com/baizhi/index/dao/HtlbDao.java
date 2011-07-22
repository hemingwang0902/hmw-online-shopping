package com.baizhi.index.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.PagerSupport;
import com.baizhi.commons.support.DateUtils;

/**
 * 类名： HtlbDao.java<br>
 * 描述：话题页面<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午07:00:31<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class HtlbDao extends DaoSupport{
	private final String ALL_TALK_FIELDS = "t.TALK_ID as TALK_ID,t.CONTENT as CONTENT,t.USER_ID as USER_ID,t.INTRODUCTION as INTRODUCTION,t.IMAGE_PATH as IMAGE_PATH,t.CREATE_TIME as CREATE_TIME,t.MODIFY_TIME as MODIFY_TIME";
	
	/**
	 * 获取热点话题及最新话题
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回话题基本信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getTalkList(int nowPage,int onePageCount){
		StringBuffer sql = new StringBuffer();
		Map<String,Object> returnMap = new HashMap<String, Object>();
		Session session = super.getSession();
		try {
			//最新话题
			sql.append("SELECT new Map(")
			   .append("a.TALK_ID as TALK_ID,")//话题信息ID
			   .append("a.USER_ID as USER_ID,")//用户ID
			   .append("a.CONTENT as NAME,")//姓名/话题名称
			   .append("a.INTRODUCTION as INTRODUCTION,")//个人介绍/话题介绍
			   .append("a.IMAGE_PATH as IMAGE_PATH) ")//相片路径/LOGO路径
			   .append("FROM T_TALK a,T_USER b ")
			   .append("WHERE a.USER_ID=b.USER_ID ")
			   .append("and  ('"+DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT)+"'>b.LAST_FREEZETIME or b.LAST_FREEZETIME is null) ")
			   .append(" order by  a.CREATE_TIME DESC ");
			List<Map<String, Object>> newlist = PagerSupport.getList(session, session.createQuery(sql.toString()),nowPage, onePageCount);
			if(newlist!=null&&newlist.size()>0){
				returnMap.put("newlist", newlist);
			}
			//最热话题
			sql = new StringBuffer();
			sql.append("SELECT new Map(")
			   .append("a.TALK_ID as TALK_ID,")//话题信息ID
			   .append("a.USER_ID as USER_ID,")//用户ID
			   .append("a.CONTENT as NAME,")//姓名/话题名称
			   .append("a.INTRODUCTION as INTRODUCTION,")//个人介绍/话题介绍
			   .append("a.IMAGE_PATH as IMAGE_PATH,")//相片路径/LOGO路径
			   .append("count(c.ATTENTIONTALK_ID) as BATTENTION_COUNT) ")//发表问题数量
			   .append("FROM T_TALK a,T_USER_BASIC b,T_USER_ATTENTIONTALK c ")
			   .append("WHERE a.USER_ID=b.USER_ID and a.TALK_ID=c.TALK_ID ")
			   .append(" group by a.TALK_ID,a.USER_ID,a.CONTENT,a.INTRODUCTION,a.IMAGE_PATH order by BATTENTION_COUNT DESC ");
			 List<Map<String, Object>> hotlist = PagerSupport.getList(session, session.createQuery(sql.toString()),nowPage, onePageCount);
			 if(hotlist!=null&&hotlist.size()>0){
					returnMap.put("hotlist", hotlist);
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return returnMap;
	}
	
	/**
	 * 获取话题信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return
	 */
	public Map<String,Object> getHtlbList(Map<String, Object> params,int nowPage,int onePageCount){
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.TALK_ID as TALK_ID,")
		   .append("a.USER_ID as USER_ID,")
		   .append("a.CONTENT as NAME,")
		   .append("a.INTRODUCTION as INTRODUCTION,")
		   .append("a.IMAGE_PATH as IMAGE_PATH,")
		   .append("(select count(*) from T_USER_ATTENTIONTALK where TALK_ID=a.TALK_ID and USER_ID=?) as IS_ATTENTION ) ")
		   .append("FROM T_TALK a  order by CREATE_TIME DESC ");
		
		Map<String,Object> returnMap = null;
		Session session = getSession();
		try {
			Object[] condition=new Object[]{params.get("USER_ID")};
			Query query = setQueryParameters(session.createQuery(sql.toString()),condition );
			returnMap = PagerSupport.getList(session, query, "T_TALK", null,nowPage, onePageCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return returnMap;
	}
	
	/**
	 * 查询最新话题列表(按照 createTime 倒序排列)
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getLastestTalkList(int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ")
		.append(ALL_TALK_FIELDS)
		.append(" FROM T_TALK t")
		.append(" ORDER BY t.CREATE_TIME DESC");
		
		return queryForListWithSQLQuery(sql.toString(), new Object[0], nowPage, onePageCount);
	}
	
	/**
	 * 查询最热话题列表(按照 attentionCount 倒序排列)
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getHottestTalkList(int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ")
		.append(ALL_TALK_FIELDS)
		.append(", (select count(uat.ATTENTIONTALK_ID) from T_USER_ATTENTIONTALK uat where uat.TALK_ID=t.TALK_ID) as ATTENTION_COUNT")
		.append(" FROM T_TALK t")
		.append(" ORDER BY ATTENTION_COUNT DESC");
		
		return queryForListWithSQLQuery(sql.toString(), new Object[0], nowPage, onePageCount);
	}
	
}
