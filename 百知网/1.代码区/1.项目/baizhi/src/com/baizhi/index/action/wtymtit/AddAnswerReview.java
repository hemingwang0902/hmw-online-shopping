package com.baizhi.index.action.wtymtit;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.WtymtitService;

/**
 * 类名： AddAnswerReview<br>
 * 描述：给回复添加评论<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-14<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AddAnswerReview  extends ActionSupport{

	private static final long serialVersionUID = -4032357682752530908L;
	private WtymtitService wtymtitService;
	private String ANSWER_ID;
	private String CONTENT;
	
	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}

	public String getANSWER_ID() {
		return ANSWER_ID;
	}

	public void setANSWER_ID(String aNSWERID) {
		ANSWER_ID = aNSWERID;
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
		int answerId = NumberUtils.toInt(ANSWER_ID);
		if(answerId > 0){
			returnMap.put("REVIEW_ID", wtymtitService.addAnswerReview(answerId, CONTENT, getSessionUserId()));
		}
		setResult(returnMap);
		return JSONSUCCESS;
	}
}
