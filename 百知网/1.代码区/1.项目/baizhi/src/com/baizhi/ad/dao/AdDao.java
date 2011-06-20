package com.baizhi.ad.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：AdDao.java
 * 描述：广告信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-06-21 00:52:07
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class AdDao extends DaoSupport{
	
	/**
	 * 新增或修改广告信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateAd(Element element) {
		return this.saveOrUpdate(element, "AD_ID");
	}
	
	/**
	 *　删除广告信息表信息
	 * 
	 * @param AD_IDS   广告信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteAd(String AD_IDS) {
		return this.delete("T_AD","AD_ID", AD_IDS);
	}
	
	/**
	 * 根据广告信息表ID获取广告信息表实体
	 * @param AD_ID 广告信息表ID
	 * @return 返回广告信息表实体,如果无查询记录则返回null
	 */
	public  Element getAdEleById(String AD_ID){
		return this.getElementById("T_AD", "AD_ID", AD_ID);
	}
	
	/**
	 *　获取广告信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getAdCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_AD a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据广告信息表ID获取广告信息表信息
	 * @param AD_ID 广告信息表ID
	 * @return 返回广告信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getAdMapById(String AD_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.AD_ID as AD_ID,")//广告ID
		   .append("a.TITLE as TITLE,")//主题
		   .append("a.CONTENT as CONTENT,")//内容(支持html内容)
		   .append("a.IMAGE as IMAGE,")//图片
		   .append("a.SHOW_TYPE as SHOW_TYPE,")//显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)
		   .append("a.HREF as HREF,")//链接地址
		   .append("a.ORDER_BY as ORDER_BY,")//显示顺序
		   .append("a.START_TIME as START_TIME,")//起始时间
		   .append("a.END_TIME as END_TIME,")//终止时间
		   .append("a.STATUS as STATUS,")//状态(字典：1申请、2通过、3不通过)
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_AD a WHERE a.AD_ID=? ");
		return this.getById(sql.toString(), new Object[]{AD_ID});
	}
	
	/**
	 * 获取广告信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回广告信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getAdList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.AD_ID as AD_ID,")//广告ID
		   .append("a.TITLE as TITLE,")//主题
		   .append("a.CONTENT as CONTENT,")//内容(支持html内容)
		   .append("a.IMAGE as IMAGE,")//图片
		   .append("a.SHOW_TYPE as SHOW_TYPE,")//显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)
		   .append("a.HREF as HREF,")//链接地址
		   .append("a.ORDER_BY as ORDER_BY,")//显示顺序
		   .append("a.START_TIME as START_TIME,")//起始时间
		   .append("a.END_TIME as END_TIME,")//终止时间
		   .append("a.STATUS as STATUS,")//状态(字典：1申请、2通过、3不通过)
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_AD a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_AD", nowPage, onePageCount);
	}
	
	/**
     * 获取广告信息表信息
     * 
     * @param  params 参数
     * @return 成功返回广告信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getAdList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.AD_ID as AD_ID,")//广告ID
		   .append("a.TITLE as TITLE,")//主题
		   .append("a.CONTENT as CONTENT,")//内容(支持html内容)
		   .append("a.IMAGE as IMAGE,")//图片
		   .append("a.SHOW_TYPE as SHOW_TYPE,")//显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)
		   .append("a.HREF as HREF,")//链接地址
		   .append("a.ORDER_BY as ORDER_BY,")//显示顺序
		   .append("a.START_TIME as START_TIME,")//起始时间
		   .append("a.END_TIME as END_TIME,")//终止时间
		   .append("a.STATUS as STATUS,")//状态(字典：1申请、2通过、3不通过)
		   .append("a.REMARK as REMARK) ")//备注
		   .append("FROM T_AD a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

