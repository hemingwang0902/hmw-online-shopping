package com.baizhi.dicitem.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.dicitem.service.DicitemService;
/**
 * 
 * 类名：DicitemSave.java
 * 描述： 字典列表清单控制类，负责处理新增、修改操作
 * 创建者：何明旺
 * 创建日期： 2011-06-20 21:02:57
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveDicitem extends DicitemForm{
	
	private DicitemService dicitemService;//字典列表清单业务类
	
	public DicitemService getDicitemService() {
		return dicitemService;
	}

	public void setDicitemService(DicitemService dicitemService) {
		this.dicitemService = dicitemService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果字典列表清单ID为""，则为新增字典列表清单，否则更新字典列表清单
		if(StringUtils.isNotEmpty(this.getDICITEM_ID())){
			element = dicitemService.getDicitemEleById("DICITEM_ID");
			Elements.setElementValue(element, "DICITEM_ID", this.getDICITEM_ID());// 字典清单ID
			Elements.setElementValue(element, "CODE", this.getCODE());// 列表字典代码
			Elements.setElementValue(element, "DIC_CODE", this.getDIC_CODE());// 字典代码
			Elements.setElementValue(element, "DIC_NAME", this.getDIC_NAME());// 字典名称
			Elements.setElementValue(element, "PDIC_CODE", this.getPDIC_CODE());// 字典上级代码
			Elements.setElementValue(element, "ALLPIN", this.getALLPIN());// 字典全拼
			Elements.setElementValue(element, "SIMPLEPIN", this.getSIMPLEPIN());// 字典简拼
			Elements.setElementValue(element, "ORDER_BY", this.getORDER_BY());// 显示顺序
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			
			//如果保存成功，返回主键
			keyid = dicitemService.saveOrUpdateDicitem(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("字典列表清单信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_DICITEM");
			Elements.setElementValue(element, "CODE", this.getCODE());// 列表字典代码
			Elements.setElementValue(element, "DIC_CODE", this.getDIC_CODE());// 字典代码
			Elements.setElementValue(element, "DIC_NAME", this.getDIC_NAME());// 字典名称
			Elements.setElementValue(element, "PDIC_CODE", this.getPDIC_CODE());// 字典上级代码
			Elements.setElementValue(element, "ALLPIN", this.getALLPIN());// 字典全拼
			Elements.setElementValue(element, "SIMPLEPIN", this.getSIMPLEPIN());// 字典简拼
			Elements.setElementValue(element, "ORDER_BY", this.getORDER_BY());// 显示顺序
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			//如果保存成功，返回主键
			keyid = dicitemService.saveOrUpdateDicitem(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
