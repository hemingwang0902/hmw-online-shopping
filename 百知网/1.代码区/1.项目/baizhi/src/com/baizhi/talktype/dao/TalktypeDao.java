package com.baizhi.talktype.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.hibernate.Session;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
 /**
 * 
 * 类名：TalktypeDao.java
 * 描述：话题类型表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-08-13 22:34:26
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class TalktypeDao extends DaoSupport{
	
	/**
	 * 新增或修改话题类型表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateTalktype(Element element) {
		return this.saveOrUpdate(element, "TALKTYPE_ID");
	}
	
	
	/**
	 * 修改话题表
	 */
	public int updateTalk(Map<String, Object> params,int TALKTYPE_ID) {
		int count=-1;
		StringBuffer sql = new StringBuffer();
		ParametersSupport ps=new ParametersSupport(params,ParametersSupport.EXECUTETYPE);
		sql.append("update T_TALKTYPE set "+ps.getConditions()+" where TALKTYPE_ID=?");
		List<Object> list = ps.getValuesList();
		list.add(TALKTYPE_ID);
		count=this.executeUpdate(sql.toString(), list.toArray());
		return count;
	}
	/**
	 * 根据话题ID，查询话题详细信息
	 * @param TALK_ID 话题ID
	 * @param 当前页
	 * @param onePageCount 每页显示的记录条数
	 * @return 查询到的结果集
	 */
	public Map<String,Object> getTalkTypeById(int TALKTYPE_ID, int loginUserId){
		StringBuffer sql = new StringBuffer()		
		.append("SELECT count(*) FROM T_TALKTYPE a WHERE TALKType_ID=? ");
		Object[] params = new Object[]{loginUserId, TALKTYPE_ID};
		List<Map<String,Object>> list = queryForListWithSQLQuery(sql.toString(), params);
		if(list == null || list.isEmpty())
			return null;
		return list.get(0);
	}
	
	/**
	 *　删除话题类型表信息
	 * 
	 * @param TALKTYPE_IDS   话题类型表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteTalktype(String TALKTYPE_IDS) {
		return this.delete("T_TALKTYPE","TALKTYPE_ID", TALKTYPE_IDS);
	}
	
	
	/**
	 *　设置取消话题类型
	 * 
	 * @param TALK_IDS   话题ID值集合以","分隔
	 * @param TYPE       类型
	 * @param TALKTYPE_ID　话题类型
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public int setTalktype(String TALK_IDS,String TYPE,String TALKTYPE_ID) {
		int count=-1;
		Session session = getSession();
		try {
			session.beginTransaction();
			if(TYPE.equals("1")){
				count=session.createQuery("update T_TALK set TALKTYPE_ID=null where TALK_ID in ("+TALK_IDS+")").executeUpdate();
			}else{
				count=session.createQuery("update T_TALK set TALKTYPE_ID="+TALKTYPE_ID+" where TALK_ID in ("+TALK_IDS+")").executeUpdate();
			}
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
	 * 根据话题类型表ID获取话题类型表实体
	 * @param TALKTYPE_ID 话题类型表ID
	 * @return 返回话题类型表实体,如果无查询记录则返回null
	 */
	public  Element getTalktypeEleById(String TALKTYPE_ID){
		return this.getElementById("T_TALKTYPE", "TALKTYPE_ID", TALKTYPE_ID);
	}
	
	/**
	 *　获取话题类型表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getTalktypeCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_TALKTYPE a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据话题类型表ID获取话题类型表信息
	 * @param TALKTYPE_ID 话题类型表ID
	 * @return 返回话题类型表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getTalktypeMapById(String TALKTYPE_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.TALKTYPE_ID as TALKTYPE_ID,")//话题类型ID
		   .append("a.TYPE_NAME as TYPE_NAME,")//类型名称
		   .append("a.REMARK as REMARK,")//备注
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_TALKTYPE a WHERE a.TALKTYPE_ID=? ");
		return this.getById(sql.toString(), new Object[]{TALKTYPE_ID});
	}
	
	/**
	 * 获取话题类型表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回话题类型表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getTalktypeList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.TALKTYPE_ID as TALKTYPE_ID,")//话题类型ID
		   .append("a.TYPE_NAME as TYPE_NAME,")//类型名称
		   .append("a.REMARK as REMARK,")//备注
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME,")//修改时间
		   .append("(select count(*) from T_TALK where TALKTYPE_ID=a.TALKTYPE_ID)as TALK_COUNT) ")//话题数量
		   .append("FROM T_TALKTYPE a WHERE 1=1");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params); 
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_TALKTYPE", nowPage, onePageCount);
	}
	
	/**
     * 获取话题类型表信息
     * 
     * @param  params 参数
     * @return 成功返回话题类型表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getTalktypeList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.TALKTYPE_ID as TALKTYPE_ID,")//话题类型ID
		   .append("a.TYPE_NAME as TYPE_NAME,")//类型名称
		   .append("a.REMARK as REMARK,")//备注
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_TALKTYPE a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

