package com.baizhi.diclist.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.diclist.service.DiclistService;
/**
 * 类名： DiclistList.java<br>
 * 描述：  获取字典列表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-22 21:19:11
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetDiclistList extends DiclistForm {
	
	private static final long serialVersionUID = -8507338792319451593L;
	
	private DiclistService diclistService;//字典列表业务类
	
	public DiclistService getDiclistService() {
		return diclistService;
	}

	public void setDiclistService(DiclistService diclistService) {
		this.diclistService = diclistService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		if(getNAME()!=null&&!getNAME().equals("")){
			this.setMap(params, "NAME like ?","%"+ this.getNAME()+"%");// 字典名称
		}
		this.setMap(params, "CODE=?", this.getCODE());// 字典代码
		
		if(getALLPIN()!=null&&!getALLPIN().trim().equals("")){
			this.setMap(params, "ALLPIN like ?", "%"+this.getALLPIN()+"%");// 字典全拼
		}
		
		if(getSIMPLEPIN()!=null&&!getSIMPLEPIN().trim().equals("")){
			this.setMap(params, "SIMPLEPIN like ?", "%"+this.getSIMPLEPIN()+"%");// 字典简拼
		}
		
		// 查询字典列表列表
		Map<String, Object> returnMap = diclistService.getDiclistList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}