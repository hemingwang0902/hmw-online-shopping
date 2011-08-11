package com.baizhi.index.action.wtymtit;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.IConstants;
import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.WtymtitService;

/**
 * 类名： AddTalkForProblem<br>
 * 描述：给问题添加话题<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-14<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AddBrandForProblem  extends ActionSupport{
	private static final long serialVersionUID = 1043837136096166859L;

	private WtymtitService wtymtitService;
	
	private String PROBLEM_ID;
	private String BRAND_ID;

	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}

	public void setPROBLEM_ID(String pROBLEMID) {
		PROBLEM_ID = pROBLEMID;
	}

	public void setBRAND_ID(String bRANDID) {
		BRAND_ID = bRANDID;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		int problemId = NumberUtils.toInt(PROBLEM_ID);
		int brandId = NumberUtils.toInt(BRAND_ID);
		if(problemId > 0 && brandId > 0){
			wtymtitService.addTalkForProblem(problemId, brandId, IConstants.TALK_TYPE_BRAND);
			returnMap.put("flag", true);
		}else{
			returnMap.put("flag", false);
		}
		setResult(returnMap);
		return JSONSUCCESS;
	}
}
