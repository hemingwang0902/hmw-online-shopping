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
	
	private Integer type;//类型 1推荐2热点3最新、4自己关注品牌
	
	
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> returnMap =null;
		//组织参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("USER_ID", this.getSessionUserId());
		//根据类型判断查询品牌数据
		if(type!=null){
			if(type==1){//查询推荐品牌
				returnMap=pqlbService.getCommendPqlbList(params, this.getNowPage(), this.getOnePageCount());
			}else if(type==2){//查询热点品牌
				returnMap=pqlbService.getHotPqlbList(params, this.getNowPage(), this.getOnePageCount());
			}else if(type==3){//查询最新品牌
				returnMap=pqlbService.getNewPqlbList(params, this.getNowPage(), this.getOnePageCount());
			}else if(type==4){//查询自己关注品牌
				params.put("myself", 1);
				returnMap=pqlbService.getPqlbList(params, this.getNowPage(), this.getOnePageCount());
			}else{
				returnMap=pqlbService.getPqlbList(params, this.getNowPage(), this.getOnePageCount());
			}
		}else{
			returnMap=pqlbService.getPqlbList(params, this.getNowPage(), this.getOnePageCount());
		}
		//将品牌数据转换成json数据
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
}
