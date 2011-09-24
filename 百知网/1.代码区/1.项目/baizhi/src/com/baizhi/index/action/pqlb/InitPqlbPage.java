package com.baizhi.index.action.pqlb;

import java.util.List;
import java.util.Map;
import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.PqlbService;

/**
 * 类名： InitPqlb.java<br>
 * 描述：初始化品牌页面<br>
 * 创建者：江红<br>
 * 创建日期：2011-7-17 下午02:17:22<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class InitPqlbPage extends ActionSupport {
	
	private static final long serialVersionUID = -5876555053491188603L;
	
	private PqlbService pqlbService;//品牌列表业务类
	
	private Map<String, Object> returnMap;
	
	public PqlbService getPqlbService() {
		return pqlbService;
	}
	
	public void setPqlbService(PqlbService pqlbService) {
		this.pqlbService = pqlbService;
	}
	
	public Map<String, Object> getReturnMap() {
		return returnMap;
	}

	public void setReturnMap(Map<String, Object> returnMap) {
		this.returnMap = returnMap;
	}
	
	private Integer type;
	
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String execute() throws Exception {
		returnMap=pqlbService.getBrandList( 1, 5);
		if(returnMap!=null&&returnMap.size()>0){
			//最新
			if(returnMap.get("newlist")!=null){
				List<Map<String, Object>> newlist=(List<Map<String, Object>>)returnMap.get("newlist");
				for (int i = 0; i < newlist.size(); i++) {
					Map<String, Object> newmap = newlist.get(i);
					String IMAGE_PATH=this.getValue(newmap, "IMAGE_PATH");
					if(IMAGE_PATH!=null&&!IMAGE_PATH.equals("")){
						newmap.put("IMAGE_PATH", this.getContext_path()+IMAGE_PATH);
					}
				}
			}
			
			//最热
			if(returnMap.get("hotlist")!=null){
				List<Map<String, Object>> hotlist=(List<Map<String, Object>>)returnMap.get("hotlist");
				for (int i = 0; i < hotlist.size(); i++) {
					Map<String, Object> hotmap = hotlist.get(i);
					String IMAGE_PATH=this.getValue(hotmap, "IMAGE_PATH");
					if(IMAGE_PATH!=null&&!IMAGE_PATH.equals("")){
						hotmap.put("IMAGE_PATH", this.getContext_path()+IMAGE_PATH);
					}
				}
			}
			
			//推荐
			if(returnMap.get("commendlist")!=null){
				List<Map<String, Object>> commendlist=(List<Map<String, Object>>)returnMap.get("commendlist");
				for (int i = 0; i < commendlist.size(); i++) {
					Map<String, Object> commendmap = commendlist.get(i);
					String IMAGE_PATH=this.getValue(commendmap, "IMAGE_PATH");
					if(IMAGE_PATH!=null&&!IMAGE_PATH.equals("")){
						commendmap.put("IMAGE_PATH", this.getContext_path()+IMAGE_PATH);
					}
				}
			}
			
			
		}
		return SUCCESS;
	}
}
