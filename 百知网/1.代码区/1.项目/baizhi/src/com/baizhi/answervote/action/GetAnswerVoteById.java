package com.baizhi.answervote.action;

import java.util.Map;
import com.baizhi.answervote.service.AnswerVoteService;

/**
 * 类名：GetAnswerVoteById.java<br>
 * 描述： 获取单条问题答案投票信息表表单信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 16:22:26<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetAnswerVoteById extends AnswerVoteForm{
	private static final long serialVersionUID = -839841501930364537L;
	private AnswerVoteService answerVoteService;//问题答案投票信息表业务类
	
	public AnswerVoteService getAnswerVoteService() {
		return answerVoteService;
	}

	public void setAnswerVoteService(AnswerVoteService answerVoteService) {
		this.answerVoteService = answerVoteService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = answerVoteService.getAnswerVoteMapById(this.getVOTE_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setANSWER_ID(this.getValue(returnMap,"ANSWER_ID"));// 问题答案ID
			this.setPROBLEM_ID(this.getValue(returnMap,"PROBLEM_ID"));// 问题ID(冗余字段)
			this.setVOTE_TYPE(this.getValue(returnMap,"VOTE_TYPE"));// 投票类型(字典：1赞成Or拒绝、2感谢作者Or没有帮助)
			this.setIS_AGREE(this.getValue(returnMap,"IS_AGREE"));// 是否赞成、感谢(0否、1是)
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
