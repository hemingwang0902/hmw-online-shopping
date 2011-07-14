package com.baizhi.answerreview.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.answerreview.service.AnswerReviewService;

/**
 * 类名： AnswerReviewList.java<br>
 * 描述：  获取问题答案评论信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 16:22:27<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetAnswerReviewList extends AnswerReviewForm {
	private static final long serialVersionUID = 2258643133366045000L;
	private AnswerReviewService answerReviewService;//问题答案评论信息表业务类
	
	public AnswerReviewService getAnswerReviewService() {
		return answerReviewService;
	}

	public void setAnswerReviewService(AnswerReviewService answerReviewService) {
		this.answerReviewService = answerReviewService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "REVIEW_ID=?", this.getREVIEW_ID());// 问题答案评论ID
		this.setMap(params, "ANSWER_ID=?", this.getANSWER_ID());// 问题答案ID
		this.setMap(params, "PROBLEM_ID=?", this.getPROBLEM_ID());// 问题ID(冗余字段)
		this.setMap(params, "CONTENT=?", this.getCONTENT());// 内容
		this.setMap(params, "PREVIEW_ID=?", this.getPREVIEW_ID());// 问题答案评论ID父ID
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询问题答案评论信息表列表
		Map<String, Object> returnMap = answerReviewService.getAnswerReviewList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}