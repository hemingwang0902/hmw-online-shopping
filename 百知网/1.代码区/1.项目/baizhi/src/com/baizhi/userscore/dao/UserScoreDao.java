package com.baizhi.userscore.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import org.hibernate.Session;

import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
 /**
 * 
 * 类名：UserScoreDao.java
 * 描述：用户积分明细表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-08-07 20:03:25
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class UserScoreDao extends DaoSupport{
	
	
	/**
	 * 
	 * @param USER_ID      当前用户ID
	 * @param BUSINESS_ID  业务主键(邀请朋友ID、提问题ID、回答问题ID)
	 * @param DYNAMIC_TYPE 业务类型(1、会员邀请朋友注册获得积分2、提问题3、回答问题)
	 * @param DESCRIPTION  描述
	 * @param dom4jSession 数据库连接
	 * @return
	 * @throws Exception
	 */
	public String saveUserScore(Integer USER_ID,Integer BUSINESS_ID,String BUSINESS_TYPE,String DESCRIPTION,Session dom4jSession)throws Exception{
		//根据类型获取积分
		Integer SCORE=0;
		List<Integer> list = dom4jSession.createQuery("select SOCRE from T_SCORE where SOCRE_TYPE="+BUSINESS_TYPE).list();
		if(list!=null&&list.size()>0){
			SCORE=Integer.parseInt(String.valueOf(list.get(0)));
		}
		//新增积分明细
		String idValue = "";
		Element element = new DefaultElement("T_USER_SCORE");
		Elements.setElementValue(element, "USER_ID", USER_ID);// 用户ID
		Elements.setElementValue(element, "BUSINESS_ID", BUSINESS_ID);// 业务主键(邀请朋友ID、提问题ID、回答问题ID)
		Elements.setElementValue(element, "BUSINESS_TYPE", BUSINESS_TYPE);////业务类型(字典：1、会员邀请朋友注册获得积分2、提问题3、回答问题)
		Elements.setElementValue(element, "SCORE", SCORE);// 积分
		Elements.setElementValue(element, "DESCRIPTION", DESCRIPTION);// 描述
		Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		
		idValue=save(element,dom4jSession);
		//修改用户表积分
		dom4jSession.createQuery("update T_USER_BASIC set SCORE=SCORE+"+SCORE+" where USER_ID="+USER_ID).executeUpdate();
		
		return idValue;
	}
	
	/**
	 * 新增或修改用户积分明细表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserScore(Element element) {
		return this.saveOrUpdate(element, "SCORE_ID");
	}
	
	/**
	 *　删除用户积分明细表信息
	 * 
	 * @param SCORE_IDS   用户积分明细表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserScore(String SCORE_IDS) {
		return this.delete("T_USER_SCORE","SCORE_ID", SCORE_IDS);
	}
	
	/**
	 * 根据用户积分明细表ID获取用户积分明细表实体
	 * @param SCORE_ID 用户积分明细表ID
	 * @return 返回用户积分明细表实体,如果无查询记录则返回null
	 */
	public  Element getUserScoreEleById(String SCORE_ID){
		return this.getElementById("T_USER_SCORE", "SCORE_ID", SCORE_ID);
	}
	
	/**
	 *　获取用户积分明细表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserScoreCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_USER_SCORE a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据用户积分明细表ID获取用户积分明细表信息
	 * @param SCORE_ID 用户积分明细表ID
	 * @return 返回用户积分明细表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserScoreMapById(String SCORE_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.SCORE_ID as SCORE_ID,")//用户积分明细ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.BUSINESS_ID as BUSINESS_ID,")//业务主键(提问题ID、回答ID)
		   .append("a.BUSINESS_TYPE as BUSINESS_TYPE,")//业务类型(字典：1、会员邀请朋友注册获得积分2、提问题3、回答问题)
		   .append("a.SCORE as SCORE,")//积分
		   .append("a.DESCRIPTION as DESCRIPTION,")//描述
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_SCORE a WHERE a.SCORE_ID=? ");
		return this.getById(sql.toString(), new Object[]{SCORE_ID});
	}
	
	/**
	 * 获取用户积分明细表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户积分明细表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserScoreList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.SCORE_ID as SCORE_ID,")//用户积分明细ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.BUSINESS_ID as BUSINESS_ID,")//业务主键(提问题ID、回答ID)
		   .append("a.BUSINESS_TYPE as BUSINESS_TYPE,")//业务类型(字典：1、会员邀请朋友注册获得积分2、提问题3、回答问题)
		   .append("a.SCORE as SCORE,")//积分
		   .append("a.DESCRIPTION as DESCRIPTION,")//描述
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_SCORE a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_USER_SCORE", nowPage, onePageCount);
	}
	
	/**
     * 获取用户积分明细表信息
     * 
     * @param  params 参数
     * @return 成功返回用户积分明细表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserScoreList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.SCORE_ID as SCORE_ID,")//用户积分明细ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.BUSINESS_ID as BUSINESS_ID,")//业务主键(提问题ID、回答ID)
		   .append("a.BUSINESS_TYPE as BUSINESS_TYPE,")//业务类型(字典：1、会员邀请朋友注册获得积分2、提问题3、回答问题)
		   .append("a.SCORE as SCORE,")//积分
		   .append("a.DESCRIPTION as DESCRIPTION,")//描述
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_SCORE a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

