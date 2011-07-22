package com.baizhi.index.action.wtymtit;

import java.util.List;
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
public class GetAnswerReviewListByAnswerId  extends ActionSupport{
	private static final long serialVersionUID = 7065461361764035243L;
	private WtymtitService wtymtitService;
	private String ANSWER_ID;
	private String reviewCount;
	private List<Map<String, Object>> answerReviewList;
	
	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}

	public String getANSWER_ID() {
		return ANSWER_ID;
	}

	public void setANSWER_ID(String aNSWERID) {
		ANSWER_ID = aNSWERID;
	}

	public void setReviewCount(String reviewCount) {
		this.reviewCount = reviewCount;
	}

	public List<Map<String, Object>> getAnswerReviewList() {
		return answerReviewList;
	}

	@Override
	public String execute() throws Exception {
		int reCount = NumberUtils.toInt(reviewCount);
		int answerId = NumberUtils.toInt(ANSWER_ID);
		if(reCount > 0){
			answerReviewList = wtymtitService.getAnswerReviewListByAnswerId(answerId);
			if(answerReviewList != null && !answerReviewList.isEmpty()){
				for (Map<String, Object> newmap : answerReviewList) {
					newmap.put("CREATE_TIME", getTime(newmap, "CREATE_TIME"));
					newmap.put("MODIFY_TIME", getTime(newmap, "MODIFY_TIME"));
				}
			}
		}
		return SUCCESS;
	}
}
