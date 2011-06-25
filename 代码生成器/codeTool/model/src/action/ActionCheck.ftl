package com.${sysName}.${packageName}.action;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import com.${sysName}.commons.ActionSupport;
import com.${sysName}.${packageName}.service.${className}Service;

/**
 * 类名：${className}Check.java<br>
 * 描述： ${tabCon}控制类，负责处理效验${tabCon}是否存在<br>
 * 创建者：${auth}<br>
 * 创建日期： ${createDate}<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class ${className}Check extends ActionSupport{
	private String ID; //主键ID
	private String NAMES; //名称
	private ${className}Service ${packageName}Service;
	
	@Override
	public String execute() throws Exception {
			Map<String,Object> map=new HashMap<String, Object>();
			boolean flag = ${packageName}Service.check${className}(ID, URLDecoder.decode(NAMES,"UTF-8"));
			map.put("flag", flag);
			map.put("message", "${tabCon}已经存在,请重新输入");
			this.setResult(map);
			return JSONSUCCESS;
	}

	public String getID() {
		return ID;
	}

	public void setID(String id) {
		ID = id;
	}

	public String getNAMES() {
		return NAMES;
	}

	public void setNAMES(String names) {
		NAMES = names;
	}

	public ${className}Service get${className}Service() {
		return ${packageName}Service;
	}

	public void set${className}Service(${className}Service ${packageName}Service) {
		this.${packageName}Service = ${packageName}Service;
	}
	
	
}
