package com.baizhi.dicitem.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：DicitemDao.java
 * 描述：字典列表清单数据操作类，负责增删改查
 * 创建者： 何明旺
 * 创建日期：2011-06-20 21:02:57
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class DicitemDao extends DaoSupport{
	
	/**
	 * 新增或修改字典列表清单信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateDicitem(Element element) {
		return this.saveOrUpdate(element, "DICITEM_ID");
	}
	
	/**
	 *　删除字典列表清单信息
	 * 
	 * @param DICITEM_IDS   字典列表清单ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteDicitem(String DICITEM_IDS) {
		return this.delete("T_DICITEM","DICITEM_ID", DICITEM_IDS);
	}
	
	/**
	 * 根据字典列表清单ID获取字典列表清单实体
	 * @param DICITEM_ID 字典列表清单ID
	 * @return 返回字典列表清单实体,如果无查询记录则返回null
	 */
	public  Element getDicitemEleById(String DICITEM_ID){
		return this.getElementById("T_DICITEM", "DICITEM_ID", DICITEM_ID);
	}
	
	/**
	 *　获取字典列表清单数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getDicitemCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_DICITEM a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据字典列表清单ID获取字典列表清单信息
	 * @param DICITEM_ID 字典列表清单ID
	 * @return 返回字典列表清单信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getDicitemMapById(String DICITEM_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.DICITEM_ID as DICITEM_ID,")//字典清单ID
		   .append("a.CODE as CODE,")//列表字典代码
		   .append("a.DIC_CODE as DIC_CODE,")//字典代码
		   .append("a.DIC_NAME as DIC_NAME,")//字典名称
		   .append("a.PDIC_CODE as PDIC_CODE,")//字典上级代码
		   .append("a.ALLPIN as ALLPIN,")//字典全拼
		   .append("a.SIMPLEPIN as SIMPLEPIN,")//字典简拼
		   .append("a.ORDER_BY as ORDER_BY,")//显示顺序
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_DICITEM a WHERE a.DICITEM_ID=? ");
		return this.getById(sql.toString(), new Object[]{DICITEM_ID});
	}
	
	/**
	 * 获取字典列表清单列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回字典列表清单列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getDicitemList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.DICITEM_ID as DICITEM_ID,")//字典清单ID
		   .append("a.CODE as CODE,")//列表字典代码
		   .append("a.DIC_CODE as DIC_CODE,")//字典代码
		   .append("a.DIC_NAME as DIC_NAME,")//字典名称
		   .append("a.PDIC_CODE as PDIC_CODE,")//字典上级代码
		   .append("a.ALLPIN as ALLPIN,")//字典全拼
		   .append("a.SIMPLEPIN as SIMPLEPIN,")//字典简拼
		   .append("a.ORDER_BY as ORDER_BY,")//显示顺序
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_DICITEM a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_DICITEM", nowPage, onePageCount);
	}
	
	/**
     * 获取字典列表清单信息
     * 
     * @param  params 参数
     * @return 成功返回字典列表清单信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getDicitemList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.DICITEM_ID as DICITEM_ID,")//字典清单ID
		   .append("a.CODE as CODE,")//列表字典代码
		   .append("a.DIC_CODE as DIC_CODE,")//字典代码
		   .append("a.DIC_NAME as DIC_NAME,")//字典名称
		   .append("a.PDIC_CODE as PDIC_CODE,")//字典上级代码
		   .append("a.ALLPIN as ALLPIN,")//字典全拼
		   .append("a.SIMPLEPIN as SIMPLEPIN,")//字典简拼
		   .append("a.ORDER_BY as ORDER_BY,")//显示顺序
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_USER a ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

