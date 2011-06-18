package com.baizhi.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * 类名：ParametersSupport<br>
 * 描述：参数支持类<br>
 * 创建者：江红 <br>
 * 创建日期： 2011-3-30<br>
 * 版本：V0.9 <br>
 * 修改者：        <br>
 * 修改日期：   <br>
 */
public class ParametersSupport {
	//条件
	private String conditions;
	
	//参数条件值
	private Object[] values;
	
	public ParametersSupport(Map<String, Object> params){
		List<Object> list=new ArrayList<Object>();
		//循环设置值
		for (Map.Entry<String, Object> entry:params.entrySet()) {
			if(entry.getKey()!=null&&entry.getKey().trim().equals("")){
				conditions+=" AND "+entry.getKey()+" ";
				list.add(entry.getValue());
			}
		}
		//设置参数条件数组值
		if(list.size()>0){
			int len=list.size();
			values=new Object[len];
			for (int i = 0; i < len; i++) {
				values[i]=list.get(i);
			}
		}
	};
	
	
	

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public Object[] getValues() {
		return values;
	}

	public void setValues(Object[] values) {
		this.values = values;
	}
	
	
}
