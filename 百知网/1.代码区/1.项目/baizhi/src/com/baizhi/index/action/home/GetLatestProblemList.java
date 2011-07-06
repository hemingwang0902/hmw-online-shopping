package com.baizhi.index.action.home;

import java.util.List;
import java.util.Map;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HomeService;

/**
 * 类名： UserBasicList.java<br>
 * 描述： 获取品牌列表列表信息 创建者：江红 创建日期： 2011-06-23 22:03:15 版本：V0.9 修改者： 修改日期：
 */
public class GetLatestProblemList extends ActionSupport {

	private static final long serialVersionUID = 5465713969149938078L;
	private HomeService homeService;
	private int nowPage;
	private int onePageCount;

	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getOnePageCount() {
		return onePageCount;
	}

	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		// 查询结果列表
		Map<String, Object> returnMap = homeService.getLatestProblemList(getSessionUserId(), this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			List<Map<String, Object>> list = (List<Map<String, Object>>) returnMap.get(KEY_LIST);
			if(list != null){
				Object RELEVANT_DETAILS = null;
				for (Map<String, Object> map : list) {
					RELEVANT_DETAILS = map.get("RELEVANT_DETAILS");
					map.put("RELEVANT_DETAILS", RELEVANT_DETAILS == null ? "" : RELEVANT_DETAILS.toString());
				}
			}
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

}
