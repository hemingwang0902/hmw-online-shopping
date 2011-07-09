package com.baizhi.index.dao;

import java.util.List;
import java.util.Map;
import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.ParametersSupport;
/**
 * 类名： SzDao.java<br>
 * 描述：设置<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-9 上午11:17:12<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class SzDao extends DaoSupport{
	/**
	 * 根据用户基本信息表ID获取用户基本信息表信息
	 * @param BASIC_ID 用户基本信息表ID
	 * @return 返回用户基本信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserBasicMapById(int USER_ID){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT new Map(")
		   .append("a.BASIC_ID as BASIC_ID,")//用户基本信息ID
		   .append("a.USER_ID as USER_ID,")//用户ID
		   .append("a.NAME as NAME,")//姓名/品牌名称
		   .append("a.NAME_MODIFYTIME as NAME_MODIFYTIME,")//姓名/品牌名称时间
		   .append("a.INTRODUCTION as INTRODUCTION,")//个人介绍/品牌介绍
		   .append("a.IMAGE_PATH as IMAGE_PATH,")//相片路径/LOGO路径
		   .append("a.WEBSITE as WEBSITE,")//个性网址
		   .append("a.WEBSITE_MODIFYTIME as WEBSITE_MODIFYTIME)")//个性网址时间
		   .append("FROM T_USER_BASIC a WHERE a.USER_ID=? ");
		return this.getById(sql.toString(), new Object[]{USER_ID});
	}
	
	/**
	 * 修改用户基本信息表信息
	 * 
	 * @param element  实体对象
	 * @return 成功返回执行记录数,失败返回-1
	 */
	public int updateUserBasic(Map<String, Object> params,int USER_ID) {
		int count=-1;
		StringBuffer sql = new StringBuffer();
		ParametersSupport ps=new ParametersSupport(params,ParametersSupport.EXECUTETYPE);
		sql.append("update T_USER_BASIC set "+ps.getConditions()+" where USER_ID=?");
		List<Object> list = ps.getValuesList();
		list.add(USER_ID);
		count=this.executeUpdate(sql.toString(), list.toArray());
		return count;
	}
	
}
