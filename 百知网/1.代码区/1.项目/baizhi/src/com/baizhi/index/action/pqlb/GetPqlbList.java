package com.baizhi.index.action.pqlb;

import java.util.HashMap;
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
	
	private Integer myself;
	
	public Integer getMyself() {
		return myself;
	}

	public void setMyself(Integer myself) {
		this.myself = myself;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("USER_ID", this.getSessionUserId());
		if(myself!=null&&myself==1){
			params.put("myself", myself);
		}
		Map<String, Object> returnMap = pqlbService.getPqlbList(params, this.getNowPage(), this.getOnePageCount());
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
}
