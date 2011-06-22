package com.baizhi.diclist.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：DiclistDao.java
 * 描述：字典列表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-06-22 21:19:11
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class DiclistDao extends DaoSupport{
	
	/**
	 * 新增或修改字典列表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateDiclist(Element element) {
		return this.saveOrUpdate(element, "DICLIST_ID");
	}
	
	/**
	 *　删除字典列表信息
	 * 
	 * @param DICLIST_IDS   字典列表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteDiclist(String DICLIST_IDS) {
		return this.delete("T_DICLIST","DICLIST_ID", DICLIST_IDS);
	}
	
	/**
	 * 根据字典列表ID获取字典列表实体
	 * @param DICLIST_ID 字典列表ID
	 * @return 返回字典列表实体,如果无查询记录则返回null
	 */
	public  Element getDiclistEleById(String DICLIST_ID){
		return this.getElementById("T_DICLIST", "DICLIST_ID", DICLIST_ID);
	}
	
	/**
	 *　获取字典列表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getDiclistCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_DICLIST a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据字典列表ID获取字典列表信息
	 * @param DICLIST_ID 字典列表ID
	 * @return 返回字典列表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getDiclistMapById(String DICLIST_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.DICLIST_ID as DICLIST_ID,")//字典列表ID
		   .append("a.NAME as NAME,")//字典名称
		   .append("a.CODE as CODE,")//字典代码
		   .append("a.ALLPIN as ALLPIN,")//字典全拼
		   .append("a.SIMPLEPIN as SIMPLEPIN,")//字典简拼
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_DICLIST a WHERE a.DICLIST_ID=? ");
		return this.getById(sql.toString(), new Object[]{DICLIST_ID});
	}
	
	/**
	 * 获取字典列表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回字典列表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getDiclistList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.DICLIST_ID as DICLIST_ID,")//字典列表ID
		   .append("a.NAME as NAME,")//字典名称
		   .append("a.CODE as CODE,")//字典代码
		   .append("a.ALLPIN as ALLPIN,")//字典全拼
		   .append("a.SIMPLEPIN as SIMPLEPIN,")//字典简拼
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_DICLIST a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_DICLIST", nowPage, onePageCount);
	}
	
	/**
     * 获取字典列表信息
     * 
     * @param  params 参数
     * @return 成功返回字典列表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getDiclistList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.DICLIST_ID as DICLIST_ID,")//字典列表ID
		   .append("a.NAME as NAME,")//字典名称
		   .append("a.CODE as CODE,")//字典代码
		   .append("a.ALLPIN as ALLPIN,")//字典全拼
		   .append("a.SIMPLEPIN as SIMPLEPIN,")//字典简拼
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_DICLIST a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

