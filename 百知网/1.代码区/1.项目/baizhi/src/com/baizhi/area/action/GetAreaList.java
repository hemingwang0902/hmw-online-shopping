package com.baizhi.area.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.area.service.AreaService;
/**
 * 类名： AreaList.java<br>
 * 描述：  获取地区信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-19 23:15:19
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetAreaList extends AreaForm {
	
	private static final long serialVersionUID = 2518446299761135961L;
	
	private AreaService areaService;//地区信息表业务类
	
	public AreaService getAreaService() {
		return areaService;
	}

	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "DIC_CODE=?", this.getDIC_CODE());// 地区代码(根据级别制定规则定义)
		if(getDIC_NAME()!=null&&!getDIC_NAME().trim().equals("")){
			this.setMap(params, "DIC_NAME like ?", "%"+this.getDIC_NAME()+"%");// 地区名称
		}
		
		if(getALLPIN()!=null&&!getALLPIN().trim().equals("")){
			this.setMap(params, "ALLPIN like ?", "%"+this.getALLPIN()+"%");// 地区全拼
		}
		
		if(getSIMPLEPIN()!=null&&!getSIMPLEPIN().trim().equals("")){
			this.setMap(params, "SIMPLEPIN like ?", "%"+this.getSIMPLEPIN()+"%");// 地区简拼
		}
		
		
		// 查询地区信息表列表
		Map<String, Object> returnMap = areaService.getAreaList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}