package com.baizhi.scorelevel.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：ScoreLevelDao.java
 * 描述：积分级别信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-06-21 00:43:41
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class ScoreLevelDao extends DaoSupport{
	
	/**
	 * 新增或修改积分级别信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateScoreLevel(Element element) {
		return this.saveOrUpdate(element, "SCORELEVEL_ID");
	}
	
	/**
	 *　删除积分级别信息表信息
	 * 
	 * @param SCORELEVEL_IDS   积分级别信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteScoreLevel(String SCORELEVEL_IDS) {
		return this.delete("T_SCORE_LEVEL","SCORELEVEL_ID", SCORELEVEL_IDS);
	}
	
	/**
	 * 根据积分级别信息表ID获取积分级别信息表实体
	 * @param SCORELEVEL_ID 积分级别信息表ID
	 * @return 返回积分级别信息表实体,如果无查询记录则返回null
	 */
	public  Element getScoreLevelEleById(String SCORELEVEL_ID){
		return this.getElementById("T_SCORE_LEVEL", "SCORELEVEL_ID", SCORELEVEL_ID);
	}
	
	/**
	 *　获取积分级别信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getScoreLevelCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_SCORE_LEVEL a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据积分级别信息表ID获取积分级别信息表信息
	 * @param SCORELEVEL_ID 积分级别信息表ID
	 * @return 返回积分级别信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getScoreLevelMapById(String SCORELEVEL_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.SCORELEVEL_ID as SCORELEVEL_ID,")//积分级别ID
		   .append("a.NAME as NAME,")//级别名称
		   .append("a.SOCRE_UP as SOCRE_UP,")//积分上限
		   .append("a.SOCRE_DOWN as SOCRE_DOWN,")//积分下限
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_SCORE_LEVEL a WHERE a.SCORELEVEL_ID=? ");
		return this.getById(sql.toString(), new Object[]{SCORELEVEL_ID});
	}
	
	/**
	 * 获取积分级别信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回积分级别信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getScoreLevelList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.SCORELEVEL_ID as SCORELEVEL_ID,")//积分级别ID
		   .append("a.NAME as NAME,")//级别名称
		   .append("a.SOCRE_UP as SOCRE_UP,")//积分上限
		   .append("a.SOCRE_DOWN as SOCRE_DOWN,")//积分下限
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_SCORE_LEVEL a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_SCORE_LEVEL", nowPage, onePageCount);
	}
	
	/**
     * 获取积分级别信息表信息
     * 
     * @param  params 参数
     * @return 成功返回积分级别信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getScoreLevelList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.SCORELEVEL_ID as SCORELEVEL_ID,")//积分级别ID
		   .append("a.NAME as NAME,")//级别名称
		   .append("a.SOCRE_UP as SOCRE_UP,")//积分上限
		   .append("a.SOCRE_DOWN as SOCRE_DOWN,")//积分下限
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_SCORE_LEVEL a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

