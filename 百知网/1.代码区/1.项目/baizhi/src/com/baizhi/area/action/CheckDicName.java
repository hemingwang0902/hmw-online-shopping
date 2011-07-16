package com.baizhi.area.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.area.service.AreaService;

/**
 * 类名： DicName.java<br>
 * 描述：<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-16 下午12:07:09<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class CheckDicName  extends AreaForm{
	
	private static final long serialVersionUID = 5939065752665119127L;
	
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
		this.setMap(params, "DIC_NAME=?", this.getDIC_NAME());// Email
		this.setMap(params, "AREA_ID<>?", this.getAREA_ID());//用户ID
		
		int count=areaService.getAreaCount(params);
		if(count>0){
			returnMap.put("flag", false);
			returnMap.put("message", "地区名称已经存在,请重新输入");
		}else{
			returnMap.put("flag", true);
		}
		this.setResult(returnMap);
		return JSONSUCCESS;
	}
}

