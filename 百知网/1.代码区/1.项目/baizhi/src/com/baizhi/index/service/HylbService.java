package com.baizhi.index.service;

import java.util.Map;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.HylbDao;
/**
 * 
 * 类名：HylbService.java
 * 描述：会员列表页
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class HylbService extends ServiceSupport{
	
	private static final long serialVersionUID = 3062065776653310122L;
	
	private HylbDao hylbDao;
	
	public HylbDao getHylbDao() {
		return hylbDao;
	}

	public void setHylbDao(HylbDao hylbDao) {
		this.hylbDao = hylbDao;
	}
	
	/**
	 * 获取热点会员及最新会员
	 * @param USER_ID 用户ID
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户基本信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getUserList(Integer USER_ID,int nowPage,int onePageCount){
		return hylbDao.getUserList(USER_ID, nowPage, onePageCount);
	}
	
	/**
	 * 获取用户基本信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户基本信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getHylbList(Map<String, Object> params,int nowPage,int onePageCount){
		return hylbDao.getHylbList(params, nowPage, onePageCount);
	}
}
