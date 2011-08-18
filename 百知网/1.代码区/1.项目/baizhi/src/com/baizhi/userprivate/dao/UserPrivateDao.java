package com.baizhi.userprivate.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.hibernate.EntityMode;
import org.hibernate.Query;
import org.hibernate.Session;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.PagerSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：UserPrivateDao.java
 * 描述：用户私信信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-07-05 00:26:42
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class UserPrivateDao extends DaoSupport{
	
	/**
	 * 保存用户私信信息表信息
	 * 
	 * @param element1  主动实体对象
	 * @param element2  被动实体对象
	 * @return 成功返回true,失败返回false
	 */
	public boolean saveUserPrivate(Element element1,Element element2) {
		Session session = getSession();
		Session dom4jSession = session.getSession(EntityMode.DOM4J);
		boolean flag = false;
		try {
			dom4jSession.beginTransaction();
			//修改
			Query query = setQueryParameters(
					session.createQuery("update T_USER_PRIVATE set SHOW_CONDITION=0 where USER_ID=? and SEND_ID=? and SHOW_CONDITION=1 "), 
					new Object[]{element1.elementText("USER_ID"),element1.elementText("SEND_ID")});
			query.executeUpdate();
			dom4jSession.save(element1);
			
			//修改
			query = setQueryParameters(
					session.createQuery("update T_USER_PRIVATE set SHOW_CONDITION=0 where USER_ID=? and SEND_ID=? and SHOW_CONDITION=1 "), 
					new Object[]{element2.elementText("USER_ID"),element2.elementText("SEND_ID")});
			query.executeUpdate();
			dom4jSession.save(element2);
			
			
			dom4jSession.getTransaction().commit();
			flag=true;
		} catch (Exception e) {
			dom4jSession.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			dom4jSession.close();
			session.close();
		}
		return flag;
	}
	
	/**
	 *　删除用户私信信息表信息
	 * 
	 * @param params  参数
	 * @return 返回boolean值,成功返回执行记录数　,失败返回-1
	 */
	public int deleteUserPrivate(Map<String, Object> params) {
		int count=-1;
		//组织删除语句
		StringBuffer sql=new StringBuffer("delete from T_USER_PRIVATE where 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		count =this.executeUpdate(sql.toString(), ps.getValues());
		return count;
	}
	
	@SuppressWarnings("all")
	/**
	 *　删除用户私信信息表信息
	 * 
	 * @param params  参数
	 * @return 返回boolean值,成功返回执行记录数　,失败返回-1
	 */
	public int deleteUserByPrivate(Integer PRIVATE_ID,Integer USER_ID) {
		int count=-1;
		//组织删除语句
		StringBuffer sql=new StringBuffer();
		
		sql.append("select PRIVATE_ID from T_USER_PRIVATE a where a.USER_ID=? ")
		   .append("and a.SEND_ID=(select SEND_ID from T_USER_PRIVATE where PRIVATE_ID=? ) ")
		   .append("and a.CREATE_TIME=(select max(CREATE_TIME) from T_USER_PRIVATE where USER_ID=a.USER_ID and SEND_ID=a.SEND_ID and PRIVATE_ID<>?  )");
		Session session = getSession();
		try {
			session.beginTransaction();
			//查询最大日期记录
			Query query = setQueryParameters(session.createQuery(sql.toString()), new Object[]{USER_ID,PRIVATE_ID,PRIVATE_ID});
			List list = query.list();
			int M_PRIVATE_ID=0;
			if(list!=null&&list.size()>0){
				M_PRIVATE_ID=Integer.parseInt(String.valueOf(list.get(0)));
			}
			
			//修改
			if(M_PRIVATE_ID>0){
				query = setQueryParameters(session.createQuery("update T_USER_PRIVATE set SHOW_CONDITION=1 where PRIVATE_ID=?"), new Object[]{M_PRIVATE_ID});
				count=query.executeUpdate();
			}
			
			query = setQueryParameters(session.createQuery("delete from T_USER_PRIVATE where PRIVATE_ID=?"), new Object[]{PRIVATE_ID});
			count=query.executeUpdate();
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		return count;
	}
	
	/**
	 * 根据用户私信信息表ID获取用户私信信息表实体
	 * @param PRIVATE_ID 用户私信信息表ID
	 * @return 返回用户私信信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserPrivateEleById(String PRIVATE_ID){
		return this.getElementById("T_USER_PRIVATE", "PRIVATE_ID", PRIVATE_ID);
	}
	
	/**
	 *　获取用户私信信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserPrivateCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_USER_PRIVATE a WHERE IS_READ=0 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据用户私信信息表ID获取用户私信信息表信息
	 * @param PRIVATE_ID 用户私信信息表ID
	 * @return 返回用户私信信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserPrivateMapById(String PRIVATE_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PRIVATE_ID as PRIVATE_ID,")//私信ID
		   .append("a.USER_ID as USER_ID,")//收件人ID
		   .append("a.SEND_ID as SEND_ID,")//发送人ID
		   .append("a.CONTENT as CONTENT,")//发送内容
		   .append("a.IS_READ as IS_READ,")//是否阅读(0否、1是)
		   .append("a.PPRIVATE_ID as PPRIVATE_ID,")//父私信ID（私信、与私信回复为一张表）
		   .append("a.CREATE_TIME as CREATE_TIME) ")//创建时间
		   .append("FROM T_USER_PRIVATE a WHERE a.PRIVATE_ID=? ");
		return this.getById(sql.toString(), new Object[]{PRIVATE_ID});
	}
	
	@SuppressWarnings("all")
	/**
	 * 获取用户私信信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户私信信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserPrivateList(Map<String, Object> params,int nowPage,int onePageCount){
		Map<String,Object> returnMap = null;
		Session session = getSession();
		try {
			//组织查询语句
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT new Map(")
			   .append("a.PRIVATE_ID as PRIVATE_ID,")//私信ID
			   .append("a.USER_ID as USER_ID,")//收件人ID
			   .append("a.SEND_ID as SEND_ID,")//发送人ID
			   .append("b.NAME as NAME,")//发送人姓名
			   .append("b.IMAGE_PATH as IMAGE_PATH,")//发送人头像
			   .append("a.CONTENT as CONTENT,")//发送内容
			   .append("a.IS_READ as IS_READ,")//是否阅读(0否、1是)
			   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间被动
			   .append("a.IS_MYSELF as IS_MYSELF,")//主动
			   .append("(select count(*) from T_USER_PRIVATE where USER_ID=a.USER_ID) as PRIVATE_COUNT,")//共几条记录
			   .append("(select count(*) from T_USER_PRIVATE where USER_ID=a.USER_ID and IS_READ=0) as NO_PRIVATE_COUNT) ")//未读记录
			   .append("FROM T_USER_PRIVATE a,T_USER_BASIC b ")
			   .append("WHERE a.SEND_ID=b.USER_ID and a.SHOW_CONDITION=1 ");
			//设置查询条件,及初始化查询条件值
			ParametersSupport ps=new ParametersSupport(params);
			sql.append(ps.getConditions());
			
			Query query = setQueryParameters(session.createQuery(sql.toString()), ps.getValues());
			returnMap = PagerSupport.getList(session, query, "T_USER_PRIVATE a", ps.getValues(),nowPage, onePageCount);
			//获取记录
			if (returnMap != null && returnMap.size() != 0) {
				//判断是否存在列表数据，如果存在列表数据，则将日期格式转换
				if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
					String PRIVATE_IDS="";
					List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
					for (int i = 0; i < list.size(); i++) {
						Map<String, Object> newmap = list.get(i);
						if(newmap!=null&&newmap.get("IS_READ")!=null){
							String IS_READ=String.valueOf(newmap.get("IS_READ"));
							if(IS_READ.equals("0")){
								PRIVATE_IDS+=(PRIVATE_IDS.equals("")?String.valueOf(newmap.get("PRIVATE_ID")):","+String.valueOf(newmap.get("PRIVATE_ID")));
								int NO_PRIVATE_COUNT=Integer.parseInt(String.valueOf(newmap.get("NO_PRIVATE_COUNT")));
								newmap.put("NO_PRIVATE_COUNT", NO_PRIVATE_COUNT-1);
							}
						}
					}
					//如果查询未阅读记录，则将未阅读记录修改成已阅读
					if(!PRIVATE_IDS.equals("")){
						query = session.createQuery("update T_USER_PRIVATE set IS_READ=1 where PRIVATE_ID in("+PRIVATE_IDS+")");
						query.executeUpdate();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return returnMap;
	}

	@SuppressWarnings("all")
	/**
	 * 修改未阅读隐私
	 * @param USER_ID 用户ID
	 * @param SEND_ID 发件人ID
	 * @return 返回用户基本信息
	 */
	public Map<String,Object> ModifyNoReadPrivate(int USER_ID,int SEND_ID){
		Map<String,Object> returnMap = null;
		Session session = getSession();
		try {
			Query query = setQueryParameters(session.createQuery("update T_USER_PRIVATE set IS_READ=1 where USER_ID=? and SEND_ID=?"), new Object[]{USER_ID,SEND_ID});
			query.executeUpdate();
			query = setQueryParameters(session.createQuery("select new Map(NAME as NAME) from T_USER_BASIC where USER_ID=?"), new Object[]{SEND_ID});
			List<Map<String,Object>> list=query.list();
			if(list!=null&&list.size()>0){
				returnMap=list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return returnMap;
	}
	
	/**
	 * 获取用户私信信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户私信信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserPrivateByList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PRIVATE_ID as PRIVATE_ID,")//私信ID
		   .append("a.USER_ID as USER_ID,")//收件人ID
		   .append("a.SEND_ID as SEND_ID,")//发送人ID
		   .append("b.NAME as NAME,")//发送人姓名
		   .append("b.IMAGE_PATH as IMAGE_PATH,")//发送人头像
		   .append("a.CONTENT as CONTENT,")//发送内容
		   .append("a.IS_READ as IS_READ,")//是否阅读(0否、1是)
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间被动
		   .append("a.IS_MYSELF as IS_MYSELF) ")//主动
		   .append("FROM T_USER_PRIVATE a,T_USER_BASIC b ")
		   .append("WHERE a.SEND_ID=b.USER_ID  ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions()+" ORDER BY CREATE_TIME DESC ");
		
		return this.getByList(sql.toString(), ps.getValues(), "T_USER_PRIVATE a", nowPage, onePageCount);
	}
	
	/**
     * 获取用户私信信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户私信信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserPrivateList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.PRIVATE_ID as PRIVATE_ID,")//私信ID
		   .append("a.USER_ID as USER_ID,")//收件人ID
		   .append("a.SEND_ID as SEND_ID,")//发送人ID
		   .append("a.CONTENT as CONTENT,")//发送内容
		   .append("a.IS_READ as IS_READ,")//是否阅读(0否、1是)
		   .append("a.PPRIVATE_ID as PPRIVATE_ID,")//父私信ID（私信、与私信回复为一张表）
		   .append("a.CREATE_TIME as CREATE_TIME) ")//创建时间
		   .append("FROM T_USER_PRIVATE a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

