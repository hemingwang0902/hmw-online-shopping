package com.baizhi.index.dao;

import java.util.Map;

import com.baizhi.IConstants;
import com.baizhi.commons.DaoSupport;
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
