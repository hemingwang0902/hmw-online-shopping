package com.baizhi.answervote.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.answervote.dao.AnswerVoteDao;

/**
 * 类名：AnswerVoteService.java<br>
 * 描述： 问题答案投票信息表服务类，负责增删改查<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 16:22:26<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class AnswerVoteService extends ServiceSupport{
	private static final long serialVersionUID = -6556082783932596764L;
	private AnswerVoteDao answerVoteDao;
	
	public AnswerVoteDao getAnswerVoteDao() {
		return answerVoteDao;
	}

	public void setAnswerVoteDao(AnswerVoteDao answerVoteDao) {
		this.answerVoteDao = answerVoteDao;
	}
	
	/**
	 * 新增或修改问题答案投票信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateAnswerVote(Element element) {
		return answerVoteDao.saveOrUpdateAnswerVote(element);
	}
	
	/**
	 *　删除问题答案投票信息表信息
	 * 
	 * @param VOTE_IDS  问题答案投票信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteAnswerVote(String VOTE_IDS) {
		return answerVoteDao.deleteAnswerVote(VOTE_IDS);
	}
	
	/**
	 * 根据问题答案投票信息表ID获取问题答案投票信息表实体
	 * @param VOTE_ID 问题答案投票信息表ID
	 * @return 返回问题答案投票信息表实体,如果无查询记录则返回null
	 */
	public  Element getAnswerVoteEleById(String VOTE_ID){
		return answerVoteDao.getAnswerVoteEleById(VOTE_ID);
	}
	
	/**
	 *　获取问题答案投票信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getAnswerVoteCount(Map<String, Object> params) {
		return answerVoteDao.getAnswerVoteCount(params);
	}
	
	/**
	 * 根据问题答案投票信息表ID获取问题答案投票信息表信息
	 * @param VOTE_ID 问题答案投票信息表ID
	 * @return 返回问题答案投票信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getAnswerVoteMapById(String VOTE_ID){
		return answerVoteDao.getAnswerVoteMapById(VOTE_ID);
	}
	
	/**
	 * 获取问题答案投票信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题答案投票信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getAnswerVoteList(Map<String, Object> params,int nowPage,int onePageCount){
		return answerVoteDao.getAnswerVoteList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取问题答案投票信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题答案投票信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getAnswerVoteList(Map<String, Object> params){
		return answerVoteDao.getAnswerVoteList(params);
	}

}
