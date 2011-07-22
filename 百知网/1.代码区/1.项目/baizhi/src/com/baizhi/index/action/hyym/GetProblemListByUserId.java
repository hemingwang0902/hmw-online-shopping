package com.baizhi.index.action.hyym;

import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.HyymService;

/**
 * 类名： GetProblemListByUserId<br>
 * 描述：获取问过的问题列表<br>
 * 创建者：何明旺<br>
 * 创建日期：2011-7-7<br>
 * 版本：1.0<br>
 * 修改者：<br>
 * 修改日期：<br>
 */
public class GetProblemListByUserId extends ActionSupport {
	private static final long serialVersionUID = -5475079542596802133L;

	private HyymService hyymService;
	private String userId;
	
	public void setHyymService(HyymService hyymService) {
		this.hyymService = hyymService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String execute() throws Exception {
		int uid = NumberUtils.toInt(userId);
		if(uid > 0){
			// 查询结果列表
			Map<String, Object> returnMap = hyymService.getProblemListByUserId(uid, this.getNowPage(), this.getOnePageCount());
			//判断是否存在查询记录
			if (returnMap != null && returnMap.size() != 0) {
				this.setResult(returnMap);
			}
		}
		return JSONSUCCESS;
	}
}
