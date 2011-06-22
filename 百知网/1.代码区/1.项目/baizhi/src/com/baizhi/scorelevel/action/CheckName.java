package com.baizhi.scorelevel.action;

import java.util.HashMap;
import java.util.Map;

import com.baizhi.scorelevel.service.ScoreLevelService;

/**
 * 
 * 类名：CheckName.java
 * 描述：验证积分名称不能为空
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class CheckName extends ScoreLevelForm{
	
	private static final long serialVersionUID = 5636405806647477216L;
	
	private ScoreLevelService scoreLevelService;//积分级别信息表业务类
	
	public ScoreLevelService getScoreLevelService() {
		return scoreLevelService;
	}

	public void setScoreLevelService(ScoreLevelService scoreLevelService) {
		this.scoreLevelService = scoreLevelService;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		//设置参数
		Map<String, Object> params = new HashMap<String, Object>();
		
		this.setMap(params, "NAME=?", this.getNAME());//级别名称
		
		this.setMap(params, "SCORELEVEL_ID<>?", this.getSCORELEVEL_ID());//积分级别ID
		
		int count=scoreLevelService.getScoreLevelCount(params);
		if(count>0){
			returnMap.put("flag", false);
			returnMap.put("message", "积别名称不能重复,请重新输入");
		}else{
			returnMap.put("flag", true);
		}
		this.setResult(returnMap);
		return JSONSUCCESS;
	}

}

