package com.baizhi.problemanswer.action;

import java.util.Map;
import com.baizhi.problemanswer.service.ProblemAnswerService;

/**
 * 类名：GetProblemAnswerById.java<br>
 * 描述： 获取单条问题答案信息表表单信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 10:39:37<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetProblemAnswerById extends ProblemAnswerForm{
	
	private ProblemAnswerService problemAnswerService;//问题答案信息表业务类
	
	public ProblemAnswerService getProblemAnswerService() {
		return problemAnswerService;
	}

	public void setProblemAnswerService(ProblemAnswerService problemAnswerService) {
		this.problemAnswerService = problemAnswerService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = problemAnswerService.getProblemAnswerMapById(this.getANSWER_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setPROBLEM_ID(this.getValue(returnMap,"PROBLEM_ID"));// 问题ID
			this.setCONTENT(this.getValue(returnMap,"CONTENT"));// 内容
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setAGREE_COUNT(this.getValue(returnMap,"AGREE_COUNT"));// 赞成数量
			this.setDISAGREE_COUNT(this.getValue(returnMap,"DISAGREE_COUNT"));// 反对数量
			this.setTHANK_COUNT(this.getValue(returnMap,"THANK_COUNT"));// 感觉作者数量
			this.setDISTHANK_COUNT(this.getValue(returnMap,"DISTHANK_COUNT"));// 没有帮助数量
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
