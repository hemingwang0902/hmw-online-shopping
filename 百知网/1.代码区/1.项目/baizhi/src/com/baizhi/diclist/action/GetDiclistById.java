package com.baizhi.diclist.action;

import java.util.Map;
import com.baizhi.diclist.service.DiclistService;
/**
 * 
 * 类名：GetDiclistById.java
 * 描述： 获取单条字典列表表单信息
 * 创建者：江红
 * 创建日期： 2011-06-22 21:19:11
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetDiclistById extends DiclistForm{
	
	private static final long serialVersionUID = 8710951919812223281L;
	
	private DiclistService diclistService;//字典列表业务类
	
	public DiclistService getDiclistService() {
		return diclistService;
	}

	public void setDiclistService(DiclistService diclistService) {
		this.diclistService = diclistService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = diclistService.getDiclistMapById(this.getDICLIST_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setNAME(this.getValue(returnMap,"NAME"));// 字典名称
			this.setCODE(this.getValue(returnMap,"CODE"));// 字典代码
			this.setALLPIN(this.getValue(returnMap,"ALLPIN"));// 字典全拼
			this.setSIMPLEPIN(this.getValue(returnMap,"SIMPLEPIN"));// 字典简拼
			this.setREMARK(this.getValue(returnMap,"REMARK"));// 备注
		}
		return SUCCESS;
	}
	
}
