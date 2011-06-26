package com.baizhi.problem.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.problem.dao.ProblemDao;
/**
 * 
 * 类名：ProblemService.java
 * 描述： 问题信息表服务类，负责增删改查
 * 创建者：江红
 * 创建日期： 2011-06-21 00:45:57
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class ProblemService extends ServiceSupport{
	
	private static final long serialVersionUID = -3984123263916268303L;
	
	private ProblemDao problemDao;
	
	public ProblemDao getProblemDao() {
		return problemDao;
	}

	public void setProblemDao(ProblemDao problemDao) {
		this.problemDao = problemDao;
	}
	
	/**
	 * 新增或修改问题信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateProblem(Element element) {
		return problemDao.saveOrUpdateProblem(element);
	}
	
	/**
	 *　删除问题信息表信息
	 * 
	 * @param PROBLEM_IDS  问题信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblem(String PROBLEM_IDS) {
		return problemDao.deleteProblem(PROBLEM_IDS);
	}
	
	/**
	 * 根据问题信息表ID获取问题信息表实体
	 * @param PROBLEM_ID 问题信息表ID
	 * @return 返回问题信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemEleById(String PROBLEM_ID){
		return problemDao.getProblemEleById(PROBLEM_ID);
	}
	
	/**
	 *　获取问题信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemCount(Map<String, Object> params) {
		return problemDao.getProblemCount(params);
	}
	
	/**
	 * 根据问题信息表ID获取问题信息表信息
	 * @param PROBLEM_ID 问题信息表ID
	 * @return 返回问题信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemMapById(String PROBLEM_ID){
		return problemDao.getProblemMapById(PROBLEM_ID);
	}
	
	/**
	 * 获取问题信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemList(Map<String, Object> params,int nowPage,int onePageCount){
		return problemDao.getProblemList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取问题信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemList(Map<String, Object> params){
		return problemDao.getProblemList(params);
	}

}
