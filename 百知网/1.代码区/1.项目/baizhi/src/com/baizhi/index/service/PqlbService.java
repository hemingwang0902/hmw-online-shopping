package com.baizhi.index.service;

import java.util.Map;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.PqlbDao;
/**
 * 
 * 类名：PqlbService.java
 * 描述： 品牌列表服务类
 * 创建者：江红
 * 创建日期： 2011-06-23 22:03:15
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class PqlbService  extends ServiceSupport{
	
	private static final long serialVersionUID = -4352096706327491213L;
	
	private PqlbDao pqlbDao;
	
	public PqlbDao getPqlbDao() {
		return pqlbDao;
	}

	public void setPqlbDao(PqlbDao pqlbDao) {
		this.pqlbDao = pqlbDao;
	}
	
	/**
	 * 获取用户基本信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回用户基本信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getPqlbList(Map<String, Object> params,int nowPage,int onePageCount){
		return pqlbDao.getPqlbList(params, nowPage, onePageCount);
	}
	
}
