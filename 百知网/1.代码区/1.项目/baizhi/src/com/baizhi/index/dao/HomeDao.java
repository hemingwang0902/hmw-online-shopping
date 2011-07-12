package com.baizhi.index.dao;

import java.util.Map;

import com.baizhi.commons.DaoSupport;

/**
 * 类名： HomeDao<br>
 * 描述：网站首页的DAO<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-2<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class HomeDao extends DaoSupport{
	private final String ALL_PROBLEM_FIELDS = " a.PROBLEM_ID as PROBLEM_ID,a.PROBLEM_TYPE as PROBLEM_TYPE,a.CONTENT as CONTENT,a.IS_ANONYMITY as IS_ANONYMITY,a.RELEVANT_DETAILS as RELEVANT_DETAILS,a.USER_ID as USER_ID,a.WAS_USERID as WAS_USERID,a.ANSWER_COUNT as ANSWER_COUNT,a.REVIEW_COUNT as REVIEW_COUNT,a.ATTENTION_COUNT as ATTENTION_COUNT,a.COLLECTION_COUNT as COLLECTION_COUNT,a.BROWSE_COUNT as BROWSE_COUNT,a.IS_REPORT as IS_REPORT,a.REPORT_COUNT as REPORT_COUNT,a.CREATE_TIME as CREATE_TIME,a.MODIFY_TIME as MODIFY_TIME ";
	private final String ALL_USER_BASIC_FIELDS = " UB.BASIC_ID as BASIC_ID, UB.USER_ID as USER_ID, UB.USER_TYPE as USER_TYPE, UB.NAME as NAME, UB.SOURCE as SOURCE, UB.PROVINCE as PROVINCE, UB.CITY as CITY, UB.INDUSTRY as INDUSTRY, UB.YEARS as YEARS, UB.LINK_MODE as LINK_MODE, UB.IS_OPEN as IS_OPEN, UB.INTRODUCTION as INTRODUCTION, UB.MOTTO as MOTTO, UB.IMAGE_PATH as IMAGE_PATH, UB.WEBSITE as WEBSITE, UB.PRIVATE_SET as PRIVATE_SET, UB.LEVEL as LEVEL, UB.SCORE as SCORE, UB.REMARK as REMARK, UB.CREATE_TIME as CREATE_TIME, UB.MODIFY_TIME as MODIFY_TIME ";
	private final String ALL_USER_BRAND_FIELDS = " UB.BRAND_ID as BRAND_ID, UB.USER_ID as USER_ID, UB.NAME as NAME, UB.INTRODUCTION as INTRODUCTION, UB.SOURCE as SOURCE, UB.PROVINCE as PROVINCE, UB.CITY as CITY, UB.INDUSTRY as INDUSTRY, UB.LINK_NAME as LINK_NAME, UB.LINK_MODE as LINK_MODE, UB.EMAIL as EMAIL, UB.IMAGE_PATH as IMAGE_PATH, UB.STAUS as STAUS, UB.AUDIT_ID as AUDIT_ID, UB.AUDIT_TIME as AUDIT_TIME, UB.REASON as REASON, UB.REMARK as REMARK, UB.CREATE_TIME as CREATE_TIME, UB.MODIFY_TIME as MODIFY_TIME ";
	
	/**
	 * 根据名称模糊查询会员、品牌和问题
	 * @param title 会员姓名、品牌名称或问题标题
	 * @return
	 */
	public Map<String,Object> getUserOrProblemByTitleList(String title, int nowPage, int onePageCount){
		//组织查询语句
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT U.USER_ID AS ID, UB.NAME AS TITLE, '1' AS TYPE")
		   .append(" FROM T_USER U, T_USER_BASIC UB")
		   .append(" WHERE U.USER_ID=UB.USER_ID")
		   .append(" AND UB.NAME LIKE ?")
		   .append(" UNION")
		   .append(" SELECT ub.BRAND_ID AS ID, ub.NAME AS TITLE, '2' AS TYPE")
		   .append(" FROM T_USER_BRAND ub")
		   .append(" WHERE ub.NAME LIKE ?")
		   .append(" UNION")
		   .append(" SELECT P.PROBLEM_ID AS ID, P.CONTENT AS TITLE, '3' AS TYPE")
		   .append(" FROM T_PROBLEM P")
		   .append(" WHERE P.CONTENT LIKE ?");
		
		Object[] params = new Object[] { title, title, title };
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据登录用户的ID，查询网站首页“最新问题”列表，返回的结果集中包含如下问题：
	 * <ol>
	 * <li>我关注的人或品牌新发表的问题</li>
	 * <li>我关注的人或品牌新回答的问题</li>
	 * <li>我关注的话题下面有新的问题</li>
	 * <li>我关注的问题有了新回答的问题</li>
	 * <li>我回答过的问题有了新回答</li>
	 * </ol>
	 * @param userId 用户ID
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示的记录条数
	 * @return 查询到的结果集
	 */
	public Map<String,Object> getLatestProblemList(int userId, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append(" SELECT DISTINCT ")
		.append(ALL_PROBLEM_FIELDS.replaceAll("a\\.", "T88."))
		.append(", UB.NAME AS NAME, UB.IMAGE_PATH AS IMAGE_PATH, UB.WEBSITE AS WEBSITE")
		.append(" FROM (SELECT ")
		.append(ALL_PROBLEM_FIELDS)
		.append(", A.CREATE_TIME AS LAST_TIME FROM T_PROBLEM A")
		.append(" WHERE A.USER_ID IN( SELECT UA.WAS_USERID FROM T_USER_ATTENTION AS UA WHERE UA.USER_ID=?)")
		.append(" UNION")
		.append(" SELECT ")
		.append(ALL_PROBLEM_FIELDS)
		.append(", T1.LAST_TIME FROM T_PROBLEM A, (SELECT PROBLEM_ID, MAX(PA.CREATE_TIME) AS LAST_TIME")
		.append(" FROM T_PROBLEM_ANSWER PA WHERE PA.USER_ID IN( SELECT WAS_USERID FROM T_USER_ATTENTION UA WHERE UA.USER_ID=?) GROUP BY PA.PROBLEM_ID) T1")
		.append(" WHERE A.PROBLEM_ID= T1.PROBLEM_ID")
		.append(" UNION")
		.append(" SELECT ")
		.append(ALL_PROBLEM_FIELDS)
		.append(", A.CREATE_TIME AS LAST_TIME FROM T_PROBLEM A, T_PROBLEM_TALK PT")
		.append(" WHERE A.PROBLEM_ID= PT.PROBLEM_ID AND PT.TALK_ID IN(")
		.append(" SELECT UAT.TALK_ID FROM T_USER_ATTENTIONTALK UAT WHERE UAT.USER_ID=?)")
		.append(" UNION")
		.append(" SELECT ")
		.append(ALL_PROBLEM_FIELDS.replaceAll("a\\.", "B."))
		.append(",T1.LAST_TIME")
		.append(" FROM (SELECT PROBLEM_ID, MAX(PA.CREATE_TIME) AS LAST_TIME FROM T_PROBLEM_ANSWER PA GROUP BY PA.PROBLEM_ID) T1,")
		.append(" (SELECT ")
		.append(ALL_PROBLEM_FIELDS)
		.append(" FROM T_PROBLEM A, T_PROBLEM_TALK PT WHERE A.PROBLEM_ID= PT.PROBLEM_ID")
		.append(" AND PT.TALK_ID IN (SELECT UAT.TALK_ID FROM T_USER_ATTENTIONTALK UAT WHERE UAT.USER_ID=?)) B")
		.append(" WHERE T1.PROBLEM_ID=B.PROBLEM_ID")
		.append(" UNION")
		.append(" SELECT ")
		.append(ALL_PROBLEM_FIELDS)
		.append(", B.LAST_TIME FROM T_PROBLEM A, (")
		.append(" SELECT T1.PROBLEM_ID, T1.LAST_TIME FROM(")
		.append(" (SELECT PROBLEM_ID, MAX(PA.CREATE_TIME) LAST_TIME FROM T_PROBLEM_ANSWER PA GROUP BY PA.PROBLEM_ID) T1,")
		.append(" (SELECT PROBLEM_ID, MAX(PA.CREATE_TIME) LAST_TIME FROM T_PROBLEM_ANSWER PA WHERE PA.USER_ID=? GROUP BY PA.PROBLEM_ID) T2")
		.append(" )")
		.append(" WHERE T1.PROBLEM_ID=T2.PROBLEM_ID AND T1.LAST_TIME>T2.LAST_TIME) B")
		.append(" WHERE A.PROBLEM_ID=B.PROBLEM_ID) T88, T_USER_BASIC UB")
		.append(" WHERE T88.USER_ID=UB.USER_ID")
		.append(" AND (T88.WAS_USERID IS NULL OR T88.WAS_USERID=?)")
		.append(" GROUP BY T88.PROBLEM_ID  ORDER BY T88.LAST_TIME DESC");

		Object[] params = new Object[6];
		for (int i = 0; i < params.length; i++) {
			params[i] = userId;
		}
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}

	/**
	 * 查询网站首页“最热问题”列表
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示的记录条数
	 * @return 查询到的结果集
	 */
	public Map<String,Object> getHottestProblemList(int userId, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ")
		.append(ALL_PROBLEM_FIELDS)
		.append(", UB.NAME AS NAME, UB.IMAGE_PATH AS IMAGE_PATH, UB.WEBSITE AS WEBSITE")
		.append(" FROM T_PROBLEM a")
		.append(" LEFT JOIN")
		.append(" (SELECT PA.PROBLEM_ID, COUNT(PROBLEM_ID) AS ANSWER_COUNT FROM T_PROBLEM_ANSWER PA GROUP BY PA.PROBLEM_ID) B")
		.append(" ON a.PROBLEM_ID=B.PROBLEM_ID")
		.append(" JOIN T_USER_BASIC UB")
		.append(" ON a.USER_ID=UB.USER_ID")
		.append(" WHERE (a.WAS_USERID IS NULL OR a.WAS_USERID=?)")
		.append(" ORDER BY B.ANSWER_COUNT DESC, A.BROWSE_COUNT DESC");
		
		return queryForListWithSQLQuery(sql.toString(), new Object[]{userId}, nowPage, onePageCount);
	}
	
	/**
	 * 根据用户的ID，查询该用户可能感兴趣的人，返回的结果集中包含如下的人：
	 * <ol>
	 * <li>同一个城市的人</li>
	 * <li>与自己关注同一个人的人</li>
	 * <li>与自己关注同一个话题的人</li>
	 * </ol>
	 * @param userId 用户ID
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示的记录条数
	 * @return 查询到的结果集
	 */
	public Map<String,Object> getMayInterestedUser(int userId, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()
		.append("SELECT").append(ALL_USER_BASIC_FIELDS).append(" FROM (")
		.append(" SELECT").append(ALL_USER_BASIC_FIELDS).append(" FROM T_USER_BASIC UB, T_USER_BASIC UB2")
		.append(" WHERE UB.CITY=UB2.CITY")
		.append(" AND UB.BASIC_ID<>UB2.BASIC_ID")
		.append(" AND UB2.USER_ID=?")
		.append(" UNION")
		.append(" SELECT").append(ALL_USER_BASIC_FIELDS).append(" FROM T_USER_BASIC UB")
		.append(" WHERE UB.USER_ID IN(")
		.append(" SELECT UA1.USER_ID FROM T_USER_ATTENTION UA1, T_USER_ATTENTION UA2")
		.append(" WHERE UA1.WAS_USERID=UA2.WAS_USERID")
		.append(" AND UA1.USER_ID<>UA2.USER_ID")
		.append(" AND UA2.USER_ID=?")
		.append(" )")
		.append(" UNION")
		.append(" SELECT").append(ALL_USER_BASIC_FIELDS).append(" FROM T_USER_BASIC UB")
		.append(" WHERE UB.USER_ID IN(")
		.append(" SELECT UA1.USER_ID FROM T_USER_ATTENTIONTALK UA1, T_USER_ATTENTIONTALK UA2")
		.append(" WHERE UA1.TALK_ID=UA2.TALK_ID")
		.append(" AND UA1.USER_ID<>UA2.USER_ID")
		.append(" AND UA2.USER_ID=?)")
		.append(" ) AS UB WHERE UB.USER_ID NOT IN(")
		.append(" SELECT UA.WAS_USERID FROM T_USER_ATTENTION UA where user_id=?")
		.append(" )");
		
		Object[] params = new Object[4];
		for (int i = 0; i < params.length; i++) {
			params[i] = userId;
		}
		
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据用户的ID，查询该用户关注的会员
	 * @param userId 用户ID
	 * @param userType 用户类型，参见 <code>com.baizhi.IConstants.USER_TYPE_*</code>
	 * @param 当前页
	 * @param onePageCount 每页显示的记录条数
	 * @return 查询到的结果集
	 */
	public Map<String,Object> getAttentionUser(int userId, int nowPage, int onePageCount){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ").append(ALL_USER_BASIC_FIELDS)
		.append(" FROM T_USER_ATTENTION UA, T_USER_BASIC UB")
		.append(" WHERE UA.USER_ID=UB.USER_ID")
		.append(" AND UA.USER_ID=?");
		
		Object[] params = new Object[]{userId};
		
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据用户的ID，查询该用户关注的品牌
	 * @param userId 用户ID
	 * @param 当前页
	 * @param onePageCount 每页显示的记录条数
	 * @return 查询到的结果集
	 */
	public Map<String,Object> getAttentionBrand(int userId, int nowPage, int onePageCount){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ").append(ALL_USER_BRAND_FIELDS)
		.append(" FROM T_USER_BATTENTION UA, T_USER_BRAND UB")
		.append(" WHERE UA.BRAND_ID=UB.BRAND_ID")
		.append(" AND UA.USER_ID=?");
		
		Object[] params = new Object[]{userId};
		
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
}