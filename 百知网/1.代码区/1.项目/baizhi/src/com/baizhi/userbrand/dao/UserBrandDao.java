package com.baizhi.userbrand.dao;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.hibernate.Query;
import org.hibernate.Session;

import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
import com.baizhi.commons.support.DateUtils;
 /**
 * 
 * 类名：UserBrandDao.java
 * 描述：用户品牌信息表数据操作类，负责增删改查
 * 创建者： 江红
 * 创建日期：2011-07-10 13:09:53
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class UserBrandDao extends DaoSupport{
	
	/**
	 * 新增或修改用户品牌信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateUserBrand(Element element) {
		return this.saveOrUpdate(element, "BRAND_ID");
	}
	
	/**
	 *　删除用户品牌信息表信息
	 * 
	 * @param BRAND_IDS   用户品牌信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteUserBrand(String BRAND_IDS) {
		return this.delete("T_USER_BRAND","BRAND_ID", BRAND_IDS);
	}
	
	
	/**
	 *　审核
	 * 
	 * @param BRAND_IDS   用户品牌信息表ID值集合以","分隔
	 * @param REASON   原因
	 * @param TYPE   类型 3同意,4不同意
	 * @param USER_ID   用户ID
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean audit(String BRAND_IDS,String REASON,int TYPE,int USER_ID) {
		boolean flag = false;
		Session session = getSession();
		try {
			//组织语句
			StringBuffer sql=new StringBuffer("update T_USER_BRAND set STAUS=?,REASON=?,AUDIT_ID=?,AUDIT_TIME=? where BRAND_ID ");
			String[] ids=BRAND_IDS.split(",");
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
			query.setInteger(0, TYPE);
			query.setString(1, REASON);
			query.setInteger(2, USER_ID);
			query.setString(3, DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));
			
			for (int i = 4; i <= ids.length+3; i++) {
				query.setLong(i, Long.parseLong(ids[(i-4)]));
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
	 * 根据用户品牌信息表ID获取用户品牌信息表实体
	 * @param BRAND_ID 用户品牌信息表ID
	 * @return 返回用户品牌信息表实体,如果无查询记录则返回null
	 */
	public  Element getUserBrandEleById(String BRAND_ID){
		return this.getElementById("T_USER_BRAND", "BRAND_ID", BRAND_ID);
	}
	
	/**
	 *　获取用户品牌信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getUserBrandCount(Map<String, Object> params) {
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT count(*) FROM T_USER_BRAND a WHERE 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getCount(sql.toString(), ps.getValues());
	}
	
	/**
	 * 根据用户品牌信息表ID获取用户品牌信息表信息
	 * @param BRAND_ID 用户品牌信息表ID
	 * @return 返回用户品牌信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserBrandMapById(String BRAND_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.BRAND_ID as BRAND_ID,")//品牌ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.NAME as NAME,")//品牌名称
		   .append("a.INTRODUCTION as INTRODUCTION,")//品牌介绍
		   .append("a.SOURCE as SOURCE,")//发源地(品牌特有)
		   .append("a.PROVINCE as PROVINCE,")//所在地区(省：地区信息表ID)
		   .append("a.CITY as CITY,")//所在地区(市：地区信息表ID)
		   .append("a.INDUSTRY as INDUSTRY,")//从事行业(字典)
		   .append("a.LINK_NAME as LINK_NAME,")//联系人姓名
		   .append("a.LINK_MODE as LINK_MODE,")//联系方式
		   .append("a.EMAIL as EMAIL,")//电子邮箱
		   .append("a.IMAGE_PATH as IMAGE_PATH,")//相片路径/LOGO路径
		   .append("a.STAUS as STAUS,")//状态(1：未申请、2：申请、3：通过、4：未通过)
		   .append("a.AUDIT_ID as AUDIT_ID,")//审核人
		   .append("a.AUDIT_TIME as AUDIT_TIME,")//审核时间
		   .append("a.REASON as REASON,")//不通过原因
		   .append("a.REMARK as REMARK,")//备注
		   .append("a.BRAND_LABEL as BRAND_LABEL,")//标签
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_BRAND a WHERE a.BRAND_ID=? ");
		return this.getById(sql.toString(), new Object[]{BRAND_ID});
	}
	
	/**
	 * 获取用户品牌信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户品牌信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserBrandList(Map<String, Object> params,int nowPage,int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.BRAND_ID as BRAND_ID,")//品牌ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("b.NAME as USER_NAME,")//用户ID
		   .append("a.NAME as NAME,")//品牌名称
		   .append("a.INTRODUCTION as INTRODUCTION,")//品牌介绍
		   .append("a.SOURCE as SOURCE,")//发源地(品牌特有)
		   .append("a.PROVINCE as PROVINCE,")//所在地区(省：地区信息表ID)
		   .append("a.CITY as CITY,")//所在地区(市：地区信息表ID)
		   .append("a.INDUSTRY as INDUSTRY,")//从事行业(字典)
		   .append("a.LINK_NAME as LINK_NAME,")//联系人姓名
		   .append("a.LINK_MODE as LINK_MODE,")//联系方式
		   .append("a.EMAIL as EMAIL,")//电子邮箱
		   .append("a.IMAGE_PATH as IMAGE_PATH,")//相片路径/LOGO路径
		   .append("a.STAUS as STAUS,")//状态(1：未申请、2：申请、3：通过、4：未通过)
		   .append("a.AUDIT_ID as AUDIT_ID,")//审核人
		   .append("(select NAME from T_USER_BASIC where USER_ID=a.AUDIT_ID)as AUDIT_NAME,")//审核人
		   .append("a.AUDIT_TIME as AUDIT_TIME,")//审核时间
		   .append("a.REASON as REASON,")//不通过原因
		   .append("a.REMARK as REMARK,")//备注
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_BRAND a,T_USER_BASIC b WHERE a.USER_ID=b.USER_ID ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues(), "T_USER_BRAND", nowPage, onePageCount);
	}
	
	/**
     * 获取用户品牌信息表信息
     * 
     * @param  params 参数
     * @return 成功返回用户品牌信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getUserBrandList(Map<String, Object> params){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.BRAND_ID as BRAND_ID,")//品牌ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.NAME as NAME,")//品牌名称
		   .append("a.INTRODUCTION as INTRODUCTION,")//品牌介绍
		   .append("a.SOURCE as SOURCE,")//发源地(品牌特有)
		   .append("a.PROVINCE as PROVINCE,")//所在地区(省：地区信息表ID)
		   .append("a.CITY as CITY,")//所在地区(市：地区信息表ID)
		   .append("a.INDUSTRY as INDUSTRY,")//从事行业(字典)
		   .append("a.LINK_NAME as LINK_NAME,")//联系人姓名
		   .append("a.LINK_MODE as LINK_MODE,")//联系方式
		   .append("a.EMAIL as EMAIL,")//电子邮箱
		   .append("a.IMAGE_PATH as IMAGE_PATH,")//相片路径/LOGO路径
		   .append("a.STAUS as STAUS,")//状态(1：未申请、2：申请、3：通过、4：未通过)
		   .append("a.AUDIT_ID as AUDIT_ID,")//审核人
		   .append("a.AUDIT_TIME as AUDIT_TIME,")//审核时间
		   .append("a.REASON as REASON,")//不通过原因
		   .append("a.REMARK as REMARK,")//备注
		   .append("a.CREATE_TIME as CREATE_TIME,")//创建时间
		   .append("a.MODIFY_TIME as MODIFY_TIME) ")//修改时间
		   .append("FROM T_USER_BRAND a where 1=1 ");
		//设置查询条件,及初始化查询条件值
		ParametersSupport ps=new ParametersSupport(params);
		sql.append(ps.getConditions());
		
		return this.getByList(sql.toString(), ps.getValues());
	}
	
}

