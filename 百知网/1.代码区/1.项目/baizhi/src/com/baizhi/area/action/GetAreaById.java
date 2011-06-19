package com.baizhi.area.action;

import java.util.Map;
import com.baizhi.area.service.AreaService;
/**
 * 
 * 类名：GetAreaById.java
 * 描述： 获取单条地区信息表表单信息
 * 创建者：江红
 * 创建日期： 2011-06-19 23:15:19
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetAreaById extends AreaForm{
	
	private AreaService areaService;//地区信息表业务类
	
	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = areaService.getAreaMapById(this.getAREA_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setDIC_CODE(this.setValue(returnMap,"DIC_CODE"));// 地区代码(根据级别制定规则定义)
			this.setDIC_NAME(this.setValue(returnMap,"DIC_NAME"));// 地区名称
			this.setPAREA_ID(this.setValue(returnMap,"PAREA_ID"));// 地区上级代码
			this.setALLPIN(this.setValue(returnMap,"ALLPIN"));// 地区全拼
			this.setSIMPLEPIN(this.setValue(returnMap,"SIMPLEPIN"));// 地区简拼
			this.setORDER_BY(this.setValue(returnMap,"ORDER_BY"));// 显示顺序
			this.setIP_START(this.setValue(returnMap,"IP_START"));// IP起始段
			this.setIP_END(this.setValue(returnMap,"IP_END"));// IP终止段
			this.setAREA_LEVEL(this.setValue(returnMap,"AREA_LEVEL"));// 地区级别(字典：1省、2市、3县、4镇、5村)暂时定义省、市两级
			this.setREMARK(this.setValue(returnMap,"REMARK"));// 备注
		}
		return SUCCESS;
	}
	
}
