package com.baizhi.ad.action;

import java.util.HashMap;
import java.util.Map;
import com.baizhi.ad.service.AdService;
/**
 * 类名： AdList.java<br>
 * 描述：  获取广告信息表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-21 00:52:07
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetAdList extends AdForm {
	private static final long serialVersionUID = -5045445089368552763L;
	private AdService adService;//广告信息表业务类
	
	public AdService getAdService() {
		return adService;
	}

	public void setAdService(AdService adService) {
		this.adService = adService;
	}
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		//设置查询条件
		this.setMap(params, "AD_ID=?", this.getAD_ID());// 广告ID
		this.setMap(params, "TITLE=?", this.getTITLE());// 主题
		this.setMap(params, "CONTENT=?", this.getCONTENT());// 内容(支持html内容)
		this.setMap(params, "IMAGE=?", this.getIMAGE());// 图片
		this.setMap(params, "SHOW_TYPE=?", this.getSHOW_TYPE());// 显示方式(字典：1左边悬浮、2中间悬浮、3右边悬浮)
		this.setMap(params, "HREF=?", this.getHREF());// 链接地址
		this.setMap(params, "ORDER_BY=?", this.getORDER_BY());// 显示顺序
		this.setMap(params, "START_TIME=?", this.getSTART_TIME());// 起始时间
		this.setMap(params, "END_TIME=?", this.getEND_TIME());// 终止时间
		this.setMap(params, "STATUS=?", this.getSTATUS());// 状态(字典：1申请、2通过、3不通过)
		this.setMap(params, "REMARK=?", this.getREMARK());// 备注
		// 查询广告信息表列表
		Map<String, Object> returnMap = adService.getAdList(params, this.getNowPage(), this.getOnePageCount());
		//判断是否存在查询记录
		if (returnMap != null && returnMap.size() != 0) {
			this.setResult(returnMap);
		}
		return JSONSUCCESS;
	}

	
	
}