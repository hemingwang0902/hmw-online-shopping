package com.baizhi.index.service;

import java.util.Map;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.SzDao;
/**
 * 类名： SzService.java<br>
 * 描述：设置<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-9 上午11:17:12<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class SzService extends ServiceSupport{
	
	private static final long serialVersionUID = 7959852606160119493L;
	
	private SzDao szDao;

	public SzDao getSzDao() {
		return szDao;
	}

	public void setSzDao(SzDao szDao) {
		this.szDao = szDao;
	}
	/**
	 * 根据用户基本信息表ID获取用户基本信息表信息
	 * @param BASIC_ID 用户基本信息表ID
	 * @return 返回用户基本信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getUserBasicMapById(int USER_ID){
		return szDao.getUserBasicMapById(USER_ID);
	}
	
	/**
	 * 修改用户基本信息表信息
	 * 
	 * @param element  实体对象
	 * @return 成功返回执行记录数,失败返回-1
	 */
	public int updateUserBasic(Map<String, Object> params,int USER_ID) {
		return szDao.updateUserBasic(params, USER_ID);
	}
}
