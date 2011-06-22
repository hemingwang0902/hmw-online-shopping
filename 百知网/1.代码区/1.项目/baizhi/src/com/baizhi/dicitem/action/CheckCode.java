package com.baizhi.dicitem.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.dicitem.service.DicitemService;
/**
 * 
 * 类名：GetDicitemById.java
 * 描述： 获取单条字典列表清单表单信息
 * 创建者：江红
 * 创建日期： 2011-06-20 21:02:57
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class CheckCode  extends DicitemForm{
	
	private static final long serialVersionUID = 8708989185009835599L;
	
	private DicitemService dicitemService;//字典列表清单业务类
	
	public DicitemService getDicitemService() {
		return dicitemService;
	}

	public void setDicitemService(DicitemService dicitemService) {
		this.dicitemService = dicitemService;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		//设置参数
		Map<String, Object> params = new HashMap<String, Object>();
		
		this.setMap(params, "DIC_CODE=?", this.getDIC_CODE());//字典代码
		this.setMap(params, "CODE=?", this.getCODE());//列表字典代码
		this.setMap(params, "DICITEM_ID<>?", this.getDICITEM_ID());//字典清单ID
		
		int count=dicitemService.getDicitemCount(params);
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
