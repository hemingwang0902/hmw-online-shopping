package com.baizhi.index.service;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.HylbDao;

public class HylbService extends ServiceSupport{
	
	private static final long serialVersionUID = 3062065776653310122L;
	
	private HylbDao hylbDao;
	
	public HylbDao getHylbDao() {
		return hylbDao;
	}

	public void setHylbDao(HylbDao hylbDao) {
		this.hylbDao = hylbDao;
	}
	
}
