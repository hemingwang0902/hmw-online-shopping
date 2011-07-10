package com.baizhi.problemcollection.action;

import java.util.Map;
import com.baizhi.problemcollection.service.ProblemCollectionService;

/**
 * 类名：GetProblemCollectionById.java<br>
 * 描述： 获取单条问题收藏信息表表单信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:13<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetProblemCollectionById extends ProblemCollectionForm{

	private static final long serialVersionUID = 3619024141847794093L;
	private ProblemCollectionService problemCollectionService;//问题收藏信息表业务类
	
	public ProblemCollectionService getProblemCollectionService() {
		return problemCollectionService;
	}

	public void setProblemCollectionService(ProblemCollectionService problemCollectionService) {
		this.problemCollectionService = problemCollectionService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = problemCollectionService.getProblemCollectionMapById(this.getCOLLECTION_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setPROBLEM_ID(this.getValue(returnMap,"PROBLEM_ID"));// 问题ID
			this.setIS_COLLECTION(this.getValue(returnMap,"IS_COLLECTION"));// 是否收藏(0否、1是)
			this.setUSER_ID(this.getValue(returnMap,"USER_ID"));// 用户ID
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
