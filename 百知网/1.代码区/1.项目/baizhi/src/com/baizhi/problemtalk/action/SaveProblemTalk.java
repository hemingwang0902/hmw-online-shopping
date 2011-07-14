package com.baizhi.problemtalk.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.problemtalk.service.ProblemTalkService;

/**
 * 类名：ProblemTalkSave.java<br>
 * 描述： 问题话题信息表控制类，负责处理新增、修改操作<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-14 10:39:35<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class SaveProblemTalk extends ProblemTalkForm{
	
	private ProblemTalkService problemTalkService;//问题话题信息表业务类
	
	public ProblemTalkService getProblemTalkService() {
		return problemTalkService;
	}

	public void setProblemTalkService(ProblemTalkService problemTalkService) {
		this.problemTalkService = problemTalkService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果问题话题信息表ID为""，则为新增问题话题信息表，否则更新问题话题信息表
		if(StringUtils.isNotEmpty(this.getPROBLEMTALK_ID())){
			element = problemTalkService.getProblemTalkEleById("PROBLEMTALK_ID");
			Elements.setElementValue(element, "PROBLEMTALK_ID", this.getPROBLEMTALK_ID());// 问题话题ID
			Elements.setElementValue(element, "TALK_ID", this.getTALK_ID());// 话题ID
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			
			//如果保存成功，返回主键
			keyid = problemTalkService.saveOrUpdateProblemTalk(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("问题话题信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_PROBLEM_TALK");
			Elements.setElementValue(element, "TALK_ID", this.getTALK_ID());// 话题ID
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			//如果保存成功，返回主键
			keyid = problemTalkService.saveOrUpdateProblemTalk(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
