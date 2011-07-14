package com.baizhi.answerreview.action;

import java.util.Map;
import com.baizhi.answerreview.service.AnswerReviewService;

/**
 * 类名：GetAnswerReviewById.java<br>
 * 描述： 获取单条问题答案评论信息表表单信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 16:22:27<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetAnswerReviewById extends AnswerReviewForm{
	private static final long serialVersionUID = 2268837331260376986L;
	private AnswerReviewService answerReviewService;//问题答案评论信息表业务类
	
	public AnswerReviewService getAnswerReviewService() {
		return answerReviewService;
	}

	public void setAnswerReviewService(AnswerReviewService answerReviewService) {
		this.answerReviewService = answerReviewService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = answerReviewService.getAnswerReviewMapById(this.getREVIEW_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setANSWER_ID(this.getValue(returnMap,"ANSWER_ID"));// 问题答案ID
			this.setPROBLEM_ID(this.getValue(returnMap,"PROBLEM_ID"));// 问题ID(冗余字段)
			this.setCONTENT(this.getValue(returnMap,"CONTENT"));// 内容
			this.setPREVIEW_ID(this.getValue(returnMap,"PREVIEW_ID"));// 问题答案评论ID父ID
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
