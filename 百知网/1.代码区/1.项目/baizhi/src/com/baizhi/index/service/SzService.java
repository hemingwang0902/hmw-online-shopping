package com.baizhi.index.service;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.SzDao;

public class SzService extends ServiceSupport{
	
	private static final long serialVersionUID = 7959852606160119493L;
	
	private SzDao szDao;

	public SzDao getSzDao() {
		return szDao;
	}

	public void setSzDao(SzDao szDao) {
		this.szDao = szDao;
	}
	
}
