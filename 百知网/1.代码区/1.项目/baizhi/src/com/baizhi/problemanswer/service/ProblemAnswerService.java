package com.baizhi.problemanswer.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.problemanswer.dao.ProblemAnswerDao;

/**
 * 类名：ProblemAnswerService.java<br>
 * 描述： 问题答案信息表服务类，负责增删改查<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 10:39:37<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class ProblemAnswerService extends ServiceSupport{
	
	private ProblemAnswerDao problemAnswerDao;
	
	public ProblemAnswerDao getProblemAnswerDao() {
		return problemAnswerDao;
	}

	public void setProblemAnswerDao(ProblemAnswerDao problemAnswerDao) {
		this.problemAnswerDao = problemAnswerDao;
	}
	
	/**
	 * 新增或修改问题答案信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateProblemAnswer(Element element) {
		return problemAnswerDao.saveOrUpdateProblemAnswer(element);
	}
	
	/**
	 *　删除问题答案信息表信息
	 * 
	 * @param ANSWER_IDS  问题答案信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblemAnswer(String ANSWER_IDS) {
		return problemAnswerDao.deleteProblemAnswer(ANSWER_IDS);
	}
	
	/**
	 * 根据问题答案信息表ID获取问题答案信息表实体
	 * @param ANSWER_ID 问题答案信息表ID
	 * @return 返回问题答案信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemAnswerEleById(String ANSWER_ID){
		return problemAnswerDao.getProblemAnswerEleById(ANSWER_ID);
	}
	
	/**
	 *　获取问题答案信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemAnswerCount(Map<String, Object> params) {
		return problemAnswerDao.getProblemAnswerCount(params);
	}
	
	/**
	 * 根据问题答案信息表ID获取问题答案信息表信息
	 * @param ANSWER_ID 问题答案信息表ID
	 * @return 返回问题答案信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemAnswerMapById(String ANSWER_ID){
		return problemAnswerDao.getProblemAnswerMapById(ANSWER_ID);
	}
	
	/**
	 * 获取问题答案信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题答案信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemAnswerList(Map<String, Object> params,int nowPage,int onePageCount){
		return problemAnswerDao.getProblemAnswerList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取问题答案信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题答案信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemAnswerList(Map<String, Object> params){
		return problemAnswerDao.getProblemAnswerList(params);
	}

}
