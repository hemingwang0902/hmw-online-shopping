package com.baizhi.user.action;

import java.util.HashMap;
import java.util.Map;

import com.baizhi.commons.ActionSupport;

/**
 * 类名： AjaxRequest.java<br>
 * 描述：AJax请求跳转到登录页<br>
 * 创建者：江红<br>
 * 创建日期：2011-8-2 上午12:59:46<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AjaxRequest  extends ActionSupport{
	
	private static final long serialVersionUID = -1700778784977143586L;
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		//判断Session是否为空
		if(getSessionUserInfo()==null||getSessionUserInfo().size()<=0){
			returnMap.put("flag", true);
		}else{
			returnMap.put("flag", false);
		}
		this.setResult(returnMap);
		return JSONSUCCESS;
	}

}
