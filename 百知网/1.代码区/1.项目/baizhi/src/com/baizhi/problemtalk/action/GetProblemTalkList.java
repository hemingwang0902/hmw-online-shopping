package com.baizhi.problemtalk.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.problemtalk.service.ProblemTalkService;

/**
 * 类名： ProblemTalkList.java<br>
 * 描述：  获取问题话题信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 10:39:35<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetProblemTalkList extends ProblemTalkForm {
	private static final long serialVersionUID = 887013820949911954L;
	private ProblemTalkService problemTalkService;//问题话题信息表业务类
	
	public ProblemTalkService getProblemTalkService() {
		return problemTalkService;
	}

	public void setProblemTalkService(ProblemTalkService problemTalkService) {
		this.problemTalkService = problemTalkService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "PROBLEMTALK_ID=?", this.getPROBLEMTALK_ID());// 问题话题ID
		this.setMap(params, "TALK_ID=?", this.getTALK_ID());// 话题ID
		this.setMap(params, "PROBLEM_ID=?", this.getPROBLEM_ID());// 问题ID
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询问题话题信息表列表
		Map<String, Object> returnMap = problemTalkService.getProblemTalkList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}