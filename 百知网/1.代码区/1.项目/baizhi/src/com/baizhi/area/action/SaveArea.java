package com.baizhi.area.action;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.area.service.AreaService;
import com.baizhi.commons.support.Elements;
/**
 * 
 * 类名：AreaSave.java
 * 描述： 地区信息表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-06-19 23:15:19
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveArea extends AreaForm{
	
	private static final long serialVersionUID = 3122825375228300143L;
	
	private AreaService areaService;//地区信息表业务类
	
	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果地区信息表ID为""，则为新增地区信息表，否则更新地区信息表
		if(StringUtils.isNotEmpty(this.getAREA_ID())){
			element = areaService.getAreaEleById("AREA_ID");
			Elements.setElementValue(element, "AREA_ID", this.getAREA_ID());// 地区ID
			setElementValue(element);
			
			//如果保存成功，返回主键
			keyid = areaService.saveOrUpdateArea(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("地区信息表信息编辑成功");
				return UPDATESUCCESS + getAREA_LEVEL();
			}
		}else{
			element = new DefaultElement("T_AREA");
			setElementValue(element);
			//如果保存成功，返回主键
			keyid = areaService.saveOrUpdateArea(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS + getAREA_LEVEL();
			}
		}
		return ERROR + getAREA_LEVEL();
	}
	
	private void setElementValue(Element element){
		Elements.setElementValue(element, "DIC_CODE", this.getDIC_CODE());// 地区代码(根据级别制定规则定义)
		Elements.setElementValue(element, "DIC_NAME", this.getDIC_NAME());// 地区名称
		Elements.setElementValue(element, "PAREA_ID", StringUtils.defaultIfEmpty(this.getPAREA_ID(), "0"));// 地区上级代码
		Elements.setElementValue(element, "ALLPIN", this.getALLPIN());// 地区全拼
		Elements.setElementValue(element, "SIMPLEPIN", this.getSIMPLEPIN());// 地区简拼
		Elements.setElementValue(element, "ORDER_BY", StringUtils.defaultIfEmpty(this.getORDER_BY(), "" + Integer.MAX_VALUE));// 显示顺序
		Elements.setElementValue(element, "IP_START", this.getIP_START());// IP起始段
		Elements.setElementValue(element, "IP_END", this.getIP_END());// IP终止段
		Elements.setElementValue(element, "AREA_LEVEL", this.getAREA_LEVEL());// 地区级别(字典：1省、2市、3县、4镇、5村)暂时定义省、市两级
		Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
	}
}
