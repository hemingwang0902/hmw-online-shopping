package com.baizhi.index.service;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.PqlbDao;

public class PqlbService  extends ServiceSupport{
	
	private static final long serialVersionUID = -4352096706327491213L;
	
	private PqlbDao pqlbDao;
	
	public PqlbDao getPqlbDao() {
		return pqlbDao;
	}

	public void setPqlbDao(PqlbDao pqlbDao) {
		this.pqlbDao = pqlbDao;
	}
	
}
