package com.baizhi.index.service;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.SzTzszDao;

public class SzTzszService  extends ServiceSupport{
	
	private static final long serialVersionUID = 4087044518208940695L;
	
	private SzTzszDao szTzszDao;

	public SzTzszDao getSzTzszDao() {
		return szTzszDao;
	}

	public void setSzTzszDao(SzTzszDao szTzszDao) {
		this.szTzszDao = szTzszDao;
	}
	
}
