package com.baizhi.problem.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.problem.service.ProblemService;
/**
 * 类名： ProblemList.java<br>
 * 描述：  获取问题信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-21 00:45:57
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetProblemList extends ProblemForm {
	
	private ProblemService problemService;//问题信息表业务类
	
	public ProblemService getProblemService() {
		return problemService;
	}

	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "PROBLEM_ID=?", this.getPROBLEM_ID());// 问题ID
		this.setMap(params, "PROBLEM_TYPE=?", this.getPROBLEM_TYPE());// 问题类型(字典：1普通、2我问的问题)
		this.setMap(params, "CONTENT=?", this.getCONTENT());// 问题内容
		this.setMap(params, "IS_ANONYMITY=?", this.getIS_ANONYMITY());// 是否匿名(0否、1是)
		this.setMap(params, "RELEVANT_DETAILS=?", this.getRELEVANT_DETAILS());// 相关细节
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "WAS_USERID=?", this.getWAS_USERID());// 被问用户ID
		this.setMap(params, "ANSWER_COUNT=?", this.getANSWER_COUNT());// 答案数量
		this.setMap(params, "REVIEW_COUNT=?", this.getREVIEW_COUNT());// 评论数量
		this.setMap(params, "ATTENTION_COUNT=?", this.getATTENTION_COUNT());// 关注数量
		this.setMap(params, "COLLECTION_COUNT=?", this.getCOLLECTION_COUNT());// 收藏数量
		this.setMap(params, "BROWSE_COUNT=?", this.getBROWSE_COUNT());// 浏览次数
		this.setMap(params, "IS_REPORT=?", this.getIS_REPORT());// 是否举报(0否、1是)
		this.setMap(params, "REPORT_COUNT=?", this.getREPORT_COUNT());// 举报次数
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询问题信息表列表
		Map<String, Object> returnMap = problemService.getProblemList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}