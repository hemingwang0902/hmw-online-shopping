package com.baizhi.scorelevel.action;

import java.util.HashMap;
import java.util.Map;

import com.baizhi.scorelevel.service.ScoreLevelService;

/**
 * 
 * 类名：CheckScore.java
 * 描述：验证积分区间段不重复
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class CheckScore extends ScoreLevelForm{
	
	private static final long serialVersionUID = 637405631897506297L;
	
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
		if((!this.getSOCRE_UP().trim().equals("")&&this.getSOCRE_DOWN().trim().equals(""))||(this.getSOCRE_UP().trim().equals("")&&!this.getSOCRE_DOWN().trim().equals(""))){
			if(!this.getSOCRE_UP().trim().equals("")){
				this.setMap(params, "? between SOCRE_UP and SOCRE_DOWN", this.getSOCRE_UP());//积分上限
			}else{
				this.setMap(params, "? between SOCRE_UP and SOCRE_DOWN", this.getSOCRE_DOWN());//积分下限
			}
		}else{
			if(!this.getSOCRE_UP().trim().equals("")&&!this.getSOCRE_DOWN().trim().equals("")){
				Object[] object=new Object[]{this.getSOCRE_UP(),this.getSOCRE_DOWN(),this.getSOCRE_UP(),this.getSOCRE_DOWN()};
				this.setMap(params, "((SOCRE_UP between ? and ?) or (SOCRE_DOWN between ? and ?))", object);
			}
		}
		
		
		this.setMap(params, "SCORELEVEL_ID<>?", this.getSCORELEVEL_ID());//积分级别ID
		
		int count=scoreLevelService.getScoreLevelCount(params);
		if(count>0){
			returnMap.put("flag", false);
			returnMap.put("message", "积分区间不能重复,请重新输入");
		}else{
			returnMap.put("flag", true);
		}
		this.setResult(returnMap);
		return JSONSUCCESS;
	}

}
