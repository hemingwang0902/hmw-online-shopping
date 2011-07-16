package com.baizhi.problemattention.dao;

import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;

 /**
 * 类名：ProblemAttentionDao.java<br>
 * 描述：问题关注信息表数据操作类，负责增删改查<br>
 * 创建者： 何明旺<br>
 * 创建日期：2011-07-10 13:47:14<br>
 * 版本：V0.9<br>
 * 修改者：  <br>
 * 修改日期：
 */
public class ProblemAttentionDao extends DaoSupport{
	
	/**
	 * 新增或修改问题关注信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateProblemAttention(Element element) {
		return this.saveOrUpdate(element, "ATTENTION_ID");
	}
	
	/**
	 *　删除问题关注信息表信息
	 * 
	 * @param ATTENTION_IDS   问题关注信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblemAttention(String ATTENTION_IDS) {
		return this.delete("T_PROBLEM_ATTENTION","ATTENTION_ID", ATTENTION_IDS);
	}
	
	/**
	 * 根据问题关注信息表ID获取问题关注信息表实体
	 * @param ATTENTION_ID 问题关注信息表ID
	 * @return 返回问题关注信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemAttentionEleById(String ATTENTION_ID){
		return this.getElementById("T_PROBLEM_ATTENTION", "ATTENTION_ID", ATTENTION_ID);
	}
	
	/**
	 *　获取问题关注信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemAttentionCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_PROBLEM_ATTENTION a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据问题关注信息表ID获取问题关注信息表信息
	 * @param ATTENTION_ID 问题关注信息表ID
	 * @return 返回问题关注信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemAttentionMapById(String ATTENTION_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.ATTENTION_ID as ATTENTION_ID,")//问题关注ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.IS_ATTENTION as IS_ATTENTION,")//是否关注(0否、1是)
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_ATTENTION a WHERE a.ATTENTION_ID=? ");
		return this.getById(sql.toString(), new Object[]{ATTENTION_ID});
	}
	
	/**
	 * 获取问题关注信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题关注信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemAttentionList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.ATTENTION_ID as ATTENTION_ID,")//问题关注ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.IS_ATTENTION as IS_ATTENTION,")//是否关注(0否、1是)
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_ATTENTION a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_PROBLEM_ATTENTION", nowPage, onePageCount);
	}
	
	/**
     * 获取问题关注信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题关注信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemAttentionList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.ATTENTION_ID as ATTENTION_ID,")//问题关注ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.IS_ATTENTION as IS_ATTENTION,")//是否关注(0否、1是)
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_ATTENTION a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	

	/**
	 * 根据用户ID和问题ID查询问题关注表的实体
	 * @param USER_ID 用户ID
	 * @param PROBLEM_ID 问题ID
	 * @return 返回问题关注表实体,如果无查询记录则返回null
	 */
	public  Element getProblemAttentionEleById(int USER_ID,int PROBLEM_ID){
		//组织查询语句
		String sql = "FROM T_PROBLEM_ATTENTION where USER_ID=? and PROBLEM_ID=?";
		return this.getElementById(sql.toString(), new Object[]{USER_ID,PROBLEM_ID});
	}

}