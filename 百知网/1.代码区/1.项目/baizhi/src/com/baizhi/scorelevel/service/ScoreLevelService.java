package com.baizhi.scorelevel.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.scorelevel.dao.ScoreLevelDao;
/**
 * 
 * 类名：ScoreLevelService.java
 * 描述： 积分级别信息表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-06-21 00:43:41
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class ScoreLevelService extends ServiceSupport{
	
	private ScoreLevelDao scoreLevelDao;
	
	public ScoreLevelDao getScoreLevelDao() {
		return scoreLevelDao;
	}

	public void setScoreLevelDao(ScoreLevelDao scoreLevelDao) {
		this.scoreLevelDao = scoreLevelDao;
	}
	
	/**
	 * 新增或修改积分级别信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateScoreLevel(Element element) {
		return scoreLevelDao.saveOrUpdateScoreLevel(element);
	}
	
	/**
	 *　删除积分级别信息表信息
	 * 
	 * @param SCORELEVEL_IDS  积分级别信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteScoreLevel(String SCORELEVEL_IDS) {
		return scoreLevelDao.deleteScoreLevel(SCORELEVEL_IDS);
	}
	
	/**
	 * 根据积分级别信息表ID获取积分级别信息表实体
	 * @param SCORELEVEL_ID 积分级别信息表ID
	 * @return 返回积分级别信息表实体,如果无查询记录则返回null
	 */
	public  Element getScoreLevelEleById(String SCORELEVEL_ID){
		return scoreLevelDao.getScoreLevelEleById(SCORELEVEL_ID);
	}
	
	/**
	 *　获取积分级别信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getScoreLevelCount(Map<String, Object> params) {
		return scoreLevelDao.getScoreLevelCount(params);
	}
	
	/**
	 * 根据积分级别信息表ID获取积分级别信息表信息
	 * @param SCORELEVEL_ID 积分级别信息表ID
	 * @return 返回积分级别信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getScoreLevelMapById(String SCORELEVEL_ID){
		return scoreLevelDao.getScoreLevelMapById(SCORELEVEL_ID);
	}
	
	/**
	 * 获取积分级别信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回积分级别信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getScoreLevelList(Map<String, Object> params,int nowPage,int onePageCount){
		return scoreLevelDao.getScoreLevelList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取积分级别信息表信息
     * 
     * @param  params 参数
     * @return 成功返回积分级别信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getScoreLevelList(Map<String, Object> params){
		return scoreLevelDao.getScoreLevelList(params);
	}

}
