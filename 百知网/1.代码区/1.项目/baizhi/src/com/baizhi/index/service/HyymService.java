package com.baizhi.index.service;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.HyymDao;

public class HyymService extends ServiceSupport{
	
	private static final long serialVersionUID = -7475180249774681389L;
	
	private HyymDao hyymDao;
	
	public HyymDao getHyymDao() {
		return hyymDao;
	}

	public void setHyymDao(HyymDao hyymDao) {
		this.hyymDao = hyymDao;
	}
}
