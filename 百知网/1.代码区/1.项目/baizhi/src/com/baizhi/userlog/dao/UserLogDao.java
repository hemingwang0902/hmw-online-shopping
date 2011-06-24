package com.baizhi.userlog.dao;

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
 * 类名：UserLogDao.java
 * 描述：用户日志表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-06-24 21:28:32
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class UserLogDao extends DaoSupport{
	
	/**
	 * 新增或修改用户日志表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserLog(Element element) {
		return this.saveOrUpdate(element, "LOG_ID");
	}
	
	
	/**
	 * 新增用户日志表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 * @throws Exception 
	 */
	public String saveUserLog(String USER_ID,String IP,Session dom4jSession) throws Exception {
		Element element = new DefaultElement("T_USER_LOG");
		Elements.setElementValue(element, "USER_ID", USER_ID);// 用户ID
		Elements.setElementValue(element, "LOGIN_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 登录时间
		Elements.setElementValue(element, "IP", IP);// IP
		Elements.setElementValue(element, "MAC", "");// MAC
		return this.save(element, dom4jSession);
	}
	
	/**
	 *　删除用户日志表信息
	 * 
	 * @param LOG_IDS   用户日志表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserLog(String LOG_IDS) {
		return this.delete("T_USER_LOG","LOG_ID", LOG_IDS);
	}
	
	/**
	 * 根据用户日志表ID获取用户日志表实体
	 * @param LOG_ID 用户日志表ID
	 * @return 返回用户日志表实体,如果无查询记录则返回null
	 */
	public  Element getUserLogEleById(String LOG_ID){
		return this.getElementById("T_USER_LOG", "LOG_ID", LOG_ID);
	}
	
	/**
	 *　获取用户日志表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserLogCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_USER_LOG a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据用户日志表ID获取用户日志表信息
	 * @param LOG_ID 用户日志表ID
	 * @return 返回用户日志表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserLogMapById(String LOG_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.LOG_ID as LOG_ID,")//用户日志ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.LOGIN_TIME as LOGIN_TIME,")//登录时间
		   .append("a.IP as IP,")//IP
		   .append("a.MAC as MAC) ")//MAC
		   .append("FROM T_USER_LOG a WHERE a.LOG_ID=? ");
		return this.getById(sql.toString(), new Object[]{LOG_ID});
	}
	
	/**
	 * 获取用户日志表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户日志表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserLogList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.LOG_ID as LOG_ID,")//用户日志ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.LOGIN_TIME as LOGIN_TIME,")//登录时间
		   .append("a.IP as IP,")//IP
		   .append("a.MAC as MAC) ")//MAC
		   .append("FROM T_USER_LOG a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_USER_LOG", nowPage, onePageCount);
	}
	
	/**
     * 获取用户日志表信息
     * 
     * @param  params 参数
     * @return 成功返回用户日志表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserLogList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.LOG_ID as LOG_ID,")//用户日志ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.LOGIN_TIME as LOGIN_TIME,")//登录时间
		   .append("a.IP as IP,")//IP
		   .append("a.MAC as MAC) ")//MAC
		   .append("FROM T_USER_LOG a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

