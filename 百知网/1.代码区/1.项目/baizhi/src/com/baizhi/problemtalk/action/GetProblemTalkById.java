package com.baizhi.problemtalk.action;

import java.util.Map;
import com.baizhi.problemtalk.service.ProblemTalkService;

/**
 * 类名：GetProblemTalkById.java<br>
 * 描述： 获取单条问题话题信息表表单信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 10:39:35<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetProblemTalkById extends ProblemTalkForm{
	
	private ProblemTalkService problemTalkService;//问题话题信息表业务类
	
	public ProblemTalkService getProblemTalkService() {
		return problemTalkService;
	}

	public void setProblemTalkService(ProblemTalkService problemTalkService) {
		this.problemTalkService = problemTalkService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = problemTalkService.getProblemTalkMapById(this.getPROBLEMTALK_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setTALK_ID(this.getValue(returnMap,"TALK_ID"));// 话题ID
			this.setPROBLEM_ID(this.getValue(returnMap,"PROBLEM_ID"));// 问题ID
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
