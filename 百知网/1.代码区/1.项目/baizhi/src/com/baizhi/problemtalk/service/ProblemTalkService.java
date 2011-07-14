package com.baizhi.problemtalk.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.problemtalk.dao.ProblemTalkDao;

/**
 * 类名：ProblemTalkService.java<br>
 * 描述： 问题话题信息表服务类，负责增删改查<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 10:39:35<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class ProblemTalkService extends ServiceSupport{
	private static final long serialVersionUID = -558290784737683188L;
	private ProblemTalkDao problemTalkDao;
	
	public ProblemTalkDao getProblemTalkDao() {
		return problemTalkDao;
	}

	public void setProblemTalkDao(ProblemTalkDao problemTalkDao) {
		this.problemTalkDao = problemTalkDao;
	}
	
	/**
	 * 新增或修改问题话题信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateProblemTalk(Element element) {
		return problemTalkDao.saveOrUpdateProblemTalk(element);
	}
	
	/**
	 *　删除问题话题信息表信息
	 * 
	 * @param PROBLEMTALK_IDS  问题话题信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteProblemTalk(String PROBLEMTALK_IDS) {
		return problemTalkDao.deleteProblemTalk(PROBLEMTALK_IDS);
	}
	
	/**
	 * 根据问题话题信息表ID获取问题话题信息表实体
	 * @param PROBLEMTALK_ID 问题话题信息表ID
	 * @return 返回问题话题信息表实体,如果无查询记录则返回null
	 */
	public  Element getProblemTalkEleById(String PROBLEMTALK_ID){
		return problemTalkDao.getProblemTalkEleById(PROBLEMTALK_ID);
	}
	
	/**
	 *　获取问题话题信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getProblemTalkCount(Map<String, Object> params) {
		return problemTalkDao.getProblemTalkCount(params);
	}
	
	/**
	 * 根据问题话题信息表ID获取问题话题信息表信息
	 * @param PROBLEMTALK_ID 问题话题信息表ID
	 * @return 返回问题话题信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getProblemTalkMapById(String PROBLEMTALK_ID){
		return problemTalkDao.getProblemTalkMapById(PROBLEMTALK_ID);
	}
	
	/**
	 * 获取问题话题信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题话题信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getProblemTalkList(Map<String, Object> params,int nowPage,int onePageCount){
		return problemTalkDao.getProblemTalkList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取问题话题信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题话题信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getProblemTalkList(Map<String, Object> params){
		return problemTalkDao.getProblemTalkList(params);
	}

}
