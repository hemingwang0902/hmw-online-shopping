package com.${sysName}.${packageName}.action;

import java.util.HashMap;
import java.util.Map;

import com.${sysName}.commons.ActionSupport;
import com.${sysName}.${packageName}.service.${className}Service;

/**
 * 
 * 类名：${className}Del.java<br>
 * 描述： ${tabCon}控制类,删除${tabCon}操作
 * 创建者：${auth}
 * 创建日期： ${createDate}
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class ${className}Del extends ActionSupport{
	
	private String ID;
	private ${className}Service ${packageName}Service;
	
	@Override
	public String execute() throws Exception {
		if(ID==null||ID.trim().equals("")){
			return ERROR;
		}
		//删除${tabCon}
		boolean result = ${packageName}Service.delete${className}(ID);
		Map<String,Object> userMap=new HashMap<String, Object>();
		if(result){
			userMap.put("flag", true);
			userMap.put("message", "${tabCon}删除成功");
		}else{
			userMap.put("flag", false);
			userMap.put("message", "${tabCon}删除失败");
		}
		this.setResult(userMap);
		return JSONSUCCESS;
	}

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		this.ID = id;
	}

	public ${className}Service get${className}Service() {
		return ${packageName}Service;
	}

	public void set${className}Service(${className}Service ${packageName}Service) {
		this.${packageName}Service = ${packageName}Service;
	}
}