package com.baizhi.index.dao;

import java.util.List;
import java.util.Map;

import com.baizhi.IConstants;
import com.baizhi.commons.DaoSupport;

public class PpymDao extends DaoSupport{
	private final String ALL_USER_BRAND_FIELDS = " UB.BRAND_ID as BRAND_ID, UB.USER_ID as USER_ID, UB.NAME as NAME, UB.INTRODUCTION as INTRODUCTION, UB.SOURCE as SOURCE, UB.PROVINCE as PROVINCE, UB.CITY as CITY, UB.INDUSTRY as INDUSTRY, UB.LINK_NAME as LINK_NAME, UB.LINK_MODE as LINK_MODE, UB.EMAIL as EMAIL, UB.IMAGE_PATH as IMAGE_PATH, UB.STAUS as STAUS, UB.AUDIT_ID as AUDIT_ID, UB.AUDIT_TIME as AUDIT_TIME, UB.REASON as REASON, UB.REMARK as REMARK, UB.CREATE_TIME as CREATE_TIME, UB.MODIFY_TIME as MODIFY_TIME ";
	private final String ALL_USER_BASIC_FIELDS = " UB.BASIC_ID as BASIC_ID, UB.USER_ID as USER_ID, UB.USER_TYPE as USER_TYPE, UB.NAME as NAME, UB.SOURCE as SOURCE, UB.PROVINCE as PROVINCE, UB.CITY as CITY, UB.INDUSTRY as INDUSTRY, UB.YEARS as YEARS, UB.LINK_MODE as LINK_MODE, UB.IS_OPEN as IS_OPEN, UB.INTRODUCTION as INTRODUCTION, UB.MOTTO as MOTTO, UB.IMAGE_PATH as IMAGE_PATH, UB.WEBSITE as WEBSITE, UB.PRIVATE_SET as PRIVATE_SET, UB.LEVEL as LEVEL, UB.SCORE as SCORE, UB.REMARK as REMARK, UB.CREATE_TIME as CREATE_TIME, UB.MODIFY_TIME as MODIFY_TIME ";
	private final String ALL_PROBLEM_FIELDS = " a.PROBLEM_ID as PROBLEM_ID,a.PROBLEM_TYPE as PROBLEM_TYPE,a.CONTENT as CONTENT,a.IS_ANONYMITY as IS_ANONYMITY,a.RELEVANT_DETAILS as RELEVANT_DETAILS,a.USER_ID as USER_ID,a.WAS_USERID as WAS_USERID,a.ANSWER_COUNT as ANSWER_COUNT,a.REVIEW_COUNT as REVIEW_COUNT,a.ATTENTION_COUNT as ATTENTION_COUNT,a.COLLECTION_COUNT as COLLECTION_COUNT,a.BROWSE_COUNT as BROWSE_COUNT,a.IS_REPORT as IS_REPORT,a.REPORT_COUNT as REPORT_COUNT,a.CREATE_TIME as CREATE_TIME,a.MODIFY_TIME as MODIFY_TIME ";
	
	/**
	 * 根据品牌ID，查询品牌详细信息
	 * @param BRAND_ID 品牌ID
	 * @param 当前页
	 * @param onePageCount 每页显示的记录条数
	 * @return 查询到的结果集
	 */
	public Map<String,Object> getBrandById(int BRAND_ID, int loginUserId){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ").append(ALL_USER_BRAND_FIELDS)
		.append(", (select count(uba.BATTENTION_ID) from T_USER_BATTENTION uba where uba.BRAND_ID=ub.BRAND_ID and uba.USER_ID=?) as ATTENTION")
		.append(" FROM T_USER_BRAND ub")
		.append(" WHERE ub.BRAND_ID=?")
		.append(" AND ub.STAUS=").append(IConstants.BRAND_STAUS_PASSED);
		
		Object[] params = new Object[]{loginUserId, BRAND_ID};
		List<Map<String,Object>> list = queryForListWithSQLQuery(sql.toString(), params);
		if(list == null || list.isEmpty())
			return null;
		return list.get(0);
	}
	
	/**
	 * 根据品牌的ID，查询关注该品牌的用户
	 * @param BRAND_ID 品牌ID
	 * @param 当前页
	 * @param onePageCount 每页显示的记录条数
	 * @return 查询到的结果集
	 */
	public Map<String,Object> getWasAttentionUserListByBrandId(int BRAND_ID, int nowPage, int onePageCount){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ").append(ALL_USER_BASIC_FIELDS)
		.append(" FROM T_USER_BASIC ub, T_USER_BATTENTION UA")
		.append(" WHERE ub.USER_ID=UA.USER_ID")
		.append(" AND UA.BRAND_ID=?")
		.append(" order by ua.CREATE_TIME desc");
		
		Object[] params = new Object[]{BRAND_ID};
		
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据品牌ID查询品牌下的问题
	 * @param BRAND_ID
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getProblemListByBrandId(int BRAND_ID, int nowPage, int onePageCount){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ").append(ALL_PROBLEM_FIELDS)
		.append(" FROM T_PROBLEM a, T_PROBLEM_TALK pt")
		.append(" WHERE a.PROBLEM_ID=pt.PROBLEM_ID")
		.append(" AND pt.TALK_ID=?")
		.append(" AND pt.TALK_TYPE=").append(IConstants.TALK_TYPE_BRAND)
		.append(" order by pt.CREATE_TIME desc");
		
		Object[] params = new Object[]{BRAND_ID};
		
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	
	}
}
