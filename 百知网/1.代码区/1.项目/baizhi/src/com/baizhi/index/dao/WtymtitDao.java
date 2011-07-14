package com.baizhi.index.dao;

import java.util.List;
import java.util.Map;

import com.baizhi.commons.DaoSupport;

public class WtymtitDao extends DaoSupport{
	private final String ALL_PROBLEM_FIELDS = " a.PROBLEM_ID as PROBLEM_ID,a.PROBLEM_TYPE as PROBLEM_TYPE,a.CONTENT as CONTENT,a.IS_ANONYMITY as IS_ANONYMITY,a.RELEVANT_DETAILS as RELEVANT_DETAILS,a.USER_ID as USER_ID,a.WAS_USERID as WAS_USERID,a.ANSWER_COUNT as ANSWER_COUNT,a.REVIEW_COUNT as REVIEW_COUNT,a.ATTENTION_COUNT as ATTENTION_COUNT,a.COLLECTION_COUNT as COLLECTION_COUNT,a.BROWSE_COUNT as BROWSE_COUNT,a.IS_REPORT as IS_REPORT,a.REPORT_COUNT as REPORT_COUNT,a.CREATE_TIME as CREATE_TIME,a.MODIFY_TIME as MODIFY_TIME ";
	private final String ALL_USER_BASIC_FIELDS = " UB.BASIC_ID as BASIC_ID, UB.USER_ID as USER_ID, UB.USER_TYPE as USER_TYPE, UB.NAME as NAME, UB.SOURCE as SOURCE, UB.PROVINCE as PROVINCE, UB.CITY as CITY, UB.INDUSTRY as INDUSTRY, UB.YEARS as YEARS, UB.LINK_MODE as LINK_MODE, UB.IS_OPEN as IS_OPEN, UB.INTRODUCTION as INTRODUCTION, UB.MOTTO as MOTTO, UB.IMAGE_PATH as IMAGE_PATH, UB.WEBSITE as WEBSITE, UB.PRIVATE_SET as PRIVATE_SET, UB.LEVEL as LEVEL, UB.SCORE as SCORE, UB.REMARK as REMARK, UB.CREATE_TIME as CREATE_TIME, UB.MODIFY_TIME as MODIFY_TIME ";
	private final String ALL_TALK_FIELDS = "t.TALK_ID as TALK_ID,t.CONTENT as CONTENT,t.USER_ID as USER_ID,t.INTRODUCTION as INTRODUCTION,t.IMAGE_PATH as IMAGE_PATH,t.CREATE_TIME as CREATE_TIME,t.MODIFY_TIME as MODIFY_TIME";
	
	/**
	 * 根据问题ID查找问题所属话题
	 * @param ProblemId 问题ID
	 * @return
	 */
	public List<Map<String, Object>> getTalkList(int ProblemId){
		StringBuffer sql = new StringBuffer()
		.append("SELECT ").append(ALL_TALK_FIELDS)
		.append(" FROM  T_TALK t")
		.append(" WHERE t.TALK_ID IN (")
		.append(" SELECT pt.TALK_ID FROM T_PROBLEM_TALK pt WHERE pt.PROBLEM_ID=?)");
		return queryForListWithSQLQuery(sql.toString(), new Object[]{ProblemId});
	}
	
	/**
	 * 根据问题ID查找问题所属话题的关注者
	 * @param ProblemId 问题ID
	 * @return
	 */
	public List<Map<String, Object>> getTalkUserList(int ProblemId){
		StringBuffer sql = new StringBuffer()
		.append("SELECT ").append(ALL_USER_BASIC_FIELDS)
		.append(" FROM  T_USER_BASIC ub")
		.append(" WHERE ub.USER_ID IN(")
		.append(" SELECT uat.USER_ID FROM T_USER_ATTENTIONTALK uat,T_PROBLEM_TALK pt")
		.append(" WHERE uat.TALK_ID=pt.TALK_ID")
		.append(" AND pt.PROBLEM_ID=?)");
		return queryForListWithSQLQuery(sql.toString(), new Object[]{ProblemId});
	}

	/**
	 * 根据问题ID查找相关问题，相关问题的查询顺序：
	 * <ol>
	 * <li>相同话题下的问题</li>
	 * <li>同一个人问的问题</li>
	 * </ol>
	 * @param problemId 问题ID
	 * @return
	 */
	public Map<String, Object> getNearProblemList(int problemId, int nowPage, int onePageCount) {
		StringBuffer sql = new StringBuffer()
		.append("SELECT ").append(ALL_PROBLEM_FIELDS)
		.append("  FROM (")
		.append(" SELECT ").append(ALL_PROBLEM_FIELDS)
		.append(" from t_problem a where a.PROBLEM_ID <> ? and a.PROBLEM_ID in(")
		.append(" select pt.PROBLEM_ID from t_problem_talk pt where pt.PROBLEM_ID=?)")
		.append(" union")
		.append(" SELECT ").append(ALL_PROBLEM_FIELDS)
		.append(" from t_problem a where a.PROBLEM_ID <> ? and a.user_id in(")
		.append(" select p.user_id from t_problem p where p.PROBLEM_ID=?)")
		.append(") a order by a.create_time desc");
		
		Object[] params = new Object[4];
		for (int i = 0; i < params.length; i++) {
			params[i] = problemId;
		}
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据话题名称模糊查询话题列表
	 * @param CONTENT
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getTalkListByContent(String CONTENT,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ")
		   .append("a.TALK_ID as TALK_ID,")//话题ID
		   .append("a.CONTENT as CONTENT,")//内容
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_TALK a WHERE a.CONTENT like ? ");
		
		return queryForListWithSQLQuery(sql.toString(), new Object[]{CONTENT}, nowPage, onePageCount);
	}
}
