package com.baizhi.index.dao;

import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.baizhi.commons.DaoSupport;
import com.baizhi.commons.PagerSupport;

/**
 * 类名： HomeDao<br>
 * 描述：网站首页的DAO<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-2<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class HomeDao extends DaoSupport{
	
	/**
	 * 根据名称模糊查询会员、品牌和问题
	 * @param title 会员姓名、品牌名称或问题标题
	 * @return
	 */
	public Map<String,Object> getUserOrProblemByTitleList(String title, int nowPage, int onePageCount){
		//组织查询语句
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT U.USER_ID AS ID, UB.NAME AS TITLE, U.USER_TYPE AS TYPE")
		   .append(" FROM T_USER U, T_USER_BASIC UB")
		   .append(" WHERE U.USER_ID=UB.USER_ID")
		   .append(" AND UB.NAME LIKE ?")
		   .append(" UNION")
		   .append(" SELECT P.PROBLEM_ID AS ID, P.CONTENT AS TITLE, '3' AS TYPE")
		   .append(" FROM T_PROBLEM P")
		   .append(" WHERE P.CONTENT LIKE ?");
		
		Session session = getSession();
		Object[] condition = new Object[] { title, title };
		Query query = session.createSQLQuery(sql.toString())
		.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		setQueryParameters(query, condition);
		return PagerSupport.getList(session, query, null, null, nowPage, onePageCount);
	}
}
