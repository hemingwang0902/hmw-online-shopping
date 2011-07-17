package com.baizhi.index.service;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
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
	
	public Map<String,Object> getListByTitleWithFull(String title, int nowPage, int onePageCount){
		return homeDao.getListByTitleWithFull(title, nowPage, onePageCount);
	}
	
	public Map<String,Object> getLatestProblemList(int userId, int nowPage, int onePageCount){
		return homeDao.getLatestProblemList(userId, nowPage, onePageCount);
	}
	
	public Map<String,Object> getHottestProblemList(int userId, int nowPage, int onePageCount){
		return homeDao.getHottestProblemList(userId, nowPage, onePageCount);
	}
	
	public Map<String,Object> getMayInterestedUser(int userId, int nowPage, int onePageCount){
		return homeDao.getMayInterestedUser(userId, nowPage, onePageCount);
	}
	
	public Map<String,Object> getAttentionUser(int userId, int nowPage, int onePageCount){
		return homeDao.getAttentionUser(userId, nowPage, onePageCount);
	}
	
	public Map<String,Object> getWasAttentionUser(int userId, int nowPage, int onePageCount){
		return homeDao.getAttentionUser(userId, nowPage, onePageCount);
	}
	
	public Map<String,Object> getAttentionBrand(int userId, int loginUserId, int nowPage, int onePageCount){
		return homeDao.getAttentionBrand(userId, loginUserId, nowPage, onePageCount);
	}
	
	/**
	 * 收藏问题
	 * @param userId 用户ID
	 * @param problemId 问题ID
	 */
	public void collectionProblem(int userId, int problemId, boolean disCollection){
		Element problem = problemDao.getProblemEleById(""+problemId);
		if(problem == null) //问题不存在
			return;
		
		Element problemCollection = problemCollectionDao.getProblemCollectionEleById(problemId, userId);
		boolean b = false;
		if(disCollection){ //取消收藏
			if(problemCollection != null){
				b = problemCollectionDao.delete(problemCollection);
			}
		}else{ //添加收藏
			if(problemCollection == null){
				problemCollection = new DefaultElement("T_PROBLEM_COLLECTION");
				Elements.setElementValue(problemCollection, "PROBLEM_ID", problemId);// 问题ID
				Elements.setElementValue(problemCollection, "IS_COLLECTION", 1);// 是否收藏(0否、1是)
				Elements.setElementValue(problemCollection, "USER_ID", userId);// 用户ID
				Elements.setElementValue(problemCollection, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
				Elements.setElementValue(problemCollection, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
				//如果保存成功，返回主键
				String keyid = problemCollectionDao.saveOrUpdateProblemCollection(problemCollection);
				b = StringUtils.isNotEmpty(keyid);
			}
		}
		
		//判断主键是否为空，如果不为空，则保存成功
		if(b){
			int COLLECTION_COUNT = NumberUtils.toInt("COLLECTION_COUNT"); //收藏数量
			Elements.setElementValue(problem, "COLLECTION_COUNT", (disCollection ? COLLECTION_COUNT-1 : COLLECTION_COUNT+1));
			problemDao.saveOrUpdateProblem(problem);
		}
	}
	
	/**
	 * 关注/取消关注问题
	 * @param userId 用户ID
	 * @param problemId 问题ID
	 * @param isDisAttention 值为 true 表示 取消关注
	 */
	public void attentionProblem(int userId, int problemId, boolean isDisAttention){
		Element problem = problemDao.getProblemEleById(""+problemId);
		if(problem == null)
			return;
		
		Element problemAttention = problemAttentionDao.getProblemAttentionEleById(userId, problemId);
		boolean b = false;
		if(isDisAttention){ //取消关注
			if(problemAttention != null){
				b = problemAttentionDao.delete(problemAttention);
			}
		}else{ //添加关注
			if(problemAttention == null){
				problemAttention = new DefaultElement("T_PROBLEM_ATTENTION");
				Elements.setElementValue(problemAttention, "PROBLEM_ID", problemId);// 问题ID
				Elements.setElementValue(problemAttention, "IS_ATTENTION", 1);// 是否关注(0否、1是)
				Elements.setElementValue(problemAttention, "USER_ID", userId);// 用户ID
				Elements.setElementValue(problemAttention, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
				Elements.setElementValue(problemAttention, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
				//如果保存成功，返回主键
				String keyid = problemAttentionDao.saveOrUpdateProblemAttention(problemAttention);
				b = org.apache.commons.lang.StringUtils.isNotEmpty(keyid);
			}
		}
		
		//判断主键是否为空，如果不为空，则保存成功
		if(b){
			int ATTENTION_COUNT = NumberUtils.toInt("ATTENTION_COUNT"); //关注数量
			Elements.setElementValue(problem, "ATTENTION_COUNT", (isDisAttention ? ATTENTION_COUNT-1 : ATTENTION_COUNT+1));
			problemDao.saveOrUpdateProblem(problem);
		}
	}
}
