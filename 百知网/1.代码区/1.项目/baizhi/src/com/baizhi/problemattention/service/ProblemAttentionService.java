package com.baizhi.problemattention.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.problemattention.dao.ProblemAttentionDao;

/**
 * 类名：ProblemAttentionService.java<br>
 * 描述： 问题关注信息表服务类，负责增删改查<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:14<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class ProblemAttentionService extends ServiceSupport{
	private static final long serialVersionUID = -6221467687433247363L;
	private ProblemAttentionDao problemAttentionDao;
	
	public ProblemAttentionDao getProblemAttentionDao() {
		return problemAttentionDao;
	}

	public void setProblemAttentionDao(ProblemAttentionDao problemAttentionDao) {
		this.problemAttentionDao = problemAttentionDao;
	}
	
	/**
	 * 新增或修改问题关注信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateProblemAttention(Element element) {
		return problemAttentionDao.saveOrUpdateProblemAttention(element);
	}
	
	/**
	 *　删除问题关注信息表信息
	 * 
	 * @param ATTENTION_IDS  问题关注信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblemAttention(String ATTENTION_IDS) {
		return problemAttentionDao.deleteProblemAttention(ATTENTION_IDS);
	}
	
	/**
	 * 根据问题关注信息表ID获取问题关注信息表实体
	 * @param ATTENTION_ID 问题关注信息表ID
	 * @return 返回问题关注信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemAttentionEleById(String ATTENTION_ID){
		return problemAttentionDao.getProblemAttentionEleById(ATTENTION_ID);
	}
	
	/**
	 *　获取问题关注信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemAttentionCount(Map<String, Object> params) {
		return problemAttentionDao.getProblemAttentionCount(params);
	}
	
	/**
	 * 根据问题关注信息表ID获取问题关注信息表信息
	 * @param ATTENTION_ID 问题关注信息表ID
	 * @return 返回问题关注信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemAttentionMapById(String ATTENTION_ID){
		return problemAttentionDao.getProblemAttentionMapById(ATTENTION_ID);
	}
	
	/**
	 * 获取问题关注信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题关注信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemAttentionList(Map<String, Object> params,int nowPage,int onePageCount){
		return problemAttentionDao.getProblemAttentionList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取问题关注信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题关注信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemAttentionList(Map<String, Object> params){
		return problemAttentionDao.getProblemAttentionList(params);
	}

}
