package com.baizhi.commons;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * 类名：ParametersSupport<br>
 * 描述：参数支持类<br>
 * 创建者：江红 <br>
 * 创建日期： 2011-3-30<br>
 * 版本：V0.9 <br>
 * 修改者：       何明旺 <br>
 * 修改日期：   2011-06-20<br>
 */
public class ParametersSupport {
	//条件
	private String conditions;
	// 用 OR 关键词连接的条件 --何明旺 2011-06-20
	private StringBuffer orConditions;
	
	//参数条件值
	private Object[] values;
	
	public ParametersSupport(Map<String, Object> params){
		StringBuffer cond = new StringBuffer();
		orConditions = new StringBuffer();
		List<Object> list=new ArrayList<Object>();
		//循环设置值
		Map.Entry<String, Object> entry;
		for (Iterator<Map.Entry<String, Object>> iter = params.entrySet().iterator(); iter.hasNext();) {
			entry = iter.next();
			if(StringUtils.isNotBlank(entry.getKey())){
				cond.append(" AND ").append(entry.getKey()).append(" ");
				orConditions.append(" OR ").append(entry.getKey()).append(" ");
				if (entry.getValue() instanceof Object[]) {
					Object[] tempobject = (Object[])entry.getValue();
					for (int i = 0; i < tempobject.length; i++) {
						list.add(tempobject[i]);
					}
				}else{
					list.add(entry.getValue());
				}
				
			}
		}
		conditions=cond.toString();
		//设置参数条件数组值
		values = list.toArray();
	};
	
	public String getConditions() {
		return conditions;
	}

	public String getOrConditions() {
		return orConditions.toString();
	}

	public Object[] getValues() {
		return values;
	}

}
