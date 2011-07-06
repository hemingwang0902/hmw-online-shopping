package com.baizhi.index.service;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.SzZhszDao;

public class SzZhszService extends ServiceSupport{
	
	private static final long serialVersionUID = 8901305506334436342L;
	
	private SzZhszDao szZhszDao;

	public SzZhszDao getSzZhszDao() {
		return szZhszDao;
	}

	public void setSzZhszDao(SzZhszDao szZhszDao) {
		this.szZhszDao = szZhszDao;
	}
	
}
