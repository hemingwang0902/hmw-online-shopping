package com.baizhi.index.action.wtymtit;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.WtymtitService;

/**
 * 类名： GetProblemAnswerList<br>
 * 描述：获取问题回复<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetProblemAnswerList  extends ActionSupport{

	private static final long serialVersionUID = -5163338377350613555L;
	private WtymtitService wtymtitService;
	private int problemId;
	
	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}
	
	public int getProblemId() {
		return problemId;
	}

	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	
	@Override
	public String execute() throws Exception {
		// 查询结果列表
		Map<String, Object> returnMap = wtymtitService.getAnswerList(problemId, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
