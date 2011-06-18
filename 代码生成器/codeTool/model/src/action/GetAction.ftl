package com.${sysName}.${packageName}.action;

import java.util.Map;
import com.${sysName}.commons.ActionSupport;
import com.${sysName}.${packageName}.service.${className}Service;


/**
 * 
 * 类名：${className}Load.java
 * 描述： ${tabCon}控制类，获取${tabCon}操作
 * 创建者：${auth}
 * 创建日期： ${createDate}
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class Get${className} extends ActionSupport{

<#list lis as being>
	private String ${being.oldCl};//${being.content}
</#list>

	private ${className}Service  ${packageName}Service;
	
	private String  ${packageName}_id ;
	
	public String get${className}_id() {
		return ${packageName}_id;
	}


	public void set${className}_id(String ${packageName}_id) {
		this.${packageName}_id = ${packageName}_id;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String,Object> ${packageName}Map =null;
		try {
			${packageName}Map = ${packageName}Service.get${className}(${packageName}_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(${packageName}Map!=null){
<#list lis as being>
			this.${being.oldCl} = (String)${packageName}Map.get("${being.oldCl}");
</#list>
		}
		return SUCCESS;
	}

	public ${className}Service get${className}Service() {
		return ${packageName}Service;
	}

	public void set${className}Service(${className}Service ${packageName}Service) {
		this.${packageName}Service = ${packageName}Service;
	}

<#list lis as being>
	public String get${being.oldCl}() {
		return ${being.oldCl};
	}

	public void set${being.oldCl}(String ${being.oldCl}) {
		this.${being.oldCl} = ${being.oldCl};
	}
	
</#list>
	
}
