package com.baizhi.talktype.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.commons.support.StringUtils;
import com.baizhi.talktype.service.TalktypeService;
/**
 * 
 * 类名：TalktypeSave.java
 * 描述： 话题类型表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-08-13 22:34:26
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveTalktype extends TalktypeForm{
	
	private static final long serialVersionUID = 7520686993321542356L;
	
	private TalktypeService talktypeService;//话题类型表业务类
	
	public TalktypeService getTalktypeService() {
		return talktypeService;
	}

	public void setTalktypeService(TalktypeService talktypeService) {
		this.talktypeService = talktypeService;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果话题类型表ID为""，则为新增话题类型表，否则更新话题类型表
		if(StringUtils.isNotEmpty(this.getTALKTYPE_ID())){
			element = talktypeService.getTalktypeEleById("TALKTYPE_ID");
			Elements.setElementValue(element, "TALKTYPE_ID", this.getTALKTYPE_ID());// 话题类型ID
			Elements.setElementValue(element, "TYPE_NAME", this.getTYPE_NAME());// 类型名称
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
			
			//如果保存成功，返回主键
			keyid = talktypeService.saveOrUpdateTalktype(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("话题类型表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("T_TALKTYPE");
			Elements.setElementValue(element, "TYPE_NAME", this.getTYPE_NAME());// 类型名称
			Elements.setElementValue(element, "REMARK", this.getREMARK());// 备注
			Elements.setElementValue(element, "CREATE_TIME",DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
			//如果保存成功，返回主键
			keyid = talktypeService.saveOrUpdateTalktype(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
