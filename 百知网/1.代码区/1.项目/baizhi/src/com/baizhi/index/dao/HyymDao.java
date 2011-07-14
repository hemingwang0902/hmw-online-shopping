package com.baizhi.index.dao;

import java.util.List;
import java.util.Map;

import com.baizhi.commons.DaoSupport;

/**
 * 类名： HyymDao<br>
 * 描述：会员页面Dao<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-7<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class HyymDao extends DaoSupport{
	private final String ALL_PROBLEM_FIELDS = " a.PROBLEM_ID as PROBLEM_ID,a.PROBLEM_TYPE as PROBLEM_TYPE,a.CONTENT as CONTENT,a.IS_ANONYMITY as IS_ANONYMITY,a.RELEVANT_DETAILS as RELEVANT_DETAILS,a.USER_ID as USER_ID,a.WAS_USERID as WAS_USERID,a.ANSWER_COUNT as ANSWER_COUNT,a.REVIEW_COUNT as REVIEW_COUNT,a.ATTENTION_COUNT as ATTENTION_COUNT,a.COLLECTION_COUNT as COLLECTION_COUNT,a.BROWSE_COUNT as BROWSE_COUNT,a.IS_REPORT as IS_REPORT,a.REPORT_COUNT as REPORT_COUNT,a.CREATE_TIME as CREATE_TIME,a.MODIFY_TIME as MODIFY_TIME ";
	
	/**
	 * 根据会员ID查询他问过的问题
	 * @param userId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getProblemListByUserId(int userId, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append(" SELECT ").append(ALL_PROBLEM_FIELDS)
		.append(" FROM T_PROBLEM A")
		.append(" WHERE A.USER_ID=?")
		.append(" ORDER BY a.CREATE_TIME DESC");

		return queryForListWithSQLQuery(sql.toString(), new Object[]{userId}, nowPage, onePageCount);
	}
	
	/**
	 * 根据会员ID查询他回答过的问题
	 * @param userId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getAnsweredProblemList(int userId, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append(" SELECT ").append(ALL_PROBLEM_FIELDS)
		.append(" FROM T_PROBLEM A")
		.append(" WHERE A.PROBLEM_ID IN(")
		.append(" SELECT PROBLEM_ID FROM T_PROBLEM_ANSWER PA WHERE PA.USER_ID=?")
		.append(") ORDER BY a.CREATE_TIME DESC");
		
		return queryForListWithSQLQuery(sql.toString(), new Object[]{userId}, nowPage, onePageCount);
	}
	
	/**
	 * 根据姓名（名称）模糊查询会员（品牌）列表
	 * @param name
	 * @param userType
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getUserListByName(String name, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append("SELECT a.BASIC_ID as BASIC_ID,a.USER_ID as USER_ID,a.USER_TYPE as USER_TYPE,a.NAME as NAME,a.SOURCE as SOURCE,a.PROVINCE as PROVINCE,a.CITY as CITY,a.INDUSTRY as INDUSTRY,a.YEARS as YEARS,a.LINK_MODE as LINK_MODE,a.IS_OPEN as IS_OPEN,a.INTRODUCTION as INTRODUCTION,a.MOTTO as MOTTO,a.IMAGE_PATH as IMAGE_PATH,a.WEBSITE as WEBSITE,a.PRIVATE_SET as PRIVATE_SET,a.LEVEL as LEVEL,a.SCORE as SCORE,a.REMARK as REMARK,a.CREATE_TIME as CREATE_TIME,a.MODIFY_TIME as MODIFY_TIME")
		.append(" FROM T_USER_BASIC a WHERE a.NAME LIKE ?");
		
		Object[] params = new Object[]{name};
		
		sql.append(" ORDER BY a.CREATE_TIME DESC");
		
		return queryForListWithSQLQuery(sql.toString(), params, nowPage, onePageCount);
	}
	
	/**
	 * 根据用户ID查询关注的话题列表
	 * @param userId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getAttentionTalkList(int userId, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer()		
		.append("SELECT A.TALK_ID AS TALK_ID,A.CONTENT AS CONTENT,A.USER_ID AS USER_ID,A.CREATE_TIME AS CREATE_TIME,A.MODIFY_TIME AS MODIFY_TIME")
		.append(" FROM T_TALK A WHERE A.TALK_ID IN(")
		.append(" SELECT TALK_ID FROM T_USER_ATTENTIONTALK UAT WHERE UAT.USER_ID=?")
		.append(") ORDER BY a.CREATE_TIME DESC");
		
		return queryForListWithSQLQuery(sql.toString(), new Object[]{userId}, nowPage, onePageCount);
	}
	
	/**
	 * 根据用户基本信息表ID获取用户基本信息表信息
	 * @param userId 用户ID
	 * @return 返回用户基本信息表信息,如果无查询记录则返回null
	 */
	public List<Map<String, Object>> getUserBasicMapByUserId(String userId){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ")
		   .append("a.BASIC_ID as BASIC_ID,")//用户基本信息ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.USER_TYPE as USER_TYPE,")//用户类型(字典：1用户、2品牌)冗余字段
		   .append("a.NAME as NAME,")//姓名/品牌名称
		   .append("a.SOURCE as SOURCE,")//发源地(品牌特有)
		   .append("a.PROVINCE as PROVINCE,")//所在地区(省：地区信息表ID)
		   .append("a.CITY as CITY,")//所在地区(市：地区信息表ID)
		   .append("a.INDUSTRY as INDUSTRY,")//从事行业(字典)
		   .append("a.YEARS as YEARS,")//所在年代(字典、用户特有)
		   .append("a.LINK_MODE as LINK_MODE,")//联系方式
		   .append("a.IS_OPEN as IS_OPEN,")//是否对外开放(0否、1是)
		   .append("a.INTRODUCTION as INTRODUCTION,")//个人介绍/品牌介绍
		   .append("a.MOTTO as MOTTO,")//人生格言(用户特有)
		   .append("a.IMAGE_PATH as IMAGE_PATH,")//相片路径/LOGO路径
		   .append("a.WEBSITE as WEBSITE,")//个性网址
		   .append("a.PRIVATE_SET as PRIVATE_SET,")//私信设置(字典：1所有人、2我关注的人)
		   .append("a.LEVEL as LEVEL,")//级别
		   .append("a.SCORE as SCORE,")//积分
		   .append("a.REMARK as REMARK,")//备注
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME ")//修改时间
		   .append("FROM T_USER_BASIC a WHERE a.USER_ID=? ");
		return queryForListWithSQLQuery(sql.toString(), new Object[]{userId});
	}
}
