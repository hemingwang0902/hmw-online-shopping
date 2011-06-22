package com.baizhi.dicitem.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.dicitem.service.DicitemService;
/**
 * 类名： DicitemList.java<br>
 * 描述：  获取字典列表清单列表信息
 * 创建者：何明旺
 * 创建日期： 2011-06-20 21:02:57
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetDicitemList extends DicitemForm {
	
	private static final long serialVersionUID = -6664797388609851711L;
	
	private DicitemService dicitemService;//字典列表清单业务类
	
	public DicitemService getDicitemService() {
		return dicitemService;
	}

	public void setDicitemService(DicitemService dicitemService) {
		this.dicitemService = dicitemService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "CODE=?", this.getCODE());// 列表字典代码
		// 查询字典列表清单列表
		Map<String, Object> returnMap = dicitemService.getDicitemList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}