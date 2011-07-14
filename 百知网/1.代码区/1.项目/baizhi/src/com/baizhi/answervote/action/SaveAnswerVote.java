package com.baizhi.answervote.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.answervote.service.AnswerVoteService;

/**
 * 类名：AnswerVoteSave.java<br>
 * 描述： 问题答案投票信息表控制类，负责处理新增、修改操作<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 16:22:26<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class SaveAnswerVote extends AnswerVoteForm{
	private static final long serialVersionUID = 7642119246209284524L;
	private AnswerVoteService answerVoteService;//问题答案投票信息表业务类
	
	public AnswerVoteService getAnswerVoteService() {
		return answerVoteService;
	}

	public void setAnswerVoteService(AnswerVoteService answerVoteService) {
		this.answerVoteService = answerVoteService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果问题答案投票信息表ID为""，则为新增问题答案投票信息表，否则更新问题答案投票信息表
		if(StringUtils.isNotEmpty(this.getVOTE_ID())){
			element = answerVoteService.getAnswerVoteEleById("VOTE_ID");
			Elements.setElementValue(element, "VOTE_ID", this.getVOTE_ID());// 问题答案投票ID
			Elements.setElementValue(element, "ANSWER_ID", this.getANSWER_ID());// 问题答案ID
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID(冗余字段)
			Elements.setElementValue(element, "VOTE_TYPE", this.getVOTE_TYPE());// 投票类型(字典：1赞成Or拒绝、2感谢作者Or没有帮助)
			Elements.setElementValue(element, "IS_AGREE", this.getIS_AGREE());// 是否赞成、感谢(0否、1是)
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			
			//如果保存成功，返回主键
			keyid = answerVoteService.saveOrUpdateAnswerVote(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("问题答案投票信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_ANSWER_VOTE");
			Elements.setElementValue(element, "ANSWER_ID", this.getANSWER_ID());// 问题答案ID
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID(冗余字段)
			Elements.setElementValue(element, "VOTE_TYPE", this.getVOTE_TYPE());// 投票类型(字典：1赞成Or拒绝、2感谢作者Or没有帮助)
			Elements.setElementValue(element, "IS_AGREE", this.getIS_AGREE());// 是否赞成、感谢(0否、1是)
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			//如果保存成功，返回主键
			keyid = answerVoteService.saveOrUpdateAnswerVote(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
