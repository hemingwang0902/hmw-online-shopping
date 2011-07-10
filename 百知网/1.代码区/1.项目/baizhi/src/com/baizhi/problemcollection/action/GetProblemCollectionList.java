package com.baizhi.problemcollection.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.problemcollection.service.ProblemCollectionService;

/**
 * 类名： ProblemCollectionList.java<br>
 * 描述：  获取问题收藏信息表列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:13<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetProblemCollectionList extends ProblemCollectionForm {

	private static final long serialVersionUID = 5110850011436201832L;
	private ProblemCollectionService problemCollectionService;//问题收藏信息表业务类
	
	public ProblemCollectionService getProblemCollectionService() {
		return problemCollectionService;
	}

	public void setProblemCollectionService(ProblemCollectionService problemCollectionService) {
		this.problemCollectionService = problemCollectionService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "COLLECTION_ID=?", this.getCOLLECTION_ID());// 问题收藏ID
		this.setMap(params, "PROBLEM_ID=?", this.getPROBLEM_ID());// 问题ID
		this.setMap(params, "IS_COLLECTION=?", this.getIS_COLLECTION());// 是否收藏(0否、1是)
		this.setMap(params, "USER_ID=?", this.getUSER_ID());// 用户ID
		this.setMap(params, "CREATE_TIME=?", this.getCREATE_TIME());// 创建时间
		this.setMap(params, "MODIFY_TIME=?", this.getMODIFY_TIME());// 修改时间
		// 查询问题收藏信息表列表
		Map<String, Object> returnMap = problemCollectionService.getProblemCollectionList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}