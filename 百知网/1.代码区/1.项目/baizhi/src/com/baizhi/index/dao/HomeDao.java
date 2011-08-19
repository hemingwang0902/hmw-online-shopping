package com.baizhi.index.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.baizhi.IConstants;
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
	private final String ALL_PROBLEM_FIELDS = " a.PROBLEM_ID as PROBLEM_ID,a.PROBLEM_TYPE as PROBLEM_TYPE,a.CONTENT as CONTENT,a.IS_ANONYMITY as IS_ANONYMITY,a.RELEVANT_DETAILS as RELEVANT_DETAILS,a.USER_ID as USER_ID,a.WAS_USERID as WAS_USERID,a.ANSWER_COUNT as ANSWER_COUNT,a.REVIEW_COUNT as REVIEW_COUNT,a.ATTENTION_COUNT as ATTENTION_COUNT,a.COLLECTION_COUNT as COLLECTION_COUNT,a.BROWSE_COUNT as BROWSE_COUNT,a.IS_REPORT as IS_REPORT,a.REPORT_COUNT as REPORT_COUNT,a.IS_TOP as IS_TOP,a.CREATE_TIME as CREATE_TIME,a.MODIFY_TIME as MODIFY_TIME ";
	private final String ALL_USER_BASIC_FIELDS = " ub.BASIC_ID as BASIC_ID, ub.USER_ID as USER_ID, ub.USER_TYPE as USER_TYPE, ub.NAME as NAME, ub.SOURCE as SOURCE, ub.PROVINCE as PROVINCE, ub.CITY as CITY, ub.INDUSTRY as INDUSTRY, ub.YEARS as YEARS, ub.LINK_MODE as LINK_MODE, ub.IS_OPEN as IS_OPEN, ub.INTRODUCTION as INTRODUCTION, ub.MOTTO as MOTTO, ub.IMAGE_PATH as IMAGE_PATH, ub.WEBSITE as WEBSITE, ub.PRIVATE_SET as PRIVATE_SET, ub.LEVEL as LEVEL, ub.SCORE as SCORE, ub.REMARK as REMARK, ub.CREATE_TIME as CREATE_TIME, ub.MODIFY_TIME as MODIFY_TIME ";
	private final String ALL_USER_BRAND_FIELDS = " ub.BRAND_ID as BRAND_ID, ub.USER_ID as USER_ID, ub.NAME as NAME, ub.INTRODUCTION as INTRODUCTION, ub.SOURCE as SOURCE, ub.PROVINCE as PROVINCE, ub.CITY as CITY, ub.INDUSTRY as INDUSTRY, ub.LINK_NAME as LINK_NAME, ub.LINK_MODE as LINK_MODE, ub.EMAIL as EMAIL, ub.IMAGE_PATH as IMAGE_PATH, ub.STAUS as STAUS, ub.AUDIT_ID as AUDIT_ID, ub.AUDIT_TIME as AUDIT_TIME, ub.REASON as REASON, ub.REMARK as REMARK, ub.CREATE_TIME as CREATE_TIME, ub.MODIFY_TIME as MODIFY_TIME ";
	
	/**
	 * 根据名称模糊查询会员、品牌、问题和话题
	 * @param title 会员姓名、品牌名称、问题或话题标题
	 * @return
	 */
	public Map<String,Object> getUserOrProblemByTitleList(String title, int nowPage, int onePageCount){
		//组织查询语句
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT U.USER_ID AS ID, ub.NAME AS TITLE, '1' AS TYPE")
		   .append(" FROM T_USER U, T_USER_BASIC ub")
		   .append(" WHERE U.USER_ID=ub.USER_ID")
		   .append(" AND ub.NAME LIKE ?")
		   .append(" UNION")
		   .append(" SELECT ub.BRAND_ID AS ID, ub.NAME AS TITLE, '2' AS TYPE")
		   .append(" FROM T_USER_BRAND ub")
		   .append(" WHERE ub.NAME LIKE ?")
		   .append(" AND ub.STAUS=").append(IConstants.BRAND_STAUS_PASSED)
		   .append(" UNION")
		   .append(" SELECT P.PROBLEM_ID AS ID, P.CONTENT AS TITLE, '3' AS TYPE")
		   .append(" FROM T_PROBLEM P")
		   .append(" WHERE P.CONTENT LIKE ?")
		   .append(" UNION")
		   .append(" SELECT t.TALK_ID AS ID, t.CONTENT AS TITLE, '4' AS TYPE")
		   .append(" FROM T_TALK t")
		   .append(" WHERE t.CONTENT LIKE ?");
		
		Object[] params = new Object[] { title, title, title, title };
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据名称模糊查询会员、品牌、问题和话题(用于搜索结果页)
	 * @param title 会员姓名、品牌名称、问题或话题标题
	 * @return
	 */
	public Map<String,Object> getListByTitleWithFull(String title, int nowPage, int onePageCount){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ub.USER_ID AS ID, ub.NAME AS TITLE, '1' AS TYPE, ub.INTRODUCTION as INTRODUCTION, ub.IMAGE_PATH as IMAGE_PATH, ub.WEBSITE as WEBSITE")
		.append(", (SELECT COUNT(ua.ATTENTION_ID) FROM T_USER_ATTENTION ua WHERE ua.WAS_USERID=ub.USER_ID) as ATTENTION_COUNT")
		.append(" FROM T_USER_BASIC ub")
		.append(" WHERE ub.NAME LIKE ?")
		.append(" UNION")
		.append(" SELECT b.BRAND_ID AS ID, b.NAME AS TITLE, '2' AS TYPE, b.INTRODUCTION as INTRODUCTION, b.IMAGE_PATH as IMAGE_PATH, null as WEBSITE")
		.append(", (SELECT COUNT(uba.BATTENTION_ID) FROM T_USER_BATTENTION uba WHERE uba.BRAND_ID=b.BRAND_ID) as ATTENTION_COUNT")
		.append(" FROM T_USER_BRAND b")
		.append(" WHERE b.NAME LIKE ?")
		.append(" AND b.STAUS=").append(IConstants.BRAND_STAUS_PASSED)
		.append(" UNION")
		.append(" SELECT P.PROBLEM_ID AS ID, P.CONTENT AS TITLE, '3' AS TYPE, p.RELEVANT_DETAILS as INTRODUCTION, null as IMAGE_PATH, null as WEBSITE")
		.append(", (SELECT COUNT(pa.ATTENTION_ID) FROM T_PROBLEM_ATTENTION pa WHERE pa.PROBLEM_ID=P.PROBLEM_ID) as ATTENTION_COUNT")
		.append(" FROM T_PROBLEM P")
		.append(" WHERE P.CONTENT LIKE ?")
		.append(" UNION")
		.append(" SELECT t.TALK_ID AS ID, t.CONTENT AS TITLE, '4' AS TYPE, t.INTRODUCTION as INTRODUCTION, t.IMAGE_PATH as IMAGE_PATH, null as WEBSITE")
		.append(", (SELECT COUNT(uat.ATTENTIONTALK_ID) FROM T_USER_ATTENTIONTALK uat WHERE uat.TALK_ID=t.TALK_ID) as ATTENTION_COUNT")
		.append(" FROM T_TALK t")
		.append(" WHERE t.CONTENT LIKE ?");
		
		Object[] params = new Object[] { title, title, title, title };
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据登录用户的ID，查询网站首页“最新问题”列表，返回的结果集中包含如下问题：
	 * <ol>
	 * <li>我关注的人新发表的问题</li>
	 * <li>我关注的人新回答的问题</li>
	 * <li>我关注的话题下新发表的问题</li>
	 * <li>我关注的问题有了新回答的问题</li>
	 * <li>我回答过的问题有了新回答</li>
	 * <li>我自己发表的问题</li>
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
		.append(ALL_PROBLEM_FIELDS.replaceAll("a\\.", "t88."))
		.append(", ub.NAME AS NAME, ub.IMAGE_PATH AS IMAGE_PATH, ub.WEBSITE AS WEBSITE, ub.INTRODUCTION as INTRODUCTION")
		.append(",(select count(pa.ATTENTION_ID) from t_problem_attention pa where pa.PROBLEM_ID=T88.PROBLEM_ID and pa.USER_ID=?) as IS_ATTENTION")
		.append(",(select count(pc.COLLECTION_ID) from t_problem_collection pc where pc.PROBLEM_ID=T88.PROBLEM_ID and pc.USER_ID=?) as IS_COLLECTION")
		.append(", pa1.ANSWER_ID as ANSWER_ID, pa1.ANSWER_CONTENT as ANSWER_CONTENT, pa1.ANSWER_USER_ID as ANSWER_USER_ID, pa1.ANSWER_USER_NAME as ANSWER_USER_NAME, pa1.ANSWER_USER_INTRODUCTION as ANSWER_USER_INTRODUCTION")
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
		.append(" WHERE A.PROBLEM_ID=B.PROBLEM_ID")
		.append(" UNION")
		.append(" SELECT ")
		.append(ALL_PROBLEM_FIELDS)
		.append(", a.MODIFY_TIME as LAST_TIME FROM T_PROBLEM a")
		.append(" WHERE a.USER_ID=?")
		.append(") t88 inner join T_USER_BASIC ub")
		.append(" on t88.USER_ID=ub.USER_ID")
		.append(" left join (select pa.ANSWER_ID as ANSWER_ID, pa.CONTENT as ANSWER_CONTENT, pa.PROBLEM_ID as PROBLEM_ID, ub.USER_ID as ANSWER_USER_ID, ub.NAME as ANSWER_USER_NAME, ub.INTRODUCTION as ANSWER_USER_INTRODUCTION from T_PROBLEM_ANSWER pa, T_USER_BASIC ub where pa.USER_ID=ub.USER_ID) pa1")
		.append(" on t88.PROBLEM_ID=pa1.PROBLEM_ID")
		.append(" WHERE (t88.WAS_USERID IS NULL OR t88.WAS_USERID=?)")
		.append(" and (pa1.ANSWER_ID is null or pa1.ANSWER_ID in(select max(ANSWER_ID) from t_problem_answer group by PROBLEM_ID))")
		.append(" GROUP BY T88.PROBLEM_ID")
		.append(" ORDER BY t88.IS_TOP DESC, t88.LAST_TIME DESC");

		Object[] params = new Object[9];
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
	public Map<String,Object> getHottestProblemList(int userId, int province, int city, int nowPage, int onePageCount){
		Object[] params = null;
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ")
		.append(ALL_PROBLEM_FIELDS)
		.append(",(a.ANSWER_COUNT+a.ATTENTION_COUNT) as HOT_COUNT , ub.NAME AS NAME, ub.IMAGE_PATH AS IMAGE_PATH, ub.WEBSITE AS WEBSITE, ub.INTRODUCTION as INTRODUCTION")
		.append(",(select count(pa.ATTENTION_ID) from t_problem_attention pa where pa.PROBLEM_ID=a.PROBLEM_ID and pa.USER_ID=?) as IS_ATTENTION")
		.append(",(select count(pc.COLLECTION_ID) from t_problem_collection pc where pc.PROBLEM_ID=a.PROBLEM_ID and pc.USER_ID=?) as IS_COLLECTION")
		.append(", pa1.ANSWER_ID as ANSWER_ID, pa1.ANSWER_CONTENT as ANSWER_CONTENT, pa1.ANSWER_USER_ID as ANSWER_USER_ID, pa1.ANSWER_USER_NAME as ANSWER_USER_NAME, pa1.ANSWER_USER_INTRODUCTION as ANSWER_USER_INTRODUCTION")
		.append(" FROM T_PROBLEM a")
		.append(" JOIN T_USER_BASIC ub")
		.append(" ON a.USER_ID=ub.USER_ID")
		.append(" left join (select pa.ANSWER_ID as ANSWER_ID, pa.CONTENT as ANSWER_CONTENT, pa.PROBLEM_ID as PROBLEM_ID, ub.USER_ID as ANSWER_USER_ID, ub.NAME as ANSWER_USER_NAME, ub.INTRODUCTION as ANSWER_USER_INTRODUCTION from T_PROBLEM_ANSWER pa, T_USER_BASIC ub where pa.USER_ID=ub.USER_ID) pa1")
		.append("  on a.PROBLEM_ID=pa1.PROBLEM_ID")
		.append(" WHERE (a.WAS_USERID IS NULL OR a.WAS_USERID=?)")
		.append(" and (pa1.ANSWER_ID is null or pa1.ANSWER_ID in(select max(ANSWER_ID) from t_problem_answer group by PROBLEM_ID))");
		if(province > 0){ //只查同省问题
			sql.append(" AND (ub.PROVINCE is null or ub.PROVINCE=?)"); 
			params = new Object[]{userId, userId, userId, province};
		}else if(city > 0){//只查同城的问题
			sql.append(" AND (ub.CITY is null or ub.CITY=?)") ;
			params = new Object[]{userId, userId, userId, city};
		}
		sql.append(" ORDER BY a.IS_TOP DESC, HOT_COUNT desc, a.ATTENTION_COUNT DESC");
		
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
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
		.append(" SELECT").append(ALL_USER_BASIC_FIELDS).append(" FROM T_USER_BASIC ub, T_USER_BASIC UB2")
		.append(" WHERE ub.CITY=UB2.CITY")
		.append(" AND ub.BASIC_ID<>UB2.BASIC_ID")
		.append(" AND UB2.USER_ID=?")
		.append(" UNION")
		.append(" SELECT").append(ALL_USER_BASIC_FIELDS).append(" FROM T_USER_BASIC ub")
		.append(" WHERE ub.USER_ID IN(")
		.append(" SELECT UA1.USER_ID FROM T_USER_ATTENTION UA1, T_USER_ATTENTION UA2")
		.append(" WHERE UA1.WAS_USERID=UA2.WAS_USERID")
		.append(" AND UA1.USER_ID<>UA2.USER_ID")
		.append(" AND UA2.USER_ID=?")
		.append(" )")
		.append(" UNION")
		.append(" SELECT").append(ALL_USER_BASIC_FIELDS).append(" FROM T_USER_BASIC ub")
		.append(" WHERE ub.USER_ID IN(")
		.append(" SELECT UA1.USER_ID FROM T_USER_ATTENTIONTALK UA1, T_USER_ATTENTIONTALK UA2")
		.append(" WHERE UA1.TALK_ID=UA2.TALK_ID")
		.append(" AND UA1.USER_ID<>UA2.USER_ID")
		.append(" AND UA2.USER_ID=?)")
		.append(" ) AS ub WHERE ub.USER_ID NOT IN(")
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
	 * @param 当前页
	 * @param onePageCount 每页显示的记录条数
	 * @return 查询到的结果集
	 */
	public Map<String,Object> getAttentionUser(int userId, int nowPage, int onePageCount){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ").append(ALL_USER_BASIC_FIELDS)
		.append(" FROM T_USER_ATTENTION UA, T_USER_BASIC ub")
		.append(" WHERE UA.WAS_USERID=ub.USER_ID")
		.append(" AND UA.USER_ID=?");
		
		Object[] params = new Object[]{userId};
		
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据用户的ID，查询关注他的人
	 * @param userId 用户ID
	 * @param 当前页
	 * @param onePageCount 每页显示的记录条数
	 * @return 查询到的结果集
	 */
	public Map<String,Object> getWasAttentionUser(int userId, int nowPage, int onePageCount){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ").append(ALL_USER_BASIC_FIELDS)
		.append(" FROM T_USER_ATTENTION UA, T_USER_BASIC ub")
		.append(" WHERE UA.USER_ID=ub.USER_ID")
		.append(" AND UA.WAS_USERID=?");
		
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
	public Map<String,Object> getAttentionBrand(int userId, int loginUserId, int nowPage, int onePageCount){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT ").append(ALL_USER_BRAND_FIELDS)
		.append(", (select count(uba.BATTENTION_ID) from T_USER_BATTENTION uba where uba.BRAND_ID=ub.BRAND_ID and uba.USER_ID=?) as ATTENTION")
		.append(" FROM T_USER_BATTENTION UA, T_USER_BRAND ub")
		.append(" WHERE UA.BRAND_ID=ub.BRAND_ID")
		.append(" AND ub.STAUS=").append(IConstants.BRAND_STAUS_PASSED)
		.append(" AND UA.USER_ID=?")
		.append(" order by ub.CREATE_TIME desc");
		
		Object[] params = new Object[]{loginUserId, userId};
		
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 查询广告
	 * @param showType
	 * @param date
	 * @return
	 */
	public List<Map<String,Object>> getAdByShowTypeAndDate(String showType, Date date){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT AD_ID,TITLE,CONTENT,IMAGE,SHOW_TYPE,HREF,ORDER_BY,START_TIME,END_TIME,STATUS,REMARK")
		.append(" FROM T_AD a")
		.append(" WHERE a.STATUS=2")
		.append(" and a.SHOW_TYPE=?")
		.append(" AND a.START_TIME<=?")
		.append(" AND a.END_TIME>?");
		
		Object[] params = new Object[]{showType, date, date};
		
		return queryForListWithSQLQuery(sql.toString(), params);
	}
}