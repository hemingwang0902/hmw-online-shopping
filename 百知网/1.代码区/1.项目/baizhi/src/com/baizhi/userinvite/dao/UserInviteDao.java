package com.baizhi.userinvite.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：UserInviteDao.java
 * 描述：用户邀请信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-06-23 22:20:22
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class UserInviteDao extends DaoSupport{
	
	/**
	 * 新增或修改用户邀请信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserInvite(Element element) {
		return this.saveOrUpdate(element, "INVITE_ID");
	}
	
	/**
	 * 新增用户邀请信息表信息
	 * 
	 * @param list  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public boolean saveUserInvite(List<Element> list) {
		boolean bool=false;
		if(list!=null&&list.size()>0){
			Element element=null;
			for (int i = 0; i < list.size(); i++) {
				element=list.get(i);
				this.save(element);
			}
			bool=true;
		}
		return bool;
	}
	
	/**
	 *　删除用户邀请信息表信息
	 * 
	 * @param INVITE_IDS   用户邀请信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserInvite(String INVITE_IDS) {
		return this.delete("T_USER_INVITE","INVITE_ID", INVITE_IDS);
	}
	
	/**
	 * 根据用户邀请信息表ID获取用户邀请信息表实体
	 * @param INVITE_ID 用户邀请信息表ID
	 * @return 返回用户邀请信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserInviteEleById(String INVITE_ID){
		return this.getElementById("T_USER_INVITE", "INVITE_ID", INVITE_ID);
	}
	
	/**
	 *　获取用户邀请信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserInviteCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_USER_INVITE a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据用户邀请信息表ID获取用户邀请信息表信息
	 * @param INVITE_ID 用户邀请信息表ID
	 * @return 返回用户邀请信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserInviteMapById(String INVITE_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.INVITE_ID as INVITE_ID,")//用户邀请ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.IS_SUCCESS as IS_SUCCESS,")//是否邀请成功(0否、1是)
		   .append("a.EMAIL as EMAIL,")//邀请Email
		   .append("a.INVITE_CODE as INVITE_CODE,")//邀请码
		   .append("a.INVITE_TIME as INVITE_TIME,")//邀请时间
		   .append("a.INVITE_USERID as INVITE_USERID) ")//邀请用户ID
		   .append("FROM T_USER_INVITE a WHERE a.INVITE_ID=? ");
		return this.getById(sql.toString(), new Object[]{INVITE_ID});
	}
	
	/**
	 * 获取用户邀请信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户邀请信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserInviteList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.INVITE_ID as INVITE_ID,")//用户邀请ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("b.NAME as NAME,")//用户ID
		   .append("a.IS_SUCCESS as IS_SUCCESS,")//是否邀请成功(0否、1是)
		   .append("a.EMAIL as EMAIL,")//邀请Email
		   .append("a.INVITE_CODE as INVITE_CODE,")//邀请码
		   .append("a.INVITE_TIME as INVITE_TIME,")//邀请时间
		   .append("a.INVITE_USERID as INVITE_USERID) ")//邀请用户ID
		   .append("FROM T_USER_INVITE a,T_USER_BASIC b WHERE a.USER_ID=b.USER_ID ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_USER_INVITE", nowPage, onePageCount);
	}
	
	/**
     * 获取用户邀请信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户邀请信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserInviteList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.INVITE_ID as INVITE_ID,")//用户邀请ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.IS_SUCCESS as IS_SUCCESS,")//是否邀请成功(0否、1是)
		   .append("a.EMAIL as EMAIL,")//邀请Email
		   .append("a.INVITE_CODE as INVITE_CODE,")//邀请码
		   .append("a.INVITE_TIME as INVITE_TIME,")//邀请时间
		   .append("a.INVITE_USERID as INVITE_USERID) ")//邀请用户ID
		   .append("FROM T_USER_INVITE a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

