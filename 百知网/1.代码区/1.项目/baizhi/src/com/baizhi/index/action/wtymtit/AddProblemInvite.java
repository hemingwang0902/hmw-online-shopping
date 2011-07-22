package com.baizhi.index.action.wtymtit;

import org.apache.commons.lang.math.NumberUtils;

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
	private String PROBLEM_ID;
	private String WAS_USER_ID;

	public String getPROBLEM_ID() {
		return PROBLEM_ID;
	}

	public void setPROBLEM_ID(String pROBLEMID) {
		PROBLEM_ID = pROBLEMID;
	}

	public String getWAS_USER_ID() {
		return WAS_USER_ID;
	}

	public void setWAS_USER_ID(String wASUSERID) {
		WAS_USER_ID = wASUSERID;
	}

	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}

	@Override
	public String execute() throws Exception {
		wtymtitService.addProblemInvite(NumberUtils.toInt(PROBLEM_ID), getSessionUserId(), NumberUtils.toInt(WAS_USER_ID));
		return JSONSUCCESS;
	}
}
