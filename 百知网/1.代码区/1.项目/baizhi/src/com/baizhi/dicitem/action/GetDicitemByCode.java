package com.baizhi.dicitem.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.baizhi.dicitem.service.DicitemService;

/**
 * 
 * 类名：GetDicitemByCode.java
 * 描述： 获取单条字典列表清单表单信息
 * 创建者：lishilin
 * 创建日期： 2011-06-20 21:02:57
 * 版本：V0.9
 * 修改者：
 * 修改日期：
 */
public class GetDicitemByCode extends DicitemForm {
	private static final long serialVersionUID = 7138769334770594385L;
	private DicitemService dicitemService;//字典列表清单业务类

	public DicitemService getDicitemService() {
		return dicitemService;
	}

	public void setDicitemService(DicitemService dicitemService) {
		this.dicitemService = dicitemService;
	}

	@Override
	public String execute() throws Exception {
		//查询数据
		List<Map<String, Object>> returnMapList = dicitemService.getDicitemByCode(this.getCODE());

		Map<String, Object> rsMap = new HashMap<String, Object>();
		rsMap.put("returnMapList", returnMapList);
		//判断是否存在查询记录
		if (returnMapList != null && returnMapList.size() != 0) {
			this.setResult(rsMap);
		}
		return JSONSUCCESS;
	}
}
