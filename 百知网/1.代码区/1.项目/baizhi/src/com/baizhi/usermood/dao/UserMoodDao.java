package com.baizhi.usermood.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;

 /**
 * 类名：UserMoodDao.java<br>
 * 描述：用户心情随记数据操作类，负责增删改查<br>
 * 创建者： 何明旺<br>
 * 创建日期：2012-02-19 15:00:28<br>
 * 版本：V0.9<br>
 * 修改者：  <br>
 * 修改日期：
 */
public class UserMoodDao extends DaoSupport{
	
	/**
	 * 新增或修改用户心情随记信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserMood(Element element) {
		return this.saveOrUpdate(element, "id");
	}
	
	/**
	 *　删除用户心情随记信息
	 * 
	 * @param idS   用户心情随记ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserMood(String idS) {
		return this.delete("T_USER_MOOD","id", idS);
	}
	
	/**
	 * 根据用户心情随记ID获取用户心情随记实体
	 * @param id 用户心情随记ID
	 * @return 返回用户心情随记实体,如果无查询记录则返回null
	 */
	public  Element getUserMoodEleById(String id){
		return this.getElementById("T_USER_MOOD", "id", id);
	}
	
	/**
	 *　获取用户心情随记数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserMoodCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_USER_MOOD a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据用户心情随记ID获取用户心情随记信息
	 * @param id 用户心情随记ID
	 * @return 返回用户心情随记信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserMoodMapById(String id){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.id as id,")//
		   .append("a.user_id as user_id,")//用户ID
		   .append("a.descript as descript,")//心情随记的内容
		   .append("a.publish_time as publish_time) ")//发表时间
		   .append("FROM T_USER_MOOD a WHERE a.id=? ");
		return this.getById(sql.toString(), new Object[]{id});
	}
	
	/**
	 * 获取用户心情随记列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户心情随记列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserMoodList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.id as id,")//
		   .append("a.user_id as user_id,")//用户ID
		   .append("a.descript as descript,")//心情随记的内容
		   .append("a.publish_time as publish_time) ")//发表时间
		   .append("FROM T_USER_MOOD a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions()).append(" order by publish_time desc");
		
		return this.getByList(sql.toString(), ps.getValues(), "T_USER_MOOD", nowPage, onePageCount);
	}
	
	/**
     * 获取用户心情随记信息
     * 
     * @param  params 参数
     * @return 成功返回用户心情随记信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserMoodList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.id as id,")//
		   .append("a.user_id as user_id,")//用户ID
		   .append("a.descript as descript,")//心情随记的内容
		   .append("a.publish_time as publish_time) ")//发表时间
		   .append("FROM T_USER_MOOD a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

