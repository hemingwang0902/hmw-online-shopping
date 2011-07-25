package com.baizhi.index.dao;

import java.util.Map;

import com.baizhi.commons.DaoSupport;

public class WgzdwtDao extends DaoSupport{
	private final String ALL_PROBLEM_FIELDS = " a.PROBLEM_ID as PROBLEM_ID,a.PROBLEM_TYPE as PROBLEM_TYPE,a.CONTENT as CONTENT,a.IS_ANONYMITY as IS_ANONYMITY,a.RELEVANT_DETAILS as RELEVANT_DETAILS,a.USER_ID as USER_ID,a.WAS_USERID as WAS_USERID,a.ANSWER_COUNT as ANSWER_COUNT,a.REVIEW_COUNT as REVIEW_COUNT,a.ATTENTION_COUNT as ATTENTION_COUNT,a.COLLECTION_COUNT as COLLECTION_COUNT,a.BROWSE_COUNT as BROWSE_COUNT,a.IS_REPORT as IS_REPORT,a.REPORT_COUNT as REPORT_COUNT,a.CREATE_TIME as CREATE_TIME,a.MODIFY_TIME as MODIFY_TIME ";
	
	/**
	 * 根据 userId 查询指定用户关注的问题
	 * @param userId
	 * @param loginUserId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getAttentionProblemList(int userId, int loginUserId, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append(" SELECT ").append(ALL_PROBLEM_FIELDS)
		.append(",(select count(pa.ATTENTION_ID) from t_problem_attention pa where pa.PROBLEM_ID=a.PROBLEM_ID and pa.USER_ID=?) as IS_ATTENTION")
		.append(",(select count(pc.COLLECTION_ID) from t_problem_collection pc where pc.PROBLEM_ID=a.PROBLEM_ID and pc.USER_ID=?) as IS_COLLECTION")
		.append(" FROM T_PROBLEM A, t_problem_attention b")
		.append(" WHERE A.PROBLEM_ID=B.PROBLEM_ID")
		.append(" AND B.USER_ID=?")
		.append(" ORDER BY a.MODIFY_TIME DESC");
		
		Object[] params = new Object[]{loginUserId, loginUserId, userId};

		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}

	
}
