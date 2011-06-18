package com.${sysName}.${packageName}.dao;

import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;
import org.hibernate.EntityMode;
import org.hibernate.Query;
import org.hibernate.Session;
import com.${sysName}.commons.DaoSupport;
import com.${sysName}.commons.PagerSupport;
/**
 * 
 * 类名：${className}Dao.java
 * 描述： ${tabCon}数据操作类，负责增删改查
 * 创建者：${auth}
 * 创建日期： ${createDate}
 * 版本：V0.9 
 * 修改者： 
 * 修改日期： 
 */
public class ${className}Dao extends DaoSupport{
	
	/**
	 * 根据${tabCon} ID获取${tabCon}信息
	 * @param id ${tabCon}ID
	 * @return 返回${tabCon}信息,如果无查询记录则返回null
	 */
	public Map<String, Object> get${className}(String id){
		Map<String,Object> ${packageName}Map = null;
		Session session = super.getSession();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		<#list lis as being>
		   .append("a.${being.oldCl} as ${being.oldCl},")//${being.content}
		</#list>
		   .append("'') FROM ${tableName} a WHERE a.${packageNameUpperCase}_ID=").append(id);
		try{
			List<Map<String,Object>> list = session.createQuery(sql.toString()).list();
			if(list!=null&&list.size()>0){
				${packageName}Map = list.get(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return ${packageName}Map;
	}
	
	/**
	 * 根据${tabCon}id获取${tabCon}实体
	 * @param id ${tabCon}id
	 * @return 返回${tabCon}实体,如果无查询记录则返回null
	 */
	public  Element get${className}ElementById(String id){
		Element element=null;
		Session session = super.getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		try {
			List<Element> list = dom4jSession.createQuery("FROM ${tableName} where ${packageNameUpperCase}_ID="+id).list();
			if(list!=null&&list.size()>0){
				element=list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return element;
	}
	
	/**
	 * 获取${tabCon}列表信息
	 * @param param 参数
	 * @param nowPage  当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回${tabCon}列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> ${packageName}List(Map<String, String> param,int nowPage,int onePageCount){
		Map<String,Object> ${packageName}Map = null;
		Session session = super.getSession();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		<#list lis as being>
		   .append("a.${being.oldCl} as ${being.oldCl},")//${being.content}
		</#list>
		   .append("'') FROM ${tableName} a WHERE 1=1");
		
		<#list lis as being>
			String ${being.oldCl}=param.get("${being.oldCl}");//${being.content}
		</#list>
		<#list lis as being>
		//设置条件${being.content}
		if(StringUtils.isNotEmpty(${being.oldCl})){
			sql.append(" AND a.${being.oldCl} = '"+${being.oldCl}.trim()+"'");
		}
		</#list>	
		
		try{
			Query query = session.createQuery(sql.toString());
			${packageName}Map = PagerSupport.getList(session, query, "${tableName}", nowPage, onePageCount);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return ${packageName}Map;
	}
	
	/**
     * 获取所有${tabCon}
     * @return 成功返回所有${tabCon},如果无查询记录则返回null
     */
	public List<Map<String,Object>>  getAll${className}(){
		List<Map<String,Object>> list=null;
		Session session=super.getSession();
		try{
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT new Map(")
			<#list lis as being>
			   .append("a.${being.oldCl} as being.oldCl,")//${being.content}
			</#list>
			   .append(" '') FROM ${tableName} a WHERE 1=1");
			list=session.createQuery(sql.toString()).list();
			if(list!=null&&list.size()>0){
				return list;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{  
			session.close();
		}
		return null;
	}
	  
	/**
	 * 新增${tabCon}
	 * @param element ${tabCon}实体
	 * @return 成功返回主键ID，否则返回""
	 */
	@Override
	public String add(Element element) {
		return this.add(element, "${packageNameUpperCase}_ID");
	}
	
	/**
	 * 检查${tabCon}
	 * @param ID   ID
	 * @param NAMES 名称
	 * @return 如果存在则返回false，否则返回true
	 */
	public boolean check${className}(String ID, String NAMES){
		boolean flag=true;
		StringBuffer sql=new StringBuffer("select count(${packageNameUpperCase}_ID) from ${tableName} where NAMES='"+NAMES+"'");
		Session session = super.getSession();
		try {
			if(StringUtils.isNotEmpty(ID)){
				sql.append(" and ${packageNameUpperCase}_ID <> "+ID);
			}
			List list = session.createQuery(sql.toString()).list();
			if(list!=null&&list.size()>0){
				if(Integer.parseInt(String.valueOf(list.get(0)))>0){
					flag=false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return flag;
	}
	
	/**
	 * 删除${tabCon}
	 * @param ${tabCon}ID 主键ID
	 * @return 成功返回true，否则返回false
	 */
	@Override
	public boolean delete(String id) {
		return this.delete("${tableName}", "${packageNameUpperCase}_ID", id);
	}
	
	/**
	 * 修改${tabCon}
	 * @param element ${tabCon}实体
	 * @return 成功返回主键ID，否则返回""
	 */
	@Override
	public String edit(Element element) {
		return this.edit(element, "${packageNameUpperCase}_ID");
	}
	
	@Override
	public Map<String, Object> getById(String id) {
		return null;
	}
	
	@Override
	public Map<String, Object> getList(Map<String, String> map, int nowPage, int onePageCount) {
		return null;
	}
}

