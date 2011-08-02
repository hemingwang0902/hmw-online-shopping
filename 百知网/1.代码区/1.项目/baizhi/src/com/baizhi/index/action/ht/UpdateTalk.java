package com.baizhi.index.action.ht;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HtymService;

/**
 * 类名： UploadTalkImage<br>
 * 描述：上传话题图片<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-8-2<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class UpdateTalk extends ActionSupport{
	private static final long serialVersionUID = 5186646580996321512L;

	private HtymService htymService;

	private String TALK_ID;
	private String INTRODUCTION;
	
	public void setHtymService(HtymService htymService) {
		this.htymService = htymService;
	}

	public void setTALK_ID(String tALKID) {
		TALK_ID = tALKID;
	}

	public void setINTRODUCTION(String iNTRODUCTION) {
		INTRODUCTION = iNTRODUCTION;
	}


	@Override
	public String execute() throws Exception {
		int count = htymService.updateTalkIntroduction(INTRODUCTION, NumberUtils.toInt(TALK_ID));
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("flag", count>0);
		setResult(resultMap);
		return JSONSUCCESS;
	}
}
