package com.baizhi.score.dao;

import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：ScoreDao.java
 * 描述：积分信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-08-07 18:51:46
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class ScoreDao extends DaoSupport{
	
	/**
	 * 新增或修改积分信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateScore(Element element) {
		return this.saveOrUpdate(element, "SCORE_ID");
	}
	
	/**
	 *　禁用积分
	 * 
	 * @param SCORE_IDS   积分信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteScore(String SCORE_IDS,Integer IS_VALID) {
		return this.executeUpdate("update T_SCORE set IS_VALID=? where SCORE_ID=?", new Object[]{IS_VALID,SCORE_IDS})>0?true:false;
	}
	
	/**
	 * 根据积分信息表ID获取积分信息表实体
	 * @param SCORE_ID 积分信息表ID
	 * @return 返回积分信息表实体,如果无查询记录则返回null
	 */
	public  Element getScoreEleById(String SCORE_ID){
		return this.getElementById("T_SCORE", "SCORE_ID", SCORE_ID);
	}
	
	/**
	 *　获取积分信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getScoreCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_SCORE a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据积分信息表ID获取积分信息表信息
	 * @param SCORE_ID 积分信息表ID
	 * @return 返回积分信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getScoreMapById(String SCORE_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.SCORE_ID as SCORE_ID,")//积分ID
		   .append("a.NAME as NAME,")//积分名称
		   .append("a.SOCRE_TYPE as SOCRE_TYPE,")//积分类型(1、会员邀请朋友注册获得积分2、提问题3、回答问题)
		   .append("a.SOCRE as SOCRE,")//积分
		   .append("a.IS_VALID as IS_VALID,")//是否禁用
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_SCORE a WHERE a.SCORE_ID=? ");
		return this.getById(sql.toString(), new Object[]{SCORE_ID});
	}
	
	/**
	 * 获取积分信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回积分信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getScoreList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.SCORE_ID as SCORE_ID,")//积分ID
		   .append("a.NAME as NAME,")//积分名称
		   .append("a.SOCRE_TYPE as SOCRE_TYPE,")//积分类型(1、会员邀请朋友注册获得积分2、提问题3、回答问题)
		   .append("a.SOCRE as SOCRE,")//积分
		   .append("a.IS_VALID as IS_VALID,")//是否禁用
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_SCORE a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_SCORE", nowPage, onePageCount);
	}
	
	
}

