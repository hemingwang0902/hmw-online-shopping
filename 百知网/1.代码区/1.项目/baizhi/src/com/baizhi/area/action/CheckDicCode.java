package com.baizhi.area.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.area.service.AreaService;

/**
 * 类名： CheckDicCode.java<br>
 * 描述：验证代码不能重复<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-16 下午12:06:55<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class CheckDicCode extends AreaForm{
	
	private static final long serialVersionUID = -555239708673475989L;
	
	private AreaService areaService;//地区信息表业务类
	
	public AreaService getAreaService() {
		return areaService;
	}
	
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap=new HashMap<String, Object>();
		//设置参数
		Map<String, Object> params = new HashMap<String, Object>();
		this.setMap(params, "DIC_CODE=?", this.getDIC_CODE());// Email
		this.setMap(params, "AREA_ID<>?", this.getAREA_ID());//用户ID
		
		int count=areaService.getAreaCount(params);
		if(count>0){
			returnMap.put("flag", false);
			returnMap.put("message", "地区代码已经存在,请重新输入");
		}else{
			returnMap.put("flag", true);
		}
		this.setResult(returnMap);
		return JSONSUCCESS;
	}
}
