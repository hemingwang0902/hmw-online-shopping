package com.${sysName}.${packageName}.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.${sysName}.commons.ServiceSupport;
import com.${sysName}.${packageName}.dao.${className}Dao;

/**
 * 类名：${className}Service.java<br>
 * 描述： ${tabCon}服务类，负责增删改查<br>
 * 创建者：${auth}<br>
 * 创建日期： ${createDate}<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class ${className}Service extends ServiceSupport{
	
	private ${className}Dao ${beanname}Dao;
	
	public ${className}Dao get${className}Dao() {
		return ${beanname}Dao;
	}

	public void set${className}Dao(${className}Dao ${beanname}Dao) {
		this.${beanname}Dao = ${beanname}Dao;
	}
	
	/**
	 * 新增或修改${tabCon}信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdate${className}(Element element) {
		return ${beanname}Dao.saveOrUpdate${className}(element);
	}
	
	/**
	 *　删除${tabCon}信息
	 * 
	 * @param ${PK_KEY}S  ${tabCon}ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean delete${className}(String ${PK_KEY}S) {
		return ${beanname}Dao.delete${className}(${PK_KEY}S);
	}
	
	/**
	 * 根据${tabCon}ID获取${tabCon}实体
	 * @param ${PK_KEY} ${tabCon}ID
	 * @return 返回${tabCon}实体,如果无查询记录则返回null
	 */
	public  Element get${className}EleById(String ${PK_KEY}){
		return ${beanname}Dao.get${className}EleById(${PK_KEY});
	}
	
	/**
	 *　获取${tabCon}数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int get${className}Count(Map<String, Object> params) {
		return ${beanname}Dao.get${className}Count(params);
	}
	
	/**
	 * 根据${tabCon}ID获取${tabCon}信息
	 * @param ${PK_KEY} ${tabCon}ID
	 * @return 返回${tabCon}信息,如果无查询记录则返回null
	 */
	public Map<String, Object> get${className}MapById(String ${PK_KEY}){
		return ${beanname}Dao.get${className}MapById(${PK_KEY});
	}
	
	/**
	 * 获取${tabCon}列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回${tabCon}列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> get${className}List(Map<String, Object> params,int nowPage,int onePageCount){
		return ${beanname}Dao.get${className}List(params, nowPage, onePageCount);
	}
	
	/**
     * 获取${tabCon}信息
     * 
     * @param  params 参数
     * @return 成功返回${tabCon}信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> get${className}List(Map<String, Object> params){
		return ${beanname}Dao.get${className}List(params);
	}

}
