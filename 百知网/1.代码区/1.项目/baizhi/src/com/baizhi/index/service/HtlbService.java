package com.baizhi.index.service;

import java.util.Map;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.HtlbDao;

/**
 * 类名： HtService.java<br>
 * 描述：话题页面<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午07:00:56<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class HtlbService extends ServiceSupport{
	
	private static final long serialVersionUID = -4263447600519828874L;
	
	private HtlbDao htlbDao;

	public HtlbDao getHtlbDao() {
		return htlbDao;
	}

	public void setHtlbDao(HtlbDao htlbDao) {
		this.htlbDao = htlbDao;
	}
	
	/**
	 * 获取热点话题及最新话题
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回话题基本信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getTalkList(int nowPage,int onePageCount){
		return htlbDao.getTalkList(nowPage, onePageCount);
	}
	
	/**
	 * 获取话题信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return
	 */
	public Map<String,Object> getHtlbList(Map<String, Object> params,int nowPage,int onePageCount){
		return htlbDao.getHtlbList(params, nowPage, onePageCount);
	}
}
