package com.baizhi.index.dao;

import java.util.Map;

import com.baizhi.commons.DaoSupport;

public class SywtDao extends DaoSupport{
	private final String ALL_PROBLEM_FIELDS = " a.PROBLEM_ID as PROBLEM_ID,a.PROBLEM_TYPE as PROBLEM_TYPE,a.CONTENT as CONTENT,a.IS_ANONYMITY as IS_ANONYMITY,a.RELEVANT_DETAILS as RELEVANT_DETAILS,a.USER_ID as USER_ID,a.WAS_USERID as WAS_USERID,a.ANSWER_COUNT as ANSWER_COUNT,a.REVIEW_COUNT as REVIEW_COUNT,a.ATTENTION_COUNT as ATTENTION_COUNT,a.COLLECTION_COUNT as COLLECTION_COUNT,a.BROWSE_COUNT as BROWSE_COUNT,a.IS_REPORT as IS_REPORT,a.REPORT_COUNT as REPORT_COUNT,a.CREATE_TIME as CREATE_TIME,a.MODIFY_TIME as MODIFY_TIME ";
	
	/**
	 * 根据用户ID查询用户可以浏览的所有问题
	 * @param userId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getAllProblemList(int userId, int loginUserId, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append(" SELECT ").append(ALL_PROBLEM_FIELDS).append(", UB.NAME AS NAME, UB.IMAGE_PATH AS IMAGE_PATH, UB.WEBSITE AS WEBSITE")
		.append(",(select count(pa.ATTENTION_ID) from t_problem_attention pa where pa.PROBLEM_ID=a.PROBLEM_ID and pa.USER_ID=?) as IS_ATTENTION")
		.append(",(select count(pc.COLLECTION_ID) from t_problem_collection pc where pc.PROBLEM_ID=a.PROBLEM_ID and pc.USER_ID=?) as IS_COLLECTION")
		.append(" FROM T_PROBLEM a, T_USER_BASIC UB")
		.append(" WHERE a.USER_ID=UB.USER_ID")
		.append(" AND (a.WAS_USERID IS NULL OR a.WAS_USERID=?)")
		.append(" ORDER BY a.IS_TOP DESC, a.CREATE_TIME DESC");

		Object[] params = new Object[]{loginUserId, loginUserId, userId};
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据用户ID查询“问我的问题”
	 * @param userId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getAskMeProblemList(int userId, int loginUserId, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append(" SELECT ").append(ALL_PROBLEM_FIELDS).append(", UB.NAME AS NAME, UB.IMAGE_PATH AS IMAGE_PATH, UB.WEBSITE AS WEBSITE")
		.append(",(select count(pa.ATTENTION_ID) from t_problem_attention pa where pa.PROBLEM_ID=a.PROBLEM_ID and pa.USER_ID=?) as IS_ATTENTION")
		.append(",(select count(pc.COLLECTION_ID) from t_problem_collection pc where pc.PROBLEM_ID=a.PROBLEM_ID and pc.USER_ID=?) as IS_COLLECTION")
		.append(" FROM T_PROBLEM a, T_USER_BASIC UB")
		.append(" WHERE a.USER_ID=UB.USER_ID")
		.append(" AND a.WAS_USERID=?")
		.append(" ORDER BY a.CREATE_TIME DESC");
		
		Object[] params = new Object[]{loginUserId, loginUserId, userId};
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据用户ID查询“邀请我回答的问题”
	 * @param userId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getInviteProblemList(int userId, int loginUserId, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append(" SELECT ").append(ALL_PROBLEM_FIELDS).append(", UB.NAME AS NAME, UB.IMAGE_PATH AS IMAGE_PATH, UB.WEBSITE AS WEBSITE")
		.append(",(select count(pa.ATTENTION_ID) from t_problem_attention pa where pa.PROBLEM_ID=a.PROBLEM_ID and pa.USER_ID=?) as IS_ATTENTION")
		.append(",(select count(pc.COLLECTION_ID) from t_problem_collection pc where pc.PROBLEM_ID=a.PROBLEM_ID and pc.USER_ID=?) as IS_COLLECTION")
		.append(" FROM T_PROBLEM a")
		.append(" JOIN")
		.append(" (SELECT PA.PROBLEM_ID, MAX(PA.CREATE_TIME) AS INVITE_TIME FROM T_PROBLEM_INVITE PA WHERE PA.WAS_USER_ID=? GROUP BY PA.PROBLEM_ID) B")
		.append(" ON a.PROBLEM_ID=B.PROBLEM_ID")
		.append(" JOIN T_USER_BASIC UB")
		.append(" ON a.USER_ID=UB.USER_ID")
		.append(" ORDER BY B.INVITE_TIME DESC");
		
		Object[] params = new Object[]{loginUserId, loginUserId, userId};
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
}
