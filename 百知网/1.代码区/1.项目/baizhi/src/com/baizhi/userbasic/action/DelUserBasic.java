package com.baizhi.userbasic.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.userbasic.service.UserBasicService;
/**
 * 
 * 类名：UserBasicDel.java<br>
 * 描述： 删除用户基本信息表信息
 * 创建者：江红
 * 创建日期：2011-06-23 22:03:15
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class DelUserBasic extends ActionSupport{
	
	private static final long serialVersionUID = -2650055546798777099L;

	private String IDS;//用户信息表ID集合以","分隔
	
	private UserBasicService userBasicService;//用户基本信息表业务类
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public UserBasicService getUserBasicService() {
		return userBasicService;
	}

	public void setUserBasicService(UserBasicService userBasicService) {
		this.userBasicService = userBasicService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = userBasicService.deleteUserBasic(IDS);
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