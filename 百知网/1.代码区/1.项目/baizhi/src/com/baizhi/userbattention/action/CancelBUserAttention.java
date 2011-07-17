package com.baizhi.userbattention.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userbattention.service.UserBattentionService;

/**
 * 类名： CancelBUserAttention.java<br>
 * 描述：<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午03:52:16<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class CancelBUserAttention  extends ActionSupport{
	
	private static final long serialVersionUID = 5111685027045665296L;

	private Integer BRAND_ID;
	
	private UserBattentionService userBattentionService;//用户关注品牌信息表业务类
	
	
	public Integer getBRAND_ID() {
		return BRAND_ID;
	}

	public void setBRAND_ID(Integer brand_id) {
		BRAND_ID = brand_id;
	}

	public UserBattentionService getUserBattentionService() {
		return userBattentionService;
	}

	public void setUserBattentionService(UserBattentionService userBattentionService) {
		this.userBattentionService = userBattentionService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//取消关注
		boolean result = userBattentionService.cancel(BRAND_ID,this.getSessionUserId());
		//判断删除是否成功
		if(result){
			flag=true;
			message="取消关注成功";
		}else{
			message="取消关注失败";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}