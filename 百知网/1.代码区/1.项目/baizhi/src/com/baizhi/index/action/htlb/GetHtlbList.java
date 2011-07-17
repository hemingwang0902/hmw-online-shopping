package com.baizhi.index.action.htlb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HtlbService;

/**
 * 类名： GetHtlbList.java<br>
 * 描述：话题列表<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午07:06:24<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetHtlbList extends ActionSupport{
	
	private static final long serialVersionUID = 6479093207725370061L;
	
	private HtlbService htlbService;
	
	public HtlbService getHtlbService() {
		return htlbService;
	}
	
	public void setHtlbService(HtlbService htlbService) {
		this.htlbService = htlbService;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("USER_ID", this.getSessionUserId());
		Map<String, Object> returnMap = htlbService.getHtlbList(params, this.getNowPage(), this.getOnePageCount());
		if (returnMap != null && returnMap.size() != 0) {
			if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
				List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> newmap = list.get(i);
					String IMAGE_PATH=getValue(newmap, "IMAGE_PATH");
					if(IMAGE_PATH.equals("")){
						IMAGE_PATH="/images/main/xner.jpg";
					}
					newmap.put("IMAGE_PATH",this.getContext_path()+IMAGE_PATH);
					
					newmap.put("INTRODUCTION",getValue(newmap, "INTRODUCTION"));
				}
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
