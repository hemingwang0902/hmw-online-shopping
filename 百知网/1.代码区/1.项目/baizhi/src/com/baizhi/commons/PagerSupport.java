package com.baizhi.commons;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.impl.SQLQueryImpl;

/**
 * 
 * 类名：PagerSupport<br>
 * 描述：分页支持类<br>
 * 创建者：江红 <br>
 * 创建日期： 2011-3-30<br>
 * 版本：V0.9 <br>
 * 修改者：        <br>
 * 修改日期：   <br>
 */
public class PagerSupport implements Serializable {

	private static final long serialVersionUID = 7868171793336018541L;

	protected PagerSupport() {
	}


	/**
	 * 根据查询条件获取分页查询结果；作者：江红 时间：2011-03-06
	 * 
	 * @param session      数据库会话对象
	 * @param query        查询对象
	 * @param tableName    查询表名
	 * @param params       查询参数
	 * @param nowPage      当前页
	 * @param onePageCount 每页显示条数
	 * 
	 * @return 返回 Map,Map存取 count 总记录数 size 总页数 list数据集存放Map数据
	 */
	public static Map<String, Object> getList(Session session, Query query, String tableName,Object[] params,int nowPage, int onePageCount) {
		Map<String, Object> data = null;
		if(StringUtils.isBlank(tableName)){
			data = new HashMap<String, Object>(); 
		}else{
			data = getPage(session, query, tableName,  nowPage, onePageCount, params);
		}
		
		query = query.setFirstResult((nowPage - 1) * onePageCount);
		query = query.setFetchSize(onePageCount);
		query = query.setMaxResults(onePageCount);
		data.put("list", query.list());
		return data;
	}
	
	/**
	 * 根据查询条件获取分页查询结果；作者：江红 时间：2011-03-06
	 * 
	 * @param session      数据库会话对象
	 * @param query        查询对象
	 * @param nowPage      当前页
	 * @param onePageCount 每页显示条数
	 * 
	 * @return 返回 List,list数据集存放Map数据
	 */
	public static List<Map<String, Object>> getList(Session session, Query query,int nowPage, int onePageCount) {
		query = query.setFirstResult((nowPage - 1) * onePageCount);
		query = query.setFetchSize(onePageCount);
		query = query.setMaxResults(onePageCount);
		return query.list();
	}

	



	/**
	 * 得到分页属性，获取分页属性，利用查询对象有设置参数方式
	 * 
	 * @param session      数据库会话对象
	 * @param query        查询对象
	 * @param tableName    查询表名
	 * @param nowPage      当前页
	 * @param onePageCount 每页显示条数
	 * @param params       查询参数
	 * @return 返回分页属性哈希表
	 */
	public static Map<String, Object> getPage(Session session, Query query, String tableName,  int nowPage, int onePageCount, Object[] params) {
		Map<String, Object> page = new HashMap<String, Object>();
		int size = 0;
		// 如果当前页为1则重新查询总记录数，否则不进行查询
		if ( nowPage == 1) {
			int total = getCount(session, query, tableName, params);
			// 如果有记录
			if (total != 0) {
				size = (int) (total / onePageCount);
				// 如果有余数，则页数加1
				if (total % onePageCount != 0) {
					size++;
				}
			}
			page.put("totalCount", total);
			page.put("totalPage", size);
		}
		return page;
	}

	/**
	 * 得到总记录数
	 * 
	 * @param session   数据库会话
	 * @param query     查询对象
	 * @param tableName 字典表名
	 * @param params    查询参数
	 * @return 返回列表数据总数
	 */
	@SuppressWarnings("unchecked")
	private static int getCount(Session session, Query query, String tableName, Object[] params) {
		int rowCount = 0;
		try {
			String sql = query.getQueryString();
			String nsql = sql;
			if (sql.toUpperCase().indexOf("ORDER BY") != -1) {
				nsql = sql.substring(sql.toUpperCase().indexOf("FROM " + tableName.toUpperCase()), sql.toUpperCase().indexOf("ORDER BY"));
			} else {
				nsql = sql.substring(sql.toUpperCase().indexOf("FROM " + tableName.toUpperCase()));
			}
			sql = "select count(*) " + nsql;
			// 如果为原生SQL查询对象
			if (query instanceof SQLQueryImpl) {
				query = session.createSQLQuery(sql);
			} else {
				query = session.createQuery(sql);
			}
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
			List<Integer> list = query.list();
			if (list != null && list.size() > 0) {
				rowCount = Integer.parseInt(list.get(0) + "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rowCount;
	}

}
