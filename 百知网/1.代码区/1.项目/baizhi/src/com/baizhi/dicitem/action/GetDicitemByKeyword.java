package com.baizhi.dicitem.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.baizhi.dicitem.service.DicitemService;
/**
 * 类名： DicitemList.java<br>
 * 描述：  获取字典列表清单列表信息<br>
 * 创建者：何明旺<br>
 * 创建日期： 2011-06-20 21:02:57<br>
 * 版本：V0.9 <br>
 * 修改者：<br>
 * 修改日期：
 */
public class GetDicitemByKeyword extends DicitemForm {
	private static final long serialVersionUID = -6319542377664328495L;
	private DicitemService dicitemService;//字典列表清单业务类
	
	public DicitemService getDicitemService() {
		return dicitemService;
	}

	public void setDicitemService(DicitemService dicitemService) {
		this.dicitemService = dicitemService;
	}
	
	@Override
	public String execute() throws Exception {
		String q = ServletActionContext.getRequest().getParameter("q") + "%";
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "DIC_NAME like ?", q);// 字典名称
		this.setMap(params, "ALLPIN like ?", q);// 字典全拼
		this.setMap(params, "SIMPLEPIN like ?", q);// 字典简拼
		// 查询字典列表清单列表
		Map<String, Object> returnMap = dicitemService.getDicitemListWithOrCondition(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}
}