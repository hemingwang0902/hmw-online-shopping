package com.${sysName}.${packageName}.action;

import java.util.HashMap;
import java.util.Map;
import com.${sysName}.commons.ActionSupport;
import com.${sysName}.${packageName}.service.${className}Service;
/**
 * 
 * 类名：${className}Del.java<br>
 * 描述： 删除${tabCon}信息
 * 创建者：${auth}
 * 创建日期：${createDate}
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class Del${className} extends ActionSupport{
	
	private String IDS;//用户信息表ID集合以","分隔
	
	private ${className}Service ${packageName}Service;
	
	public String getIDS() {
		return IDS;
	}

	public void setIDS(String ids) {
		IDS = ids;
	}
	
	public ${className}Service get${className}Service() {
		return ${packageName}Service;
	}

	public void set${className}Service(${className}Service ${packageName}Service) {
		this.${packageName}Service = ${packageName}Service;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> returnmap=new HashMap<String, Object>();
		boolean flag=false;
		String message="";
		//判断参数是否为空
		if(IDS!=null&&!IDS.trim().equals("")){
			//删除用户
			boolean result = ${packageName}Service.delete${className}(IDS);
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