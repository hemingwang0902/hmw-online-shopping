package com.baizhi.probleminvite.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.probleminvite.service.ProblemInviteService;

/**
 * 类名：ProblemInviteSave.java<br>
 * 描述： 问题邀请人信息表控制类，负责处理新增、修改操作<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-12 11:03:45<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class SaveProblemInvite extends ProblemInviteForm{
	private static final long serialVersionUID = -6059561540661846035L;
	private ProblemInviteService problemInviteService;//问题邀请人信息表业务类
	
	public ProblemInviteService getProblemInviteService() {
		return problemInviteService;
	}

	public void setProblemInviteService(ProblemInviteService problemInviteService) {
		this.problemInviteService = problemInviteService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果问题邀请人信息表ID为""，则为新增问题邀请人信息表，否则更新问题邀请人信息表
		if(StringUtils.isNotEmpty(this.getINVITE_ID())){
			element = problemInviteService.getProblemInviteEleById("INVITE_ID");
			Elements.setElementValue(element, "INVITE_ID", this.getINVITE_ID());// 问题邀请人ID
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID
			Elements.setElementValue(element, "IS_ATTENTION", this.getIS_ATTENTION());// 是否回答(0否、1是)
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "WAS_USER_ID", this.getWAS_USER_ID());// 被邀请的用户ID
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			
			//如果保存成功，返回主键
			keyid = problemInviteService.saveOrUpdateProblemInvite(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("问题邀请人信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_PROBLEM_INVITE");
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID
			Elements.setElementValue(element, "IS_ATTENTION", this.getIS_ATTENTION());// 是否回答(0否、1是)
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "WAS_USER_ID", this.getWAS_USER_ID());// 被邀请的用户ID
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			//如果保存成功，返回主键
			keyid = problemInviteService.saveOrUpdateProblemInvite(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
