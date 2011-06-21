package com.baizhi.scorelevel.action;

import java.util.Map;
import com.baizhi.scorelevel.service.ScoreLevelService;
/**
 * 
 * 类名：GetScoreLevelById.java
 * 描述： 获取单条积分级别信息表表单信息
 * 创建者：江红
 * 创建日期： 2011-06-21 00:43:41
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetScoreLevelById extends ScoreLevelForm{
	
	private ScoreLevelService scoreLevelService;//积分级别信息表业务类
	
	public ScoreLevelService getScoreLevelService() {
		return scoreLevelService;
	}

	public void setScoreLevelService(ScoreLevelService scoreLevelService) {
		this.scoreLevelService = scoreLevelService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = scoreLevelService.getScoreLevelMapById(this.getSCORELEVEL_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setNAME(this.getValue(returnMap,"NAME"));// 级别名称
			this.setSOCRE_UP(this.getValue(returnMap,"SOCRE_UP"));// 积分上限
			this.setSOCRE_DOWN(this.getValue(returnMap,"SOCRE_DOWN"));// 积分下限
			this.setREMARK(this.getValue(returnMap,"REMARK"));// 备注
		}
		return SUCCESS;
	}
	
}
