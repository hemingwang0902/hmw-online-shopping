package com.baizhi.score.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.score.service.ScoreService;
/**
 * 
 * 类名：ScoreDel.java<br>
 * 描述： 是否禁用
 * 创建者：江红
 * 创建日期：2011-08-07 18:51:46
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class DelScore extends ActionSupport{
	
	private static final long serialVersionUID = 2358198313833957284L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private Integer IS_VALID;
	
	private ScoreService scoreService;//积分信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	public Integer getIS_VALID() {
		return IS_VALID;
	}

	public void setIS_VALID(Integer is_valid) {
		IS_VALID = is_valid;
	}

	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//禁用
			if(IS_VALID==0){
				IS_VALID=1;
			}else{
				IS_VALID=0;
			}
			boolean result = scoreService.deleteScore(IDS,IS_VALID);
			//判断删除是否成功
			if(result){
				flag=true;
				message="积分禁用成功";
			}else{
				message="积分禁用失败";
			}
		}else{
			message="请选择要禁用的积分";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}