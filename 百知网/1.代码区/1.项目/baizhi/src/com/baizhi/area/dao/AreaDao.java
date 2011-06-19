package com.baizhi.area.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：AreaDao.java
 * 描述：地区信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-06-20 00:09:56
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class AreaDao extends DaoSupport{
	
	/**
	 * 新增或修改地区信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateArea(Element element) {
		return this.saveOrUpdate(element, "AREA_ID");
	}
	
	/**
	 *　删除地区信息表信息
	 * 
	 * @param AREA_IDS   地区信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteArea(String AREA_IDS) {
		return this.delete("T_AREA","AREA_ID", AREA_IDS);
	}
	
	/**
	 * 根据地区信息表ID获取地区信息表实体
	 * @param AREA_ID 地区信息表ID
	 * @return 返回地区信息表实体,如果无查询记录则返回null
	 */
	public  Element getAreaEleById(String AREA_ID){
		return this.getElementById("T_AREA", "AREA_ID", AREA_ID);
	}
	
	/**
	 *　获取地区信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getAreaCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_AREA a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据地区信息表ID获取地区信息表信息
	 * @param AREA_ID 地区信息表ID
	 * @return 返回地区信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getAreaMapById(String AREA_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.AREA_ID as AREA_ID,")//地区ID
		   .append("a.DIC_CODE as DIC_CODE,")//地区代码(根据级别制定规则定义)
		   .append("a.DIC_NAME as DIC_NAME,")//地区名称
		   .append("a.PAREA_ID as PAREA_ID,")//地区上级代码
		   .append("a.ALLPIN as ALLPIN,")//地区全拼
		   .append("a.SIMPLEPIN as SIMPLEPIN,")//地区简拼
		   .append("a.ORDER_BY as ORDER_BY,")//显示顺序
		   .append("a.IP_START as IP_START,")//IP起始段
		   .append("a.IP_END as IP_END,")//IP终止段
		   .append("a.AREA_LEVEL as AREA_LEVEL,")//地区级别(字典：1省、2市、3县、4镇、5村)暂时定义省、市两级
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_AREA a WHERE a.AREA_ID=? ");
		return this.getById(sql.toString(), new Object[]{AREA_ID});
	}
	
	/**
	 * 获取地区信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回地区信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getAreaList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.AREA_ID as AREA_ID,")//地区ID
		   .append("a.DIC_CODE as DIC_CODE,")//地区代码(根据级别制定规则定义)
		   .append("a.DIC_NAME as DIC_NAME,")//地区名称
		   .append("a.PAREA_ID as PAREA_ID,")//地区上级代码
		   .append("a.ALLPIN as ALLPIN,")//地区全拼
		   .append("a.SIMPLEPIN as SIMPLEPIN,")//地区简拼
		   .append("a.ORDER_BY as ORDER_BY,")//显示顺序
		   .append("a.IP_START as IP_START,")//IP起始段
		   .append("a.IP_END as IP_END,")//IP终止段
		   .append("a.AREA_LEVEL as AREA_LEVEL,")//地区级别(字典：1省、2市、3县、4镇、5村)暂时定义省、市两级
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_AREA a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_AREA", nowPage, onePageCount);
	}
	
	/**
     * 获取地区信息表信息
     * 
     * @param  params 参数
     * @return 成功返回地区信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getAreaList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.AREA_ID as AREA_ID,")//地区ID
		   .append("a.DIC_CODE as DIC_CODE,")//地区代码(根据级别制定规则定义)
		   .append("a.DIC_NAME as DIC_NAME,")//地区名称
		   .append("a.PAREA_ID as PAREA_ID,")//地区上级代码
		   .append("a.ALLPIN as ALLPIN,")//地区全拼
		   .append("a.SIMPLEPIN as SIMPLEPIN,")//地区简拼
		   .append("a.ORDER_BY as ORDER_BY,")//显示顺序
		   .append("a.IP_START as IP_START,")//IP起始段
		   .append("a.IP_END as IP_END,")//IP终止段
		   .append("a.AREA_LEVEL as AREA_LEVEL,")//地区级别(字典：1省、2市、3县、4镇、5村)暂时定义省、市两级
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_USER a ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

