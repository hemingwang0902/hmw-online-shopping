package com.baizhi.answervote.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.answervote.service.AnswerVoteService;

/**
 * 类名： AnswerVoteList.java<br>
 * 描述：  获取问题答案投票信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 16:22:26<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetAnswerVoteList extends AnswerVoteForm {
	private static final long serialVersionUID = 3433304859939512547L;
	private AnswerVoteService answerVoteService;//问题答案投票信息表业务类
	
	public AnswerVoteService getAnswerVoteService() {
		return answerVoteService;
	}

	public void setAnswerVoteService(AnswerVoteService answerVoteService) {
		this.answerVoteService = answerVoteService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "VOTE_ID=?", this.getVOTE_ID());// 问题答案投票ID
		this.setMap(params, "ANSWER_ID=?", this.getANSWER_ID());// 问题答案ID
		this.setMap(params, "PROBLEM_ID=?", this.getPROBLEM_ID());// 问题ID(冗余字段)
		this.setMap(params, "VOTE_TYPE=?", this.getVOTE_TYPE());// 投票类型(字典：1赞成Or拒绝、2感谢作者Or没有帮助)
		this.setMap(params, "IS_AGREE=?", this.getIS_AGREE());// 是否赞成、感谢(0否、1是)
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询问题答案投票信息表列表
		Map<String, Object> returnMap = answerVoteService.getAnswerVoteList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}