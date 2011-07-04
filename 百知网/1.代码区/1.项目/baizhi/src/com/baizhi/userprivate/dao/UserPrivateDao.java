package com.baizhi.userprivate.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：UserPrivateDao.java
 * 描述：用户私信信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-07-05 00:26:42
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class UserPrivateDao extends DaoSupport{
	
	/**
	 * 新增或修改用户私信信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserPrivate(Element element) {
		return this.saveOrUpdate(element, "PRIVATE_ID");
	}
	
	/**
	 *　删除用户私信信息表信息
	 * 
	 * @param PRIVATE_IDS   用户私信信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserPrivate(String PRIVATE_IDS) {
		return this.delete("T_USER_PRIVATE","PRIVATE_ID", PRIVATE_IDS);
	}
	
	/**
	 * 根据用户私信信息表ID获取用户私信信息表实体
	 * @param PRIVATE_ID 用户私信信息表ID
	 * @return 返回用户私信信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserPrivateEleById(String PRIVATE_ID){
		return this.getElementById("T_USER_PRIVATE", "PRIVATE_ID", PRIVATE_ID);
	}
	
	/**
	 *　获取用户私信信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserPrivateCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_USER_PRIVATE a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据用户私信信息表ID获取用户私信信息表信息
	 * @param PRIVATE_ID 用户私信信息表ID
	 * @return 返回用户私信信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserPrivateMapById(String PRIVATE_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PRIVATE_ID as PRIVATE_ID,")//私信ID
		   .append("a.USER_ID as USER_ID,")//收件人ID
		   .append("a.SEND_ID as SEND_ID,")//发送人ID
		   .append("a.CONTENT as CONTENT,")//发送内容
		   .append("a.IS_READ as IS_READ,")//是否阅读(0否、1是)
		   .append("a.PPRIVATE_ID as PPRIVATE_ID,")//父私信ID（私信、与私信回复为一张表）
		   .append("a.CREATE_TIME as CREATE_TIME) ")//创建时间
		   .append("FROM T_USER_PRIVATE a WHERE a.PRIVATE_ID=? ");
		return this.getById(sql.toString(), new Object[]{PRIVATE_ID});
	}
	
	/**
	 * 获取用户私信信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户私信信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserPrivateList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PRIVATE_ID as PRIVATE_ID,")//私信ID
		   .append("a.USER_ID as USER_ID,")//收件人ID
		   .append("a.SEND_ID as SEND_ID,")//发送人ID
		   .append("a.CONTENT as CONTENT,")//发送内容
		   .append("a.IS_READ as IS_READ,")//是否阅读(0否、1是)
		   .append("a.PPRIVATE_ID as PPRIVATE_ID,")//父私信ID（私信、与私信回复为一张表）
		   .append("a.CREATE_TIME as CREATE_TIME) ")//创建时间
		   .append("FROM T_USER_PRIVATE a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_USER_PRIVATE", nowPage, onePageCount);
	}
	
	/**
     * 获取用户私信信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户私信信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserPrivateList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PRIVATE_ID as PRIVATE_ID,")//私信ID
		   .append("a.USER_ID as USER_ID,")//收件人ID
		   .append("a.SEND_ID as SEND_ID,")//发送人ID
		   .append("a.CONTENT as CONTENT,")//发送内容
		   .append("a.IS_READ as IS_READ,")//是否阅读(0否、1是)
		   .append("a.PPRIVATE_ID as PPRIVATE_ID,")//父私信ID（私信、与私信回复为一张表）
		   .append("a.CREATE_TIME as CREATE_TIME) ")//创建时间
		   .append("FROM T_USER_PRIVATE a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

