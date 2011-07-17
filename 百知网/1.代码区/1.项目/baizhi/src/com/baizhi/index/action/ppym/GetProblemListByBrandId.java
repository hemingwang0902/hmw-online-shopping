package com.baizhi.index.action.ppym;

import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.PpymService;

/**
 * 类名： GetProblemListByBrandId<br>
 * 描述：根据品牌ID查询品牌下的问题<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-10<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetProblemListByBrandId extends ActionSupport{
	private static final long serialVersionUID = -7494711825638228013L;
	private PpymService ppymService;
	private int BRAND_ID;

	public void setPpymService(PpymService ppymService) {
		this.ppymService = ppymService;
	}

	public void setBRAND_ID(int bRANDID) {
		BRAND_ID = bRANDID;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> jsonMap = ppymService.getProblemListByBrandId(BRAND_ID, getNowPage(), getOnePageCount());
		setResult(jsonMap);
		return SUCCESS;
	}

}
