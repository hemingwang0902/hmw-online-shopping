package com.baizhi.user.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
/**
 * 
 * 类名：    UserDao.java
 * 描述：    用户信息表数据操作类，负责增删改查
 * 创建者：  江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：    V0.9
 * 修改者：  
 * 修改日期：
 */
public class UserDao extends DaoSupport{
	
	/**
	 * 新增或修改用户信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUser(Element element) {
		return this.saveOrUpdate(element, "USER_ID");
	}
	
	/**
	 *　删除用户信息表信息
	 * 
	 * @param USER_IDS  用户信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUser(String USER_IDS) {
		return this.delete("T_USER","USER_ID", USER_IDS);
	}
	
	/**
	 * 根据用户信息表ID获取用户信息表实体
	 * @param USER_ID 用户信息表ID
	 * @return 返回用户信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserEleById(String USER_ID){
		return this.getElementById("T_USER", "USER_ID", USER_ID);
	}
	
	/**
	 *　获取用户信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_USER a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据用户信息表ID获取用户信息表信息
	 * @param USER_ID 用户信息表ID
	 * @return 返回用户信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserMapById(String USER_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.USER_TYPE as USER_TYPE,")//用户类型(字典：1用户、2品牌)
		   .append("a.EMAIL as EMAIL,")//Email
		   .append("a.PASSWORD as PASSWORD,")//密码
		   .append("a.REG_TIME as REG_TIME,")//注册时间
		   .append("a.LAST_LOGINTIME as LAST_LOGINTIME,")//最后登录时间
		   .append("a.IP as IP,")//最后登录IP
		   .append("a.MAC as MAC,")//最后登录MAC
		   .append("a.LAST_FREEZETIME as LAST_FREEZETIME) ")//最后冻结时间
		   .append("FROM T_USER a WHERE a.USER_ID=? ");
		return this.getById(sql.toString(), new Object[]{USER_ID});
	}
	
	/**
	 * 获取用户信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.USER_TYPE as USER_TYPE,")//用户类型(字典：1用户、2品牌)
		   .append("a.EMAIL as EMAIL,")//Email
		   .append("a.PASSWORD as PASSWORD,")//密码
		   .append("a.REG_TIME as REG_TIME,")//注册时间
		   .append("a.LAST_LOGINTIME as LAST_LOGINTIME,")//最后登录时间
		   .append("a.IP as IP,")//最后登录IP
		   .append("a.MAC as MAC,")//最后登录MAC
		   .append("a.LAST_FREEZETIME as LAST_FREEZETIME) ")//最后冻结时间
		   .append("FROM T_USER a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		
		return this.getByList(sql.toString(), ps.getValues(), "T_USER", nowPage, onePageCount);
	}
	
	/**
     * 获取用户信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.USER_TYPE as USER_TYPE,")//用户类型(字典：1用户、2品牌)
		   .append("a.EMAIL as EMAIL,")//Email
		   .append("a.PASSWORD as PASSWORD,")//密码
		   .append("a.REG_TIME as REG_TIME,")//注册时间
		   .append("a.LAST_LOGINTIME as LAST_LOGINTIME,")//最后登录时间
		   .append("a.IP as IP,")//最后登录IP
		   .append("a.MAC as MAC,")//最后登录MAC
		   .append("a.LAST_FREEZETIME as LAST_FREEZETIME) ")//最后冻结时间
		   .append("FROM T_USER a ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

