package com.baizhi.problemanswer.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.problemanswer.service.ProblemAnswerService;

/**
 * 类名： ProblemAnswerList.java<br>
 * 描述：  获取问题答案信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 10:39:37<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetProblemAnswerList extends ProblemAnswerForm {
	private static final long serialVersionUID = -6691386113388408563L;
	private ProblemAnswerService problemAnswerService;//问题答案信息表业务类
	
	public ProblemAnswerService getProblemAnswerService() {
		return problemAnswerService;
	}

	public void setProblemAnswerService(ProblemAnswerService problemAnswerService) {
		this.problemAnswerService = problemAnswerService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "ANSWER_ID=?", this.getANSWER_ID());// 问题答案ID
		this.setMap(params, "PROBLEM_ID=?", this.getPROBLEM_ID());// 问题ID
		this.setMap(params, "CONTENT=?", this.getCONTENT());// 内容
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "AGREE_COUNT=?", this.getAGREE_COUNT());// 赞成数量
		this.setMap(params, "DISAGREE_COUNT=?", this.getDISAGREE_COUNT());// 反对数量
		this.setMap(params, "THANK_COUNT=?", this.getTHANK_COUNT());// 感觉作者数量
		this.setMap(params, "DISTHANK_COUNT=?", this.getDISTHANK_COUNT());// 没有帮助数量
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询问题答案信息表列表
		Map<String, Object> returnMap = problemAnswerService.getProblemAnswerList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}