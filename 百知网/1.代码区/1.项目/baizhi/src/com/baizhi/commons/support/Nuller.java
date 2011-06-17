package com.baizhi.commons.support;

import java.io.Serializable;
import java.util.Map;

import org.dom4j.Element;

/**
 * 类名：Nuller.java<br>
 * 描述：空支持类<br>
 * 创建者：江红<br>
 * 创建日期：2010-8-9<br>
 * 版本：<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class Nuller implements Serializable {

	private static final long serialVersionUID = -9156316333984609630L;
	
	protected Nuller() {
	}

	/**
	 * 将值设置到实体中
	 * 
	 * @param element 实体
	 * @param name 字段名
	 * @param value 值
	 */
	public static void notNullSet(Element element, String name, Object value) {
		notNullSet(element, name, value, null);
	}

	/**
	 * 将值设置到实体中
	 * 
	 * @param element 实体
	 * @param name 字段名
	 * @param value 值
	 * @param defaultValue 默认值
	 */
	public static void notNullSet(Element element, String name, Object value, String defaultValue) {
		if (element.element(name) == null) {
			element.addElement(name);
		}
		if (value instanceof Integer || value instanceof Long) {
			if (Integer.parseInt(value + "") != 0 || Long.parseLong(value + "") != 0) {// 如果值不为零
				element.element(name).setText(value + "");
			}
		} else if (value instanceof Float || value instanceof Double) {
			if (Float.parseFloat(value + "") != 0 || Double.parseDouble(value + "") != 0) {// 如果值不为零
				element.element(name).setText(value + "");
			}
		} else if (value instanceof String) {
			if (value != null && !(value + "").equals("") && !(value + "").equalsIgnoreCase("null")) {// 如果不为空
				element.element(name).setText(value + "");
			}
		} 
//		else if (value instanceof SerializableClob) { // 如果为大文本类型字段
//			SerializableClob sClob = (SerializableClob) value;
//			try {
//				Reader reader = sClob.getCharacterStream();
//				StringBuffer sb = new StringBuffer();
//				int len = 0;
//				while ((len = reader.read()) != -1) {
//					sb.append((char) len);
//				}
//				element.element(name).setText(sb.toString());
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		if (defaultValue != null && (value == null || (value + "").equals("") || (value + "").equals("0") || (value + "").equalsIgnoreCase("null"))) { // 如果缺省值不为空且当前元素节点值为空，则设置缺省值
			element.element(name).setText(defaultValue);
		}
	}

	/**
	 * 从实体中取得长整型的值
	 * 
	 * @param element 实体
	 * @param name 字段名
	 * @return 长整型的值
	 */
	public static long getLong(Element element, String name) {
		if (element == null) { // 如果实体对象为空
			return 0;
		}
		return getLong(element.elementText(name));
	}

	/**
	 * 转换指定的对象值，如果为空或“null”串，则返回“”串
	 * 
	 * @param obj 要转换的对象
	 * @return 如果对象为空或“null”串，则返回“”串
	 */
	public static String null2Str(Object obj) {
		return null2Str(obj + "");
	}

	/**
	 * 转换指定的字符串，如果为空或“null”串，则返回“”串
	 * 
	 * @param str 要转换的字符串
	 * @return 如果字符串为空或“null”串，则返回“”串
	 */
	public static String null2Str(String str) {
		if (str == null || str.equalsIgnoreCase("null")) { // 如果指定的字符串为空或“null”串
			str = "";
		}
		return str;
	}

	/**
	 * 转换指定的字符串，如果为空或空串,则返回带空格的串
	 * 
	 * @param str 要转换的字符串
	 * @return 带空格的串
	 */
	public static String null2Space(String str) {
		if (str == null || str.equals("") || str.equalsIgnoreCase("null")) {
			str = "　";
		}
		return str;
	}

	public static String getString(Object value) {
		return getString(value + "", "");
	}

	public static String getString(String value, String defaultValue) {
		if (value != null && !value.equals("") && !value.equalsIgnoreCase("null")) {
			return value.trim();
		}
		return defaultValue;
	}

	public static int getInt(Object value) {
		Integer result = null;
		try {
			result = Integer.parseInt(value + "");
		} catch (NumberFormatException e) {
		}
		return getInt(result, 0);
	}

	public static int getInt(int value, int defaultValue) {
		if (value <= 0) {
			return defaultValue;
		}
		return value;
	}

	public static long getLong(Object value) {
		Long result = null;
		try {
			result = Long.parseLong(value + "");
		} catch (NumberFormatException e) {
		}
		return getLong(result, 0);
	}

	public static long getLong(Long value, long defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		return value.longValue();
	}

	public static float getFloat(Object value) {
		Float result = null;
		try {
			result = Float.parseFloat(value + "");
		} catch (NumberFormatException e) {
		}
		return getFloat(result, 0.0f);
	}

	public static float getFloat(Float value, float defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		return value.floatValue();
	}

	public static double getDouble(Object value) {
		Double result = null;
		try {
			result = Double.parseDouble(value + "");
		} catch (NumberFormatException e) {
		}
		return getDouble(result, 0.0);
	}

	public static double getDouble(Double value, double defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		return value.doubleValue();
	}

	public static boolean getBoolean(Object value) {
		Boolean result = null;
		try {
			result = Boolean.parseBoolean(value + "");
		} catch (NumberFormatException e) {
		}
		return getBoolean(result, false);
	}

	public static boolean getBoolean(Boolean value, boolean defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		return value == Boolean.TRUE;
	}
	/**
	 * 清理map中的null值
	 * @param map
	 * @return
	 */
	public static Map<String, Object> clearMapNull(Map<String,Object> map){
		if (map == null) {
			return 	map;
		}
    	for(String key:map.keySet()){
    		if(map.get(key)==null){
    			map.put(key, "");
    		}
    	}
    	return map;
    }
}
