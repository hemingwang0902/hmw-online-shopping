package com.baizhi.score.action;

import java.util.Map;
import com.baizhi.score.service.ScoreService;
/**
 * 
 * 类名：GetScoreById.java
 * 描述： 获取单条积分信息表表单信息
 * 创建者：江红
 * 创建日期： 2011-08-07 18:51:46
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetScoreById extends ScoreForm{
	
	private static final long serialVersionUID = -3109257037273576095L;
	
	private ScoreService scoreService;//积分信息表业务类
	
	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = scoreService.getScoreMapById(this.getSCORE_ID());
		if(returnMap!=null&&returnMap.size()>0){
			this.setNAME(this.getValue(returnMap,"NAME"));// 积分名称
			// 积分类型(1、会员邀请朋友注册获得积分2、提问题3、回答问题)
			if(this.getValue(returnMap,"SOCRE_TYPE").equals("1")){
				this.setSOCRE_TYPE("邀请朋友");
			}else if(this.getValue(returnMap,"SOCRE_TYPE").equals("2")){
				this.setSOCRE_TYPE("提问题");
			}else if(this.getValue(returnMap,"SOCRE_TYPE").equals("3")){
				this.setSOCRE_TYPE("回答问题");
			}
			
			this.setSOCRE(this.getValue(returnMap,"SOCRE"));// 积分
			this.setIS_VALID(this.getValue(returnMap,"IS_VALID"));// 是否禁用
			this.setREMARK(this.getValue(returnMap,"REMARK"));// 备注
		}
		return SUCCESS;
	}
	
}
