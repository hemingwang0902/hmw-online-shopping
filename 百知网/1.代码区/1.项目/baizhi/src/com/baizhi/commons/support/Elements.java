package com.baizhi.commons.support;

import java.io.Serializable;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;


/**
 * 类名：Elements.java<br>
 * 描述：Element支持类<br>
 * 创建者：江红<br>
 * 创建日期：2011-3-10 下午22:20:36<br>
 * 版本：<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class Elements implements Serializable {

	private static final long serialVersionUID = -6189002030001331890L;

	protected Elements() {
	}

	/**
	 * 将值设置到实体中
	 * @param element 实体
	 * @param name    字段名
	 * @param value   值
	 */
	public static void setElementValue(Element element, String name, Object value) {
		if (element.element(name) == null) {
			element.addElement(name);
		}
		if (value instanceof Integer || value instanceof Long) {
			element.element(name).setText(value + "");
		} else if (value instanceof Float || value instanceof Double) {
			element.element(name).setText(value + "");
		} else if (value instanceof String) {
			if (value != null  ) {// 如果不为空
				element.element(name).setText(value + "");
			}
		} else if (value==null){
			Element element1 = element.element(name);
			element.remove(element1);
		}
	}
	
	/**
	 * 实例化Element对象
	 * @param tableName 表名
	 * @return 返回Element对象
	 */
	public static Element getInstance(String tableName){
		return new DefaultElement(tableName);
	}
	

}
