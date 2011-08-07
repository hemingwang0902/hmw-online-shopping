package com.baizhi.score.service;

import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.score.dao.ScoreDao;
/**
 * 
 * 类名：ScoreService.java
 * 描述： 积分信息表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-08-07 18:51:46
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class ScoreService extends ServiceSupport{
	
	private static final long serialVersionUID = -6593652486168325871L;
	
	private ScoreDao scoreDao;
	
	public ScoreDao getScoreDao() {
		return scoreDao;
	}

	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}
	
	/**
	 * 新增或修改积分信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateScore(Element element) {
		return scoreDao.saveOrUpdateScore(element);
	}
	
	/**
	 *　禁用积分
	 * 
	 * @param SCORE_IDS  积分信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteScore(String SCORE_IDS,Integer IS_VALID) {
		return scoreDao.deleteScore(SCORE_IDS,IS_VALID);
	}
	
	/**
	 * 根据积分信息表ID获取积分信息表实体
	 * @param SCORE_ID 积分信息表ID
	 * @return 返回积分信息表实体,如果无查询记录则返回null
	 */
	public  Element getScoreEleById(String SCORE_ID){
		return scoreDao.getScoreEleById(SCORE_ID);
	}
	
	/**
	 *　获取积分信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getScoreCount(Map<String, Object> params) {
		return scoreDao.getScoreCount(params);
	}
	
	/**
	 * 根据积分信息表ID获取积分信息表信息
	 * @param SCORE_ID 积分信息表ID
	 * @return 返回积分信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getScoreMapById(String SCORE_ID){
		return scoreDao.getScoreMapById(SCORE_ID);
	}
	
	/**
	 * 获取积分信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回积分信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getScoreList(Map<String, Object> params,int nowPage,int onePageCount){
		return scoreDao.getScoreList(params, nowPage, onePageCount);
	}
	

}
