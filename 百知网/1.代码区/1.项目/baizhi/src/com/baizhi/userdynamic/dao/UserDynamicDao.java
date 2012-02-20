package com.baizhi.userdynamic.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import org.hibernate.Session;

import com.baizhi.IConstants;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
 /**
 * 
 * 类名：UserDynamicDao.java
 * 描述：用户动态信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-07-05 00:34:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class UserDynamicDao extends DaoSupport{
	
	/**
	 * 新增或修改用户动态信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserDynamic(Element element) {
		return this.saveOrUpdate(element, "DYNAMIC_ID");
	}
	
	/**
	 * 
	 * @param USER_ID      当前用户ID
	 * @param TITLE        动态主题(暂时不用)
	 * @param BUSINESS_ID  业务主键
	 * @param DYNAMIC_TYPE 业务类型(1：有人关注了我、2：有人问了我一个问题、3：有人邀请我回答一个问题、4：我关注的问题有了新答案、5：有人关注了我的品牌、7:有人关注了我品牌问题、8:我关注的品牌问题有了新答案)
	 * @param CONTENT      动态内容
	 * @param WARN_USERID  提醒用户ID
	 * @param dom4jSession 数据库连接
	 * @return
	 * @throws Exception
	 */
	public String saveUserDynamic(Integer USER_ID,String TITLE,Integer BUSINESS_ID, IConstants.NoticeType DYNAMIC_TYPE,String CONTENT,Integer WARN_USERID,Session dom4jSession)throws Exception{
		String idValue = "";
		Element element = new DefaultElement("T_USER_DYNAMIC");
		Elements.setElementValue(element, "USER_ID", USER_ID);// 用户ID
		Elements.setElementValue(element, "TITLE", TITLE);// 动态主题
		Elements.setElementValue(element, "BUSINESS_ID", BUSINESS_ID);// 业务主键(回复问题ID、关注会员ID)
		Elements.setElementValue(element, "DYNAMIC_TYPE", "" + DYNAMIC_TYPE.key);// 动态类型(字典：1回答问题、2关注会员)
		Elements.setElementValue(element, "CONTENT", CONTENT);// 动态内容(存放组织好的html内容)
		Elements.setElementValue(element, "WARN_USERID", WARN_USERID);// 提醒用户ID
		Elements.setElementValue(element, "IS_OPEN", 0);// 是否查看(0否、1是)
		Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		
		idValue=save(element,dom4jSession);
		
		return idValue;
	}
	
	/**
	 *　删除用户动态信息表信息
	 * 
	 * @param DYNAMIC_IDS   用户动态信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserDynamic(String DYNAMIC_IDS) {
		return this.delete("T_USER_DYNAMIC","DYNAMIC_ID", DYNAMIC_IDS);
	}
	
	/**
	 * 根据用户动态信息表ID获取用户动态信息表实体
	 * @param DYNAMIC_ID 用户动态信息表ID
	 * @return 返回用户动态信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserDynamicEleById(String DYNAMIC_ID){
		return this.getElementById("T_USER_DYNAMIC", "DYNAMIC_ID", DYNAMIC_ID);
	}
	
	/**
	 *　获取用户动态信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserDynamicCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_USER_DYNAMIC a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据用户动态信息表ID获取用户动态信息表信息
	 * @param DYNAMIC_ID 用户动态信息表ID
	 * @return 返回用户动态信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserDynamicMapById(String DYNAMIC_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.DYNAMIC_ID as DYNAMIC_ID,")//用户动态ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.TITLE as TITLE,")//动态主题
		   .append("a.BUSINESS_ID as BUSINESS_ID,")//业务主键(回复问题ID、关注会员ID)
		   .append("a.DYNAMIC_TYPE as DYNAMIC_TYPE,")//动态类型(字典：1回答问题、2关注会员)
		   .append("a.CONTENT as CONTENT,")//动态内容(存放组织好的html内容)
		   .append("a.WARN_USERID as WARN_USERID,")//提醒用户ID
		   .append("a.IS_OPEN as IS_OPEN,")//是否查看(0否、1是)
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_DYNAMIC a WHERE a.DYNAMIC_ID=? ");
		return this.getById(sql.toString(), new Object[]{DYNAMIC_ID});
	}
	
	/**
	 * 获取用户动态信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户动态信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserDynamicList(Map<String, Object> params,int nowPage,int onePageCount){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT ")
		   .append("new Map(a.DYNAMIC_ID as DYNAMIC_ID,")//用户动态ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.TITLE as TITLE,")//动态主题
		   .append("a.BUSINESS_ID as BUSINESS_ID,")//业务主键(回复问题ID、关注会员ID)
		   .append("a.DYNAMIC_TYPE as DYNAMIC_TYPE,")//动态类型(字典：1回答问题、2关注会员)
		   .append("a.CONTENT as CONTENT,")//动态内容(存放组织好的html内容)
		   .append("a.WARN_USERID as WARN_USERID,")//提醒用户ID
		   .append("a.IS_OPEN as IS_OPEN,")
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("b.NAME as USER_NAME,")//姓名
		   .append("b.IMAGE_PATH as IMAGE_PATH) ")//路径
		   .append("FROM T_USER_DYNAMIC a,T_USER_BASIC b WHERE a.USER_ID=b.USER_ID ")
		   .append("and a.WARN_USERID=? ");
		Object[] values=null;
		if(params.get("IS_OPEN")!=null){
			sql.append("and a.IS_OPEN=?");	
			values=new Object[]{params.get("WARN_USERID"),params.get("IS_OPEN")};
		}else{
			values=new Object[]{params.get("WARN_USERID")};
		}
		sql.append("order by CREATE_TIME DESC");
		
		
		return this.getByList(sql.toString(), values, "T_USER_DYNAMIC", nowPage, onePageCount);
	}
	
	/**
	 * 修改是否查看
	 * @param DYNAMIC_ID 消息ID
	 * @return 成功返回执行数量，失败返回-1
	 */
	public int ModifyIsOpen(int DYNAMIC_ID){
		int count=-1;
		count=this.executeUpdate("update T_USER_DYNAMIC set IS_OPEN=1 where DYNAMIC_ID=?", new Object[]{DYNAMIC_ID});
		return count;
		
	}
	
	/**
     * 获取用户动态信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户动态信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserDynamicList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.DYNAMIC_ID as DYNAMIC_ID,")//用户动态ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.TITLE as TITLE,")//动态主题
		   .append("a.BUSINESS_ID as BUSINESS_ID,")//业务主键(回复问题ID、关注会员ID)
		   .append("a.DYNAMIC_TYPE as DYNAMIC_TYPE,")//动态类型(字典：1回答问题、2关注会员)
		   .append("a.CONTENT as CONTENT,")//动态内容(存放组织好的html内容)
		   .append("a.WARN_USERID as WARN_USERID,")//提醒用户ID
		   .append("a.IS_OPEN as IS_OPEN,")//是否查看(0否、1是)
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_DYNAMIC a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

