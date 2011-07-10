package com.baizhi.index.service;

import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.index.dao.HomeDao;
import com.baizhi.problem.dao.ProblemDao;
import com.baizhi.problemattention.dao.ProblemAttentionDao;
import com.baizhi.problemcollection.dao.ProblemCollectionDao;

public class HomeService  extends ServiceSupport{
	
	private static final long serialVersionUID = 7308230389953671913L;
	
	private HomeDao homeDao;
	private ProblemDao problemDao;
	private ProblemAttentionDao problemAttentionDao;
	private ProblemCollectionDao problemCollectionDao;

	public void setHomeDao(HomeDao homeDao) {
		this.homeDao = homeDao;
	}
	
	public void setProblemDao(ProblemDao problemDao) {
		this.problemDao = problemDao;
	}

	public void setProblemAttentionDao(ProblemAttentionDao problemAttentionDao) {
		this.problemAttentionDao = problemAttentionDao;
	}

	public void setProblemCollectionDao(ProblemCollectionDao problemCollectionDao) {
		this.problemCollectionDao = problemCollectionDao;
	}

	public Map<String,Object> getUserOrProblemByTitleList(String title, int nowPage, int onePageCount){
		return homeDao.getUserOrProblemByTitleList(title, nowPage, onePageCount);
	}
	
	public Map<String,Object> getLatestProblemList(int userId, int nowPage, int onePageCount){
		return homeDao.getLatestProblemList(userId, nowPage, onePageCount);
	}
	
	public Map<String,Object> getHottestProblemList(int nowPage, int onePageCount){
		return homeDao.getHottestProblemList(nowPage, onePageCount);
	}
	
	public Map<String,Object> getMayInterestedUser(int userId, int nowPage, int onePageCount){
		return homeDao.getMayInterestedUser(userId, nowPage, onePageCount);
	}
	
	public Map<String,Object> getAttentionUser(int userId, int nowPage, int onePageCount){
		return homeDao.getAttentionUser(userId, nowPage, onePageCount);
	}
	
	public Map<String,Object> getAttentionBrand(int userId, int nowPage, int onePageCount){
		return homeDao.getAttentionBrand(userId, nowPage, onePageCount);
	}
	
	/**
	 * 收藏问题
	 * @param userId 用户ID
	 * @param problemId 问题ID
	 */
	public void collectionProblem(int userId, int problemId){
		Element problem = problemDao.getProblemEleById(""+problemId);
		if(problem == null)
			return;
		
		Element problemCollection = new DefaultElement("T_PROBLEM_COLLECTION");
		Elements.setElementValue(problemCollection, "PROBLEM_ID", problemId);// 问题ID
		Elements.setElementValue(problemCollection, "IS_COLLECTION", 1);// 是否收藏(0否、1是)
		Elements.setElementValue(problemCollection, "USER_ID", userId);// 用户ID
		Elements.setElementValue(problemCollection, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		Elements.setElementValue(problemCollection, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
		//如果保存成功，返回主键
		String keyid = problemCollectionDao.saveOrUpdateProblemCollection(problemCollection);
		//判断主键是否为空，如果不为空，则保存成功
		if(StringUtils.isNotEmpty(keyid)){
			int COLLECTION_COUNT = NumberUtils.toInt("COLLECTION_COUNT"); //收藏数量
			Elements.setElementValue(problem, "COLLECTION_COUNT", COLLECTION_COUNT + 1);
			problemDao.saveOrUpdateProblem(problem);
		}
	}
	
	/**
	 * 关注问题
	 * @param userId 用户ID
	 * @param problemId 问题ID
	 */
	public void attentionProblem(int userId, int problemId){
		Element problem = problemDao.getProblemEleById(""+problemId);
		if(problem == null)
			return;
		
		Element problemAttention = new DefaultElement("T_PROBLEM_ATTENTION");
		Elements.setElementValue(problemAttention, "PROBLEM_ID", problemId);// 问题ID
		Elements.setElementValue(problemAttention, "IS_ATTENTION", 1);// 是否关注(0否、1是)
		Elements.setElementValue(problemAttention, "USER_ID", userId);// 用户ID
		Elements.setElementValue(problemAttention, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		Elements.setElementValue(problemAttention, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
		//如果保存成功，返回主键
		String keyid = problemAttentionDao.saveOrUpdateProblemAttention(problemAttention);
		
		//判断主键是否为空，如果不为空，则保存成功
		if(StringUtils.isNotEmpty(keyid)){
			int ATTENTION_COUNT = NumberUtils.toInt("ATTENTION_COUNT"); //关注数量
			Elements.setElementValue(problem, "ATTENTION_COUNT", ATTENTION_COUNT + 1);
			problemDao.saveOrUpdateProblem(problem);
		}
	}
}
