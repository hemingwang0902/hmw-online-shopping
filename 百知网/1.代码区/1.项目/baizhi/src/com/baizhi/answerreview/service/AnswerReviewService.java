package com.baizhi.answerreview.service;

import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.answerreview.dao.AnswerReviewDao;

/**
 * 类名：AnswerReviewService.java<br>
 * 描述： 问题答案评论信息表服务类，负责增删改查<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 16:22:27<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class AnswerReviewService extends ServiceSupport{
	private static final long serialVersionUID = 3235592243843509032L;
	private AnswerReviewDao answerReviewDao;
	
	public AnswerReviewDao getAnswerReviewDao() {
		return answerReviewDao;
	}

	public void setAnswerReviewDao(AnswerReviewDao answerReviewDao) {
		this.answerReviewDao = answerReviewDao;
	}
	
	/**
	 * 新增或修改问题答案评论信息表信息
	 * 
	 * @param element  实体对象
	 * @return 返回主键ID,失败返回""
	 */
	public String saveOrUpdateAnswerReview(Element element) {
		return answerReviewDao.saveOrUpdateAnswerReview(element);
	}
	
	/**
	 *　删除问题答案评论信息表信息
	 * 
	 * @param REVIEW_IDS  问题答案评论信息表ID值集合以","分隔
	 * @return 返回boolean值,成功返回true,失败返回false
	 */
	public boolean deleteAnswerReview(String REVIEW_IDS) {
		return answerReviewDao.deleteAnswerReview(REVIEW_IDS);
	}
	
	/**
	 * 根据问题答案评论信息表ID获取问题答案评论信息表实体
	 * @param REVIEW_ID 问题答案评论信息表ID
	 * @return 返回问题答案评论信息表实体,如果无查询记录则返回null
	 */
	public  Element getAnswerReviewEleById(String REVIEW_ID){
		return answerReviewDao.getAnswerReviewEleById(REVIEW_ID);
	}
	
	/**
	 *　获取问题答案评论信息表数量
	 * 
	 * @param params  参数
	 * @return 返回查询记录数量,失败返回-1
	 */
	public int getAnswerReviewCount(Map<String, Object> params) {
		return answerReviewDao.getAnswerReviewCount(params);
	}
	
	/**
	 * 根据问题答案评论信息表ID获取问题答案评论信息表信息
	 * @param REVIEW_ID 问题答案评论信息表ID
	 * @return 返回问题答案评论信息表信息,如果无查询记录则返回null
	 */
	public Map<String, Object> getAnswerReviewMapById(String REVIEW_ID){
		return answerReviewDao.getAnswerReviewMapById(REVIEW_ID);
	}
	
	/**
	 * 获取问题答案评论信息表列表信息
	 * @param params 参数
	 * @param nowPage 当前页
	 * @param onePageCount 每页显示多少条
	 * @return 返回问题答案评论信息表列表信息,如果无查询记录则返回null
	 */
	public Map<String,Object> getAnswerReviewList(Map<String, Object> params,int nowPage,int onePageCount){
		return answerReviewDao.getAnswerReviewList(params, nowPage, onePageCount);
	}
	
	/**
     * 获取问题答案评论信息表信息
     * 
     * @param  params 参数
     * @return 成功返回问题答案评论信息表信息,如果无查询记录则返回null
     */
	public List<Map<String,Object>> getAnswerReviewList(Map<String, Object> params){
		return answerReviewDao.getAnswerReviewList(params);
	}

}
