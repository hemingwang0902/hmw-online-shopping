package com.baizhi.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
import com.baizhi.commons.constant.Diclist;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.userlog.dao.UserLogDao;
/**
 * 
 * 类名：UserDao.java
 * 描述：用户信息表数据操作类，负责增删改查
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class UserDao extends DaoSupport{
	
	private UserLogDao userLogDao;
	
	public UserLogDao getUserLogDao() {
		return userLogDao;
	}

	public void setUserLogDao(UserLogDao userLogDao) {
		this.userLogDao = userLogDao;
	}

	/**
	 * 新增用户信息表信息
	 * 
	 * @param element  实体对象
	 * @param basicelement  基本信息实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveUser(Element element,Element basicelement) {
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		String idValue = "";
		try {
			dom4jSession.beginTransaction();
			dom4jSession.save(element);
			Elements.setElementValue(basicelement, "USER_ID", element.elementText("USER_ID"));// 姓名/品牌名称
			dom4jSession.save(basicelement);
			dom4jSession.getTransaction().commit();
			idValue = element.elementText("USER_ID");
		} catch (Exception e) {
			dom4jSession.beginTransaction().rollback();
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return idValue;
		
	}
	
	/**
	 * 修改用户信息表信息
	 * 
	 * @param element  实体对象
	 * @param basicelement  基本信息实体对象
	 * @return 返回true,失败false
	 */
	public boolean modifyUser(Map<String, Object> params) {
		Session session = getSession();
		boolean flag = false;
		try {
			session.beginTransaction();
			setQueryParameters(session.createQuery("update T_USER set PASSWORD=? where USER_ID=? "),
					new Object[]{ params.get("PASSWORD"),params.get("USER_ID")}).executeUpdate();
			setQueryParameters(session.createQuery("update T_USER_BASIC set NAME=? where USER_ID=? "),
					new Object[]{ params.get("NAME"),params.get("USER_ID")}).executeUpdate();
			session.getTransaction().commit();
			flag=true;
		} catch (Exception e) {
			session.beginTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return flag;
		
	}
	
	/**
	 * 注册用户信息表信息
	 * 
	 * @param userelement  用户实体对象
	 * @param basicelement 基本信息实体对象
	 * @param WAS_USERID 邀请人ID
	 * @return 返回主键ID,失败返回""
	 */
	public Map<String, Object> regiest(Element userelement,Element basicelement,Integer WAS_USERID) {
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		Map<String, Object> returnMap=new HashMap<String, Object>();
		try {
			dom4jSession.beginTransaction();
			dom4jSession.save(userelement);
			Elements.setElementValue(basicelement, "USER_ID", userelement.elementText("USER_ID"));// 用户ID
			
			dom4jSession.save(basicelement);
			
			//如果从别人链接注册
			if(WAS_USERID>0){
				Element element = new DefaultElement("T_USER_ATTENTION");
				Elements.setElementValue(element, "USER_ID",  userelement.elementText("USER_ID"));// 用户ID
				Elements.setElementValue(element, "WAS_USERID", WAS_USERID);// 被关注用户
				Elements.setElementValue(element, "IS_ATTENTION",1);// 是否关注(0否、1是)
				Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
				dom4jSession.save(element);
			}
			
			dom4jSession.getTransaction().commit();
			returnMap.put("USER_ID",userelement.elementText("USER_ID"));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dom4jSession.close();
			session.close();
		}
		return returnMap;
	}
	
	/**
	 * 修改密码
	 * 
	 * @param USER_ID  用户ID
	 * @param PASSWORD 密码
	 * @return 返回执行记录数
	 */
	public int modifyPassword(int USER_ID,String PASSWORD) {
		return this.executeUpdate("update T_USER set PASSWORD=? where USER_ID=?", new Object[]{PASSWORD,USER_ID});
	}
	
	/**
	 * 修改密码
	 * 
	 * @param EMAIL    email
	 * @param PASSWORD 密码
	 * @return 返回执行记录数
	 */
	public int modifyPassword(String EMAIL,String PASSWORD) {
		return this.executeUpdate("update T_USER set PASSWORD=? where EMAIL=?", new Object[]{PASSWORD,EMAIL});
	}
	
	/**
	 *　删除用户信息表信息
	 * 
	 * @param USER_IDS  用户信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUser(String USER_IDS) {
		Session session = getSession();
		boolean flag = false;
		try {
			session.beginTransaction();
			setQueryParameters(session.createQuery("update T_USER set LAST_FREEZETIME='9999-09-09' where USER_ID "+getSplitStr(USER_IDS)),
					USER_IDS.split(",")).executeUpdate();
			session.getTransaction().commit();
			flag=true;
		} catch (Exception e) {
			session.beginTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return flag;
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
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 登录
	 * @param EMAIL 用户名
	 * @param PASSWORD 密码
	 * @param IP IP
	 * @return 返回用户信息表信息,如果无查询记录则返回null
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> login(String EMAIL,String PASSWORD,String IP){
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		Map<String, Object> returnMap=null;
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
		   .append("a.LAST_FREEZETIME as LAST_FREEZETIME, ")//最后冻结时间
		   .append("b.INTRODUCTION as INTRODUCTION,")//个人介绍/品牌介绍
		   .append("b.NAME as NAME,")//姓名
		   .append("b.PROVINCE  as PROVINCE,")//城市
		   .append("b.CITY  as CITY,")//城市
		   .append("(select DIC_NAME from T_AREA where DIC_CODE=b.CITY)  as CITY_NAME ) ")//城市
		   .append("FROM T_USER a,T_USER_BASIC b WHERE a.EMAIL=? and a.PASSWORD=? and a.USER_ID=b.USER_ID ");
		
		try {
			List<Map<String,Object>> list=setQueryParameters(session.createQuery(sql.toString()), new Object[]{EMAIL,PASSWORD}).list();
			
			if(list!=null&&list.size()>0){
				returnMap=list.get(0);
			}
			//如果用户登录成功
			if(returnMap!=null&&returnMap.get("USER_ID")!=null&&!String.valueOf(returnMap.get("USER_ID")).trim().equals("")){
				String USER_ID=String.valueOf(returnMap.get("USER_ID"));
				dom4jSession.beginTransaction();
				//添加日志
				userLogDao.saveUserLog(USER_ID, IP, dom4jSession);
				//修改最后登录时间
				dom4jSession.createQuery("update T_USER set LAST_LOGINTIME='"+DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT)+"' where USER_ID="+USER_ID).executeUpdate();
				
				dom4jSession.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dom4jSession.close();
			session.close();
		}
		
		return returnMap;
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
		   .append("a.LAST_FREEZETIME as LAST_FREEZETIME,")//最后冻结时间
		   .append("b.NAME as NAME) ")//姓名　
		   .append("FROM T_USER a,T_USER_BASIC b WHERE a.USER_ID=b.USER_ID and a.USER_ID=? ");
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
		   .append("(select DIC_NAME from T_DICITEM where a.USER_TYPE=DIC_CODE and CODE='"+Diclist.BZ000001+"') as USER_TYPE_NAME,")//用户类型(字典：1用户、2品牌)
		   .append("a.EMAIL as EMAIL,")//Email
		   .append("a.PASSWORD as PASSWORD,")//密码
		   .append("a.REG_TIME as REG_TIME,")//注册时间
		   .append("a.LAST_LOGINTIME as LAST_LOGINTIME,")//最后登录时间
		   .append("a.IP as IP,")//最后登录IP
		   .append("a.MAC as MAC,")//最后登录MAC
		   .append("a.LAST_FREEZETIME as LAST_FREEZETIME, ")//最后冻结时间
		   .append("b.NAME as NAME) ")//姓名　
		   .append("FROM T_USER a,T_USER_BASIC b WHERE a.USER_ID=b.USER_ID and ('"+DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT)+"'>LAST_FREEZETIME or LAST_FREEZETIME is null) ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
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
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

