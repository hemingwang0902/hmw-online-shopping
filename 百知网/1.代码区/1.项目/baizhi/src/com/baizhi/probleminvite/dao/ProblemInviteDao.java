package com.baizhi.probleminvite.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;

 /**
 * 类名：ProblemInviteDao.java<br>
 * 描述：问题邀请人信息表数据操作类，负责增删改查<br>
 * 创建者： 何明旺<br>
 * 创建日期：2011-07-12 11:03:45<br>
 * 版本：V0.9<br>
 * 修改者：  <br>
 * 修改日期：
 */
public class ProblemInviteDao extends DaoSupport{
	
	/**
	 * 新增或修改问题邀请人信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateProblemInvite(Element element) {
		return this.saveOrUpdate(element, "INVITE_ID");
	}
	
	/**
	 *　删除问题邀请人信息表信息
	 * 
	 * @param INVITE_IDS   问题邀请人信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblemInvite(String INVITE_IDS) {
		return this.delete("T_PROBLEM_INVITE","INVITE_ID", INVITE_IDS);
	}
	
	/**
	 * 根据问题邀请人信息表ID获取问题邀请人信息表实体
	 * @param INVITE_ID 问题邀请人信息表ID
	 * @return 返回问题邀请人信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemInviteEleById(String INVITE_ID){
		return this.getElementById("T_PROBLEM_INVITE", "INVITE_ID", INVITE_ID);
	}
	
	/**
	 *　获取问题邀请人信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemInviteCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_PROBLEM_INVITE a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据问题邀请人信息表ID获取问题邀请人信息表信息
	 * @param INVITE_ID 问题邀请人信息表ID
	 * @return 返回问题邀请人信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemInviteMapById(String INVITE_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.INVITE_ID as INVITE_ID,")//问题邀请人ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.IS_ATTENTION as IS_ATTENTION,")//是否回答(0否、1是)
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.WAS_USER_ID as WAS_USER_ID,")//被邀请的用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_INVITE a WHERE a.INVITE_ID=? ");
		return this.getById(sql.toString(), new Object[]{INVITE_ID});
	}
	
	/**
	 * 获取问题邀请人信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题邀请人信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemInviteList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.INVITE_ID as INVITE_ID,")//问题邀请人ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.IS_ATTENTION as IS_ATTENTION,")//是否回答(0否、1是)
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.WAS_USER_ID as WAS_USER_ID,")//被邀请的用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_INVITE a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_PROBLEM_INVITE", nowPage, onePageCount);
	}
	
	/**
     * 获取问题邀请人信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题邀请人信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemInviteList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.INVITE_ID as INVITE_ID,")//问题邀请人ID
		   .append("a.PROBLEM_ID as PROBLEM_ID,")//问题ID
		   .append("a.IS_ATTENTION as IS_ATTENTION,")//是否回答(0否、1是)
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.WAS_USER_ID as WAS_USER_ID,")//被邀请的用户ID
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_PROBLEM_INVITE a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
	public  Element getProblemInviteEleById(int PROBLEM_ID, int USER_ID,int WAS_USERID){
		//组织查询语句
		String sql = "FROM T_PROBLEM_INVITE where PROBLEM_ID=? and USER_ID=? and WAS_USER_ID=?";
		return this.getElementById(sql.toString(), new Object[]{PROBLEM_ID, USER_ID, WAS_USERID});
	}
}