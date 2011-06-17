package com.baizhi.user.dao;

import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import com.baizhi.commons.DaoSupport;

/**
 * 
 * 类名：UserDao<br>
 * 描述： 用户信息类负责新增 、修改、 删除、查询操作<br>
 * 创建者：江红  <br>
 * 创建日期： 2011-3-11<br>
 * 版本：V0.9 <br>
 * 修改者：        <br>
 * 修改日期：   <br>
 */
public class UserDao  extends DaoSupport{
	
	/**
	 * 用户登录
	 * @param username  用户名
	 * @param userpwd   用户密码
	 * @param ip        IP地址
	 * @param mac       Mac地址
	 * @return          返回用户信息
	 */
	@SuppressWarnings("all")
	public Map<String,Object> login(String username,String userpwd,String ip,String mac){
		Map<String,Object> data=null;
		Session session = super.getSession();
		try {
			StringBuffer sql=new StringBuffer();
			//验证用户是否登录成功
			sql.append("select new Map(a.REG_ID as USER_ID,a.REG_CNAME as USER_NAME,a.REG_USER as REG_USER,a.PASSWORD as PASSWORD,")
			   .append("a.BLONG_UNIT as UNIT_ID) ")
			   .append(" from PUB_REGUSER a  where a.REG_USER=? and a.PASSWORD=? "); 
			Query query = session.createQuery(sql.toString());
			query.setString(0, username);
			query.setString(1, userpwd);
			//获取用户信息
			List<Map<String,Object>> list = query.list();
			if(list!=null||list.size()>0){
				return list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return data;
	}
	
}
