package com.baizhi.index.action.wtymtit;

import java.util.HashMap;
import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.WtymtitService;

/**
 * 类名： AddTalkForProblem<br>
 * 描述：给问题添加话题<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-14<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AddTalkForProblem  extends ActionSupport{

	private static final long serialVersionUID = 1185570284350615963L;

	private WtymtitService wtymtitService;
	
	private int PROBLEM_ID;
	private String CONTENT;

	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}

	public int getPROBLEM_ID() {
		return PROBLEM_ID;
	}

	public void setPROBLEM_ID(int pROBLEMID) {
		PROBLEM_ID = pROBLEMID;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}


	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("TALK_ID", wtymtitService.addTalkForProblem(PROBLEM_ID, CONTENT, getSessionUserId()));
		setResult(returnMap);
		return JSONSUCCESS;
	}
}
