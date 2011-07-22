package com.baizhi.index.action.wtymtit;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.WtymtitService;

/**
 * 类名： SaveProblemAnswer<br>
 * 描述：添加回复<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class SaveProblemAnswer  extends ActionSupport{

	private static final long serialVersionUID = -2206076413627129232L;
	private WtymtitService wtymtitService;
	private String problemId;
	private String CONTENT; 
	
	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}
	
	public String getProblemId() {
		return problemId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	@Override
	public String execute() throws Exception {
		int problem_id = NumberUtils.toInt(problemId);
		if(problem_id > 0){
			// 查询结果列表
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("ANSWER_ID", wtymtitService.addAnswer(StringUtils.trimToEmpty(CONTENT), problem_id, getSessionUserId()));
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
