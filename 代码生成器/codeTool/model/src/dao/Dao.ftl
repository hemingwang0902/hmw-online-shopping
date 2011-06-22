package com.${sysName}.${packageName}.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.${sysName}.commons.DaoSupport;
import com.${sysName}.commons.ParametersSupport;
 /**
 * 
 * 类名：${className}Dao.java
 * 描述：${tabCon}数据操作类，负责增删改查
 * 创建者： ${auth}
 * 创建日期：${createDate}
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class ${className}Dao extends DaoSupport{
	
	/**
	 * 新增或修改${tabCon}信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdate${className}(Element element) {
		return this.saveOrUpdate(element, "${PK_KEY}");
	}
	
	/**
	 *　删除${tabCon}信息
	 * 
	 * @param ${PK_KEY}S   ${tabCon}ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean delete${className}(String ${PK_KEY}S) {
		return this.delete("${tableName}","${PK_KEY}", ${PK_KEY}S);
	}
	
	/**
	 * 根据${tabCon}ID获取${tabCon}实体
	 * @param ${PK_KEY} ${tabCon}ID
	 * @return 返回${tabCon}实体,如果无查询记录则返回null
	 */
	public  Element get${className}EleById(String ${PK_KEY}){
		return this.getElementById("${tableName}", "${PK_KEY}", ${PK_KEY});
	}
	
	/**
	 *　获取${tabCon}数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int get${className}Count(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM ${tableName} a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据${tabCon}ID获取${tabCon}信息
	 * @param ${PK_KEY} ${tabCon}ID
	 * @return 返回${tabCon}信息,如果无查询记录则返回null
	 */
	public Map<String, Object> get${className}MapById(String ${PK_KEY}){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		<#list lis as being>
			<#if being_index != (totalcount-1)>
		   .append("a.${being.oldCl} as ${being.oldCl},")//${being.content}
			<#else>
		   .append("a.${being.oldCl} as ${being.oldCl}) ")//${being.content}
			</#if>
		</#list>
		   .append("FROM ${tableName} a WHERE a.${PK_KEY}=? ");
		return this.getById(sql.toString(), new Object[]{${PK_KEY}});
	}
	
	/**
	 * 获取${tabCon}列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回${tabCon}列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> get${className}List(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   <#list lis as being>
		   <#if being_index != (totalcount-1)>
		   .append("a.${being.oldCl} as ${being.oldCl},")//${being.content}
			<#else>
		   .append("a.${being.oldCl} as ${being.oldCl}) ")//${being.content}
			</#if>
		   </#list>
		   .append("FROM ${tableName} a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "${tableName}", nowPage, onePageCount);
	}
	
	/**
     * 获取${tabCon}信息
     * 
     * @param  params 参数
     * @return 成功返回${tabCon}信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> get${className}List(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   <#list lis as being>
		   <#if being_index != (totalcount-1)>
		   .append("a.${being.oldCl} as ${being.oldCl},")//${being.content}
			<#else>
		   .append("a.${being.oldCl} as ${being.oldCl}) ")//${being.content}
			</#if>
		   </#list>
		   .append("FROM ${tableName} a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

