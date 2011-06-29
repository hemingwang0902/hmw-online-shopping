package com.baizhi.index.service;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.SywtDao;

public class SywtService extends ServiceSupport{
	
	private static final long serialVersionUID = 728325753861617281L;
	
	private SywtDao sywtDao;
	
	public SywtDao getSywtDao() {
		return sywtDao;
	}

	public void setSywtDao(SywtDao sywtDao) {
		this.sywtDao = sywtDao;
	}
}
