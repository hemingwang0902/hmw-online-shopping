package com.baizhi.problemcollection.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.problemcollection.dao.ProblemCollectionDao;

/**
 * 类名：ProblemCollectionService.java<br>
 * 描述： 问题收藏信息表服务类，负责增删改查<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:13<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class ProblemCollectionService extends ServiceSupport{

	private static final long serialVersionUID = 5801547676690688390L;
	private ProblemCollectionDao problemCollectionDao;
	
	public ProblemCollectionDao getProblemCollectionDao() {
		return problemCollectionDao;
	}

	public void setProblemCollectionDao(ProblemCollectionDao problemCollectionDao) {
		this.problemCollectionDao = problemCollectionDao;
	}
	
	/**
	 * 新增或修改问题收藏信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateProblemCollection(Element element) {
		return problemCollectionDao.saveOrUpdateProblemCollection(element);
	}
	
	/**
	 *　删除问题收藏信息表信息
	 * 
	 * @param COLLECTION_IDS  问题收藏信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblemCollection(String COLLECTION_IDS) {
		return problemCollectionDao.deleteProblemCollection(COLLECTION_IDS);
	}
	
	/**
	 * 根据问题收藏信息表ID获取问题收藏信息表实体
	 * @param COLLECTION_ID 问题收藏信息表ID
	 * @return 返回问题收藏信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemCollectionEleById(String COLLECTION_ID){
		return problemCollectionDao.getProblemCollectionEleById(COLLECTION_ID);
	}
	
	/**
	 *　获取问题收藏信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemCollectionCount(Map<String, Object> params) {
		return problemCollectionDao.getProblemCollectionCount(params);
	}
	
	/**
	 * 根据问题收藏信息表ID获取问题收藏信息表信息
	 * @param COLLECTION_ID 问题收藏信息表ID
	 * @return 返回问题收藏信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemCollectionMapById(String COLLECTION_ID){
		return problemCollectionDao.getProblemCollectionMapById(COLLECTION_ID);
	}
	
	/**
	 * 获取问题收藏信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题收藏信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemCollectionList(Map<String, Object> params,int nowPage,int onePageCount){
		return problemCollectionDao.getProblemCollectionList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取问题收藏信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题收藏信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemCollectionList(Map<String, Object> params){
		return problemCollectionDao.getProblemCollectionList(params);
	}

}
