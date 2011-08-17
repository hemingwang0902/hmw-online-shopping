package com.baizhi.talk.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

import com.baizhi.commons.support.DateUtils;
import com.baizhi.commons.support.Elements;
import com.baizhi.talk.service.TalkService;
/**
 * 
 * 类名：TalkSave.java
 * 描述： 话题信息表控制类，负责处理新增、修改操作
 * 创建者：江红
 * 创建日期： 2011-06-20 23:49:03
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class SaveTalk extends TalkForm{
	
	private static final long serialVersionUID = 5738462955015810485L;
	
	private TalkService talkService;//话题信息表业务类
	private Boolean isAjax;

	public void setTalkService(TalkService talkService) {
		this.talkService = talkService;
	}
	
	public void setIsAjax(Boolean isAjax) {
		this.isAjax = isAjax;
	}

	@Override
	public String execute() throws Exception {
		String content = StringUtils.trimToEmpty(getCONTENT());
		setINTRODUCTION(StringUtils.trimToEmpty(getINTRODUCTION()));
		
		Element element = null;
		String keyid="";
		//如果话题信息表ID为""，则为新增话题信息表，否则更新话题信息表
		if(StringUtils.isNotEmpty(this.getTALK_ID())){
			element = talkService.getTalkEleById("TALK_ID");
			//Elements.setElementValue(element, "TALK_ID", this.getTALK_ID());// 话题ID
			Elements.setElementValue(element, "CONTENT", content);// 内容
			Elements.setElementValue(element, "INTRODUCTION", this.getINTRODUCTION());
			Elements.setElementValue(element, "IMAGE_PATH", org.apache.commons.lang.StringUtils.trimToEmpty(this.getIMAGE_PATH()));
			Elements.setElementValue(element, "MODIFY_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 修改时间
			
			//如果保存成功，返回主键
			keyid = talkService.saveOrUpdateTalk(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("话题信息表信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			Map<String, Object> conditions = new HashMap<String, Object>();
			conditions.put("CONTENT=?", content);
			List<Map<String, Object>> list = talkService.getTalkList(conditions);
			if(list.isEmpty()){ //不存在 content 相同的话题，添加
				element = new DefaultElement("T_TALK");
				Elements.setElementValue(element, "CONTENT", content);// 内容
				Elements.setElementValue(element, "USER_ID", this.getSessionUserId());// 用户ID
				Elements.setElementValue(element, "INTRODUCTION", this.getINTRODUCTION());
				Elements.setElementValue(element, "IMAGE_PATH", this.getIMAGE_PATH());
				Elements.setElementValue(element, "CREATE_TIME", DateUtils.getCurrentTime(DateUtils.SHOW_DATE_FORMAT));// 创建时间
				//Elements.setElementValue(element, "MODIFY_TIME", this.getMODIFY_TIME());// 修改时间
				//如果保存成功，返回主键
				keyid = talkService.saveOrUpdateTalk(element);
			}else{//已经存放 content 相同的话题，则直接给出提示信息后返回
				this.setMessage("话题已经存在");
			}
			
			if(Boolean.TRUE.equals(isAjax)){
				Map<String, Object> returnMap = new HashMap<String, Object>();
				returnMap.put("id", keyid);
				returnMap.put("message", StringUtils.trimToEmpty(getMessage()));
				setResult(returnMap);
				return JSONSUCCESS;
			}else{
				//判断主键是否为空，如果不为空，则保存成功
				if(StringUtils.isNotEmpty(keyid)){
					return SUCCESS;
				}
			}
		}
		return ERROR;
	}

}
