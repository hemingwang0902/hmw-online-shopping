package com.baizhi.diclist.action;

import java.util.HashMap;
import java.util.Map;

import com.baizhi.diclist.service.DiclistService;

/**
 * 
 * 类名：CheckNode.java<br>
 * 描述： 验证字典代码不能为重复
 * 创建者：江红
 * 创建日期：2011-06-22 21:19:11
 * 版本：V0.9 
 * 修改者： 
 * 修改日期：
 */
public class CheckCode   extends DiclistForm {

	private static final long serialVersionUID = 1163142145931754060L;
	
	private DiclistService diclistService;//字典列表业务类
	
	public DiclistService getDiclistService() {
		return diclistService;
	}

	public void setDiclistService(DiclistService diclistService) {
		this.diclistService = diclistService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		//设置参数
		Map<String, Object> params = new HashMap<String, Object>();
		
		this.setMap(params, "CODE=?", this.getCODE());//字典代码
		
		this.setMap(params, "DICLIST_ID<>?", this.getDICLIST_ID());//字典列表ID
		
		int count=diclistService.getDiclistCount(params);
		if(count>0){
			returnMap.put("flag", false);
			returnMap.put("message", "字典代码不能重复,请重新输入");
		}else{
			returnMap.put("flag", true);
		}
		this.setResult(returnMap);
		return JSONSUCCESS;
	}

}
