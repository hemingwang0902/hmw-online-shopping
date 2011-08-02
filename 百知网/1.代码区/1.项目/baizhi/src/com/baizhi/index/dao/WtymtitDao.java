package com.baizhi.index.dao;

import java.util.List;
import java.util.Map;

import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;

public class WtymtitDao extends DaoSupport{
	private final String ALL_PROBLEM_FIELDS = " a.PROBLEM_ID as PROBLEM_ID,a.PROBLEM_TYPE as PROBLEM_TYPE,a.CONTENT as CONTENT,a.IS_ANONYMITY as IS_ANONYMITY,a.RELEVANT_DETAILS as RELEVANT_DETAILS,a.USER_ID as USER_ID,a.WAS_USERID as WAS_USERID,a.ANSWER_COUNT as ANSWER_COUNT,a.REVIEW_COUNT as REVIEW_COUNT,a.ATTENTION_COUNT as ATTENTION_COUNT,a.COLLECTION_COUNT as COLLECTION_COUNT,a.BROWSE_COUNT as BROWSE_COUNT,a.IS_REPORT as IS_REPORT,a.REPORT_COUNT as REPORT_COUNT,a.CREATE_TIME as CREATE_TIME,a.MODIFY_TIME as MODIFY_TIME ";
	private final String ALL_USER_BASIC_FIELDS = " UB.BASIC_ID as BASIC_ID, UB.USER_ID as USER_ID, UB.USER_TYPE as USER_TYPE, UB.NAME as NAME, UB.SOURCE as SOURCE, UB.PROVINCE as PROVINCE, UB.CITY as CITY, UB.INDUSTRY as INDUSTRY, UB.YEARS as YEARS, UB.LINK_MODE as LINK_MODE, UB.IS_OPEN as IS_OPEN, UB.INTRODUCTION as INTRODUCTION, UB.MOTTO as MOTTO, UB.IMAGE_PATH as IMAGE_PATH, UB.WEBSITE as WEBSITE, UB.PRIVATE_SET as PRIVATE_SET, UB.LEVEL as LEVEL, UB.SCORE as SCORE, UB.REMARK as REMARK, UB.CREATE_TIME as CREATE_TIME, UB.MODIFY_TIME as MODIFY_TIME ";
	private final String ALL_TALK_FIELDS = "t.TALK_ID as TALK_ID,t.CONTENT as CONTENT,t.USER_ID as USER_ID,t.INTRODUCTION as INTRODUCTION,t.IMAGE_PATH as IMAGE_PATH,t.CREATE_TIME as CREATE_TIME,t.MODIFY_TIME as MODIFY_TIME";
	private final String ALL_ANSWER_FIELDS = "a.ANSWER_ID as ANSWER_ID, a.PROBLEM_ID as PROBLEM_ID, a.CONTENT as CONTENT, a.USER_ID as USER_ID, a.AGREE_COUNT as AGREE_COUNT, a.DISAGREE_COUNT as DISAGREE_COUNT, a.THANK_COUNT as THANK_COUNT, a.DISTHANK_COUNT as DISTHANK_COUNT, a.CREATE_TIME as CREATE_TIME, a.MODIFY_TIME as MODIFY_TIME";
	private final String ALL_ANSWER_REVIEW_FIELDS = "a.REVIEW_ID as REVIEW_ID, a.ANSWER_ID as ANSWER_ID, a.PROBLEM_ID as PROBLEM_ID, a.CONTENT as CONTENT, a.PREVIEW_ID as PREVIEW_ID, a.USER_ID as USER_ID, a.CREATE_TIME as CREATE_TIME, a.MODIFY_TIME as MODIFY_TIME";
	
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
	public Map<String, Object> getNearProblemList(int problemId, int loginUserId, int nowPage, int onePageCount) {
		StringBuffer sql = new StringBuffer()
		.append("SELECT ").append(ALL_PROBLEM_FIELDS)
		.append("  FROM (")
		.append(" SELECT ").append(ALL_PROBLEM_FIELDS)
		.append(" from t_problem a where a.PROBLEM_ID <> ? and (a.WAS_USERID is null or a.WAS_USERID=?) and a.PROBLEM_ID in(")
		.append(" select pt.PROBLEM_ID from t_problem_talk pt where pt.PROBLEM_ID=?)")
		.append(" union")
		.append(" SELECT ").append(ALL_PROBLEM_FIELDS)
		.append(" from t_problem a where a.PROBLEM_ID <> ? and (a.WAS_USERID is null or a.WAS_USERID=?) and a.user_id in(")
		.append(" select p.user_id from t_problem p where p.PROBLEM_ID=?)")
		.append(") a order by a.create_time desc");
		
		Object[] params = new Object[] {
			problemId, loginUserId, problemId,
			problemId, loginUserId, problemId
		};
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
		sql.append("SELECT ").append(ALL_TALK_FIELDS)
		   .append(" FROM T_TALK t WHERE t.CONTENT like ? ");
		
		return queryForListWithSQLQuery(sql.toString(), new Object[]{CONTENT}, nowPage, onePageCount);
	}
	
	public Map<String,Object> getTalkByContent(String CONTENT){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ").append(ALL_TALK_FIELDS)
		   .append(" FROM T_TALK t WHERE t.CONTENT = ? ");
		
		List<Map<String,Object>> list = queryForListWithSQLQuery(sql.toString(), new Object[]{CONTENT});
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
	
	/**
	 * 根据问题ID，查询回复列表
	 * @param probelmId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getProblemAnswerListByProblemId(int probelmId, int loginUserId,int nowPage,int onePageCount){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ").append(ALL_ANSWER_FIELDS)
		.append(", ub.NAME as NAME, ub.INTRODUCTION as INTRODUCTION")
		.append(",(select count(ar.REVIEW_ID) from T_ANSWER_REVIEW ar where ar.ANSWER_ID=a.ANSWER_ID) as REVIEW_COUNT")
		.append(",(select count(av1.VOTE_ID) from T_ANSWER_VOTE av1 where av1.ANSWER_ID=a.ANSWER_ID and av1.USER_ID=? and av1.VOTE_TYPE='1' and av1.IS_AGREE='1') as AGREE")
		.append(",(select count(av2.VOTE_ID) from T_ANSWER_VOTE av2 where av2.ANSWER_ID=a.ANSWER_ID and av2.USER_ID=? and av2.VOTE_TYPE='1' and av2.IS_AGREE='0') as DISAGREE")
		.append(",(select count(av3.VOTE_ID) from T_ANSWER_VOTE av3 where av3.ANSWER_ID=a.ANSWER_ID and av3.USER_ID=? and av3.VOTE_TYPE='2' and av3.IS_AGREE='1') as THANK")
		.append(",(select count(av4.VOTE_ID) from T_ANSWER_VOTE av4 where av4.ANSWER_ID=a.ANSWER_ID and av4.USER_ID=? and av4.VOTE_TYPE='2' and av4.IS_AGREE='0') as DISTHANK")
		.append(" from t_problem_answer a, T_USER_BASIC ub")
		.append(" where a.USER_ID=ub.USER_ID and a.PROBLEM_ID=?");
		Object[] params = new Object[]{
				loginUserId, loginUserId, loginUserId, loginUserId, probelmId
		};
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据问题回复ID查询评论
	 * @return
	 */
	public List<Map<String,Object>> getAnswerReviewListByAnswerId(int ANSWER_ID){
		StringBuffer sql = new StringBuffer()
		.append("select ").append(ALL_ANSWER_REVIEW_FIELDS)
		.append(", ub.NAME as NAME, ub.INTRODUCTION as INTRODUCTION")
		.append(" from T_ANSWER_REVIEW a, T_USER_BASIC ub")
		.append(" where a.USER_ID=ub.USER_ID")
		.append(" and a.ANSWER_ID=?");
		return queryForListWithSQLQuery(sql.toString(), new Object[]{ANSWER_ID});
	}
	
	
	/**
	 * 修改问题回答
	 */
	public int updateAnswer(Map<String, Object> params,int ANSWER_ID) {
		int count=-1;
		ParametersSupport ps=new ParametersSupport(params,ParametersSupport.EXECUTETYPE);
		String sql = "update T_PROBLEM_ANSWER set "+ps.getConditions()+" where ANSWER_ID=?";
		List<Object> list = ps.getValuesList();
		list.add(ANSWER_ID);
		count=this.executeUpdate(sql.toString(), list.toArray());
		return count;
	}
}
