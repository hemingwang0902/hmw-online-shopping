package com.baizhi.index.action.pqlb;

import com.baizhi.commons.ActionSupport;
import com.baizhi.index.service.PqlbService;

/**
 * 类名： UserBasicList.java<br>
 * 描述：  获取品牌列表列表信息
 * 创建者：江红
 * 创建日期： 2011-06-23 22:03:15
 * 版本：V0.9 
 * 修改者：
 * 修改日期：
 */
public class GetPqlbList  extends ActionSupport {
	
	private static final long serialVersionUID = -9198632796526537340L;
	
	private PqlbService pqlbService;//品牌列表业务类
	
	public PqlbService getPqlbService() {
		return pqlbService;
	}
	
	public void setPqlbService(PqlbService pqlbService) {
		this.pqlbService = pqlbService;
	}
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	
}
