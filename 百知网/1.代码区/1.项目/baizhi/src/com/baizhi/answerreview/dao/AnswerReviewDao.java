package com.baizhi.answerreview.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;

 /**
 * 类名：AnswerReviewDao.java<br>
 * 描述：问题答案评论信息表数据操作类，负责增删改查<br>
 * 创建者： 何明旺<br>
 * 创建日期：2011-07-14 16:22:27<br>
 * 版本：V0.9<br>
 * 修改者：  <br>
 * 修改日期：
 */
public class AnswerReviewDao extends DaoSupport{
	
	/**
	 * 新增或修改问题答案评论信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateAnswerReview(Element element) {
		return this.saveOrUpdate(element, "REVIEW_ID");
	}
	
	/**
	 *　删除问题答案评论信息表信息
	 * 
	 * @param REVIEW_IDS   问题答案评论信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteAnswerReview(String REVIEW_IDS) {
		return this.delete("T_ANSWER_REVIEW","REVIEW_ID", REVIEW_IDS);
	}
	
	/**
	 * 根据问题答案评论信息表ID获取问题答案评论信息表实体
	 * @param REVIEW_ID 问题答案评论信息表ID
	 * @return 返回问题答案评论信息表实体,如果无查询记录则返回null
	 */
	public  Element getAnswerReviewEleById(String REVIEW_ID){
		return this.getElementById("T_ANSWER_REVIEW", "REVIEW_ID", REVIEW_ID);
	}
	
	/**
	 *　获取问题答案评论信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getAnswerReviewCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_ANSWER_REVIEW a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据问题答案评论信息表ID获取问题答案评论信息表信息
	 * @param REVIEW_ID 问题答案评论信息表ID
	 * @return 返回问题答案评论信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getAnswerReviewMapById(String REVIEW_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.REVIEW_ID as REVIEW_ID,")//问题答案评论ID
		   .append("a.ANSWER_ID as ANSWER_ID,")//问题答案ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID(冗余字段)
		   .append("a.CONTENT as CONTENT,")//内容
		   .append("a.PREVIEW_ID as PREVIEW_ID,")//问题答案评论ID父ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_ANSWER_REVIEW a WHERE a.REVIEW_ID=? ");
		return this.getById(sql.toString(), new Object[]{REVIEW_ID});
	}
	
	/**
	 * 获取问题答案评论信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题答案评论信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getAnswerReviewList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.REVIEW_ID as REVIEW_ID,")//问题答案评论ID
		   .append("a.ANSWER_ID as ANSWER_ID,")//问题答案ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID(冗余字段)
		   .append("a.CONTENT as CONTENT,")//内容
		   .append("a.PREVIEW_ID as PREVIEW_ID,")//问题答案评论ID父ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_ANSWER_REVIEW a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_ANSWER_REVIEW", nowPage, onePageCount);
	}
	
	/**
     * 获取问题答案评论信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题答案评论信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getAnswerReviewList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.REVIEW_ID as REVIEW_ID,")//问题答案评论ID
		   .append("a.ANSWER_ID as ANSWER_ID,")//问题答案ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID(冗余字段)
		   .append("a.CONTENT as CONTENT,")//内容
		   .append("a.PREVIEW_ID as PREVIEW_ID,")//问题答案评论ID父ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_ANSWER_REVIEW a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

