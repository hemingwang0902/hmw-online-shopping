package com.baizhi.problem.action;

import java.util.Map;
import com.baizhi.problem.service.ProblemService;
/**
 * 
 * 类名：GetProblemById.java
 * 描述： 获取单条问题信息表表单信息
 * 创建者：江红
 * 创建日期： 2011-06-21 00:45:57
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetProblemById extends ProblemForm{
	
	private ProblemService problemService;//问题信息表业务类
	
	public ProblemService getProblemService() {
		return problemService;
	}

	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = problemService.getProblemMapById(this.getPROBLEM_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setPROBLEM_TYPE(this.setValue(returnMap,"PROBLEM_TYPE"));// 问题类型(字典：1普通、2我问的问题)
			this.setCONTENT(this.setValue(returnMap,"CONTENT"));// 问题内容
			this.setIS_ANONYMITY(this.setValue(returnMap,"IS_ANONYMITY"));// 是否匿名(0否、1是)
			this.setRELEVANT_DETAILS(this.setValue(returnMap,"RELEVANT_DETAILS"));// 相关细节
			this.setUSER_ID(this.setValue(returnMap,"USER_ID"));// 用户ID
			this.setWAS_USERID(this.setValue(returnMap,"WAS_USERID"));// 被问用户ID
			this.setANSWER_COUNT(this.setValue(returnMap,"ANSWER_COUNT"));// 答案数量
			this.setREVIEW_COUNT(this.setValue(returnMap,"REVIEW_COUNT"));// 评论数量
			this.setATTENTION_COUNT(this.setValue(returnMap,"ATTENTION_COUNT"));// 关注数量
			this.setCOLLECTION_COUNT(this.setValue(returnMap,"COLLECTION_COUNT"));// 收藏数量
			this.setBROWSE_COUNT(this.setValue(returnMap,"BROWSE_COUNT"));// 浏览次数
			this.setIS_REPORT(this.setValue(returnMap,"IS_REPORT"));// 是否举报(0否、1是)
			this.setREPORT_COUNT(this.setValue(returnMap,"REPORT_COUNT"));// 举报次数
			this.setCREATE_TIME(this.setValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.setValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
