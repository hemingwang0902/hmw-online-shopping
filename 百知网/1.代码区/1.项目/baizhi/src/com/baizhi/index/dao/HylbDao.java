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
 * 
 * 类名：HylbDao.java
 * 描述：会员列表页
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class HylbDao extends DaoSupport{
	
	/**
	 * 获取热点会员及最新会员
	 * @param USER_ID 用户ID
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户基本信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserList(Integer USER_ID,int nowPage,int onePageCount){
		StringBuffer sql = new StringBuffer();
		Map<String,Object> returnMap = new HashMap<String, Object>();
		Session session = super.getSession();
		try {
			//最新会员
			sql.append("SELECT new Map(")
			   .append("a.BASIC_ID as BASIC_ID,")//用户基本信息ID
			   .append("a.USER_ID as USER_ID,")//用户ID
			   .append("a.NAME as NAME,")//姓名/品牌名称
			   .append("a.INTRODUCTION as INTRODUCTION,")//个人介绍/品牌介绍
			   .append("a.IMAGE_PATH as IMAGE_PATH)")//相片路径/LOGO路径
			   .append("FROM T_USER_BASIC a,T_USER b ")
			   .append("WHERE a.USER_ID=b.USER_ID ")
			   .append("and  ('"+DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT)+"'>b.LAST_FREEZETIME or b.LAST_FREEZETIME is null) ")
			   .append(" order by  a.CREATE_TIME DESC ");
			List<Map<String, Object>> newlist = PagerSupport.getList(session, session.createQuery(sql.toString()),nowPage, onePageCount);
			if(newlist!=null&&newlist.size()>0){
				returnMap.put("newlist", newlist);
			}
			//最热会员
			sql = new StringBuffer();
			sql.append("SELECT new Map(")
			   .append("a.BASIC_ID as BASIC_ID,")//用户基本信息ID
			   .append("a.USER_ID as USER_ID,")//用户ID
			   .append("a.NAME as NAME,")//姓名/品牌名称
			   .append("a.INTRODUCTION as INTRODUCTION,")//个人介绍/品牌介绍
			   .append("a.IMAGE_PATH as IMAGE_PATH,")//相片路径/LOGO路径
			   .append("count(c.PROBLEM_ID) as PROBLEM_COUNT)")//发表问题数量
			   .append("FROM T_USER_BASIC a,T_USER b,T_PROBLEM c ")
			   .append("WHERE a.USER_ID=b.USER_ID and a.USER_ID=c.USER_ID ")
			   .append("and  ('"+DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT)+"'>b.LAST_FREEZETIME or b.LAST_FREEZETIME is null) ")
			   .append(" group by a.BASIC_ID,a.USER_ID,a.NAME,a.INTRODUCTION,a.IMAGE_PATH order by PROBLEM_COUNT DESC ");
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
	 * 获取用户基本信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户基本信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getHylbList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.BASIC_ID as BASIC_ID,")//用户基本信息ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.NAME as NAME,")//姓名/品牌名称
		   .append("a.INTRODUCTION as INTRODUCTION,")//个人介绍/品牌介绍
		   .append("a.IMAGE_PATH as IMAGE_PATH,")//相片路径/LOGO路径
		   .append("(select count(*) from T_USER_ATTENTION where WAS_USERID=a.USER_ID and USER_ID=?) as IS_ATTENTION ) ")//是否已关注
		   .append("FROM T_USER_BASIC a WHERE a.USER_TYPE in(1,2) and a.USER_ID<>? order by CREATE_TIME DESC ");
		//设置查询条件,及初始化查询条件值
		Map<String,Object> returnMap = null;
		Session session = getSession();
		try {
			Object[] condition=new Object[]{params.get("USER_ID"),params.get("USER_ID")};
			Query query = setQueryParameters(session.createQuery(sql.toString()),condition );
			returnMap = PagerSupport.getList(session, query, "T_USER_BASIC", null,nowPage, onePageCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return returnMap;
	}
}
