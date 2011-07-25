package com.baizhi.index.action.hylb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HylbService;

/**
 * 类名： GetHylbList.java<br>
 * 描述：获取会员信息<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午12:43:23<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetHylbList  extends ActionSupport {
	
	private static final long serialVersionUID = -9198632796526537340L;
	
	private  HylbService hylbService;
	
	public HylbService getHylbService() {
		return hylbService;
	}

	public void setHylbService(HylbService hylbService) {
		this.hylbService = hylbService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("USER_ID", this.getSessionUserId());
		// 查询品牌列表
		Map<String, Object> returnMap = hylbService.getHylbList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			//判断是否存在列表数据，如果存在列表数据，则将日期格式转换
			if(returnMap.get("list")!=null&&((List<Map<String,Object>>)returnMap.get("list")).size()>0){
				List<Map<String, Object>> list = (List<Map<String,Object>>)returnMap.get("list");
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> newmap = list.get(i);
					String IMAGE_PATH=getValue(newmap, "IMAGE_PATH");
					if(IMAGE_PATH.equals("")){
						IMAGE_PATH="/images/main/xner.jpg";
					}
					newmap.put("IMAGE_PATH", IMAGE_PATH);
					
					newmap.put("INTRODUCTION",getValue(newmap, "INTRODUCTION"));
					
				}
				
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
}
