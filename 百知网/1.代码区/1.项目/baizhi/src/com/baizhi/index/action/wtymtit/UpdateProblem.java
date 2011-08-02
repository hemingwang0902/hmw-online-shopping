package com.baizhi.index.action.wtymtit;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.WtymtitService;

/**
 * 类名： SaveProblem<br>
 * 描述：修改回复<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class UpdateProblem  extends ActionSupport{

	private static final long serialVersionUID = -1451571357251067443L;
	private WtymtitService wtymtitService;
	private String PROBLEM_ID;
	private String CONTENT; 
	private String RELEVANT_DETAILS; 
	
	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public void setPROBLEM_ID(String pROBLEMID) {
		PROBLEM_ID = pROBLEMID;
	}

	public void setRELEVANT_DETAILS(String rELEVANTDETAILS) {
		RELEVANT_DETAILS = rELEVANTDETAILS;
	}

	@Override
	public String execute() throws Exception {
		int problemId = NumberUtils.toInt(PROBLEM_ID);
		if(problemId > 0){
			// 查询结果列表
			Map<String, Object> returnMap = new HashMap<String, Object>();
			int count = wtymtitService.updateProblem(problemId, StringUtils.trimToEmpty(CONTENT), StringUtils.trimToEmpty(RELEVANT_DETAILS));
			returnMap.put("flag", count>0);
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
