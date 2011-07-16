package com.baizhi.index.action.wtymtit;

import java.util.List;
import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HomeService;
import com.baizhi.index.service.WtymtitService;
import com.baizhi.problem.service.ProblemService;

/**
 * 类名： WtymDetail<br>
 * 描述：跳转到问题详细页面<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class WtymDetail  extends ActionSupport{

	private static final long serialVersionUID = -6091216231613960668L;
	
	private WtymtitService wtymtitService;
	private ProblemService problemService;
	private HomeService homeService;
	
	private int problemId;
	//问题详细
	private Map<String, Object> problem;
	// 问题所属的话题
	private List<Map<String, Object>> talkList;
	//话题关注者
	private List<Map<String, Object>> talkUserList;
	//话题关注者数量
	private int talkUserCount;
	// 相关问题
	private List<Map<String, Object>> nearProblemList;
	

	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}

	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	public int getProblemId() {
		return problemId;
	}

	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}

	public List<Map<String, Object>> getTalkUserList() {
		return talkUserList;
	}

	public Map<String, Object> getProblem() {
		return problem;
	}

	public List<Map<String, Object>> getTalkList() {
		return talkList;
	}

	public List<Map<String, Object>> getNearProblemList() {
		return nearProblemList;
	}

	public int getTalkUserCount() {
		return talkUserCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		problem = problemService.getProblemMapById(problemId, getSessionUserId());
		if(problem == null || problem.isEmpty()){
			return INPUT; //问题不存在
		}
		
		talkList = wtymtitService.getTalkList(problemId);
		
		talkUserList = wtymtitService.getTalkUserList(problemId);
		if(talkUserList != null){
			talkUserCount = talkUserList.size();
		}
		
		int nowPage=1, onePageCount=4;
		Map<String, Object> resultMap = wtymtitService.getNearProblemList(problemId, getSessionUserId(), nowPage, onePageCount);
		nearProblemList = (List<Map<String, Object>>) resultMap.get(KEY_LIST);
		if(nearProblemList == null || nearProblemList.isEmpty()){
			nearProblemList = (List<Map<String, Object>>) homeService.getHottestProblemList(getSessionUserId(), nowPage, onePageCount).get(KEY_LIST);
		}

		//更新浏览次数
		int browseCount = wtymtitService.updateBrowseCount(problemId);
		problem.put("BROWSE_COUNT", browseCount);
		
		return SUCCESS;
	}

}
