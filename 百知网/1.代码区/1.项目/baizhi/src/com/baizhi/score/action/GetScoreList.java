package com.baizhi.score.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.score.service.ScoreService;
/**
 * 类名： ScoreList.java<br>
 * 描述：  获取积分信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-08-07 18:51:46
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetScoreList extends ScoreForm {
	
	private static final long serialVersionUID = -8810343455013074482L;
	
	private ScoreService scoreService;//积分信息表业务类
	
	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		if(this.getNAME()!=null&&!this.getNAME().trim().equals("")){
			this.setMap(params, "NAME like ?", "%"+this.getNAME()+"%");// 积分名称
		}
		this.setMap(params, "IS_VALID=?", this.getIS_VALID());// 是否禁用
		// 查询积分信息表列表
		Map<String, Object> returnMap = scoreService.getScoreList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}