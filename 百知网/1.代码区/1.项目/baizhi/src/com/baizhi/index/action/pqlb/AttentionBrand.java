package com.baizhi.index.action.pqlb;

import org.apache.commons.lang.BooleanUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.PqlbService;

/**
 * 类名： AttentionBrand<br>
 * 描述：关注/取消关注 品牌<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-17<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class AttentionBrand  extends ActionSupport {
	private static final long serialVersionUID = -6392040870159838265L;
	private PqlbService pqlbService;//品牌列表业务类
	private int BRAND_ID;
	private String disAttention;

	public void setPqlbService(PqlbService pqlbService) {
		this.pqlbService = pqlbService;
	}
	
	public void setBRAND_ID(int bRANDID) {
		BRAND_ID = bRANDID;
	}

	public void setDisAttention(String disAttention) {
		this.disAttention = disAttention;
	}

	@Override
	public String execute() throws Exception {
		pqlbService.attentionBrand(getSessionUserId(), BRAND_ID, BooleanUtils.toBoolean(disAttention));
		return JSONSUCCESS;
	}

	
}
