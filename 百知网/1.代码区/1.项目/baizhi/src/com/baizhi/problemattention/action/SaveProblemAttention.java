package com.baizhi.problemattention.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.problemattention.service.ProblemAttentionService;

/**
 * 类名：ProblemAttentionSave.java<br>
 * 描述： 问题关注信息表控制类，负责处理新增、修改操作<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:14<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class SaveProblemAttention extends ProblemAttentionForm{
	private static final long serialVersionUID = 4241281515929123004L;
	private ProblemAttentionService problemAttentionService;//问题关注信息表业务类
	
	public ProblemAttentionService getProblemAttentionService() {
		return problemAttentionService;
	}

	public void setProblemAttentionService(ProblemAttentionService problemAttentionService) {
		this.problemAttentionService = problemAttentionService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果问题关注信息表ID为""，则为新增问题关注信息表，否则更新问题关注信息表
		if(StringUtils.isNotEmpty(this.getATTENTION_ID())){
			element = problemAttentionService.getProblemAttentionEleById("ATTENTION_ID");
			Elements.setElementValue(element, "ATTENTION_ID", this.getATTENTION_ID());// 问题关注ID
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID
			Elements.setElementValue(element, "IS_ATTENTION", this.getIS_ATTENTION());// 是否关注(0否、1是)
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			
			//如果保存成功，返回主键
			keyid = problemAttentionService.saveOrUpdateProblemAttention(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("问题关注信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_PROBLEM_ATTENTION");
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID
			Elements.setElementValue(element, "IS_ATTENTION", this.getIS_ATTENTION());// 是否关注(0否、1是)
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			//如果保存成功，返回主键
			keyid = problemAttentionService.saveOrUpdateProblemAttention(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
