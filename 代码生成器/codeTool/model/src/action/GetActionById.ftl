package com.${sysName}.${packageName}.action;

import java.util.Map;
import com.${sysName}.${packageName}.service.${className}Service;
/**
 * 
 * 类名：Get${className}ById.java
 * 描述： 获取单条${tabCon}表单信息
 * 创建者：${auth}
 * 创建日期： ${createDate}
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class Get${className}ById extends ${className}Form{
	
	private ${className}Service ${packageName}Service;//${tabCon}业务类
	
	public ${className}Service get${className}Service() {
		return ${packageName}Service;
	}

	public void set${className}Service(${className}Service ${packageName}Service) {
		this.${packageName}Service = ${packageName}Service;
	}
	
	@Override
	public String execute() throws Exception {
		//查询数据
		Map<String, Object>  returnMap = ${packageName}Service.get${className}MapById(this.get${PK_KEY}());
		if(returnMap!=null&&returnMap.size()>0){
			<#list lis as being>
			<#if being.columnkey != "PRI">
			this.set${being.oldCl}(this.setValue(returnMap,"${being.oldCl}"));// ${being.content}
			</#if>
			</#list>
		}
		return SUCCESS;
	}
	
}
