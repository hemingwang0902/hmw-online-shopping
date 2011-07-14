package com.baizhi.index.action.wtymtit;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.WtymtitService;

/**
 * 类名： AddProblemInvite<br>
 * 描述：邀请他人回答<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-14<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AddProblemInvite  extends ActionSupport{
	private static final long serialVersionUID = 1303095726159142667L;

	private WtymtitService wtymtitService;
	private int PROBLEM_ID;
	private int WAS_USER_ID;
	
	public int getPROBLEM_ID() {
		return PROBLEM_ID;
	}

	public void setPROBLEM_ID(int pROBLEMID) {
		PROBLEM_ID = pROBLEMID;
	}

	public int getWAS_USER_ID() {
		return WAS_USER_ID;
	}

	public void setWAS_USER_ID(int wASUSERID) {
		WAS_USER_ID = wASUSERID;
	}

	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}

	@Override
	public String execute() throws Exception {
		wtymtitService.addProblemInvite(PROBLEM_ID, getSessionUserId(), WAS_USER_ID);
		return JSONSUCCESS;
	}
}
