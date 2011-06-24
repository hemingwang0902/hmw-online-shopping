package com.baizhi.dicitem.action;

import java.util.HashMap;
import java.util.Map;

import com.baizhi.commons.component.PinyinUtils;
/**
 * 类名： GetPinyin<br>
 * 描述：获取全拼和首拼<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-6-25<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetPinyin  extends DicitemForm{
	
	private static final long serialVersionUID = 1027620389519752764L;

	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		returnMap.put("ALLPIN", PinyinUtils.getQuanPin(this.getDIC_NAME()).toUpperCase());
		returnMap.put("SIMPLEPIN", PinyinUtils.getShouPin(this.getDIC_NAME()).toUpperCase());
		this.setResult(returnMap);
		return JSONSUCCESS;
	}
}
