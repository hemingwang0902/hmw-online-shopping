package com.baizhi.index.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.IConstants;
import com.baizhi.answerreview.dao.AnswerReviewDao;
import com.baizhi.answervote.dao.AnswerVoteDao;
import com.baizhi.commons.ServiceSupport;
import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.exception.BaizhiException;
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
	private AnswerVoteDao answerVoteDao;
	private AnswerReviewDao answerReviewDao;

	public void setWtymtitDao(WtymtitDao wtymtitDao) {
		this.wtymtitDao = wtymtitDao;
	}

	public void setProblemDao(ProblemDao problemDao) {
		this.problemDao = problemDao;
	}

	public void setTalkDao(TalkDao talkDao) {
		this.talkDao = talkDao;
	}

	public void setProblemTalkDao(ProblemTalkDao problemTalkDao) {
		this.problemTalkDao = problemTalkDao;
	}

	public void setProblemInviteDao(ProblemInviteDao problemInviteDao) {
		this.problemInviteDao = problemInviteDao;
	}

	public void setProblemAnswerDao(ProblemAnswerDao problemAnswerDao) {
		this.problemAnswerDao = problemAnswerDao;
	}

	public void setAnswerVoteDao(AnswerVoteDao answerVoteDao) {
		this.answerVoteDao = answerVoteDao;
	}

	public void setAnswerReviewDao(AnswerReviewDao answerReviewDao) {
		this.answerReviewDao = answerReviewDao;
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
	
	public Map<String, Object> getNearProblemList(int problemId, int loginUserId, int nowPage, int onePageCount) {
		return wtymtitDao.getNearProblemList(problemId, loginUserId, nowPage, onePageCount);
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
	
	public String addTalkForProblem(int problemId, String talkContent, int userId){
		Map<String, Object> talk = wtymtitDao.getTalkByContent(talkContent);
		String talkId = null;
		if(talk == null){ //如果该话题不存在，则新增
			talkId = addTalk(talkContent, userId);
		}else {
			talkId = talk.get("TALK_ID").toString();
		}
		return addTalkForProblem(problemId, NumberUtils.toInt(talkId));
	}
	
	/**
	 * 给问题添加话题
	 */
	public String addTalkForProblem(int problemId, int talkId){
		Element element = problemTalkDao.getProblemTalkEleById(problemId, talkId);
		if(element != null)
			return element.elementTextTrim("PROBLEMTALK_ID");
			
		element = new DefaultElement("T_PROBLEM_TALK");
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
	public Map<String, Object> getAnswerList(int problemId, int loginUserId, int nowPage, int onePageCount) {
		return 	wtymtitDao.getProblemAnswerListByProblemId(problemId, loginUserId, nowPage, onePageCount);
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
		Element element = problemInviteDao.getProblemInviteEleById(problemId, userId, wasUserId);
		if(element != null) //已经存在，则直接返回
			return element.elementTextTrim("INVITE_ID");
			
		element = new DefaultElement("T_PROBLEM_INVITE");
		Elements.setElementValue(element, "PROBLEM_ID", problemId);// 问题ID
		Elements.setElementValue(element, "IS_ATTENTION", 0);// 是否回答(0否、1是)
		Elements.setElementValue(element, "USER_ID", userId);// 用户ID
		Elements.setElementValue(element, "WAS_USER_ID", wasUserId);// 被邀请的用户ID
		Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
		//如果保存成功，返回主键
		return problemInviteDao.saveOrUpdateProblemInvite(element);
	}
	
	/**
	 * 对回复进行操作：赞同、反对、感谢作者、对我没帮助
	 * @param ANSWER_ID
	 * @param USER_ID
	 * @param voteField
	 */
	public void answerVote(int ANSWER_ID, int USER_ID, String voteField){
		String VOTE_TYPE = "-1";
		int IS_AGREE = -1;
		
		if(IConstants.ANSWER_VOTE_AGREE.equalsIgnoreCase(voteField)){//赞同
			VOTE_TYPE = "1";
			IS_AGREE = 1;
		}else if(IConstants.ANSWER_VOTE_DISAGREE.equalsIgnoreCase(voteField)){ //反对
			VOTE_TYPE = "1";
			IS_AGREE = 0;
		}else if(IConstants.ANSWER_VOTE_THANK.equalsIgnoreCase(voteField)){ //感谢作者
			VOTE_TYPE = "2";
			IS_AGREE = 1;
		}else if(IConstants.ANSWER_VOTE_DISTHANK.equalsIgnoreCase(voteField)){ //没有帮助
			VOTE_TYPE = "2";
			IS_AGREE = 0;
		}else{
			throw new BaizhiException("不支持的投票类型。");
		}
		
		Element answer = problemAnswerDao.getProblemAnswerEleById(""+ANSWER_ID);
		if(answer == null) //问题回复不存在，则直接返回
			return;
		
		
		Element vote = answerVoteDao.getAnswerVoteEleById(ANSWER_ID, USER_ID, VOTE_TYPE, IS_AGREE);
		if(vote != null) //如果记录已经存在，则直接返回
			return;
		
		vote = new DefaultElement("T_ANSWER_VOTE");
		Elements.setElementValue(vote, "ANSWER_ID", ANSWER_ID);// 问题答案ID
		Elements.setElementValue(vote, "PROBLEM_ID", answer.elementTextTrim("PROBLEM_ID"));// 问题ID(冗余字段)
		Elements.setElementValue(vote, "VOTE_TYPE", VOTE_TYPE);// 投票类型(字典：1赞成Or拒绝、2感谢作者Or没有帮助)
		Elements.setElementValue(vote, "IS_AGREE", IS_AGREE);// 是否赞成、感谢(0否、1是)
		Elements.setElementValue(vote, "USER_ID", USER_ID);// 用户ID
		Elements.setElementValue(vote, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		Elements.setElementValue(vote, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
		//如果保存成功，返回主键
		String keyid = answerVoteDao.saveOrUpdateAnswerVote(vote);
		if(StringUtils.isNotEmpty(keyid)){
			String fieldName = voteField.toUpperCase() + "_COUNT";
			int COUNT = NumberUtils.toInt(answer.elementTextTrim(fieldName))+1;
			Elements.setElementValue(answer, fieldName, COUNT);
			problemDao.saveOrUpdateProblem(answer);
		}
	}
	
	public String addAnswerReview(int ANSWER_ID, String CONTENT, int USER_ID){
		Element answer = problemAnswerDao.getProblemAnswerEleById(""+ANSWER_ID);
		if(answer == null)
			return null;
		
		Element element = new DefaultElement("T_ANSWER_REVIEW");
		Elements.setElementValue(element, "ANSWER_ID", ANSWER_ID);// 问题答案ID
		Elements.setElementValue(element, "PROBLEM_ID", answer.elementTextTrim("PROBLEM_ID"));// 问题ID(冗余字段)
		Elements.setElementValue(element, "CONTENT", CONTENT);// 内容
		Elements.setElementValue(element, "PREVIEW_ID", null);// 问题答案评论ID父ID
		Elements.setElementValue(element, "USER_ID", USER_ID);// 用户ID
		Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
		Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
		//如果保存成功，返回主键
		return answerReviewDao.saveOrUpdateAnswerReview(element);
	}
}
