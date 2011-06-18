package com.${sysName}.${packageName}.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.${sysName}.commons.ServiceSupport;
import com.${sysName}.${packageName}.dao.${className}Dao;

/**
 * 
 * 类名：${className}Service.java
 * 描述： ${tabCon}服务类，负责增删改查
 * 创建者：${auth}
 * 创建日期： ${createDate}
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class ${className}Service extends ServiceSupport{
	
	private ${className}Dao ${packageName}Dao;
	
	public ${className}Dao get${className}Dao() {
		return ${packageName}Dao;
	}

	public void set${className}Dao(${className}Dao ${packageName}Dao) {
		this.${packageName}Dao = ${packageName}Dao;
	}
	
	/**
	 * 根据${tabCon} ID获取${tabCon}信息
	 * @param id ${tabCon}ID
	 * @return 返回${tabCon}信息,如果无查询记录则返回null
	 */
	public Map<String, Object> get${className}(String id){
		return ${packageName}Dao.get${className}(id);
	}
	
	/**
	 * 根据${tabCon}id获取${tabCon}实体
	 * @param id ${tabCon}id
	 * @return 返回${tabCon}实体,如果无查询记录则返回null
	 */
	public Element get${className}ElementById(String id){
		return ${packageName}Dao.get${className}ElementById(id);
	}
	
	/**
	 * 获取${tabCon}列表信息
	 * @param param 参数
	 * @param nowPage  当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回${tabCon}列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> ${packageName}List(Map<String, String> param,int nowPage,int onePageCount){
		return ${packageName}Dao.${packageName}List(param,nowPage,onePageCount);
	}
	
	/**
     * 获取所有${tabCon}
     * @return 成功返回所有${tabCon},如果无查询记录则返回null
     */
	public List<Map<String,Object>>  getAll${className}(){
		return ${packageName}Dao.getAll${className}();
	}
	
	/**
	 * 新增
	 * @param element ${tabCon}实体
	 * @return 成功返回主键ID，否则返回""
	 */
	public String add${className}(Element element){
		return ${packageName}Dao.add(element);
	}
	
	/**
	 * 检查${tabCon}
	 * @param ID   ID
	 * @param NAMES 名称
	 * @return 如果存在则返回false，否则返回true
	 */
	public  boolean check${className}(String ID, String NAMES){
		return ${packageName}Dao.check${className}(ID, NAMES);
	}
	
	/**
	 * 删除${tabCon}
	 * @param id ${tabCon}ID
	 * @return 成功返回true,失败返回false
	 */
	public boolean delete${className}(String id){
		return ${packageName}Dao.delete(id);
	}
	
	/**
	 * 修改
	 * @param element ${tabCon}实体
	 * @return 成功返回主键ID，否则返回""
	 */
	public String edit${className}(Element element){
		return ${packageName}Dao.edit(element);
	}

}
