package com.baizhi.index.dao;

import java.util.List;
import java.util.Map;

import com.baizhi.IConstants;
import com.baizhi.commons.DaoSupport;

public class HtymDao extends DaoSupport{
	private final String ALL_TALK_FIELDS = "t.TALK_ID as TALK_ID,t.CONTENT as CONTENT,t.USER_ID as USER_ID,t.INTRODUCTION as INTRODUCTION,t.IMAGE_PATH as IMAGE_PATH,t.CREATE_TIME as CREATE_TIME,t.MODIFY_TIME as MODIFY_TIME";
	private final String ALL_USER_BASIC_FIELDS = " UB.BASIC_ID as BASIC_ID, UB.USER_ID as USER_ID, UB.USER_TYPE as USER_TYPE, UB.NAME as NAME, UB.SOURCE as SOURCE, UB.PROVINCE as PROVINCE, UB.CITY as CITY, UB.INDUSTRY as INDUSTRY, UB.YEARS as YEARS, UB.LINK_MODE as LINK_MODE, UB.IS_OPEN as IS_OPEN, UB.INTRODUCTION as INTRODUCTION, UB.MOTTO as MOTTO, UB.IMAGE_PATH as IMAGE_PATH, UB.WEBSITE as WEBSITE, UB.PRIVATE_SET as PRIVATE_SET, UB.LEVEL as LEVEL, UB.SCORE as SCORE, UB.REMARK as REMARK, UB.CREATE_TIME as CREATE_TIME, UB.MODIFY_TIME as MODIFY_TIME ";
	private final String ALL_PROBLEM_FIELDS = " a.PROBLEM_ID as PROBLEM_ID,a.PROBLEM_TYPE as PROBLEM_TYPE,a.CONTENT as CONTENT,a.IS_ANONYMITY as IS_ANONYMITY,a.RELEVANT_DETAILS as RELEVANT_DETAILS,a.USER_ID as USER_ID,a.WAS_USERID as WAS_USERID,a.ANSWER_COUNT as ANSWER_COUNT,a.REVIEW_COUNT as REVIEW_COUNT,a.ATTENTION_COUNT as ATTENTION_COUNT,a.COLLECTION_COUNT as COLLECTION_COUNT,a.BROWSE_COUNT as BROWSE_COUNT,a.IS_REPORT as IS_REPORT,a.REPORT_COUNT as REPORT_COUNT,a.CREATE_TIME as CREATE_TIME,a.MODIFY_TIME as MODIFY_TIME ";
	
	/**
	 * 根据话题ID，查询话题详细信息
	 * @param TALK_ID 话题ID
	 * @param 当前页
	 * @param onePageCount 每页显示的记录条数
	 * @return 查询到的结果集
	 */
	public Map<String,Object> getTalkById(int TALK_ID, int loginUserId){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ").append(ALL_TALK_FIELDS)
		.append(", (select count(uba.ATTENTIONTALK_ID) from T_USER_ATTENTIONTALK uba where uba.TALK_ID=t.TALK_ID and uba.USER_ID=?) as ATTENTION")
		.append(" FROM T_TALK t")
		.append(" WHERE t.TALK_ID=?");
		
		Object[] params = new Object[]{loginUserId, TALK_ID};
		List<Map<String,Object>> list = queryForListWithSQLQuery(sql.toString(), params);
		if(list == null || list.isEmpty())
			return null;
		return list.get(0);
	}
	
	/**
	 * 根据话题的ID，查询关注该话题的用户
	 * @param TALK_ID 话题ID
	 * @param 当前页
	 * @param onePageCount 每页显示的记录条数
	 * @return 查询到的结果集
	 */
	public Map<String,Object> getWasAttentionUserListByTalkId(int TALK_ID, int nowPage, int onePageCount){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ").append(ALL_USER_BASIC_FIELDS)
		.append(" FROM T_USER_BASIC ub, T_USER_ATTENTIONTALK UA")
		.append(" WHERE ub.USER_ID=UA.USER_ID")
		.append(" AND UA.TALK_ID=?")
		.append(" order by ua.CREATE_TIME desc");
		
		Object[] params = new Object[]{TALK_ID};
		
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据话题ID查询话题下的问题
	 * @param TALK_ID
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getProblemListByTalkId(int TALK_ID, int loginUserId, int nowPage, int onePageCount){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ").append(ALL_PROBLEM_FIELDS)
		.append(",(select count(pa.ATTENTION_ID) from t_problem_attention pa where pa.PROBLEM_ID=a.PROBLEM_ID and pa.USER_ID=?) as IS_ATTENTION")
		.append(",(select count(pc.COLLECTION_ID) from t_problem_collection pc where pc.PROBLEM_ID=a.PROBLEM_ID and pc.USER_ID=?) as IS_COLLECTION")
		.append(" FROM T_PROBLEM a, T_PROBLEM_TALK pt")
		.append(" WHERE a.PROBLEM_ID=pt.PROBLEM_ID")
		.append(" AND pt.TALK_ID=?")
		.append(" AND pt.TALK_TYPE=").append(IConstants.TALK_TYPE_TALK)
		.append(" order by pt.CREATE_TIME desc");
		
		Object[] params = new Object[]{loginUserId, loginUserId, TALK_ID};
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	
	}
}
