package com.baizhi.userdynamic.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userdynamic.service.UserDynamicService;

/**
 * 类名： ModifyIsOpen.java<br>
 * 描述：修改是否打开<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-16 下午03:51:14<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class ModifyIsOpen extends ActionSupport{
	
	private static final long serialVersionUID = -3973330327957254231L;

	private UserDynamicService userDynamicService;//用户动态信息表业务类
	
	private Integer DYNAMIC_ID;
	
	public UserDynamicService getUserDynamicService() {
		return userDynamicService;
	}
	
	public void setUserDynamicService(UserDynamicService userDynamicService) {
		this.userDynamicService = userDynamicService;
	}
	
	public Integer getDYNAMIC_ID() {
		return DYNAMIC_ID;
	}

	public void setDYNAMIC_ID(Integer dynamic_id) {
		DYNAMIC_ID = dynamic_id;
	}

	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		int count=-1;
		String message="";
		boolean flag=false;
		//判断参数是否为空
		if(DYNAMIC_ID!=null&&DYNAMIC_ID>0){
			count=userDynamicService.ModifyIsOpen(DYNAMIC_ID);
			if(count>0){
				flag=true;
			}
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}

}