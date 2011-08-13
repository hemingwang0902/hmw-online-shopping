package com.baizhi.talktype.action;

import java.util.Map;
import com.baizhi.talktype.service.TalktypeService;
/**
 * 
 * 类名：GetTalktypeById.java
 * 描述： 获取单条话题类型表表单信息
 * 创建者：江红
 * 创建日期： 2011-08-13 22:34:26
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetTalktypeById extends TalktypeForm{
	
	private static final long serialVersionUID = 969657774457691L;
	
	private TalktypeService talktypeService;//话题类型表业务类
	
	public TalktypeService getTalktypeService() {
		return talktypeService;
	}

	public void setTalktypeService(TalktypeService talktypeService) {
		this.talktypeService = talktypeService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = talktypeService.getTalktypeMapById(this.getTALKTYPE_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setTYPE_NAME(this.getValue(returnMap,"TYPE_NAME"));// 类型名称
			this.setREMARK(this.getValue(returnMap,"REMARK"));// 备注
			this.setCREATE_TIME(this.getValue(returnMap,"CREATE_TIME"));// 创建时间
			this.setMODIFY_TIME(this.getValue(returnMap,"MODIFY_TIME"));// 修改时间
		}
		return SUCCESS;
	}
	
}
