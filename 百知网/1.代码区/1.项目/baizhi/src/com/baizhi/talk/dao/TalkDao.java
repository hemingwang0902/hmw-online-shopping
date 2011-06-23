package com.baizhi.talk.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：TalkDao.java
 * 描述：话题信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-06-20 23:49:03
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class TalkDao extends DaoSupport{
	
	/**
	 * 新增或修改话题信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateTalk(Element element) {
		return this.saveOrUpdate(element, "TALK_ID");
	}
	
	/**
	 *　删除话题信息表信息
	 * 
	 * @param TALK_IDS   话题信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteTalk(String TALK_IDS) {
		return this.delete("T_TALK","TALK_ID", TALK_IDS);
	}
	
	/**
	 * 根据话题信息表ID获取话题信息表实体
	 * @param TALK_ID 话题信息表ID
	 * @return 返回话题信息表实体,如果无查询记录则返回null
	 */
	public  Element getTalkEleById(String TALK_ID){
		return this.getElementById("T_TALK", "TALK_ID", TALK_ID);
	}
	
	/**
	 *　获取话题信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getTalkCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_TALK a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据话题信息表ID获取话题信息表信息
	 * @param TALK_ID 话题信息表ID
	 * @return 返回话题信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getTalkMapById(String TALK_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.TALK_ID as TALK_ID,")//话题ID
		   .append("a.CONTENT as CONTENT,")//内容
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_TALK a WHERE a.TALK_ID=? ");
		return this.getById(sql.toString(), new Object[]{TALK_ID});
	}
	
	/**
	 * 获取话题信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回话题信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getTalkList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.TALK_ID as TALK_ID,")//话题ID
		   .append("a.CONTENT as CONTENT,")//内容
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("b.NAME as NAME,")//用户名
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_TALK a,T_USER_BASIC b WHERE a.USER_ID=b.USER_ID ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_TALK", nowPage, onePageCount);
	}
	
	/**
     * 获取话题信息表信息
     * 
     * @param  params 参数
     * @return 成功返回话题信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getTalkList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.TALK_ID as TALK_ID,")//话题ID
		   .append("a.CONTENT as CONTENT,")//内容
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_TALK a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

