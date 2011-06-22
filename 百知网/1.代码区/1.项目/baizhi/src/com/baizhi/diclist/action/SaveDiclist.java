package com.baizhi.diclist.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.diclist.service.DiclistService;
/**
 * 
 * 类名：DiclistSave.java
 * 描述： 字典列表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-06-22 21:19:11
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveDiclist extends DiclistForm{
	
	private static final long serialVersionUID = 2766985777973674645L;
	
	private DiclistService diclistService;//字典列表业务类
	
	public DiclistService getDiclistService() {
		return diclistService;
	}

	public void setDiclistService(DiclistService diclistService) {
		this.diclistService = diclistService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果字典列表ID为""，则为新增字典列表，否则更新字典列表
		if(StringUtils.isNotEmpty(this.getDICLIST_ID())){
			element = diclistService.getDiclistEleById("DICLIST_ID");
			Elements.setElementValue(element, "DICLIST_ID", this.getDICLIST_ID());// 字典列表ID
			Elements.setElementValue(element, "NAME", this.getNAME());// 字典名称
			Elements.setElementValue(element, "CODE", this.getCODE());// 字典代码
			Elements.setElementValue(element, "ALLPIN", this.getALLPIN());// 字典全拼
			Elements.setElementValue(element, "SIMPLEPIN", this.getSIMPLEPIN());// 字典简拼
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			
			//如果保存成功，返回主键
			keyid = diclistService.saveOrUpdateDiclist(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("字典列表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_DICLIST");
			Elements.setElementValue(element, "NAME", this.getNAME());// 字典名称
			Elements.setElementValue(element, "CODE", this.getCODE());// 字典代码
			Elements.setElementValue(element, "ALLPIN", this.getALLPIN());// 字典全拼
			Elements.setElementValue(element, "SIMPLEPIN", this.getSIMPLEPIN());// 字典简拼
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			//如果保存成功，返回主键
			keyid = diclistService.saveOrUpdateDiclist(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
