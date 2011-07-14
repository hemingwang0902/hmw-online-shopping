package com.baizhi.index.action.wtymtit;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.WtymtitService;

/**
 * 类名： GetTalklistByContent<br>
 * 描述：根据话题内容模糊查询话题<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-14<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetTalklistByContent  extends ActionSupport{
	private static final long serialVersionUID = 4430870688401866620L;

	private WtymtitService wtymtitService;
	
	private String q;

	public void setWtymtitService(WtymtitService wtymtitService) {
		this.wtymtitService = wtymtitService;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	@Override
	public String execute() throws Exception {
		// 查询结果列表
		Map<String, Object> returnMap = wtymtitService.getTalkListByContent(q+"%", getNowPage(), getOnePageCount());
		setResult(returnMap);
		return JSONSUCCESS;
	}
}
