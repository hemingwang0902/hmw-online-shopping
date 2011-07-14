package com.baizhi.answerreview.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.answerreview.service.AnswerReviewService;

/**
 * 类名：AnswerReviewSave.java<br>
 * 描述： 问题答案评论信息表控制类，负责处理新增、修改操作<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 16:22:27<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class SaveAnswerReview extends AnswerReviewForm{
	private static final long serialVersionUID = 129389513296126L;
	private AnswerReviewService answerReviewService;//问题答案评论信息表业务类
	
	public AnswerReviewService getAnswerReviewService() {
		return answerReviewService;
	}

	public void setAnswerReviewService(AnswerReviewService answerReviewService) {
		this.answerReviewService = answerReviewService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果问题答案评论信息表ID为""，则为新增问题答案评论信息表，否则更新问题答案评论信息表
		if(StringUtils.isNotEmpty(this.getREVIEW_ID())){
			element = answerReviewService.getAnswerReviewEleById("REVIEW_ID");
			Elements.setElementValue(element, "REVIEW_ID", this.getREVIEW_ID());// 问题答案评论ID
			Elements.setElementValue(element, "ANSWER_ID", this.getANSWER_ID());// 问题答案ID
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID(冗余字段)
			Elements.setElementValue(element, "CONTENT", this.getCONTENT());// 内容
			Elements.setElementValue(element, "PREVIEW_ID", this.getPREVIEW_ID());// 问题答案评论ID父ID
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			
			//如果保存成功，返回主键
			keyid = answerReviewService.saveOrUpdateAnswerReview(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("问题答案评论信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_ANSWER_REVIEW");
			Elements.setElementValue(element, "ANSWER_ID", this.getANSWER_ID());// 问题答案ID
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID(冗余字段)
			Elements.setElementValue(element, "CONTENT", this.getCONTENT());// 内容
			Elements.setElementValue(element, "PREVIEW_ID", this.getPREVIEW_ID());// 问题答案评论ID父ID
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			//如果保存成功，返回主键
			keyid = answerReviewService.saveOrUpdateAnswerReview(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
