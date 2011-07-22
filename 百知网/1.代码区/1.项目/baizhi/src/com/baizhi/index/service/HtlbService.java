package com.baizhi.index.service;

import java.util.Map;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.HtlbDao;
import com.baizhi.index.dao.HyymDao;

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
	private HyymDao hyymDao;

	public void setHtlbDao(HtlbDao htlbDao) {
		this.htlbDao = htlbDao;
	}
	
	public void setHyymDao(HyymDao hyymDao) {
		this.hyymDao = hyymDao;
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
	
	/**
	 * 根据用户ID查询关注的话题列表
	 * @param userId 用户ID
	 * @param loginUserId 当前登录的用户ID
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return
	 * @author 何明旺
	 */
	public Map<String,Object> GetTalkListByUserId(int userId, int loginUserId, int nowPage, int onePageCount){
		return hyymDao.getAttentionTalkList(userId, loginUserId, nowPage, onePageCount);
	}
	
	/**
	 * 查询最新话题列表(按照 createTime 倒序排列)
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 * @author 何明旺
	 */
	public Map<String,Object> getLastestTalkList(int nowPage,int onePageCount){
		return htlbDao.getLastestTalkList(nowPage, onePageCount);
	}
	
	/**
	 * 查询最热话题列表(按照 attentionCount 倒序排列)
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 * @author 何明旺
	 */
	public Map<String,Object> getHottestTalkList(int nowPage,int onePageCount){
		return htlbDao.getHottestTalkList(nowPage, onePageCount);
	}
}
