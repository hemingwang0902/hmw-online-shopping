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
		this.setMap(params, "DICLIST_ID=?", this.getDICLIST_ID());// 字典列表ID
		this.setMap(params, "NAME=?", this.getNAME());// 字典名称
		this.setMap(params, "CODE=?", this.getCODE());// 字典代码
		this.setMap(params, "ALLPIN=?", this.getALLPIN());// 字典全拼
		this.setMap(params, "SIMPLEPIN=?", this.getSIMPLEPIN());// 字典简拼
		this.setMap(params, "REMARK=?", this.getREMARK());// 备注
		// 查询字典列表列表
		Map<String, Object> returnMap = diclistService.getDiclistList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}