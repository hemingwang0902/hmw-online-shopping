package com.baizhi.index.action.wtymtit;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.WtymtitService;

/**
 * 类名： AnswerVote<br>
 * 描述：问题答案投票<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-14<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AnswerVote  extends ActionSupport{
	private static final long serialVersionUID = 1303095726159142667L;

	private WtymtitService wtymtitService;
	
	private String ANSWER_ID;
	private String voteField;

	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}

	public String getANSWER_ID() {
		return ANSWER_ID;
	}

	public void setANSWER_ID(String aNSWERID) {
		ANSWER_ID = aNSWERID;
	}

	public String getVoteField() {
		return voteField;
	}

	public void setVoteField(String voteField) {
		this.voteField = voteField;
	}

	@Override
	public String execute() throws Exception {
		int answerId = NumberUtils.toInt(ANSWER_ID);
		if(answerId > 0){
			wtymtitService.answerVote(answerId, getSessionUserId(), voteField);
		}
		return JSONSUCCESS;
	}
}
