package com.baizhi.probleminvite.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.probleminvite.service.ProblemInviteService;

/**
 * 类名： ProblemInviteList.java<br>
 * 描述：  获取问题邀请人信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-12 11:03:45<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetProblemInviteList extends ProblemInviteForm {
	private static final long serialVersionUID = -4748863928746409581L;
	private ProblemInviteService problemInviteService;//问题邀请人信息表业务类
	
	public ProblemInviteService getProblemInviteService() {
		return problemInviteService;
	}

	public void setProblemInviteService(ProblemInviteService problemInviteService) {
		this.problemInviteService = problemInviteService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "INVITE_ID=?", this.getINVITE_ID());// 问题邀请人ID
		this.setMap(params, "PROBLEM_ID=?", this.getPROBLEM_ID());// 问题ID
		this.setMap(params, "IS_ATTENTION=?", this.getIS_ATTENTION());// 是否回答(0否、1是)
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "WAS_USER_ID=?", this.getWAS_USER_ID());// 被邀请的用户ID
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询问题邀请人信息表列表
		Map<String, Object> returnMap = problemInviteService.getProblemInviteList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}