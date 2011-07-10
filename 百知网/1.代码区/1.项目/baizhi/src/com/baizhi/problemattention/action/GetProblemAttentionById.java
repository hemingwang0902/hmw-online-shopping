package com.baizhi.problemattention.action;

import java.util.Map;
import com.baizhi.problemattention.service.ProblemAttentionService;

/**
 * 类名：GetProblemAttentionById.java<br>
 * 描述： 获取单条问题关注信息表表单信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:14<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetProblemAttentionById extends ProblemAttentionForm{
	private static final long serialVersionUID = 5941519045490415185L;
	private ProblemAttentionService problemAttentionService;//问题关注信息表业务类
	
	public ProblemAttentionService getProblemAttentionService() {
		return problemAttentionService;
	}

	public void setProblemAttentionService(ProblemAttentionService problemAttentionService) {
		this.problemAttentionService = problemAttentionService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = problemAttentionService.getProblemAttentionMapById(this.getATTENTION_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setPROBLEM_ID(this.getValue(returnMap,"PROBLEM_ID"));// 问题ID
			this.setIS_ATTENTION(this.getValue(returnMap,"IS_ATTENTION"));// 是否关注(0否、1是)
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
