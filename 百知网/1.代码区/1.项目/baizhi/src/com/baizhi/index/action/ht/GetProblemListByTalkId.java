package com.baizhi.index.action.ht;

import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HtymService;

/**
 * 类名： GetProblemListByTalkId<br>
 * 描述：根据话题ID查询话题下的问题<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetProblemListByTalkId extends ActionSupport{
	private static final long serialVersionUID = -4184402561436174968L;
	private HtymService htymService;
	private String TALK_ID;

	public void setHtymService(HtymService htymService) {
		this.htymService = htymService;
	}

	public void setTALK_ID(String tALKID) {
		TALK_ID = tALKID;
	}

	@Override
	public String execute() throws Exception {
		int talkId = NumberUtils.toInt(TALK_ID);
		if(talkId > 0){
			Map<String, Object> jsonMap = htymService.getProblemListByTalkId(talkId, getNowPage(), getOnePageCount());
			setResult(jsonMap);
		}
		return JSONSUCCESS;
	}

}
