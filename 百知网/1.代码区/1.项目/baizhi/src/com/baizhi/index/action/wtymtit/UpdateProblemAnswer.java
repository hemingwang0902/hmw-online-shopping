package com.baizhi.index.action.wtymtit;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.WtymtitService;

/**
 * 类名： SaveProblemAnswer<br>
 * 描述：修改回复<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class UpdateProblemAnswer  extends ActionSupport{
	private static final long serialVersionUID = -7111402426373474889L;
	private WtymtitService wtymtitService;
	private String ANSWER_ID;
	private String CONTENT; 
	
	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}

	public void setANSWER_ID(String aNSWERID) {
		ANSWER_ID = aNSWERID;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	@Override
	public String execute() throws Exception {
		int answerId = NumberUtils.toInt(ANSWER_ID);
		if(answerId > 0){
			// 查询结果列表
			Map<String, Object> returnMap = new HashMap<String, Object>();
			int count = wtymtitService.updateAnswer(answerId, StringUtils.trimToEmpty(CONTENT));
			returnMap.put("flag", count>0);
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
