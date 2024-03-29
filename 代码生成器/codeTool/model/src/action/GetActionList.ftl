package com.${sysName}.${packageName}.action;

import java.util.HashMap;
import java.util.Map;
import com.${sysName}.${packageName}.service.${className}Service;

/**
 * 类名： ${className}List.java<br>
 * 描述：  获取${tabCon}列表信息<br>
 * 创建者：${auth}<br>
 * 创建日期： ${createDate}<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class Get${className}List extends ${className}Form {
	
	private ${className}Service ${beanname}Service;//${tabCon}业务类
	
	public ${className}Service get${className}Service() {
		return ${beanname}Service;
	}

	public void set${className}Service(${className}Service ${beanname}Service) {
		this.${beanname}Service = ${beanname}Service;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		<#list lis as being>
		this.setMap(params, "${being.oldCl}=?", this.get${being.oldCl}());// ${being.content}
		</#list>
		// 查询${tabCon}列表
		Map<String, Object> returnMap = ${beanname}Service.get${className}List(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}