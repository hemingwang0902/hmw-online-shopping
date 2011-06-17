package com.${sysName}.${packageName}.action;

import java.net.URLDecoder;
import java.util.Map;
import java.util.HashMap;
import com.commons.ActionSupport;
import com.${sysName}.${packageName}.service.${className}Service;

/**
 * 类名： ${className}List.java<br>
 * 描述： ${tabCon}控制类,查询${tabCon}列表
 * 创建者：${auth}
 * 创建日期： ${createDate}
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class ${className}List extends ActionSupport {
	
	private int nowPage;//当前页
	private int onePageCount;//每页显示多少条
	<#list lis as being>
	private String ${being.oldCl};//${being.content}
	</#list>
	
	private ${className}Service ${packageName}Service;

	@Override
	public String execute() throws Exception {
		Map<String,String> param=new HashMap<String,String>();
		//查询${tabCon}列表
		<#list lis as being>
		this.set${being.oldCl}(URLDecoder.decode(this.get${being.oldCl}(),"UTF-8"));//${being.content}
		</#list>
		<#list lis as being>
		param.put("${being.oldCl}",${being.oldCl});
		</#list>
		Map<String,Object> ${packageName}Map = ${packageName}Service.${packageName}List(param,nowPage,onePageCount);
		if(${packageName}Map!=null && ${packageName}Map.size()!=0){
			this.setResult(${packageName}Map);
		}
		return JSONSUCCESS;
	}
	
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getOnePageCount() {
		return onePageCount;
	}

	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
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