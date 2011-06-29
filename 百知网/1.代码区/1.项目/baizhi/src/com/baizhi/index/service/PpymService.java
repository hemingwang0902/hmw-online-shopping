package com.baizhi.index.service;

import com.baizhi.commons.ServiceSupport;
import com.baizhi.index.dao.PpymDao;

public class PpymService  extends ServiceSupport{
	
	private static final long serialVersionUID = 5535064051007903340L;
	
	private PpymDao ppymDao;
	
	public PpymDao getPpymDao() {
		return ppymDao;
	}

	public void setPpymDao(PpymDao ppymDao) {
		this.ppymDao = ppymDao;
	}
}
