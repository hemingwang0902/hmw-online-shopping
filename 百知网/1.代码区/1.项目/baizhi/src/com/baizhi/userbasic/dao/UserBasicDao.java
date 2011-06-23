package com.baizhi.userbasic.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：UserBasicDao.java
 * 描述：用户基本信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-06-23 22:03:15
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class UserBasicDao extends DaoSupport{
	
	/**
	 * 新增或修改用户基本信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserBasic(Element element) {
		return this.saveOrUpdate(element, "BASIC_ID");
	}
	
	/**
	 *　删除用户基本信息表信息
	 * 
	 * @param BASIC_IDS   用户基本信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserBasic(String BASIC_IDS) {
		return this.delete("T_USER_BASIC","BASIC_ID", BASIC_IDS);
	}
	
	/**
	 * 根据用户基本信息表ID获取用户基本信息表实体
	 * @param BASIC_ID 用户基本信息表ID
	 * @return 返回用户基本信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserBasicEleById(String BASIC_ID){
		return this.getElementById("T_USER_BASIC", "BASIC_ID", BASIC_ID);
	}
	
	/**
	 *　获取用户基本信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserBasicCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_USER_BASIC a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据用户基本信息表ID获取用户基本信息表信息
	 * @param BASIC_ID 用户基本信息表ID
	 * @return 返回用户基本信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserBasicMapById(String BASIC_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.BASIC_ID as BASIC_ID,")//用户基本信息ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.USER_TYPE as USER_TYPE,")//用户类型(字典：1用户、2品牌)冗余字段
		   .append("a.NAME as NAME,")//姓名/品牌名称
		   .append("a.SOURCE as SOURCE,")//发源地(品牌特有)
		   .append("a.PROVINCE as PROVINCE,")//所在地区(省：地区信息表ID)
		   .append("a.CITY as CITY,")//所在地区(市：地区信息表ID)
		   .append("a.INDUSTRY as INDUSTRY,")//从事行业(字典)
		   .append("a.YEARS as YEARS,")//所在年代(字典、用户特有)
		   .append("a.LINK_MODE as LINK_MODE,")//联系方式
		   .append("a.IS_OPEN as IS_OPEN,")//是否对外开放(0否、1是)
		   .append("a.INTRODUCTION as INTRODUCTION,")//个人介绍/品牌介绍
		   .append("a.MOTTO as MOTTO,")//人生格言(用户特有)
		   .append("a.IMAGE_PATH as IMAGE_PATH,")//相片路径/LOGO路径
		   .append("a.WEBSITE as WEBSITE,")//个性网址
		   .append("a.PRIVATE_SET as PRIVATE_SET,")//私信设置(字典：1所有人、2我关注的人)
		   .append("a.LEVEL as LEVEL,")//级别
		   .append("a.SCORE as SCORE,")//积分
		   .append("a.REMARK as REMARK,")//备注
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_BASIC a WHERE a.BASIC_ID=? ");
		return this.getById(sql.toString(), new Object[]{BASIC_ID});
	}
	
	/**
	 * 获取用户基本信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户基本信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserBasicList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.BASIC_ID as BASIC_ID,")//用户基本信息ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.USER_TYPE as USER_TYPE,")//用户类型(字典：1用户、2品牌)冗余字段
		   .append("a.NAME as NAME,")//姓名/品牌名称
		   .append("a.SOURCE as SOURCE,")//发源地(品牌特有)
		   .append("a.PROVINCE as PROVINCE,")//所在地区(省：地区信息表ID)
		   .append("a.CITY as CITY,")//所在地区(市：地区信息表ID)
		   .append("a.INDUSTRY as INDUSTRY,")//从事行业(字典)
		   .append("a.YEARS as YEARS,")//所在年代(字典、用户特有)
		   .append("a.LINK_MODE as LINK_MODE,")//联系方式
		   .append("a.IS_OPEN as IS_OPEN,")//是否对外开放(0否、1是)
		   .append("a.INTRODUCTION as INTRODUCTION,")//个人介绍/品牌介绍
		   .append("a.MOTTO as MOTTO,")//人生格言(用户特有)
		   .append("a.IMAGE_PATH as IMAGE_PATH,")//相片路径/LOGO路径
		   .append("a.WEBSITE as WEBSITE,")//个性网址
		   .append("a.PRIVATE_SET as PRIVATE_SET,")//私信设置(字典：1所有人、2我关注的人)
		   .append("a.LEVEL as LEVEL,")//级别
		   .append("a.SCORE as SCORE,")//积分
		   .append("a.REMARK as REMARK,")//备注
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_BASIC a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_USER_BASIC", nowPage, onePageCount);
	}
	
	/**
     * 获取用户基本信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户基本信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserBasicList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.BASIC_ID as BASIC_ID,")//用户基本信息ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.USER_TYPE as USER_TYPE,")//用户类型(字典：1用户、2品牌)冗余字段
		   .append("a.NAME as NAME,")//姓名/品牌名称
		   .append("a.SOURCE as SOURCE,")//发源地(品牌特有)
		   .append("a.PROVINCE as PROVINCE,")//所在地区(省：地区信息表ID)
		   .append("a.CITY as CITY,")//所在地区(市：地区信息表ID)
		   .append("a.INDUSTRY as INDUSTRY,")//从事行业(字典)
		   .append("a.YEARS as YEARS,")//所在年代(字典、用户特有)
		   .append("a.LINK_MODE as LINK_MODE,")//联系方式
		   .append("a.IS_OPEN as IS_OPEN,")//是否对外开放(0否、1是)
		   .append("a.INTRODUCTION as INTRODUCTION,")//个人介绍/品牌介绍
		   .append("a.MOTTO as MOTTO,")//人生格言(用户特有)
		   .append("a.IMAGE_PATH as IMAGE_PATH,")//相片路径/LOGO路径
		   .append("a.WEBSITE as WEBSITE,")//个性网址
		   .append("a.PRIVATE_SET as PRIVATE_SET,")//私信设置(字典：1所有人、2我关注的人)
		   .append("a.LEVEL as LEVEL,")//级别
		   .append("a.SCORE as SCORE,")//积分
		   .append("a.REMARK as REMARK,")//备注
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_BASIC a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

