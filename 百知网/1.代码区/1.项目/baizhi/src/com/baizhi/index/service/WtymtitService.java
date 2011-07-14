package com.baizhi.index.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.index.dao.WtymtitDao;
import com.baizhi.problem.dao.ProblemDao;
import com.baizhi.problemanswer.dao.ProblemAnswerDao;
import com.baizhi.probleminvite.dao.ProblemInviteDao;
import com.baizhi.problemtalk.dao.ProblemTalkDao;
import com.baizhi.talk.dao.TalkDao;

public class WtymtitService  extends ServiceSupport{
	
	private static final long serialVersionUID = 6665001478560038725L;
	
	private WtymtitDao wtymtitDao;
	private ProblemDao problemDao;
	private TalkDao talkDao;
	private ProblemTalkDao problemTalkDao;
	private ProblemInviteDao problemInviteDao;
	private ProblemAnswerDao problemAnswerDao;

	public void setWtymtitDao(WtymtitDao wtymtitDao) {
		this.wtymtitDao = wtymtitDao;
	}
	
	public void setProblemDao(ProblemDao problemDao) {
		this.problemDao = problemDao;
	}

	/**
	 * 更新问题的浏览数（浏览一次，将值加1）
	 * @param PROBLEM_ID 问题ID
	 * @return 更新后的浏览次数
	 */
	public int updateBrowseCount(int PROBLEM_ID){
		Element problem = problemDao.getProblemEleById(""+PROBLEM_ID);
		if(problem == null)
			return 0;
		
		int BROWSE_COUNT = NumberUtils.toInt(problem.elementTextTrim("BROWSE_COUNT"))+1;
		Elements.setElementValue(problem, "BROWSE_COUNT", BROWSE_COUNT);
		problemDao.saveOrUpdateProblem(problem);
		return BROWSE_COUNT;
	}

	public List<Map<String, Object>> getTalkList(int ProblemId){
		return wtymtitDao.getTalkList(ProblemId);
	}
	
	public List<Map<String, Object>> getTalkUserList(int ProblemId){
		return wtymtitDao.getTalkUserList(ProblemId);
	}
	
	public Map<String, Object> getNearProblemList(int problemId, int nowPage, int onePageCount) {
		return wtymtitDao.getNearProblemList(problemId, nowPage, onePageCount);
	}

	/**
	 * 根据话题内容模糊查询话题列表
	 * @param CONTENT
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String,Object> getTalkListByContent(String CONTENT,int nowPage,int onePageCount){
		return wtymtitDao.getTalkListByContent(CONTENT, nowPage, onePageCount);
	}
	
	/**
	 * 添加话题
	 * @param CONTENT
	 * @param userId
	 * @return 保存成功后的话题ID
	 */
	public String addTalk(String CONTENT, int userId){
		Element element = new DefaultElement("T_TALK");
		Elements.setElementValue(element, "CONTENT", CONTENT);// 内容
		Elements.setElementValue(element, "USER_ID", userId);// 用户ID
		Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
		//如果保存成功，返回主键
		return talkDao.saveOrUpdateTalk(element);
	}
	
	/**
	 * 给问题添加话题
	 */
	public String addTalkForProblem(int problemId, int talkId){
		Element element = new DefaultElement("T_PROBLEM_TALK");
		Elements.setElementValue(element, "TALK_ID", talkId);// 话题ID
		Elements.setElementValue(element, "PROBLEM_ID", problemId);// 问题ID
		Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
		//如果保存成功，返回主键
		return problemTalkDao.saveOrUpdateProblemTalk(element);
	}
	
	/**
	 * 获取问题的回复列表
	 * @param problemId
	 * @param nowPage
	 * @param onePageCount
	 * @return
	 */
	public Map<String, Object> getAnswerList(int problemId, int nowPage, int onePageCount) {
		return null;
	}
	
	/**
	 * 添加回复
	 * @param CONTENT
	 * @param userId
	 * @return
	 */
	public String addAnswer(String CONTENT, int problemId, int userId){
		Element element = new DefaultElement("T_PROBLEM_ANSWER");
		Elements.setElementValue(element, "PROBLEM_ID", problemId);// 问题ID
		Elements.setElementValue(element, "CONTENT", CONTENT);// 内容
		Elements.setElementValue(element, "USER_ID", userId);// 用户ID
		Elements.setElementValue(element, "AGREE_COUNT", 0);// 赞成数量
		Elements.setElementValue(element, "DISAGREE_COUNT", 0);// 反对数量
		Elements.setElementValue(element, "THANK_COUNT", 0);// 感觉作者数量
		Elements.setElementValue(element, "DISTHANK_COUNT", 0);// 没有帮助数量
		Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
		//如果保存成功，返回主键
		return problemAnswerDao.saveOrUpdateProblemAnswer(element);
	}
	
	/**
	 * 邀请他人回答
	 * @param problemId
	 * @param userId
	 * @param wasUserId
	 * @return
	 */
	public String addProblemInvite(int problemId, int userId, int wasUserId){
		Element element = new DefaultElement("T_PROBLEM_INVITE");
		Elements.setElementValue(element, "PROBLEM_ID", problemId);// 问题ID
		Elements.setElementValue(element, "IS_ATTENTION", 0);// 是否回答(0否、1是)
		Elements.setElementValue(element, "USER_ID", userId);// 用户ID
		Elements.setElementValue(element, "WAS_USER_ID", wasUserId);// 被邀请的用户ID
		Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
		//如果保存成功，返回主键
		return problemInviteDao.saveOrUpdateProblemInvite(element);
	}
}
