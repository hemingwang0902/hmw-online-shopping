package com.baizhi.index.action.wdzx;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userbasic.service.UserBasicService;
import com.baizhi.userprivate.service.UserPrivateService;

/**
 * 类名： InitWdzxDetailForm.java<br>
 * 描述：<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-10 上午01:51:02<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class InitWdzxDetailForm  extends ActionSupport{
	
	private static final long serialVersionUID = 4984317974097905083L;
	
	private UserBasicService userBasicService;//用户基本信息表业务类
	
	private UserPrivateService userPrivateService;
	
	Map<String, Object>  returnMap;
	
	public UserBasicService getUserBasicService() {
		return userBasicService;
	}

	public void setUserBasicService(UserBasicService userBasicService) {
		this.userBasicService = userBasicService;
	}
	
	public UserPrivateService getUserPrivateService() {
		return userPrivateService;
	}

	public void setUserPrivateService(UserPrivateService userPrivateService) {
		this.userPrivateService = userPrivateService;
	}
	
	private Integer SEND_ID;
	
	private Integer NO_PRIVATE_COUNT;
	
	public void setSEND_ID(Integer send_id) {
		SEND_ID = send_id;
	}
	
	public Integer getSEND_ID() {
		return SEND_ID;
	}

	public Map<String, Object> getReturnMap() {
		return returnMap;
	}

	public void setReturnMap(Map<String, Object> returnMap) {
		this.returnMap = returnMap;
	}
	
	public Integer getNO_PRIVATE_COUNT() {
		return NO_PRIVATE_COUNT;
	}

	public void setNO_PRIVATE_COUNT(Integer no_private_count) {
		NO_PRIVATE_COUNT = no_private_count;
	}

	@Override
	public String execute() throws Exception {
		//修改未阅读记录数
		if(NO_PRIVATE_COUNT>0){
			returnMap=userPrivateService.ModifyNoReadPrivate(this.getSessionUserId(), SEND_ID);
		}else{
			//获取基本信息
			Map<String, Object>  params=new HashMap<String, Object>();
			params.put("USER_ID=?", SEND_ID);
			returnMap = userBasicService.getUserBasicMapById(params);
		}
		return SUCCESS;
	}
}