package com.baizhi.problemtalk.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;

 /**
 * 类名：ProblemTalkDao.java<br>
 * 描述：问题话题信息表数据操作类，负责增删改查<br>
 * 创建者： 何明旺<br>
 * 创建日期：2011-07-14 10:39:35<br>
 * 版本：V0.9<br>
 * 修改者：  <br>
 * 修改日期：
 */
public class ProblemTalkDao extends DaoSupport{
	
	/**
	 * 新增或修改问题话题信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateProblemTalk(Element element) {
		return this.saveOrUpdate(element, "PROBLEMTALK_ID");
	}
	
	/**
	 *　删除问题话题信息表信息
	 * 
	 * @param PROBLEMTALK_IDS   问题话题信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblemTalk(String PROBLEMTALK_IDS) {
		return this.delete("T_PROBLEM_TALK","PROBLEMTALK_ID", PROBLEMTALK_IDS);
	}
	
	/**
	 * 根据问题话题信息表ID获取问题话题信息表实体
	 * @param PROBLEMTALK_ID 问题话题信息表ID
	 * @return 返回问题话题信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemTalkEleById(String PROBLEMTALK_ID){
		return this.getElementById("T_PROBLEM_TALK", "PROBLEMTALK_ID", PROBLEMTALK_ID);
	}
	
	/**
	 *　获取问题话题信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemTalkCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_PROBLEM_TALK a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据问题话题信息表ID获取问题话题信息表信息
	 * @param PROBLEMTALK_ID 问题话题信息表ID
	 * @return 返回问题话题信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemTalkMapById(String PROBLEMTALK_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PROBLEMTALK_ID as PROBLEMTALK_ID,")//问题话题ID
		   .append("a.TALK_ID as TALK_ID,")//话题ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_TALK a WHERE a.PROBLEMTALK_ID=? ");
		return this.getById(sql.toString(), new Object[]{PROBLEMTALK_ID});
	}
	
	/**
	 * 获取问题话题信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题话题信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemTalkList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PROBLEMTALK_ID as PROBLEMTALK_ID,")//问题话题ID
		   .append("a.TALK_ID as TALK_ID,")//话题ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_TALK a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_PROBLEM_TALK", nowPage, onePageCount);
	}
	
	/**
     * 获取问题话题信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题话题信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemTalkList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PROBLEMTALK_ID as PROBLEMTALK_ID,")//问题话题ID
		   .append("a.TALK_ID as TALK_ID,")//话题ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_TALK a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
	public  Element getProblemTalkEleById(int PROBLEM_ID, int TALK_ID){
		String sql = "FROM T_PROBLEM_TALK where PROBLEM_ID=? and TALK_ID=?";
		return this.getElementById(sql, new Object[]{PROBLEM_ID, TALK_ID});
	}
}

