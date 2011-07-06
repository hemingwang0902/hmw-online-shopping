package com.baizhi.scorelevel.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.scorelevel.service.ScoreLevelService;
/**
 * 类名： ScoreLevelList.java<br>
 * 描述：  获取积分级别信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-21 00:43:41
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetScoreLevelList extends ScoreLevelForm {
	
	private static final long serialVersionUID = -734599018810260532L;
	
	private ScoreLevelService scoreLevelService;//积分级别信息表业务类
	
	public ScoreLevelService getScoreLevelService() {
		return scoreLevelService;
	}

	public void setScoreLevelService(ScoreLevelService scoreLevelService) {
		this.scoreLevelService = scoreLevelService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		if(getNAME()!=null&&!getNAME().trim().equals("")){
			this.setMap(params, "NAME like ?", "%"+this.getNAME()+"%");// 级别名称
		}
		
		// 查询积分级别信息表列表
		Map<String, Object> returnMap = scoreLevelService.getScoreLevelList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}