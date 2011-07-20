package com.baizhi.index.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.baizhi.IConstants;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.PagerSupport;
import com.baizhi.commons.support.DateUtils;
/**
 * 
 * 类名：PqlbDao.java
 * 描述：品牌列表数据操作类
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class PqlbDao extends DaoSupport{
	
	private static final String ALL_BRAND_FIELD = "a.BRAND_ID as BRAND_ID, a.USER_ID as USER_ID, a.NAME as NAME, a.INTRODUCTION as INTRODUCTION, a.SOURCE as SOURCE, a.PROVINCE as PROVINCE, a.CITY as CITY, a.INDUSTRY as INDUSTRY, a.LINK_NAME as LINK_NAME, a.LINK_MODE as LINK_MODE, a.EMAIL as EMAIL, a.IMAGE_PATH as IMAGE_PATH, a.STAUS as STAUS, a.AUDIT_ID as AUDIT_ID, a.AUDIT_TIME as AUDIT_TIME, a.REASON as REASON, a.REMARK as REMARK, a.BRAND_LABEL as BRAND_LABEL, a.CREATE_TIME as CREATE_TIME, a.MODIFY_TIME as MODIFY_TIME";
	
	/**
	 * 获取热点品牌及最新品牌
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回品牌基本信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getBrandList(int nowPage,int onePageCount){
		StringBuffer sql = new StringBuffer();
		Map<String,Object> returnMap = new HashMap<String, Object>();
		Session session = super.getSession();
		try {
			//最新品牌
			sql.append("SELECT new Map(")
			   .append("a.BRAND_ID as BRAND_ID,")//品牌信息ID
			   .append("a.USER_ID as USER_ID,")//用户ID
			   .append("a.NAME as NAME,")//姓名/品牌名称
			   .append("a.INTRODUCTION as INTRODUCTION,")//个人介绍/品牌介绍
			   .append("a.IMAGE_PATH as IMAGE_PATH)")//相片路径/LOGO路径
			   .append("FROM T_USER_BRAND a,T_USER b ")
			   .append("WHERE a.USER_ID=b.USER_ID and a.STAUS=3 ")
			   .append("and  ('"+DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT)+"'>b.LAST_FREEZETIME or b.LAST_FREEZETIME is null) ")
			   .append(" order by  a.CREATE_TIME DESC ");
			List<Map<String, Object>> newlist = PagerSupport.getList(session, session.createQuery(sql.toString()),nowPage, onePageCount);
			if(newlist!=null&&newlist.size()>0){
				returnMap.put("newlist", newlist);
			}
			//最热品牌
			sql = new StringBuffer();
			sql.append("SELECT new Map(")
			   .append("a.BRAND_ID as BRAND_ID,")//品牌信息ID
			   .append("a.USER_ID as USER_ID,")//用户ID
			   .append("a.NAME as NAME,")//姓名/品牌名称
			   .append("a.INTRODUCTION as INTRODUCTION,")//个人介绍/品牌介绍
			   .append("a.IMAGE_PATH as IMAGE_PATH,")//相片路径/LOGO路径
			   .append("count(c.BATTENTION_ID) as BATTENTION_COUNT)")//发表问题数量
			   .append("FROM T_USER_BRAND a,T_USER_BASIC b,T_USER_BATTENTION c ")
			   .append("WHERE a.USER_ID=b.USER_ID and a.BRAND_ID=c.BRAND_ID  and a.STAUS=3  ")
			   .append(" group by a.BRAND_ID,a.USER_ID,b.NAME,b.INTRODUCTION,b.IMAGE_PATH order by BATTENTION_COUNT DESC ");
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
	 * 获取品牌信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return
	 */
	public Map<String,Object> getPqlbList(Map<String, Object> params,int nowPage,int onePageCount){
		
		StringBuffer sql = new StringBuffer();
		if(params.get("myself")!=null){
			sql.append("SELECT new Map(")
			   .append("a.BRAND_ID as BRAND_ID,")
			   .append("a.USER_ID as USER_ID,")
			   .append("a.NAME as NAME,")
			   .append("a.INTRODUCTION as INTRODUCTION,")
			   .append("a.IMAGE_PATH as IMAGE_PATH,")
			   .append("'1' as IS_ATTENTION ) ")
			   .append("FROM T_USER_BRAND a,T_USER_BATTENTION b where a.BRAND_ID=b.BRAND_ID and a.STAUS=3 and b.USER_ID=? order by a.CREATE_TIME DESC ");
		}else{
			sql.append("SELECT new Map(")
			   .append("a.BRAND_ID as BRAND_ID,")
			   .append("a.USER_ID as USER_ID,")
			   .append("a.NAME as NAME,")
			   .append("a.INTRODUCTION as INTRODUCTION,")
			   .append("a.IMAGE_PATH as IMAGE_PATH,")
			   .append("(select count(*) from T_USER_BATTENTION where BRAND_ID=a.BRAND_ID and USER_ID=?) as IS_ATTENTION ) ")
			   .append("FROM T_USER_BRAND a where a.STAUS=3   order by CREATE_TIME DESC ");
		}
		Map<String,Object> returnMap = null;
		Session session = getSession();
		try {
			Object[] condition=new Object[]{params.get("USER_ID")};
			Query query = setQueryParameters(session.createQuery(sql.toString()),condition );
			returnMap = PagerSupport.getList(session, query, "T_USER_BRAND", condition,nowPage, onePageCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return returnMap;
	}
	
	
	/**
	 * 最热品牌
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String, Object> getHottestBrand(int nowPage, int onePageCount){
		StringBuffer sql = new StringBuffer()
		.append("select ").append(ALL_BRAND_FIELD)
		.append(", (select count(ub.BATTENTION_ID) from T_USER_BATTENTION ub where ub.BRAND_ID=a.BRAND_ID) as ATTENTION_COUNT") 
		.append(" from T_USER_BRAND a")
		.append(" where a.STAUS=").append(IConstants.BRAND_STAUS_PASSED)
		.append(" order by ATTENTION_COUNT desc");
		
		Object[] params = new Object[] {};
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 最新品牌
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String, Object> getLastestBrand(int nowPage, int onePageCount){
		StringBuffer sql = new StringBuffer()
		.append("select ").append(ALL_BRAND_FIELD)
		.append(" from T_USER_BRAND a")
		.append(" where a.STAUS=").append(IConstants.BRAND_STAUS_PASSED)
		.append(" order by a.CREATE_TIME desc");
		
		Object[] params = new Object[] {};
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
}
