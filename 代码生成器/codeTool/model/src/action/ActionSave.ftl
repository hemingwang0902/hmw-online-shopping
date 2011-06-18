package com.${sysName}.${packageName}.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import org.apache.commons.lang.StringUtils;
import com.${sysName}.commons.ActionSupport;
import com.${sysName}.commons.support.Elements;
import com.${sysName}.${packageName}.service.${className}Service;
/**
 * 
 * 类名：${className}Save.java
 * 描述： ${tabCon}控制类，负责处理新增、修改操作
 * 创建者：${auth}
 * 创建日期： ${createDate}
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class ${className}Save extends ActionSupport{
	<#list lis as being>
	private String ${being.oldCl};//${being.content}
	</#list>

	private ${className}Service  ${packageName}Service;
	

	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果用户ID为0，则为新增${tabCon}，否则更新${tabCon}
		if(StringUtils.isNotEmpty(${packageNameUpperCase}_ID)){
			element = ${packageName}Service.get${className}ElementById("${packageNameUpperCase}_ID");
			<#list lis as being>
			Elements.setElementValue(element, "${being.oldCl}", ${being.oldCl});
			</#list>
			
			//如果保存成功，返回主键
			keyid = ${packageName}Service.edit${className}(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("${tabCon}信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("${tableName}");
			<#list lis as being>
			Elements.setElementValue(element, "${being.oldCl}", ${being.oldCl});
			</#list>
			//如果保存成功，返回主键
			keyid = ${packageName}Service.add${className}(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		
		return ERROR;
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
