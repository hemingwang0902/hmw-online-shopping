package com.baizhi.index.dao;

import java.util.Map;

import com.baizhi.commons.DaoSupport;

public class WgzdwtDao extends DaoSupport{
	private final String ALL_PROBLEM_FIELDS = " a.PROBLEM_ID as PROBLEM_ID,a.PROBLEM_TYPE as PROBLEM_TYPE,a.CONTENT as CONTENT,a.IS_ANONYMITY as IS_ANONYMITY,a.RELEVANT_DETAILS as RELEVANT_DETAILS,a.USER_ID as USER_ID,a.WAS_USERID as WAS_USERID,a.ANSWER_COUNT as ANSWER_COUNT,a.REVIEW_COUNT as REVIEW_COUNT,a.ATTENTION_COUNT as ATTENTION_COUNT,a.COLLECTION_COUNT as COLLECTION_COUNT,a.BROWSE_COUNT as BROWSE_COUNT,a.IS_REPORT as IS_REPORT,a.REPORT_COUNT as REPORT_COUNT,a.CREATE_TIME as CREATE_TIME,a.MODIFY_TIME as MODIFY_TIME ";
	
	public Map<String,Object> getAttentionProblemList(int userId, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append(" SELECT ").append(ALL_PROBLEM_FIELDS)
		.append(" FROM T_PROBLEM A, t_problem_attention b")
		.append(" WHERE A.PROBLEM_ID=B.PROBLEM_ID")
		.append(" AND B.USER_ID=?")
		.append(" ORDER BY a.MODIFY_TIME DESC");
		
		Object[] params = new Object[]{userId};

		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}

	
}
