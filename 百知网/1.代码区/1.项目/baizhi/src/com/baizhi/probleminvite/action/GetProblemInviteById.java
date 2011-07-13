package com.baizhi.probleminvite.action;

import java.util.Map;
import com.baizhi.probleminvite.service.ProblemInviteService;

/**
 * 类名：GetProblemInviteById.java<br>
 * 描述： 获取单条问题邀请人信息表表单信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-12 11:03:45<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetProblemInviteById extends ProblemInviteForm{
	private static final long serialVersionUID = -5912531951129686100L;
	private ProblemInviteService problemInviteService;//问题邀请人信息表业务类
	
	public ProblemInviteService getProblemInviteService() {
		return problemInviteService;
	}

	public void setProblemInviteService(ProblemInviteService problemInviteService) {
		this.problemInviteService = problemInviteService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = problemInviteService.getProblemInviteMapById(this.getINVITE_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setPROBLEM_ID(this.getValue(returnMap,"PROBLEM_ID"));// 问题ID
			this.setIS_ATTENTION(this.getValue(returnMap,"IS_ATTENTION"));// 是否回答(0否、1是)
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setWAS_USER_ID(this.getValue(returnMap,"WAS_USER_ID"));// 被邀请的用户ID
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
