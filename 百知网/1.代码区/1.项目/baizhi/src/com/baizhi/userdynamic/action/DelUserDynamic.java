package com.baizhi.userdynamic.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userdynamic.service.UserDynamicService;
/**
 * 
 * 类名：UserDynamicDel.java<br>
 * 描述： 删除用户动态信息表信息
 * 创建者：江红
 * 创建日期：2011-07-05 00:34:20
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class DelUserDynamic extends ActionSupport{
	
	private static final long serialVersionUID = 5147937370847165881L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private UserDynamicService userDynamicService;//用户动态信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public UserDynamicService getUserDynamicService() {
		return userDynamicService;
	}

	public void setUserDynamicService(UserDynamicService userDynamicService) {
		this.userDynamicService = userDynamicService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = userDynamicService.deleteUserDynamic(IDS);
			//判断删除是否成功
			if(result){
				flag=true;
				message="用户删除成功";
			}else{
				message="用户删除失败";
			}
		}else{
			message="请选择要删除的用户";
		}
		returnmap.put("flag", flag);
		returnmap.put("message", message);
		this.setResult(returnmap);
		return JSONSUCCESS;
	}
	
}