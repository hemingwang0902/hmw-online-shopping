package com.baizhi.problemcollection.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.problemcollection.service.ProblemCollectionService;

/**
 * 类名：ProblemCollectionSave.java<br>
 * 描述： 问题收藏信息表控制类，负责处理新增、修改操作<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-07-10 13:47:13<br>
 * 版本：V0.9<br>
 * 修改者：<br>
 * 修改日期：
 */
public class SaveProblemCollection extends ProblemCollectionForm{

	private static final long serialVersionUID = -1491776020588855417L;
	private ProblemCollectionService problemCollectionService;//问题收藏信息表业务类
	
	public ProblemCollectionService getProblemCollectionService() {
		return problemCollectionService;
	}

	public void setProblemCollectionService(ProblemCollectionService problemCollectionService) {
		this.problemCollectionService = problemCollectionService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果问题收藏信息表ID为""，则为新增问题收藏信息表，否则更新问题收藏信息表
		if(StringUtils.isNotEmpty(this.getCOLLECTION_ID())){
			element = problemCollectionService.getProblemCollectionEleById("COLLECTION_ID");
			Elements.setElementValue(element, "COLLECTION_ID", this.getCOLLECTION_ID());// 问题收藏ID
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID
			Elements.setElementValue(element, "IS_COLLECTION", this.getIS_COLLECTION());// 是否收藏(0否、1是)
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			
			//如果保存成功，返回主键
			keyid = problemCollectionService.saveOrUpdateProblemCollection(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("问题收藏信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_PROBLEM_COLLECTION");
			Elements.setElementValue(element, "PROBLEM_ID", this.getPROBLEM_ID());// 问题ID
			Elements.setElementValue(element, "IS_COLLECTION", this.getIS_COLLECTION());// 是否收藏(0否、1是)
			Elements.setElementValue(element, "USER_ID", this.getUSER_ID());// 用户ID
			Elements.setElementValue(element, "CREATE_TIME", this.getCREATE_TIME());// 创建时间
			Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
			//如果保存成功，返回主键
			keyid = problemCollectionService.saveOrUpdateProblemCollection(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
