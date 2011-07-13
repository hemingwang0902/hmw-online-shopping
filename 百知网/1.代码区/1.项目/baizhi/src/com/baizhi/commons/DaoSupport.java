package com.baizhi.commons;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.hibernate.EntityMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.baizhi.commons.PagerSupport;

/**
 * 
 * 类名：DaoSupport<br>
 * 描述：数据层支持类<br>
 * 创建者：江红 <br>
 * 创建日期： 2011-3-30<br>
 * 版本：V0.9 <br>
 * 修改者：        <br>
 * 修改日期：   <br>
 */
public abstract class DaoSupport extends HibernateDaoSupport {
	
	protected Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * 公共新增
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID
	 */
	public String save(Element element) {
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		String keyid = "";
		try {
			dom4jSession.beginTransaction();
			Serializable serializableid = dom4jSession.save(element);
			dom4jSession.getTransaction().commit();
			if(serializableid!=null&&!serializableid.equals("")){
				keyid=serializableid.toString();
			}
		} catch (Exception e) {
			dom4jSession.beginTransaction().rollback();
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return keyid;
	}
	
	/**
	 * 公共新增
	 * 
	 * @param element  实体对象
	 * @param dom4jSession 链接对象
	 * @return 返回主键ID
	 */
	public String save(Element element,Session dom4jSession) throws Exception{
		String keyid = "";
		Serializable serializableid = dom4jSession.save(element);
		if (serializableid != null && !serializableid.equals("")) {
			return serializableid.toString();
		}
		return keyid;
	}
	
	/**
	 * 公共新增或修改方法
	 * 
	 * @param element  实体对象
	 * @param idName   主键字段名称
	 * @return 返回主键ID
	 */
	public String saveOrUpdate(Element element,String idName) {
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		String idValue = "";
		try {
			dom4jSession.beginTransaction();
			dom4jSession.saveOrUpdate(element);
			dom4jSession.getTransaction().commit();
			idValue = element.elementText(idName);
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
	 * 公共新增或修改方法
	 * 
	 * @param element  实体对象
	 * @param idName   主键字段名称
	 * @param dom4jSession 链接对象
	 * @return 返回主键ID
	 */
	public String saveOrUpdate(Element element,String idName,Session dom4jSession) throws Exception {
		dom4jSession.saveOrUpdate(element);
		return element.elementText(idName);
	}
	
	
	
	/**
	 * 公共修改方法
	 * 
	 * @param element  实体对象
	 * @param idName   主键字段名称
	 * @return 返回主键ID
	 */
	public String update(Element element,String idName) {
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		String idValue = "";
		try {
			dom4jSession.beginTransaction();
			dom4jSession.update(element);
			dom4jSession.getTransaction().commit();
			idValue = element.elementText(idName);
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
	 * 公共修改方法
	 * 
	 * @param element  实体对象
	 * @param idName   主键字段名称
	 * @return 返回主键ID
	 */
	public String update(Element element,String idName,Session dom4jSession) throws Exception {
		dom4jSession.update(element);
		return element.elementText(idName);
	}
	
	/**
	 * 公共删除方法
	 * 
	 * @param element  实体对象
	 * @return 返回布尔值
	 */
	public boolean delete(Element element) {
		boolean flag=false;
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		try {
			dom4jSession.beginTransaction();
			dom4jSession.delete(element);
			dom4jSession.getTransaction().commit();
			flag=true;
		} catch (Exception e) {
			dom4jSession.beginTransaction().rollback();
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return flag;
	}
	
	/**
	 * 公共批量删除表信息
	 * 
	 * @param tableName 表名
	 * @param idName    表主键字段名
	 * @param idValue   ID值集合以","分隔
	 * @return
	 */
	public boolean delete(String tableName, String idName, String idValue) {
		boolean flag = false;
		Session session = getSession();
		try {
			//组织删除语句
			StringBuffer sql=new StringBuffer("delete from " + tableName + " where " + idName + " ");
			String[] ids=idValue.split(",");
			int length=ids.length;
			if(length==1){
				sql.append("=?");
			}else{
				StringBuffer condition=new StringBuffer("");
				condition.append("?");
				for (int i = 1; i <length; i++) {
					condition.append(",?");
				}
				sql.append("in("+condition+")");
			}
			//执行语句
			session.beginTransaction();
			Query query = session.createQuery(sql.toString());
			for (int i = 0; i < ids.length; i++) {
				query.setLong(i, Long.parseLong(ids[i]));
			}
			query.executeUpdate();
			session.getTransaction().commit();
			flag = true;
		} catch (Exception e) {
			session.beginTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return flag;
	}
	
	/**
	 * 获取in 字符串
	 * @param idValue
	 * @return
	 */
	public String getSplitStr(String idValue){
		StringBuffer str=new StringBuffer();
		String[] ids=idValue.split(",");
		int length=ids.length;
		if(length==1){
			str.append("=?");
		}else{
			StringBuffer condition=new StringBuffer("");
			condition.append("?");
			for (int i = 1; i <length; i++) {
				condition.append(",?");
			}
			str.append("in("+condition+")");
		}
		return str.toString();
	}
	
	/**
	 * 公共批量删除表信息
	 * 
	 * @param tableName 表名
	 * @param idName    表主键字段名
	 * @param idValue   ID值集合以","分隔
	 * @return
	 */
	public boolean delete(String tableName, String idName, String idValue,Session session) throws Exception  {
		//组织删除语句
		StringBuffer sql=new StringBuffer("delete from " + tableName + " where " + idName + " ");
		String[] ids=idValue.split(",");
		int length=ids.length;
		if(length==1){
			sql.append("=?");
		}else{
			StringBuffer condition=new StringBuffer("");
			condition.append("?");
			for (int i = 1; i <length; i++) {
				condition.append(",?");
			}
			sql.append("in("+condition+")");
		}
		//执行语句
		Query query = session.createQuery(sql.toString());
		for (int i = 0; i < ids.length; i++) {
			query.setLong(i, Long.parseLong(ids[i]));
		}
		query.executeUpdate();
		return true;
	}
	
	/**
	 * 公共执行方法
	 * 
	 * @param sql     SQL删除、修改、新增语句
	 * @param params  参数
	 * @return 返回指行条数
	 */
	public int executeUpdate(String sql,Object[] params) {
		int count=-1;
		Session session = getSession();
		try {
			session.beginTransaction();
			Query query = setQueryParameters(session.createQuery(sql), params);
			count=query.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.beginTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * 公共执行查询方法，获取单条记录
	 * 
	 * @param sql     SQL查询语句
	 * @param params  参数
	 * @return 返回单条记录
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> getById(String sql,Object[] params) {
		Map<String, Object> returnmap=null;
		Session session = getSession();
		try {
			Query query = setQueryParameters(session.createQuery(sql), params);
			List<Map<String,Object>> list=query.list();
			if(list!=null&&list.size()>0){
				returnmap=list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return returnmap;
	}
	
	/**
	 * 公共执行查询方法，获取数量
	 * 
	 * @param sql     SQL查询语句
	 * @param params  参数
	 * @return 返回数量
	 */
	@SuppressWarnings("unchecked")
	public int getCount(String sql,Object[] params) {
		int count=-1;
		Session session = getSession();
		try {
			Query query = setQueryParameters(session.createQuery(sql), params);
			List list=query.list();
			if(list!=null&&list.size()>0){
				count=Integer.parseInt(String.valueOf(list.get(0)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return count;
	}
	
	/**
	 * 公共执行查询方法，获取全部记录
	 * 
	 * @param sql     SQL查询语句
	 * @param params  参数
	 * @return 返回查询列表
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> getByList(String sql,Object[] params) {
		List<Map<String,Object>> returnlist=null;
		Session session = getSession();
		try {
			Query query = setQueryParameters(session.createQuery(sql), params);
			returnlist=query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return returnlist;
	}
	
	public Map<String,Object> getByList(String sql,Object[] params,int nowPage, int onePageCount) {
		return getByList(sql, params, nowPage, onePageCount, null);
	}
	
	public Map<String,Object> getByList(String sql,Object[] params,int nowPage, int onePageCount, Session session) {
		return getByList(sql, params, null, nowPage, onePageCount, session);
	}
	
	/**
	 * 公共执行查询方法，获取全部记录
	 * 
	 * @param sql           SQL查询语句
	 * @param params        参数
	 * @param tableName     表名
	 * @param nowPage       当前页
	 * @param onePageCount  每页显示多少条
	 * @return 返回布尔值
	 */
	public Map<String,Object> getByList(String sql,Object[] params,String tableName,int nowPage, int onePageCount) {
		return getByList(sql, params, tableName, nowPage, onePageCount, null);
	}
	
	public Map<String,Object> getByList(String sql,Object[] params,String tableName,int nowPage, int onePageCount, Session session) {
		Map<String,Object> returnMap = null;
		if(session == null || !session.isOpen()){
			session = getSession();
		}
		try {
			Query query = setQueryParameters(session.createQuery(sql), params);
			returnMap = PagerSupport.getList(session, query, tableName, params,nowPage, onePageCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return returnMap;
	}
	
	/**
	 * 根据ID获取实体
	 * @param tableName 表名
	 * @param keyid 主键字段
	 * @param id 主键id
	 * @return 返回表实体,如果无查询记录则返回null
	 */
	@SuppressWarnings("unchecked")
	public  Element getElementById(String tableName,String keyid,String id){
		Element element=null;
		Session session = super.getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		try {
			List<Element> list = dom4jSession.createQuery("FROM "+tableName+" where "+keyid+"="+id).list();
			if(list!=null&&list.size()>0){
				element=list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return element;
	}
	
	/**
	 * 公共执行查询方法，获取单条记录
	 * 
	 * @param sql     SQL查询语句
	 * @param params  参数
	 * @return 返回单条记录
	 */
	@SuppressWarnings("unchecked")
	public Element getElementById(String sql,Object[] params) {
		Element element=null;
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		try {
			Query query = setQueryParameters(dom4jSession.createQuery(sql), params);
			List<Element> list=query.list();
			if(list!=null&&list.size()>0){
				element=list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return element;
	}
	

	/**
	 * 公共执行查询方法，获取全部记录
	 * @param sql SQL查询语句
	 * @param params 参数
	 * @author 何明旺
	 * @return 返回查询列表
	 */
	public List<Map<String,Object>> queryForListWithSQLQuery(String sql,Object[] params) {
		List<Map<String,Object>> returnlist=null;
		Session session = getSession();
		try {
			setQueryParameters(session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP), params).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return returnlist;
	}
	
	public Map<String,Object> queryForListWithSQLQuery(String sql,Object[] params,int nowPage, int onePageCount) {
		return queryForListWithSQLQuery(sql, params, nowPage, onePageCount, null);
	}
	
	public Map<String,Object> queryForListWithSQLQuery(String sql,Object[] params,int nowPage, int onePageCount, Session session) {
		return queryForListWithSQLQuery(sql, params, null, nowPage, onePageCount, session);
	}
	
	/**
	 * 公共执行查询方法，获取全部记录
	 * 
	 * @param sql           SQL查询语句
	 * @param params        参数
	 * @param tableName     表名
	 * @param nowPage       当前页
	 * @param onePageCount  每页显示多少条
	 * @return 返回布尔值
	 */
	public Map<String,Object> queryForListWithSQLQuery(String sql,Object[] params,String tableName,int nowPage, int onePageCount) {
		return queryForListWithSQLQuery(sql, params, tableName, nowPage, onePageCount, null);
	}
	
	public Map<String,Object> queryForListWithSQLQuery(String sql,Object[] params,String tableName,int nowPage, int onePageCount, Session session) {
		Map<String,Object> returnMap = null;
		if(session == null || !session.isOpen()){
			session = getSession();
		}
		try {
			Query query = setQueryParameters(session.createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP), params);
			returnMap = PagerSupport.getList(session, query, tableName, params,nowPage, onePageCount);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return returnMap;
	}
	
	/**
	 * 设置参数
	 * @param query Query对象
	 * @param obj   参数值数组
	 * @return
	 */
	public Query setQueryParameters(Query query, Object[] params) {
		if(params!=null){
			for (int i = 0; i < params.length; i++) {
				if (params[i] instanceof Integer) {
					query.setInteger(i, (Integer) params[i]);
				} else if (params[i] instanceof Long) {
					query.setLong(i, (Long) params[i]);
				} else if (params[i] instanceof Boolean) {
					query.setBoolean(i, (Boolean) params[i]);
				} else if (params[i] instanceof Double) {
					query.setDouble(i, (Double) params[i]);
				} else if (params[i] instanceof Float) {
					query.setFloat(i, (Float) params[i]);
				} else if (params[i] instanceof Date) {
					query.setDate(i, (Date) params[i]);
				} else {
					query.setString(i, (String) params[i]);
				}
			}
		}
		return query;
	}
}
