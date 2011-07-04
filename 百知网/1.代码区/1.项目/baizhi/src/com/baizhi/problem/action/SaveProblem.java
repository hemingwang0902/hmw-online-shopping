package com.baizhi.problem.action;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.problem.service.ProblemService;
/**
 * 
 * 类名：ProblemSave.java
 * 描述： 问题信息表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-06-21 00:45:57
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveProblem extends ProblemForm{
	
	private static final long serialVersionUID = -1349659000089046904L;
	
	private Boolean isAjax;
	
	private ProblemService problemService;//问题信息表业务类
	
	public Boolean getIsAjax() {
		return isAjax;
	}

	public void setIsAjax(Boolean isAjax) {
		this.isAjax = isAjax;
	}

	public void setProblemService(ProblemService problemService) {
		this.problemService = problemService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果问题信息表ID为""，则为新增问题信息表，否则更新问题信息表
		if(StringUtils.isNotEmpty(this.getPROBLEM_ID())){
			element = problemService.getProblemEleById("PROBLEM_ID");
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID
			Elements.setElementValue(element, "PROBLEM_TYPE", this.getPROBLEM_TYPE());// 问题类型(字典：1普通、2我问的问题)
			Elements.setElementValue(element, "CONTENT", this.getCONTENT());// 问题内容
			Elements.setElementValue(element, "IS_ANONYMITY", this.getIS_ANONYMITY());// 是否匿名(0否、1是)
			Elements.setElementValue(element, "RELEVANT_DETAILS", this.getRELEVANT_DETAILS());// 相关细节
			if(this.getWAS_USERID()!=null&&!this.getWAS_USERID().trim().equals("")){
				Elements.setElementValue(element, "WAS_USERID", this.getWAS_USERID());// 被问用户ID
			}
			Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
			
			//如果保存成功，返回主键
			keyid = problemService.saveOrUpdateProblem(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("问题信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_PROBLEM");
			Elements.setElementValue(element, "PROBLEM_TYPE", this.getPROBLEM_TYPE());// 问题类型(字典：1普通、2我问的问题)
			Elements.setElementValue(element, "CONTENT", this.getCONTENT());// 问题内容
			Elements.setElementValue(element, "IS_ANONYMITY", this.getIS_ANONYMITY());// 是否匿名(0否、1是)
			Elements.setElementValue(element, "RELEVANT_DETAILS", this.getRELEVANT_DETAILS());// 相关细节
			Elements.setElementValue(element, "USER_ID", this.getSessionUserId());// 用户ID
			if(this.getWAS_USERID()!=null&&!this.getWAS_USERID().trim().equals("")){
				Elements.setElementValue(element, "WAS_USERID", this.getWAS_USERID());// 被问用户ID
			}
			Elements.setElementValue(element, "ANSWER_COUNT", 0);// 答案数量
			Elements.setElementValue(element, "REVIEW_COUNT", 0);// 评论数量
			Elements.setElementValue(element, "ATTENTION_COUNT",0);// 关注数量
			Elements.setElementValue(element, "COLLECTION_COUNT",0);// 收藏数量
			Elements.setElementValue(element, "BROWSE_COUNT", 0);// 浏览次数
			Elements.setElementValue(element, "IS_REPORT", 0);// 是否举报(0否、1是)
			Elements.setElementValue(element, "REPORT_COUNT", 0);// 举报次数
			Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
			//如果保存成功，返回主键
			keyid = problemService.saveOrUpdateProblem(element);
			
			Map<String, Object> returnMap = new HashMap<String, Object>();
			returnMap.put("id", keyid);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				if(Boolean.TRUE.equals(isAjax)){
					setResult(returnMap);
					return JSONSUCCESS;
				}else{
					return SUCCESS;
				}
			}
		}
		return ERROR;
	}

}
