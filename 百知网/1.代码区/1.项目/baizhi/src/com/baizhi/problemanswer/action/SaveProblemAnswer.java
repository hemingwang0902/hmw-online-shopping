package com.baizhi.problemanswer.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.problemanswer.service.ProblemAnswerService;

/**
 * 类名：ProblemAnswerSave.java<br>
 * 描述： 问题答案信息表控制类，负责处理新增、修改操作<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 10:39:37<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class SaveProblemAnswer extends ProblemAnswerForm{
	private static final long serialVersionUID = 1498549020660348651L;
	private ProblemAnswerService problemAnswerService;//问题答案信息表业务类
	
	public ProblemAnswerService getProblemAnswerService() {
		return problemAnswerService;
	}

	public void setProblemAnswerService(ProblemAnswerService problemAnswerService) {
		this.problemAnswerService = problemAnswerService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果问题答案信息表ID为""，则为新增问题答案信息表，否则更新问题答案信息表
		if(StringUtils.isNotEmpty(this.getANSWER_ID())){
			element = problemAnswerService.getProblemAnswerEleById("ANSWER_ID");
			Elements.setElementValue(element, "ANSWER_ID", this.getANSWER_ID());// 问题答案ID
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID
			Elements.setElementValue(element, "CONTENT", this.getCONTENT());// 内容
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "AGREE_COUNT", this.getAGREE_COUNT());// 赞成数量
			Elements.setElementValue(element, "DISAGREE_COUNT", this.getDISAGREE_COUNT());// 反对数量
			Elements.setElementValue(element, "THANK_COUNT", this.getTHANK_COUNT());// 感觉作者数量
			Elements.setElementValue(element, "DISTHANK_COUNT", this.getDISTHANK_COUNT());// 没有帮助数量
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			
			//如果保存成功，返回主键
			keyid = problemAnswerService.saveOrUpdateProblemAnswer(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("问题答案信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_PROBLEM_ANSWER");
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID
			Elements.setElementValue(element, "CONTENT", this.getCONTENT());// 内容
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "AGREE_COUNT", this.getAGREE_COUNT());// 赞成数量
			Elements.setElementValue(element, "DISAGREE_COUNT", this.getDISAGREE_COUNT());// 反对数量
			Elements.setElementValue(element, "THANK_COUNT", this.getTHANK_COUNT());// 感觉作者数量
			Elements.setElementValue(element, "DISTHANK_COUNT", this.getDISTHANK_COUNT());// 没有帮助数量
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			//如果保存成功，返回主键
			keyid = problemAnswerService.saveOrUpdateProblemAnswer(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
