package com.baizhi.problemattention.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.problemattention.service.ProblemAttentionService;

/**
 * 类名： ProblemAttentionList.java<br>
 * 描述：  获取问题关注信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:14<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetProblemAttentionList extends ProblemAttentionForm {
	private static final long serialVersionUID = 6031878254016805308L;
	private ProblemAttentionService problemAttentionService;//问题关注信息表业务类
	
	public ProblemAttentionService getProblemAttentionService() {
		return problemAttentionService;
	}

	public void setProblemAttentionService(ProblemAttentionService problemAttentionService) {
		this.problemAttentionService = problemAttentionService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "ATTENTION_ID=?", this.getATTENTION_ID());// 问题关注ID
		this.setMap(params, "PROBLEM_ID=?", this.getPROBLEM_ID());// 问题ID
		this.setMap(params, "IS_ATTENTION=?", this.getIS_ATTENTION());// 是否关注(0否、1是)
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询问题关注信息表列表
		Map<String, Object> returnMap = problemAttentionService.getProblemAttentionList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}