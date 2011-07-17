package com.baizhi.index.action.pqlb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.PqlbService;

/**
 * 
 * 类名：GetPqlbList.java
 * 描述：品牌列表
 * 创建者：江红
 * 创建日期：2011-06-18 22:32:20
 * 版本：V0.9
 * 修改者：  
 * 修改日期：
 */
public class GetPqlbList  extends ActionSupport {
	
	private static final long serialVersionUID = -9198632796526537340L;
	
	private PqlbService pqlbService;
	
	public PqlbService getPqlbService() {
		return pqlbService;
	}
	
	public void setPqlbService(PqlbService pqlbService) {
		this.pqlbService = pqlbService;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("USER_ID", this.getSessionUserId());
		Map<String, Object> returnMap = pqlbService.getPqlbList(params, this.getNowPage(), this.getOnePageCount());
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
