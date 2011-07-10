package com.baizhi.problemcollection.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;

 /**
 * 类名：ProblemCollectionDao.java<br>
 * 描述：问题收藏信息表数据操作类，负责增删改查<br>
 * 创建者： 何明旺<br>
 * 创建日期：2011-07-10 13:47:13<br>
 * 版本：V0.9<br>
 * 修改者：  <br>
 * 修改日期：
 */
public class ProblemCollectionDao extends DaoSupport{
	
	/**
	 * 新增或修改问题收藏信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateProblemCollection(Element element) {
		return this.saveOrUpdate(element, "COLLECTION_ID");
	}
	
	/**
	 *　删除问题收藏信息表信息
	 * 
	 * @param COLLECTION_IDS   问题收藏信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblemCollection(String COLLECTION_IDS) {
		return this.delete("T_PROBLEM_COLLECTION","COLLECTION_ID", COLLECTION_IDS);
	}
	
	/**
	 * 根据问题收藏信息表ID获取问题收藏信息表实体
	 * @param COLLECTION_ID 问题收藏信息表ID
	 * @return 返回问题收藏信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemCollectionEleById(String COLLECTION_ID){
		return this.getElementById("T_PROBLEM_COLLECTION", "COLLECTION_ID", COLLECTION_ID);
	}
	
	/**
	 *　获取问题收藏信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemCollectionCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_PROBLEM_COLLECTION a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据问题收藏信息表ID获取问题收藏信息表信息
	 * @param COLLECTION_ID 问题收藏信息表ID
	 * @return 返回问题收藏信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemCollectionMapById(String COLLECTION_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.COLLECTION_ID as COLLECTION_ID,")//问题收藏ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.IS_COLLECTION as IS_COLLECTION,")//是否收藏(0否、1是)
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_COLLECTION a WHERE a.COLLECTION_ID=? ");
		return this.getById(sql.toString(), new Object[]{COLLECTION_ID});
	}
	
	/**
	 * 获取问题收藏信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题收藏信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemCollectionList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.COLLECTION_ID as COLLECTION_ID,")//问题收藏ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.IS_COLLECTION as IS_COLLECTION,")//是否收藏(0否、1是)
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_COLLECTION a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_PROBLEM_COLLECTION", nowPage, onePageCount);
	}
	
	/**
     * 获取问题收藏信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题收藏信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemCollectionList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.COLLECTION_ID as COLLECTION_ID,")//问题收藏ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.IS_COLLECTION as IS_COLLECTION,")//是否收藏(0否、1是)
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_COLLECTION a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

