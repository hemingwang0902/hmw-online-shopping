package com.baizhi.problem.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
import com.baizhi.commons.constant.Diclist;
 /**
 * 
 * 类名：ProblemDao.java
 * 描述：问题信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-06-21 00:45:57
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class ProblemDao extends DaoSupport{
	
	/**
	 * 新增或修改问题信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateProblem(Element element) {
		return this.saveOrUpdate(element, "PROBLEM_ID");
	}
	
	/**
	 *　删除问题信息表信息
	 * 
	 * @param PROBLEM_IDS   问题信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblem(String PROBLEM_IDS) {
		return this.delete("T_PROBLEM","PROBLEM_ID", PROBLEM_IDS);
	}
	
	/**
	 * 根据问题信息表ID获取问题信息表实体
	 * @param PROBLEM_ID 问题信息表ID
	 * @return 返回问题信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemEleById(String PROBLEM_ID){
		return this.getElementById("T_PROBLEM", "PROBLEM_ID", PROBLEM_ID);
	}
	
	/**
	 *　获取问题信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_PROBLEM a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据问题信息表ID获取问题信息表信息
	 * @param PROBLEM_ID 问题信息表ID
	 * @return 返回问题信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemMapById(String PROBLEM_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.PROBLEM_TYPE as PROBLEM_TYPE,")//问题类型(字典：1普通、2我问的问题)
		   .append("a.CONTENT as CONTENT,")//问题内容
		   .append("a.IS_ANONYMITY as IS_ANONYMITY,")//是否匿名(0否、1是)
		   .append("a.RELEVANT_DETAILS as RELEVANT_DETAILS,")//相关细节
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.WAS_USERID as WAS_USERID,")//被问用户ID
		   .append("a.ANSWER_COUNT as ANSWER_COUNT,")//答案数量
		   .append("a.REVIEW_COUNT as REVIEW_COUNT,")//评论数量
		   .append("a.ATTENTION_COUNT as ATTENTION_COUNT,")//关注数量
		   .append("a.COLLECTION_COUNT as COLLECTION_COUNT,")//收藏数量
		   .append("a.BROWSE_COUNT as BROWSE_COUNT,")//浏览次数
		   .append("a.IS_REPORT as IS_REPORT,")//是否举报(0否、1是)
		   .append("a.REPORT_COUNT as REPORT_COUNT,")//举报次数
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM a WHERE a.PROBLEM_ID=? ");
		return this.getById(sql.toString(), new Object[]{PROBLEM_ID});
	}
	
	/**
	 * 获取问题信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("(select DIC_NAME from T_DICITEM where a.PROBLEM_TYPE=DIC_CODE and CODE='"+Diclist.BZ000002+"') as PROBLEM_TYPE_NAME,")//问题类型(字典：1普通、2我问的问题)
		   .append("a.CONTENT as CONTENT,")//问题内容
		   .append("a.IS_ANONYMITY as IS_ANONYMITY,")//是否匿名(0否、1是)
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("(select NAME from T_USER_BASIC where USER_ID=a.USER_ID) as NAME,")//会员姓名
		   .append("a.ANSWER_COUNT as ANSWER_COUNT,")//答案数量
		   .append("a.REVIEW_COUNT as REVIEW_COUNT,")//评论数量
		   .append("a.ATTENTION_COUNT as ATTENTION_COUNT,")//关注数量
		   .append("a.COLLECTION_COUNT as COLLECTION_COUNT,")//收藏数量
		   .append("a.BROWSE_COUNT as BROWSE_COUNT,")//浏览次数
		   .append("a.IS_REPORT as IS_REPORT,")//是否举报(0否、1是)
		   .append("a.REPORT_COUNT as REPORT_COUNT,")//举报次数
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_PROBLEM", nowPage, onePageCount);
	}
	
	/**
     * 获取问题信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.PROBLEM_TYPE as PROBLEM_TYPE,")//问题类型(字典：1普通、2我问的问题)
		   .append("a.CONTENT as CONTENT,")//问题内容
		   .append("a.IS_ANONYMITY as IS_ANONYMITY,")//是否匿名(0否、1是)
		   .append("a.RELEVANT_DETAILS as RELEVANT_DETAILS,")//相关细节
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.WAS_USERID as WAS_USERID,")//被问用户ID
		   .append("a.ANSWER_COUNT as ANSWER_COUNT,")//答案数量
		   .append("a.REVIEW_COUNT as REVIEW_COUNT,")//评论数量
		   .append("a.ATTENTION_COUNT as ATTENTION_COUNT,")//关注数量
		   .append("a.COLLECTION_COUNT as COLLECTION_COUNT,")//收藏数量
		   .append("a.BROWSE_COUNT as BROWSE_COUNT,")//浏览次数
		   .append("a.IS_REPORT as IS_REPORT,")//是否举报(0否、1是)
		   .append("a.REPORT_COUNT as REPORT_COUNT,")//举报次数
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

