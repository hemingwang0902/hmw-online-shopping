package com.baizhi.dicitem.action;

import java.util.Map;
import com.baizhi.dicitem.service.DicitemService;
/**
 * 
 * 类名：GetDicitemById.java
 * 描述： 获取单条字典列表清单表单信息
 * 创建者：何明旺
 * 创建日期： 2011-06-20 21:02:57
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetDicitemById extends DicitemForm{
	
	private DicitemService dicitemService;//字典列表清单业务类
	
	public DicitemService getDicitemService() {
		return dicitemService;
	}

	public void setDicitemService(DicitemService dicitemService) {
		this.dicitemService = dicitemService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = dicitemService.getDicitemMapById(this.getDICITEM_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setCODE(this.setValue(returnMap,"CODE"));// 列表字典代码
			this.setDIC_CODE(this.setValue(returnMap,"DIC_CODE"));// 字典代码
			this.setDIC_NAME(this.setValue(returnMap,"DIC_NAME"));// 字典名称
			this.setPDIC_CODE(this.setValue(returnMap,"PDIC_CODE"));// 字典上级代码
			this.setALLPIN(this.setValue(returnMap,"ALLPIN"));// 字典全拼
			this.setSIMPLEPIN(this.setValue(returnMap,"SIMPLEPIN"));// 字典简拼
			this.setORDER_BY(this.setValue(returnMap,"ORDER_BY"));// 显示顺序
			this.setREMARK(this.setValue(returnMap,"REMARK"));// 备注
		}
		return SUCCESS;
	}
	
}
