package com.${sysName}.${packageName}.action;

import com.${sysName}.commons.ActionSupport;

/**
 * 类名： ${className}List.java<br>
 * 描述：  获取${tabCon}列表信息<br>
 * 创建者：${auth}<br>
 * 创建日期： ${createDate}<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public abstract class ${className}Form extends ActionSupport {
	
	<#list lis as being>
	private String ${being.oldCl};//${being.content}
	</#list>
	
	<#list lis as being>
	public String get${being.oldCl}() {
		return ${being.oldCl};
	}

	public void set${being.oldCl}(String ${being.oldCl}) {
		this.${being.oldCl} = ${being.oldCl};
	}
	
	</#list>
}