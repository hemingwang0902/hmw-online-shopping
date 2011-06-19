package com.${sysName}.${packageName}.action;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.${sysName}.commons.support.Elements;
import com.${sysName}.commons.support.StringUtils;
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
public class Save${className} extends ${className}Form{
	
	private ${className}Service ${packageName}Service;//${tabCon}业务类
	
	public ${className}Service get${className}Service() {
		return ${packageName}Service;
	}

	public void set${className}Service(${className}Service ${packageName}Service) {
		this.${packageName}Service = ${packageName}Service;
	}
	
	@Override
	public String execute() throws Exception {
		Element element = null;
		String keyid="";
		//如果${tabCon}ID为""，则为新增${tabCon}，否则更新${tabCon}
		if(StringUtils.isNotEmpty(this.get${PK_KEY}())){
			element = ${packageName}Service.get${className}EleById("${PK_KEY}");
			<#list lis as being>
			Elements.setElementValue(element, "${being.oldCl}", this.get${being.oldCl}());// ${being.content}
			</#list>
			
			//如果保存成功，返回主键
			keyid = ${packageName}Service.saveOrUpdate${className}(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				this.setMessage("${tabCon}信息编辑成功");
				return UPDATESUCCESS;
			}
		}else{
			element = new DefaultElement("${tableName}");
			<#list lis as being>
			<#if being.columnkey != "PRI">
			Elements.setElementValue(element, "${being.oldCl}", this.get${being.oldCl}());// ${being.content}
			</#if>
			</#list>
			//如果保存成功，返回主键
			keyid = ${packageName}Service.saveOrUpdate${className}(element);
			//判断主键是否为空，如果不为空，则保存成功
			if(StringUtils.isNotEmpty(keyid)){
				return SUCCESS;
			}
		}
		return ERROR;
	}

}
